import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class zsguidokasji {
    private JPanel panel1;
    private JTextField datuminput;
    private JTextField teminput;
    private JTextField sonneinp;
    private JTextField niederschalginput;
    private JTextField dauerin;
    private JTextField drucki;
    private JTextArea area;
    private JButton newbtn;
    private JButton changebtn;
    private JButton seachbutn;

    ArrayList<ka> ysob = new ArrayList<ka>();

    public zsguidokasji() {
        area.setEditable(false);
        newbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ysob.add(new ka(datuminput.getText(), Double.parseDouble(teminput.getText()),
                        Double.parseDouble(sonneinp.getText()), Double.parseDouble(niederschalginput.getText()),
                        Double.parseDouble(dauerin.getText()), Double.parseDouble(drucki.getText())));
                area.append(ysob.toString());
            }
        });
        changebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        seachbutn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    // private void createUIComponents() {
    // wtf soll hier hin idk lol
    // }

    public static ArrayList<ka> change(ArrayList<ka> ysob) {
        // todo
        return ysob;
    }

    public static ArrayList<ka> search(ArrayList<ka> ysob) {
        // todo
        return ysob;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ajfisahdgsduhgdsugh");
        frame.setContentPane((new zsguidokasji().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(640,600);
        frame.pack();
        frame.setVisible(true);
    }

}
