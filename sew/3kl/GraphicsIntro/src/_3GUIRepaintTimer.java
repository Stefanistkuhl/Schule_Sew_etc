import javax.swing.*;
import java.awt.*;

public class _3GUIRepaintTimer extends JPanel {
    private String text = "Hello World";
    private Color color = Color.BLACK;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawString(text, 100, 100);
        // Other drawing methods...
    }

    public void updateText(String newText) {
        this.text = newText;
        repaint();
    }

    public void updateColor(Color newColor) {
        this.color = newColor;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        _4GUIColorPicker panel = new _4GUIColorPicker();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);

        // Example of updating the text and color after 2 seconds
        new Timer(2000, e -> {
            panel.updateText("Updated Text");
            panel.updateColor(Color.BLUE);
        }).start();
    }
}
