/*
Entwickle ein einfaches Schülerverwaltungssystem mit GUI, das es einem Benutzer ermöglicht, Schüler hinzuzufügen, anzuzeigen, und zu suchen. Verwende dazu eine ArrayList, um die Schülerobjekte zu speichern.

Die Schülerklasse soll folgende Attribute enthalten:

    Name
    Schülernummer
    Alter
    Abteilung

Das Verwaltungssystem sollte folgende Funktionen unterstützen:

    Hinzufügen eines neuen Schülers mit den oben genannten Attributen. 
    Anzeigen aller Schüler aus der Arrayliste in der GUI. Verwende dazu eine eine TextArea und die .append() Methode der TextArea.
    Suchen nach einem Schüler anhand seiner Schülernummer und Anzeigen seiner Informationen. Kann über ein extra Textfeld oder den bereits vorhandenen Textfelder gemacht werden.
Du kannst das System auch um weitere Funktionen erweitern, wie z.B. die Möglichkeit, die Informationen eines Schülers zu aktualisieren oder auch einen Schüler aus der ArrayList zu entfernen.
 */
package oida.oida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class grrrr {
    private JTextArea oida;
    private JButton HInzufügenButton;
    private JButton suchenButton;
    private JButton alleAnzeigenButton;
    private JTextField namenfeld;
    private JTextField nummerfeld;
    private JTextField alterfeld;
    private JTextField abteilungsgeld;
    private JPanel panel1;

    ArrayList<Schüler> fakedb = new ArrayList();

    public grrrr() {
        oida.setEditable(false);
        HInzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fakedb.add(new Schüler(namenfeld.getText(),Integer.parseInt(nummerfeld.getText()),Integer.parseInt(alterfeld.getText()),abteilungsgeld.getText()));
            }
        });
        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suchen(Integer.parseInt(nummerfeld.getText()), fakedb);
            }
        });
        alleAnzeigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < fakedb.size();i+=1){

                    oida.append(fakedb.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane((new grrrr().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void suchen(int suche, ArrayList<Schüler> fakedb){
        for(int i = 0; i < fakedb.size();i+=1){
            if(suche == fakedb.get(i).getNummer()){
                oida.append(fakedb.toString());
            }
        }
    }
}
