import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _4GUIColorPicker extends JPanel {
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
        frame.setSize(500, 300);

        // Add a button to open the color picker
        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(panel, "Choose a color", panel.color);
                if (newColor != null) {
                    panel.updateColor(newColor);
                }
            }
        });
        frame.add(colorButton, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
}