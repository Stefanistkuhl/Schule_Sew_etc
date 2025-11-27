import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class thing {
    private JButton startButton;
    private JButton stopButton;
    private JLabel out;
    private JPanel panel1;
    Counter c;

    public thing() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = new Counter(out, 0);
                c.start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.interrupt();
            }
        });
    }

    void main() {
        SwingUtilities.invokeLater(
                () -> {
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
