import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Logger;

public class Gui {
    JFrame f;
    JLabel l_kreis, l_reckteck;
    JTextField t_radius,t_länge, t_breite;
    JButton kreis_fläche,kreis_umfang,kreis_to_string, rechteck_fläche,rechteck_umfang,rechteck_to_string;
    Kreis k;
    Rechteck r;
    Gui(){
        f = new JFrame();

        JPanel p1 = new JPanel(new GridLayout(4,2));
        p1.setBackground(Color.PINK);
        JPanel p2 = new JPanel(new GridLayout(4,2));
        p2.setBackground(Color.PINK);

        kreis_fläche = new JButton("kreis fläche");
        //kreis_fläche.setBounds(10,10,200,50);
        kreis_umfang = new JButton("kreis umfang");
        //kreis_umfang.setBounds(10,70,200,50);
        kreis_to_string = new JButton("kreis to str");
        //kreis_to_string.setBounds(10,130,200,50);
        t_radius = new JTextField();
        //t_radius.setBounds(200,200,200,50);

        rechteck_fläche = new JButton("rechteck fläche");
        //rechteck_fläche.setBounds(10,10,200,50);
        rechteck_umfang = new JButton("rechteck umfang");
        //rechteck_umfang.setBounds(10,70,200,50);
        rechteck_to_string = new JButton("rechteck to str");
        //rechteck_to_string.setBounds(10,130,200,50);
        t_länge = new JTextField();
        //t_länge.setBounds(200,200,200,50);
        t_breite = new JTextField();
        //t_breite.setBounds(200,300,200,50);

        l_kreis = new JLabel();
        //l_kreis.setBounds(300,300,400,50);
        l_reckteck = new JLabel();
        //l_reckteck.setBounds(300,300,400,50);


        //Create the panel that contains the "cards".
        //https://stackoverflow.com/questions/66830786/java-gui-switching-between-panels-on-button-click
        JPanel cards = new JPanel(new CardLayout());
        cards.add(p1, "Rechteck");
        cards.add(p2, "Kreis");

        // Add your card container to the frame
        Container pane = f.getContentPane();
        pane.add(cards, BorderLayout.CENTER);
        JButton btn = new JButton("Wechseln");
        JButton exit = new JButton("exit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.next(cards);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                    System.exit(69);
            }
        });
        kreis_umfang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = new Kreis();
                String s = t_radius.getText();
                double input = Double.parseDouble(s);
                double output = 0;
                k.setRadius(input);
                output = k.umfang();
                String ergebnis = String.valueOf(output);
                l_kreis.setText(ergebnis);
            }
        });
        kreis_fläche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = new Kreis();
                String s = t_radius.getText();
                double input = Double.parseDouble(s);
                double output = 0;
                k.setRadius(input);
                output = k.Fläche();
                String ergebnis = String.valueOf(output);
                l_kreis.setText(ergebnis);
            }
        });
        kreis_to_string.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = new Kreis();
                String s = t_radius.getText();
                double input = Double.parseDouble(s);
                String output = "";
                k.setRadius(input);
                output = k.toString();
                String ergebnis = String.valueOf(output);
                l_kreis.setText(ergebnis);
            }
        });
        rechteck_fläche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r = new Rechteck();
                String s_b = t_breite.getText();
                String s_l = t_länge.getText();
                double input_b = Double.parseDouble(s_b);
                double input_l = Double.parseDouble(s_l);
                double output = 0;
                r.setBreite(input_b);
                r.setLänge(input_l);
                output = r.Fläche();
                String ergebnis = String.valueOf(output);
                l_reckteck.setText(ergebnis);
            }
        });
        rechteck_umfang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r = new Rechteck();
                String s_b = t_breite.getText();
                String s_l = t_länge.getText();
                double input_b = Double.parseDouble(s_b);
                double input_l = Double.parseDouble(s_l);
                double output = 0;
                r.setBreite(input_b);
                r.setLänge(input_l);
                output = r.umfang();
                String ergebnis = String.valueOf(output);
                l_reckteck.setText(ergebnis);

            }
        });
        rechteck_to_string.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r = new Rechteck();
                String s_b = t_breite.getText();
                String s_l = t_länge.getText();
                double input_b = Double.parseDouble(s_b);
                double input_l = Double.parseDouble(s_l);
                String output = "";
                r.setBreite(input_b);
                r.setLänge(input_l);
                output = r.toString();
                String ergebnis = String.valueOf(output);
                l_reckteck.setText(ergebnis);
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(btn);
        btnPanel.add(exit);
        pane.add(btnPanel, BorderLayout.SOUTH);
        p2.add(kreis_fläche);
        p2.add(kreis_umfang);
        p2.add(kreis_to_string);
        p2.add(t_radius);
        p2.add(l_kreis);

        p1.add(rechteck_fläche);
        p1.add(rechteck_umfang);
        p1.add(rechteck_to_string);
        p1.add(t_breite);
        p1.add(t_länge);
        p1.add(l_reckteck);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(690, 690);
        f.setVisible(true);
    }

}
