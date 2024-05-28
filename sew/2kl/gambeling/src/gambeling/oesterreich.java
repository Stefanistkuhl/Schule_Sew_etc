package gambeling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class oesterreich {
    private JButton skrupellos;
    private JLabel bild1;
    private JLabel bild2;
    private JLabel bild3;
    private JPanel panel1;
    private JLabel baum;
    // randoom dings mache
    // gewonne oder verloren
    // statistik
    // bilder austaucen (fake animaion)

    public oesterreich() {
        skrupellos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int auto = (int) (Math.random() * 3 + 1);
                System.out.println(auto);
                Image[] cars = new Image[3];
                cars[0] = new ImageIcon("car1.png").getImage()
                        .getScaledInstance(300, 300,
                                Image.SCALE_DEFAULT);
                cars[1] = new ImageIcon("car2.png").getImage()
                        .getScaledInstance(300, 300,
                                Image.SCALE_DEFAULT);
                cars[2] = new ImageIcon("car3.png").getImage()
                        .getScaledInstance(300, 300,
                                Image.SCALE_DEFAULT);
                JLabel[] labels = new JLabel[3];
                labels[0] = bild1;
                labels[1] = bild2;
                labels[2] = bild3;

                for (int feuerwehr = 0; feuerwehr < 3; feuerwehr += 1) {
                    int rand = (int) (Math.random() * 3) + 1;
                    labels[rand].setIcon(new ImageIcon(cars[feuerwehr]));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ka oida");
        frame.setContentPane((new oesterreich().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 690);
        frame.setVisible(true);
    }
}
