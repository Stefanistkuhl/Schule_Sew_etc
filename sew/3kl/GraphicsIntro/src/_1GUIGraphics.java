import javax.swing.*;
import java.awt.*;

public class _1GUIGraphics extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] x = {950,450,650};
        int[] y = {450,450,250};
        g.setColor(Color.BLACK);
        g.fillRect(185,550, 80,300);
        g.setColor(Color.ORANGE);
        g.fillOval(120,400, 200, 200);
        g.setColor(Color.YELLOW);
        g.fillRoundRect(450,450, 500, 400, 10, 10);
        g.setColor(Color.BLUE);
        g.fillRect(550,600,110,110);
        g.setColor(Color.GREEN);
        g.fillRect(800,710, 80,140);
        g.setColor(Color.RED);
        g.fillPolygon(x,y ,3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("uuh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _1GUIGraphics());
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}
