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

    ArrayList<Integer> top = new ArrayList<>();
    ArrayList<Integer> mid = new ArrayList<>();
    ArrayList<Integer> bottom = new ArrayList<>();

    public gfbdk() {

        top.add(0);
        top.add(0);
        top.add(0);
        mid.add(0);
        mid.add(0);
        mid.add(0);
        bottom.add(0);
        bottom.add(0);
        bottom.add(0);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zrk();
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
                if (!dransein) {
                    inksoben.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    top.set(0, 1);
                    checkwin();
                } else {
                    inksoben.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    top.set(0, 2);
                    checkwin();
                }
            }
        });
        oben.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!dransein) {
                    oben.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    top.set(1, 1);
                    checkwin();
                } else {
                    oben.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    top.set(1, 2);
                    checkwin();
                }
            }
        });
        obenrechts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!dransein) {
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    top.set(2, 1);
                    checkwin();
                } else {
                    obenrechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    top.set(2, 2);
                    checkwin();
                }
            }
        });
        mittelinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein) {
                    mittelinks.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    mid.set(0, 1);
                    checkwin();
                } else {
                    mittelinks.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    mid.set(0, 2);
                    checkwin();
                }

            }
        });
        mitte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein) {
                    mitte.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    mid.set(1, 1);
                    checkwin();
                } else {
                    mitte.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    mid.set(1, 2);
                    checkwin();
                }

            }
        });
        mitterechts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein) {
                    obenrechts.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    mid.set(2, 1);
                    checkwin();
                } else {
                    mitterechts.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    mid.set(2, 2);
                    checkwin();
                }

            }
        });
        linksunten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein) {
                    linksunten.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    bottom.set(0, 1);
                    checkwin();
                } else {
                    linksunten.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    bottom.set(0, 2);
                    checkwin();
                }

            }
        });
        mitteunten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein) {
                    mitteunten.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    bottom.set(1, 1);
                    checkwin();
                } else {
                    mitteunten.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    bottom.set(1, 2);
                    checkwin();
                }

            }
        });
        rechtsunten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dransein) {
                    rechtsunten.setText("X");
                    spieler.setText("Spieler 2 ist dran");
                    dransein = true;
                    bottom.set(2, 1);
                    checkwin();
                } else {
                    rechtsunten.setText("0");
                    dransein = false;
                    spieler.setText("Spieler 1 ist dran");
                    bottom.set(2, 2);
                    checkwin();
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

    public void zrk() {
        spieler.setText("Spieler 1 ist dran");
        dransein = false;
        inksoben.setText("");
        oben.setText("");
        obenrechts.setText("");
        mittelinks.setText("");
        mitte.setText("");
        mitterechts.setText("");
        rechtsunten.setText("");
        mitteunten.setText("");
        linksunten.setText("");
        top.clear();
        mid.clear();
        bottom.clear();
        bottom.add(0);
        bottom.add(0);
        mid.add(0);
        mid.add(0);
        mid.add(0);
        top.add(0);
        top.add(0);
        top.add(0);
    }

    public int checkwin() {
        int ergebnis = 0;
        if ((top.get(0) == 1 && top.get(1) == 1 && top.get(2) == 1)
                || (mid.get(0) == 1 && mid.get(1) == 1 && mid.get(2) == 1)
                || (bottom.get(0) == 1 && bottom.get(1) == 1 && bottom.get(2) == 1)
                || ((top.get(0) == 1 && mid.get(0) == 1 && bottom.get(0) == 1)
                        || ((top.get(1) == 1 && mid.get(1) == 1 && bottom.get(1) == 1)
                                || (top.get(2) == 1 && mid.get(2) == 1 && bottom.get(2) == 1))
                        || (top.get(0) == 1 && mid.get(1) == 1 && bottom.get(2) == 1)
                        || (top.get(2) == 1 && mid.get(1) == 1 && bottom.get(0) == 1))) {
            ergebnis = 1;
            System.out.println(ergebnis);
            spieler.setText("Spieler 1 hat gewonnen");
        } else if ((top.get(0) == 2 && top.get(1) == 2 && top.get(2) == 2)
                || (mid.get(0) == 2 && mid.get(1) == 2 && mid.get(2) == 2)
                || (bottom.get(0) == 2 && bottom.get(1) == 2 && bottom.get(2) == 2)
                || ((top.get(0) == 2 && mid.get(0) == 2 && bottom.get(0) == 2)
                        || ((top.get(1) == 2 && mid.get(1) == 2 && bottom.get(1) == 2)
                                || (top.get(2) == 2 && mid.get(2) == 2 && bottom.get(2) == 2))
                        || (top.get(0) == 2 && mid.get(1) == 2 && bottom.get(2) == 2)
                        || (top.get(2) == 2 && mid.get(1) == 2 && bottom.get(0) == 2))) {
            ergebnis = 2;
            System.out.println(ergebnis);
            spieler.setText("Spieler 2 hat gewonnen");
        } else {
            ergebnis = 0;
            System.out.println(ergebnis);
        }
        return ergebnis;
    }
}
