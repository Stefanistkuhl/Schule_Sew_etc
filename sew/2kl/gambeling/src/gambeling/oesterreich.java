package gambeling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
                ArrayList<Integer> ka = new ArrayList<>();
                ka.add(0);
                ka.add(1);
                ka.add(2);

                Collections.shuffle(ka);
                for (int feuerwehr = 0; feuerwehr < 3; feuerwehr += 1) {
                    System.out.println(ka.toString());
                    labels[ka.get(ka.get(feuerwehr))].setIcon(new ImageIcon(cars[ka.get(feuerwehr)]));
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
