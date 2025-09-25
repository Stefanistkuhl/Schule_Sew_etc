import javax.swing.*;
import java.awt.*;

public class Racer {
    private final JLabel label;
    private final int dx;
    private final int dy;
    private final Timer timer;

    public Racer(JLabel label, int intervalMs, int dx, int dy) {
        this.label = label;
        this.dx = dx;
        this.dy = dy;

        // Timer runs on EDT, safe for Swing
        this.timer = new Timer(
                intervalMs,
                e -> {
                    Container parent = label.getParent();
                    if (parent == null)
                        return;

                    Point p = label.getLocation();
                    int newX = p.x + dx;
                    int newY = p.y + dy;

                    // stop when moving out of parent bounds (example: right edge)
                    if (newX > parent.getWidth()) {
                        ((Timer) e.getSource()).stop();
                        return;
                    }

                    label.setLocation(newX, newY);
                    parent.repaint();
                });
    }

    public void start() {
        timer.start();
    }
}
