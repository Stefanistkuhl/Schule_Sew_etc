import javax.swing.*;
import java.awt.*;

public class _6GUIAnimation extends JPanel {
    private int x = 0;
    private int y = 0;
    private final int DIAMETER = 50;

    public _6GUIAnimation() {
        Timer timer = new Timer(30, e -> {
            x += 5;
            y += 5;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _6GUIAnimation());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}