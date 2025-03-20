import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class _10Geometry extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for better graphics quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw a rectangle
        g2d.setColor(Color.RED);
        g2d.fill(new Rectangle2D.Double(50, 50, 100, 100));

        // Draw an ellipse
        g2d.setColor(Color.BLUE);
        g2d.fill(new Ellipse2D.Double(200, 50, 100, 100));

        // Draw a line
        g2d.setColor(Color.GREEN);
        g2d.draw(new Line2D.Double(50, 200, 300, 200));

        // Draw a round rectangle
        g2d.setColor(Color.MAGENTA);
        g2d.fill(new RoundRectangle2D.Double(50, 250, 100, 100, 20, 20));

        // Draw an arc
        g2d.setColor(Color.ORANGE);
        g2d.fill(new Arc2D.Double(200, 250, 100, 100, 0, 180, Arc2D.OPEN));

        // Draw a quadratic curve
        g2d.setColor(Color.CYAN);
        QuadCurve2D q = new QuadCurve2D.Double();
        q.setCurve(50, 400, 150, 350, 250, 400);
        g2d.draw(q);

        // Draw a cubic curve
        g2d.setColor(Color.PINK);
        CubicCurve2D c = new CubicCurve2D.Double();
        c.setCurve(50, 450, 150, 400, 250, 500, 350, 450);
        g2d.draw(c);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Geometry Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _10Geometry());
        frame.setSize(400, 600);
        frame.setVisible(true);
    }
}