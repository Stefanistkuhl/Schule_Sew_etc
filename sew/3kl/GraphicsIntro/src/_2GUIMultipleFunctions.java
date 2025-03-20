import javax.swing.*;
import java.awt.*;

public class _2GUIMultipleFunctions extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawText(g);
        drawLine(g);
        drawRectangle(g);
        drawOval(g);
        drawFilledRectangle(g);
        drawFilledOval(g);
    }

    private void drawText(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Hello World", 100, 100);
        g.setColor(Color.BLUE);
        g.drawString("Hello World", 200, 200);
    }

    private void drawLine(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(10, 10, 100, 100);
    }

    private void drawRectangle(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(200, 10, 100, 100);
    }

    private void drawOval(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(50, 50, 100, 100);
    }

    private void drawFilledRectangle(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(10, 10, 100, 100);
    }

    private void drawFilledOval(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(77, 88, 200, 60);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _2GUIMultipleFunctions());
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}