import javax.swing.*;
import java.awt.*;

public class _5GUIUpdateRepaint extends JPanel {
    private int ovalX = 10;
    private int ovalY = 10;

    public _5GUIUpdateRepaint() {
        // Move the oval every second
        Timer timer = new Timer(1000, e -> {
            ovalX += 10;
            ovalY += 10;
            repaint(); // Request a repaint
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(ovalX, ovalY, 50, 50);
    }

    @Override
    public void update(Graphics g) {
        // Custom update behavior (optional)
        super.update(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Update vs Repaint Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _5GUIUpdateRepaint());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
/*
In Java's AWT and Swing, update and repaint are methods used to refresh the display of a component, but they serve different purposes and are used in different contexts.
repaint()
Purpose: Requests that a component be repainted.
How it works: When you call repaint(), it schedules a call to the component's update method, which in turn calls paint.
Usage: Typically used when you want to refresh the display of a component after making changes to its state.
update(Graphics g)
Purpose: Prepares the component for painting.
How it works: The update method is called by the AWT painting system in response to a repaint request. By default, it clears the component's drawing area and then calls paint.
Usage: You rarely call update directly. Instead, you override it if you need to customize the clearing behavior before painting.
*/