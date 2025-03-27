import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class thissucks extends JPanel {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Color currentColor = Color.BLACK;
    private String currentShape = "FREE";
    private Point startPoint;
    private Point currentPoint;

    private static class Shape {
        Color color;
        String type;
        Point start;
        Point end;
        ArrayList<Point> points;

        Shape(Color color, String type, Point start, Point end) {
            this.color = color;
            this.type = type;
            this.start = start;
            this.end = end;
            this.points = new ArrayList<>();
        }
    }

    public thissucks() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Color picker button
        JButton colorButton = new JButton("Color");
        colorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Choose Color", currentColor);
            if (newColor != null) {
                currentColor = newColor;
            }
        });

        // Shape buttons
        JButton freeButton = new JButton("Free");
        JButton rectButton = new JButton("Rectangle");
        JButton ovalButton = new JButton("Oval");
        JButton triangleButton = new JButton("Triangle");
        JButton clearButton = new JButton("Clear");

        freeButton.addActionListener(e -> currentShape = "FREE");
        rectButton.addActionListener(e -> currentShape = "RECT");
        ovalButton.addActionListener(e -> currentShape = "OVAL");
        triangleButton.addActionListener(e -> currentShape = "TRIANGLE");
        clearButton.addActionListener(e -> {
            shapes.clear();
            startPoint = null;
            currentPoint = null;
            SwingUtilities.invokeLater(this::repaint);
        });

        controlPanel.add(colorButton);
        controlPanel.add(freeButton);
        controlPanel.add(rectButton);
        controlPanel.add(ovalButton);
        controlPanel.add(triangleButton);
        controlPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                if (currentShape.equals("FREE")) {
                    Shape shape = new Shape(currentColor, currentShape, startPoint, null);
                    shape.points.add(startPoint);
                    shapes.add(shape);
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                currentPoint = e.getPoint();
                if (currentShape.equals("FREE")) {
                    shapes.get(shapes.size()-1).points.add(currentPoint);
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!currentShape.equals("FREE")) {
                    shapes.add(new Shape(currentColor, currentShape, startPoint, e.getPoint()));
                    currentPoint = null;
                    startPoint = null;
                }
                repaint();
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape shape : shapes) {
            g2d.setColor(shape.color);
            switch (shape.type) {
                case "FREE":
                    for (int i = 1; i < shape.points.size(); i++) {
                        Point p1 = shape.points.get(i-1);
                        Point p2 = shape.points.get(i);
                        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
                    }
                    break;
                case "RECT":
                    drawRect(g2d, shape.start, shape.end);
                    break;
                case "OVAL":
                    drawOval(g2d, shape.start, shape.end);
                    break;
                case "TRIANGLE":
                    drawTriangle(g2d, shape.start, shape.end);
                    break;
            }
        }

        if (startPoint != null && currentPoint != null && !currentShape.equals("FREE")) {
            g2d.setColor(currentColor);
            switch (currentShape) {
                case "RECT":
                    drawRect(g2d, startPoint, currentPoint);
                    break;
                case "OVAL":
                    drawOval(g2d, startPoint, currentPoint);
                    break;
                case "TRIANGLE":
                    drawTriangle(g2d, startPoint, currentPoint);
                    break;
            }
        }
    }

    private void drawRect(Graphics2D g, Point start, Point end) {
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);
        g.drawRect(x, y, width, height);
    }

    private void drawOval(Graphics2D g, Point start, Point end) {
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);
        g.drawOval(x, y, width, height);
    }

    private void drawTriangle(Graphics2D g, Point start, Point end) {
        int[] xPoints = {start.x, (start.x + end.x)/2, end.x};
        int[] yPoints = {end.y, start.y, end.y};
        g.drawPolygon(xPoints, yPoints, 3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("IASCJFIASFJAISFJAISJFIASJFIjs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new thissucks());
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
