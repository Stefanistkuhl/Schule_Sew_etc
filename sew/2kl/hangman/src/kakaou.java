import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class kakaou {
        private JPanel panel1;
        private JTextField input;
        private JLabel foto;
        private JButton send;
        private JTextField wort;
        private JLabel guesses;
        private JButton replayButton;

        int fails = 0;
        boolean contains = false;
        String[] woerter = { "Haus", "Baum", "Kind", "Hund", "Katze", "Auto", "Buch", "Stuhl",
                "Tisch",
                "Fenster", "Lampe", "Tor", "Garten", "Wald", "Fluss",
                "Berg", "See", "Wiese", "Blume",
                "Strasse", "Bus", "Zug", "Bahn", "Fahrrad", "Uhr",
                "Tag", "Nacht", "Sonne", "Mond",
                "Stern", "Himmel", "Wolke", "Regen", "Schnee", "Wind",
                "Feuer", "Wasser", "Erde",
                "Luft", "Eis", "Brot", "Milch", "Wurst", "Ei", "Apfel",
                "Banane", "Traube", "Kirsche",
                "Pflaume", "Birne", "Melone", "Beere", "Salat",
                "Tomate", "Kartoffel", "Zwiebel",
                "Knoblauch", "Karotte", "Kohl", "Reis", "Nudel",
                "Fisch", "Fleisch", "Huhn", "Kuh",
                "Schwein", "Schaf", "Pferd", "Vogel", "Maus", "Ratte",
                "Hase", "Frosch", "Schlange",
                "Spinne", "Ameise", "Biene", "Schmetterling", "Fliege",
                "Wurm", "Heuschrecke", "Blatt",
                "Ast", "Zweig", "Wurzel", "Samen", "Schule", "Lehrer",
                "Tafel", "Bleistift", "Heft",
                "Tasche", "Karte", "Spiel", "Ball", "Brille", "Freund",
                "Raum", "Licht", "Hand", "Fuss",
                "Kopf", "Arm", "Sommer", "Winter", "Herbst", "Reise",
                "Fluss", "Licht", "Schloss",
                "Stadt", "Dorf", "Flugzeug", "Hafen" };

        public kakaou() {
                wort.setEditable(false);
                String[] woerter_test = { "aaaaacccccccccca","bbbbbbbbaaaaaaabbbbbbbbbb"};

                Image[] say = new Image[8];
                say[0] = new ImageIcon("nix.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);
                say[1] = new ImageIcon("minus5.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);
                say[2] = new ImageIcon("minus4.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);
                say[3] = new ImageIcon("minus3.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);
                say[4] = new ImageIcon("minus2.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);
                say[5] = new ImageIcon("minus2.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);
                say[6] = new ImageIcon("minus1.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);
                say[7] = new ImageIcon("ganz.jpg").getImage()
                        .getScaledInstance(369, 396,
                                Image.SCALE_DEFAULT);

                foto.setIcon(new ImageIcon(say[0]));

                String wortxd = genwort(woerter);

                send.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                                String tmp = "";
                                tmp = input.getText();
                                input.setText("");
                                char guess = tmp.charAt(0);
                                String guessxd = Character.toString(guess);
                                boolean test = false;
                                if (wortxd.contains(guessxd)) {
                                        contains = true;
                                        System.out.println(wortxd.indexOf(
                                                guess));
                                } else {
                                        contains = false;
                                }

                                if (contains) {
                                        String tmpxd = "";
                                        tmpxd = wort.getText();
                                        System.out.println(tmpxd);
                                        for (int i = 0; i < wortxd.length(); i++) {
                                                if (wortxd.charAt(i)==guess){
                                                        tmpxd = tmpxd.substring(0, i) + guess
                                                                + tmpxd.substring(i + 1);

                                                }
                                        }
                                        System.out.println(tmpxd);
                                        wort.setText(tmpxd);
                                } else {
                                        showMessageDialog(null, "Falsch");
                                        fails += 1;
                                        foto.setIcon(new ImageIcon(say[fails]));
                                }
                                String tmp2 = "";
                                tmp2 = guesses.getText();
                                tmp2 = tmp2.substring(0, guesses.getText().indexOf(guessxd.toUpperCase())) + ""
                                        + tmp2.substring(guesses.getText().indexOf(guessxd.toUpperCase()) + 1);
                                guesses.setText(tmp2);
                                tmp2 = "";
                                if (!wort.getText().contains("*")){
                                        showMessageDialog(null, "du hast gewonnen yipeeee :3");
                                }
                                System.out.println(fails);
                                contains = false;
                                if (fails >= 7) {
                                        showMessageDialog(null, "Game over oida");
                                }
                                // play again btn
                        }
                });

                replayButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                                wort.setText("");
                                guesses.setText("A B C D E F G H I J L K M N O P Q R S T U V W X Y Z");
                                foto.setIcon(new ImageIcon(say[0]));
                                String wortxd = genwort(woerter);

                        }
                });
        }
        public String genwort(String[] woerter) {
                int rand = (int) (Math.random() * 99);
                String wortxd = woerter[rand];
                System.out.println(wortxd);
                for (int i = 0; i < wortxd.length(); i++) {
                        wort.setText(wort.getText() + "*");
                }
                return wortxd;
        }

        private void createUIComponents() {
                // TODO: place custom component creation code here
        }

        public static void main(String[] args) {
                JFrame frame = new JFrame(
                        "gaygagygagyagygagyagygagyagygagyagygagyagygaygagygaygagyagygaygagyagygaygagygay");
                frame.setContentPane((new kakaou().panel1));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(960, 690);
                frame.setVisible(true);
        }
}
