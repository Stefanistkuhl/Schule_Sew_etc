package jsdhofsdijf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gfbdk {
    private JButton exitButton;
    private JButton resetButton;
    private JButton inksoben;
    private JButton oben;
    private JButton obenrechts;
    private JButton linksunten;
    private JButton mitte;
    private JButton rechtsunten;
    private JButton mittelinks;
    private JButton mitterechts;
    private JButton mitteunten;
    private JPanel panel1;
    private JLabel spieler;

    boolean dransein = false;

    public gfbdk() {
        ArrayList<Boolean>top=new ArrayList<>();
        ArrayList<Boolean>mid=new ArrayList<>();
        ArrayList<Boolean>bottom=new ArrayList<>();

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(69);
            }
        });
        inksoben.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein){
                   inksoben.setText("X");
                   spieler.setText("Spieler 2 ist dran");
                   dransein = true;
                }else {
                    inksoben.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }
            }
        });
        oben.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!dransein){
                    oben.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    oben.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }
            }
        });
        obenrechts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!dransein){
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    obenrechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }
            }
        });
        mittelinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein){
                    mittelinks.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    mittelinks.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }

            }
        });
        mitte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein){
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    obenrechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }

            }
        });
        mitterechts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein){
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    obenrechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }

            }
        });
        linksunten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein){
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    obenrechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }

            }
        });
        mitteunten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein){
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    obenrechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }

            }
        });
        rechtsunten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein){
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                }else {
                    obenrechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("oida");
        frame.setContentPane((new gfbdk().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
