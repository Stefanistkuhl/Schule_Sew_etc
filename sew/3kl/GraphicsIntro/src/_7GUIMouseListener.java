import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class _7GUIMouseListener extends JPanel {
    private final List<Point> points = new ArrayList<>();
    private final JButton deleteButton;

    public _7GUIMouseListener() {
        setLayout(new BorderLayout());

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            points.clear();
            repaint();
        });

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(deleteButton);

        add(topPanel, BorderLayout.NORTH);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Point point : points) {
            g.fillOval(point.x - 10, point.y - 10, 20, 20);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _7GUIMouseListener());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}