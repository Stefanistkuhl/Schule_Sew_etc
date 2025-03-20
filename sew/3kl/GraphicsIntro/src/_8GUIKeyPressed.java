import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class _8GUIKeyPressed extends JPanel {
    private int x = 200;
    private int y = 200;
    private final int DIAMETER = 50;

    public _8GUIKeyPressed() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT -> x -= 10;
                    case KeyEvent.VK_RIGHT -> x += 10;
                    case KeyEvent.VK_UP -> y -= 10;
                    case KeyEvent.VK_DOWN -> y += 10;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Pressed Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _8GUIKeyPressed());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}