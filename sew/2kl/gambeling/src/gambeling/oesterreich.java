package gambeling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class oesterreich {
    private JButton anzeigen;
    private JLabel bild1;
    private JLabel bild2;
    private JLabel bild3;
    private JPanel panel1;

    public oesterreich() {
        anzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Image image = new ImageIcon("car1.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                bild1.setIcon(new ImageIcon(image));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ka oida");
        frame.setContentPane((new oesterreich().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(690, 690);
        frame.setVisible(true);
    }
}
