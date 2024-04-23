package jsdhofsdijf;

import javax.swing.*;

import java.awt.Color;
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
    private JButton testButton;

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
                    mitterechts.setText("X");
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
        frame.setSize(690, 690);
        frame.setVisible(true);
    }

    public void zrk() {
        spieler.setText("Spieler 1 ist dran");
        dransein = false;
        inksoben.setText("");
        inksoben.setBackground(null);
        oben.setText("");
        oben.setBackground(null);
        obenrechts.setText("");
        obenrechts.setBackground(null);
        mittelinks.setText("");
        mittelinks.setBackground(null);
        mitte.setText("");
        mitte.setBackground(null);
        mitterechts.setText("");
        mitterechts.setBackground(null);
        rechtsunten.setText("");
        rechtsunten.setBackground(null);
        mitteunten.setText("");
        mitteunten.setBackground(null);
        linksunten.setText("");
        linksunten.setBackground(null);
        top.clear();
        mid.clear();
        bottom.clear();
        bottom.add(0);
        bottom.add(0);
        bottom.add(0);
        mid.add(0);
        mid.add(0);
        mid.add(0);
        top.add(0);
        top.add(0);
        top.add(0);
    }

    public void pink(int sieger) {
        System.out.println("oida");
        // erste reihe waagrecht
        if (top.get(0) == 1 && top.get(1) == 1 && top.get(2) == 1) {
            inksoben.setBackground(Color.PINK);
            oben.setBackground(Color.PINK);
            obenrechts.setBackground(Color.PINK);
        }
        // zweite reihe waagrecht
        if (mid.get(0) == 1 && mid.get(1) == 1 && mid.get(2) == 1) {
            mitterechts.setBackground(Color.PINK);
            mitte.setBackground(Color.PINK);
            mittelinks.setBackground(Color.PINK);

        }
        // dritte reihe waagrecht
        if (bottom.get(0) == 1 && bottom.get(1) == 1 && bottom.get(2) == 1) {
            linksunten.setBackground(Color.PINK);
            mitteunten.setBackground(Color.PINK);
            rechtsunten.setBackground(Color.PINK);

        }
        // erste reihe senktrecht
        if (top.get(0) == 1 && mid.get(0) == 1 && bottom.get(0) == 1) {
            inksoben.setBackground(Color.PINK);
            linksunten.setBackground(Color.PINK);
            mittelinks.setBackground(Color.PINK);

        }
        // zweite reihe senktrecht
        if (top.get(1) == 1 && mid.get(1) == 1 && bottom.get(1) == 1) {
            oben.setBackground(Color.PINK);
            mitte.setBackground(Color.PINK);
            mitteunten.setBackground(Color.PINK);

        }
        // dritte reihe senktrecht
        if (top.get(2) == 1 && mid.get(2) == 1 && bottom.get(2) == 1) {
            obenrechts.setBackground(Color.PINK);
            mitterechts.setBackground(Color.PINK);
            rechtsunten.setBackground(Color.PINK);

        }
        // erste diagonale
        if (top.get(0) == 1 && mid.get(1) == 1 && bottom.get(2) == 1) {
            inksoben.setBackground(Color.PINK);
            mitte.setBackground(Color.PINK);
            rechtsunten.setBackground(Color.PINK);

        }
        // zweite diagonale
        if (top.get(2) == 1 && mid.get(1) == 1 && bottom.get(0) == 1) {
            obenrechts.setBackground(Color.PINK);
            mitte.setBackground(Color.PINK);
            linksunten.setBackground(Color.PINK);

        }
    }

    public void blau(int sieger) {
        System.out.println("oida");
        // erste reihe waagrecht
        if (top.get(0) == 2 && top.get(1) == 2 && top.get(2) == 2) {
            inksoben.setBackground(Color.BLUE);
            oben.setBackground(Color.BLUE);
            obenrechts.setBackground(Color.BLUE);
        }
        // zweite reihe waagrecht
        if (mid.get(0) == 2 && mid.get(1) == 2 && mid.get(2) == 2) {
            mitterechts.setBackground(Color.BLUE);
            mitte.setBackground(Color.BLUE);
            mittelinks.setBackground(Color.BLUE);

        }
        // dritte reihe waagrecht
        if (bottom.get(0) == 2 && bottom.get(1) == 2 && bottom.get(2) == 2) {
            linksunten.setBackground(Color.BLUE);
            mitteunten.setBackground(Color.BLUE);
            rechtsunten.setBackground(Color.BLUE);

        }
        // erste reihe senktrecht
        if (top.get(0) == 2 && mid.get(0) == 2 && bottom.get(0) == 2) {
            inksoben.setBackground(Color.BLUE);
            linksunten.setBackground(Color.BLUE);
            mittelinks.setBackground(Color.BLUE);

        }
        // zweite reihe senktrecht
        if (top.get(1) == 2 && mid.get(1) == 2 && bottom.get(1) == 2) {
            oben.setBackground(Color.BLUE);
            mitte.setBackground(Color.BLUE);
            mitteunten.setBackground(Color.BLUE);

        }
        // dritte reihe senktrecht
        if (top.get(2) == 2 && mid.get(2) == 2 && bottom.get(2) == 2) {
            obenrechts.setBackground(Color.BLUE);
            mitterechts.setBackground(Color.BLUE);
            rechtsunten.setBackground(Color.BLUE);

        }
        // erste diagonale
        if (top.get(0) == 2 && mid.get(1) == 2 && bottom.get(2) == 2) {
            inksoben.setBackground(Color.BLUE);
            mitte.setBackground(Color.BLUE);
            rechtsunten.setBackground(Color.BLUE);

        }
        // zweite diagonale
        if (top.get(2) == 2 && mid.get(1) == 1 && bottom.get(0) == 2) {
            obenrechts.setBackground(Color.BLUE);
            mitte.setBackground(Color.BLUE);
            linksunten.setBackground(Color.BLUE);

        }
    }

    public int checkwin() {
        int ergebnis = 0;
        if ((top.get(0) == 1 && top.get(1) == 1 && top.get(2) == 1)
                || (mid.get(0) == 1 && mid.get(1) == 1 && mid.get(2) == 1)
                || (bottom.get(0) == 1 && bottom.get(1) == 1 && bottom.get(2) == 1)
                || ((top.get(0) == 1 && mid.get(0) == 1 && bottom.get(0) == 1)
                        || ((top.get(1) == 1 && mid.get(1) == 1 && bottom.get(1) == 1)
                                || (top.get(2) == 1 && mid.get(2) == 1 && bottom.get(2) == 1)
                                || (top.get(0) == 1 && mid.get(1) == 1 && bottom.get(2) == 1)
                                || (top.get(2) == 1 && mid.get(1) == 1 && bottom.get(0) == 1)))) {
            ergebnis = 1;
            pink(ergebnis);
            spieler.setText("Spieler 1 hat gewonnen");
            int ka = JOptionPane.showConfirmDialog(null, "Spieler 1 hat gewonnen! Willst du das Spiel zurücksetzen?");
            if (ka == 0) {
                zrk();
            }
        } else if ((top.get(0) == 2 && top.get(1) == 2 && top.get(2) == 2)
                || (mid.get(0) == 2 && mid.get(1) == 2 && mid.get(2) == 2)
                || (bottom.get(0) == 2 && bottom.get(1) == 2 && bottom.get(2) == 2)
                || ((top.get(0) == 2 && mid.get(0) == 2 && bottom.get(0) == 2)
                        || ((top.get(1) == 2 && mid.get(1) == 2 && bottom.get(1) == 2)
                                || (top.get(2) == 2 && mid.get(2) == 2 && bottom.get(2) == 2)
                                || (top.get(0) == 2 && mid.get(1) == 2 && bottom.get(2) == 2)
                                || (top.get(2) == 2 && mid.get(1) == 2 && bottom.get(0) == 2)))) {
            ergebnis = 2;
            blau(ergebnis);
            spieler.setText("Spieler 2 hat gewonnen");
            int ka = JOptionPane.showConfirmDialog(null, "Spieler 2 hat gewonnen! Willst du das Spiel zurücksetzen?");
            if (ka == 0) {
                zrk();
            }
        } else if ((!top.contains(0) && !mid.contains(0) && !bottom.contains(0))) {
            ergebnis = 3;
            spieler.setText("Unentschiden");
            int ka = JOptionPane.showConfirmDialog(null, "Unentschieden Spiel zurücksetzen?");
            if (ka == 0) {
                zrk();
            }
        } else {
            ergebnis = 0;
        }
        return ergebnis;
    }
}
