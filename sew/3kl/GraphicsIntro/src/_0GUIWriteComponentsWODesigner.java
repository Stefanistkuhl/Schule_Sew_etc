import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _0GUIWriteComponentsWODesigner extends JFrame {
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JLabel resultLabel;

    private JPanel panel;

    public _0GUIWriteComponentsWODesigner() {

        // Create a panel to hold the components
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // 3 rows, 2 columns

        // Initialize components
        label = new JLabel("Namen eingeben:");
        textField = new JTextField();
        button = new JButton("Bestätigen");
        resultLabel = new JLabel("");

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text field
                String name = textField.getText();

                // Set the text of the result label
                resultLabel.setText("Hello, " + name + "!");
            }
        });

        // Add the components to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(resultLabel);

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        // Create an instance of the frame and set it up
        JFrame frame = new _0GUIWriteComponentsWODesigner();
        frame.setVisible(true);
        // Set the title of the window
        frame.setTitle("Simple GUI Example");

        // Set the size of the window
        frame.setSize(400, 200);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}