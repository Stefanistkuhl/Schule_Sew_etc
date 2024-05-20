package ehsgjuposfg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class ka {
    private JTextField pin;
    private JButton loginButton;
    private JButton abhebenButton;
    private JButton einzahlenButton;
    private JButton registerButton;
    private JLabel kontostand;
    private JPanel panel1;
    private JButton a6Button;
    private JButton a9Button;
    private JTextField input;

    public boolean login = false;

    public ka() {
        pin.setEditable(false);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null, "js ist 🐴💩");
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if () {
                }
           }
        });
        einzahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        abhebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pin.setText(pin.getText() + " 9");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pin.setText(pin.getText() + " 6");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("lua > js");
        frame.setContentPane((new ka().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(690, 690);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
