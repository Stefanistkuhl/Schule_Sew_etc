import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Counter extends Thread {
    JLabel l;
    List<JButton> buttons;
    JButton randomButton;

    public Counter(JLabel l, List<JButton> buttons) {
        this.l = l;
        this.buttons = buttons;
    }

    @Override
    public void run() {
        randomButton = buttons.get(ThreadLocalRandom.current().nextInt(buttons.size()));
        var delay = ThreadLocalRandom.current().nextInt(2000, 5001);

        randomButton.setBackground(Color.RED);
        var startTime = System.currentTimeMillis();

        try {
            sleep(delay);
        } catch (InterruptedException e) {
            var endTime = System.currentTimeMillis();
            var reactionTime = endTime - startTime;
            l.setText(reactionTime + " ms");
            randomButton.setBackground(Color.WHITE);
            return;
        }

        randomButton.setBackground(Color.WHITE);
        l.setText("too slow");
    }

    public boolean isCorrectButton(JButton clicked) {
        return clicked == randomButton;
    }
}