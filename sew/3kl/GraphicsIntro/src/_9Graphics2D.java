import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class _9Graphics2D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for better graphics quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw a rectangle
        g2d.setColor(Color.RED);
        g2d.fill(new Rectangle2D.Double(50, 50, 100, 100));

        // Draw an oval
        g2d.setColor(Color.BLUE);
        g2d.fill(new Ellipse2D.Double(200, 50, 100, 100));

        // Draw a line
        g2d.setColor(Color.GREEN);
        g2d.draw(new Line2D.Double(50, 200, 300, 200));

        // Apply a transformation
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(45), 150, 150);
        g2d.setTransform(transform);

        // Draw a transformed rectangle
        g2d.setColor(Color.ORANGE);
        g2d.fill(new Rectangle2D.Double(100, 100, 100, 100));

        // Reset transformation
        g2d.setTransform(new AffineTransform());

        // Draw a string
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        g2d.drawString("Hello, Graphics2D!", 50, 250);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics2D Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _9Graphics2D());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}