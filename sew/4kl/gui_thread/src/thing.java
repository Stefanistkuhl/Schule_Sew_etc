import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class thing {
    private JButton btn;
    private JPanel panel1;
    private JLabel label;
    private JLabel time;
    private JProgressBar secondbar;
    private JProgressBar minBar;
    private JProgressBar hoursBar;

    public thing() {
        secondbar.setMaximum(60);
        minBar.setMaximum(60);
        hoursBar.setMaximum(24);
        TimeTick tt = new TimeTick(time);
        tt.start();
        ProgressBarThread ttt = new ProgressBarThread(secondbar, minBar, hoursBar);
        ttt.start();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CounterThread t = new CounterThread(label);
                t.start();
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("grjielocspxigzruisoru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new thing().panel1);
        frame.pack();
        frame.setSize(800, 300);
        frame.setVisible(true);

    }

}
