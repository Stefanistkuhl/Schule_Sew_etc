package at.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class oida {
    private JButton testButton;
    private JPanel panel1;
    private JButton anmeldenButton;
    private JButton registerButton;
    private JLabel label_passowrd;
    private JLabel label_user;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JLabel label;

    public oida() {


        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<User>list = new ArrayList<>();
                list.add(new User(textField1.getText(),passwordField1.getText()));
                userbase(list);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane((new oida().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static ArrayList<User> userbase (ArrayList<User> input){
        ArrayList<ArrayList<User>> crazydatenbank = new ArrayList<>();
        crazydatenbank.add(input);
        for (int i = 0; i<crazydatenbank.size();i+=1){

        }
        return input;
    }
}

