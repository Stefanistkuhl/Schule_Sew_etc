import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _11GUIMultipleWindowMain extends JFrame {
    public _11GUIMultipleWindowMain() {
        setTitle("Haupfenster");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton openButton = new JButton("2. Fenster öffnen");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new _11GUIMultipleWindowSecond().setVisible(true);
            }
        });

        add(openButton);
    }

    public static void main(String[] args) {
        new _11GUIMultipleWindowMain().setVisible(true);
    }
}