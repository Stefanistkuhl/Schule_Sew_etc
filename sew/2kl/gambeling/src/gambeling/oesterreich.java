package gambeling;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class oesterreich {
    private JButton skrupellos;
    private JLabel bild1;
    private JLabel bild2;
    private JLabel bild3;
    private JPanel panel1;
    private JLabel baum;
    private JButton clearButton;
    // bilder austaucen (fake animaion)
    // guthaben wenn kein geld dann ende

    int wins = 0;
    int lost = 0;
    private JLabel winsoida;
    private JLabel lostoida;
    private JLabel geldodaso;
    int guthaben = 6969;

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
                ArrayList<Integer> uiiafs = new ArrayList<>();

                for (int feuerwehr = 0; feuerwehr < 3; feuerwehr += 1) {
                    int rand = (int) (Math.random() * 3) + 0;
                    // rand = 0;
                    uiiafs.add(rand);
                    // System.out.println(rand);
                    labels[feuerwehr].setIcon(new ImageIcon(cars[rand]));
                }
                if ((uiiafs.get(uiiafs.size() - 1) == uiiafs.get(uiiafs.size() - 2)
                        && uiiafs.get(uiiafs.size() - 2) == uiiafs.get(uiiafs.size() - 3))) {
                    baum.setText("du hast gewonnenn oida");
                    wins += 1;
                    guthaben += 699;
                    geldodaso.setText(Integer.toString(guthaben));
                    winsoida.setText(Integer.toString(wins));
                } else {
                    baum.setText("du hast veloren l+ring");
                    lost += 1;
                    guthaben -= 699;
                    if (guthaben < 0) {
                        System.exit(69);
                    }
                    geldodaso.setText(Integer.toString(guthaben));
                    lostoida.setText(Integer.toString(lost));
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
