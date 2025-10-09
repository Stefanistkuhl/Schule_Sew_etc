import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class thing {
	private JPanel panel1;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame f = new JFrame("tot");
			f.setContentPane(new thing().panel1);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(300, 320);
			f.setLocationRelativeTo(null);
			f.setLayout(new BorderLayout());
			f.add(new Clock(), BorderLayout.CENTER);
			f.setVisible(true);
		});
	}

	static class Clock extends JComponent {
		private final TimeHelper time = new TimeHelper();
		private final Timer timer;

		public Clock() {
			setPreferredSize(new Dimension(250, 250));
			setBackground(Color.WHITE);
			setOpaque(true);
			initTime();

			timer = new Timer(
					1000,
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							initTime();
							repaint();
						}
					});
			timer.setInitialDelay(0);
			timer.start();
		}

		private void initTime() {
			SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
			String t = df.format(new Date());
			time.setHour(Integer.parseInt(t.split(":")[0]));
			time.setMinute(Integer.parseInt(t.split(":")[1]));
			time.setSeconds(Integer.parseInt(t.split(":")[2]));
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(
					RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			int width = getWidth();
			int height = getHeight();
			int size = Math.min(width, height);
			int centerX = width / 2;
			int centerY = height / 2;
			int radius = size / 2 - 10;

			g2.setColor(getBackground());
			g2.fillRect(0, 0, width, height);
			g2.setColor(Color.LIGHT_GRAY);
			g2.setStroke(new BasicStroke(1.2f));
			g2.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

			drawTickMarks(g2, centerX, centerY, size);

			drawM(g2, centerX, centerY, radius);
			drawH(g2, centerX, centerY, radius);
			drawS(g2, centerX, centerY, radius);

			g2.setColor(Color.DARK_GRAY);
			g2.setStroke(new BasicStroke(1f));
			g2.drawOval(centerX - 2, centerY - 2, 4, 4);
			g2.dispose();
		}

		private void drawTickMarks(Graphics2D g2, int centerX, int centerY, int r) {
			for (int i = 0; i < 60; i++) {
				boolean major = (i % 5 == 0);
				int tickLen = major ? 12 : 6;
				float angle = 90 - (i * 6f);
				Point outer = getLocationOf(angle, r);
				Point inner = getLocationOf(angle, r - tickLen);
				g2.setColor(major ? Color.DARK_GRAY : Color.GRAY);
				g2.setStroke(new BasicStroke(major ? 2f : 1f));
				g2.drawLine(centerX + inner.x, centerY - inner.y, centerX + outer.x, centerY - outer.y);
			}
		}

		private void drawS(Graphics2D g2, int centerX, int centerY, int r) {
			float angle = 90 - (time.getSeconds() * 6f);
			int len = (int) (r * 0.85);
			Point tip = getLocationOf(angle, len);
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2.drawLine(centerX, centerY, centerX + tip.x, centerY - tip.y);
		}

		private void drawH(Graphics2D g2, int centerX, int centerY, int r) {
			float angle = 90 - ((time.getHour() % 12) * 30f + time.getMinute() * 0.5f);
			int len = (int) (r * 0.5);
			Point tip = getLocationOf(angle, len);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2.drawLine(centerX, centerY, centerX + tip.x, centerY - tip.y);
		}

		private void drawM(Graphics2D g2, int centerX, int centerY, int r) {
			float angle = 90 - (time.getMinute() * 6f);
			int len = (int) (r * 0.75);
			Point tip = getLocationOf(angle, len);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2.drawLine(centerX, centerY, centerX + tip.x, centerY - tip.y);
		}

		private Point getLocationOf(float angle, int radius) {
			double x = Math.cos(Math.toRadians(angle)) * radius;
			double y = Math.sin(Math.toRadians(angle)) * radius;
			return new Point((int) Math.round(x), (int) Math.round(y));
		}
	}
}
