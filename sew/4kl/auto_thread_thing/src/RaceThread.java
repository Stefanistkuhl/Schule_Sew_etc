import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CompletableFuture;

public class RaceThread extends Thread {
    private final JLabel label;
    private final int intervalMs;
    private final int dx;
    private final int dy;
    private final CompletableFuture<String> winner;

    public RaceThread(JLabel label, int intervalMs, int dx, int dy, CompletableFuture<String> winner) {
        this.label = label;
        this.intervalMs = intervalMs;
        this.dx = dx;
        this.dy = dy;
        this.winner = winner;
        setName("RaceThread-" + label.getName());
        setDaemon(true);
    }

    @Override
    public void run() {
        while (!winner.isDone()) {
            final boolean[] finished = { false };

            try {
                SwingUtilities.invokeAndWait(() -> {
                    Container parent = label.getParent();
                    if (parent == null || !parent.isShowing()) {
                        finished[0] = true;
                        return;
                    }

                    Point p = label.getLocation();
                    int newX = p.x + dx;
                    int newY = p.y + dy;

                    int limitX = parent.getWidth() - label.getWidth();
                    if (newX >= limitX) {
                        newX = limitX;
                        finished[0] = true;
                    }

                    int limitY = parent.getHeight() - label.getHeight();
                    newY = Math.max(0, Math.min(newY, limitY));

                    label.setLocation(newX, newY);
                    parent.repaint();
                });
            } catch (Exception ex) {
                return;
            }

            if (finished[0]) {
                String name = label.getName() != null ? label.getName() : label.toString();
                winner.complete(name);
                return;
            }

            try {
                Thread.sleep(intervalMs);
            } catch (InterruptedException ie) {
                return;
            }
        }
    }
}
