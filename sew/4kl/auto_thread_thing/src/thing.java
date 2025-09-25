import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class thing {
    private JPanel panel1;
    private JButton startButton;
    private JLabel ynails;
    private JLabel yfear;
    private JLabel ydread;
    private final JFrame frame;
    private JLabel spoingus;

    public thing(JFrame frame) {
        this.frame = frame;

        ImageIcon spoingusIcon = new ImageIcon(
                Objects.requireNonNull(thing.class.getResource("/images/spoingusheimer.jpg")));
        spoingus.setIcon(spoingusIcon);
        ImageIcon ynailsIcon = new ImageIcon(
                Objects.requireNonNull(thing.class.getResource("/images/ynails.png")));
        ynails.setIcon(ynailsIcon);
        ImageIcon yfearIcon = new ImageIcon(
                Objects.requireNonNull(thing.class.getResource("/images/yfear.png")));
        yfear.setIcon(yfearIcon);
        ImageIcon ydreadIcon = new ImageIcon(
                Objects.requireNonNull(thing.class.getResource("/images/ydread.png")));
        ydread.setIcon(ydreadIcon);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spoingus.setName("spoingus");
                yfear.setName("yfear");
                ydread.setName("ydread");
                ynails.setName("ynails");
                CompletableFuture<String> winner = new CompletableFuture<>();

                winner.thenAccept(name -> SwingUtilities
                        .invokeLater(() -> JOptionPane.showMessageDialog(frame, "Winner: " + name)));

                ThreadLocalRandom rnd = ThreadLocalRandom.current();
                int i1 = rnd.nextInt(15, 51), i2 = rnd.nextInt(15, 51),
                        i3 = rnd.nextInt(15, 51), i4 = rnd.nextInt(15, 51);
                int step = 5;

                new RaceThread(spoingus, i1, step, 0, winner).start();
                new RaceThread(yfear, i2, step, 0, winner).start();
                new RaceThread(ydread, i3, step, 0, winner).start();
                new RaceThread(ynails, i4, step, 0, winner).start();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("i hate setting window titles bc they are useless anyway");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            thing content = new thing(frame);
            frame.setContentPane(content.panel1);
            frame.setSize(900, 500);
            frame.setVisible(true);
        });
    }

}
