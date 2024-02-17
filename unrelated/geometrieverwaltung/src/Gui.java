import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class Gui implements ActionListener {
    JFrame f;
    JLabel l;
    JTextField t;
    JButton kreis, rechteck, exit;
    Kreis k;
    Gui(){
        f = new JFrame();
        kreis = new JButton("kreis");
        kreis.setBounds(10,10,200,50);
        rechteck = new JButton("rechteck");
        rechteck.setBounds(10,70,200,50);
        exit = new JButton("exit");
        exit.setBounds(580,600,80,50);
        l = new JLabel();
        l.setBounds(300,300,300,50);
        t = new JTextField();
        t.setBounds(300, 200, 300,50);


        f.add(kreis);
        f.add(rechteck);
        f.add(exit);
        f.add(l);
        f.add(t);
        kreis.addActionListener(this);
        rechteck.addActionListener(this);
        exit.addActionListener(this);

        f.setSize(690,690);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String s = t.getText();
        if(e.getSource()==exit){
            System.exit(69);
        }
        k = new Kreis();
        System.out.println(s);
        double input = Double.parseDouble(s);
        System.out.println(input);
        double output = 0;

        if(e.getSource()==kreis){
            k.setRadius(input);
            output = k.Fläche();
            System.out.println(output);
        }
        String ergebnis = String.valueOf(output);
        System.out.println(ergebnis);
        l.setText(ergebnis);
    }
}
