package at.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;


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


        ArrayList<User>list = new ArrayList<>();
        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User eingabe = (new User(textField1.getText(),passwordField1.getText()));
                boolean exists = user_check(list, eingabe);
                if (!exists){
                    showMessageDialog(null, "Du hast keinen Account und musst dich registrieren");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User eingabe = (new User(textField1.getText(),passwordField1.getText()));
                list.add(eingabe);
                userbase_register(list, eingabe);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane((new oida().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static ArrayList<User> userbase_register (ArrayList<User> db,User input){

        for (int i = 0; i<db.size();i+=1){

            if ((input.getUsername().equals(db.get(i).getUsername()))&&(input.getPassword().equals(db.get(i).getPassword()))){
                showMessageDialog(null,"Schon registriert idi");
            }else {
                db.add(input);
            }
        }
        for (int i = 0; i<db.size();i+=1){
            System.out.println(db.toString());
        }
        return db;
    }

    public static Boolean user_check(ArrayList<User> db, User input){
        boolean exist = false;
        System.out.println(db.toString());
        for (int i = 0; i<db.size();i+=1){
            if ((input.getUsername().equals(db.get(i).getUsername()))&&(input.getPassword().equals(db.get(i).getPassword()))){
                System.out.println("HALLLO");
                exist = true;
                login(db, input);
            }else {
                exist = false;
            }
        }
        return exist;
    }
    public static void login(ArrayList<User> db, User input){
        for (int i = 0; i<db.size();i+=1){
            if ((input.getUsername().equals(db.get(i).getUsername()))&&(input.getPassword().equals(db.get(i).getPassword()))){
                showMessageDialog(null,"Hallo "+ db.get(i).getUsername());
            }
        }
    }
}

