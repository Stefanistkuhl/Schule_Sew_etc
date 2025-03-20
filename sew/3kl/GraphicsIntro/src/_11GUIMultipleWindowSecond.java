import javax.swing.*;

public class _11GUIMultipleWindowSecond extends JFrame {
    public _11GUIMultipleWindowSecond() {
        setTitle("2. Fenster");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Wir befinden uns im 2.Fenster ", SwingConstants.CENTER);
        add(label);
    }
}