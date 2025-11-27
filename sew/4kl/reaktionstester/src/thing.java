import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class thing {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel out;
    private JButton startButton;

    Counter c;

    public thing() {
        button1.addActionListener(e -> checkClick(button1));
        button2.addActionListener(e -> checkClick(button2));
        button3.addActionListener(e -> checkClick(button3));

        startButton.addActionListener(e -> {
            c = new Counter(out, List.of(button1, button2, button3));
            c.start();
        });
    }

    private void checkClick(JButton clickedButton) {
        if (c != null && c.isCorrectButton(clickedButton)) {
            c.interrupt();
        } else {
            out.setText("Wrong button!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("who needs window titles");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            thing content = new thing();
            frame.setContentPane(content.panel1);
            frame.setSize(900, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}