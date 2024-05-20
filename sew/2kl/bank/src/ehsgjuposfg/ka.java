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
    private JButton exitButton;

    public boolean login = false;

    public ka() {
        User user = new User(0, 0);
        user.setPin(6969);
        user.setKontostand(69.0);
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
                if (user.login(Integer.parseInt(pin.getText()))) {
                    kontostand.setText(Double.toString(user.getKontostand()));
                }
                pin.setText("");
            }
        });
        einzahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.einzahlen(Double.parseDouble(pin.getText()));
                kontostand.setText(Double.toString(user.getKontostand()));
                pin.setText("");
            }
        });
        abhebenButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                user.abheben(Double.parseDouble(pin.getText()));
                kontostand.setText(Double.toString(user.getKontostand()));
                pin.setText("");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pin.setText(pin.getText() + "9");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pin.setText(pin.getText() + "6");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(69);
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
