import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Thing {
    private JPanel panel1;
    private JLabel ball;
    private JLabel thingL;
    private JLabel thingR;
    private JLabel scoreLeft;
    private JButton startButton;
    private JLabel scoreRight;
    private final JFrame frame;

    ImageIcon paddleLeftIcon =
            new ImageIcon(
                    Objects.requireNonNull(Thing.class.getResource("/images/paddleLeft.png")));
    ImageIcon paddeRightIcon =
            new ImageIcon(
                    Objects.requireNonNull(Thing.class.getResource("/images/paddleRight.png")));
    ImageIcon ballIcon =
            new ImageIcon(Objects.requireNonNull(Thing.class.getResource("/images/ball.png")));
    ImageIcon paddleLeftSmall = scaleBy(paddleLeftIcon, 0.5);
    ImageIcon paddleRightSmall = scaleBy(paddeRightIcon, 0.5);
    ImageIcon ballSmall = scaleBy(ballIcon, 0.2);

    private int leftVel = 0, rightVel = 0;
    private int ballVx = 6, ballVy = 4;
    private int scoreL = 0, scoreR = 0;
    private Timer timer;
    private final int paddleSpeed = 10;
    private boolean waitingForServe = true;

    public Thing(JFrame frame) {
        this.frame = frame;

        panel1.setLayout(null);
        panel1.setBackground(Color.BLACK);

        thingL.setIcon(paddleLeftSmall);
        thingR.setIcon(paddleRightSmall);
        ball.setIcon(ballSmall);
        thingL.setText("");
        thingR.setText("");
        ball.setText("");

        scoreLeft.setForeground(Color.WHITE);
        scoreRight.setForeground(Color.WHITE);
        scoreLeft.setFont(new Font("SansSerif", Font.BOLD, 24));
        scoreRight.setFont(new Font("SansSerif", Font.BOLD, 24));
        scoreLeft.setHorizontalAlignment(SwingConstants.CENTER);
        scoreRight.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLeft.setText("0");
        scoreRight.setText("0");

        thingL.setBounds(
                40, 200, paddleLeftSmall.getIconWidth(), paddleLeftSmall.getIconHeight());
        thingR.setBounds(
                820, 200, paddleRightSmall.getIconWidth(), paddleRightSmall.getIconHeight());
        ball.setBounds(430, 230, ballSmall.getIconWidth(), ballSmall.getIconHeight());

        scoreLeft.setBounds(900 / 2 - 80, 10, 60, 30);
        scoreRight.setBounds(900 / 2 + 20, 10, 60, 30);
        startButton.setBounds(10, 10, 100, 30);

        setupKeybinds();

        startButton.addActionListener(e -> startOrReset());

        timer = new Timer(1000 / 60, e -> tick());
        centerBall();
    }

    public static ImageIcon scaleBy(ImageIcon src, double percent) {
        int w = (int) Math.round(src.getIconWidth() * percent);
        int h = (int) Math.round(src.getIconHeight() * percent);
        Image scaled = src.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
        return new ImageIcon(scaled);
    }

    private void setupKeybinds() {
        bind(panel1, "L_UP_P", "pressed W", () -> { leftVel = -paddleSpeed; tryServe(); });
        bind(panel1, "L_UP_R", "released W", () -> { if (leftVel < 0) leftVel = 0; });
        bind(panel1, "L_DN_P", "pressed S", () -> { leftVel = +paddleSpeed; tryServe(); });
        bind(panel1, "L_DN_R", "released S", () -> { if (leftVel > 0) leftVel = 0; });

        bind(panel1, "R_UP_P", "pressed UP", () -> { rightVel = -paddleSpeed; tryServe(); });
        bind(panel1, "R_UP_R", "released UP", () -> { if (rightVel < 0) rightVel = 0; });
        bind(panel1, "R_DN_P", "pressed DOWN", () -> { rightVel = +paddleSpeed; tryServe(); });
        bind(panel1, "R_DN_R", "released DOWN", () -> { if (rightVel > 0) rightVel = 0; });
    }

    public static void bind(JComponent c, String name, String rune, Runnable action) {
        InputMap im = c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = c.getActionMap();
        im.put(KeyStroke.getKeyStroke(rune), name);
        am.put(
                name,
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.run();
                    }
                });
    }

    private void startOrReset() {
        centerBall();
        randomizeBallDirection();
        waitingForServe = false;
        if (!timer.isRunning()) timer.start();
    }

    private void tryServe() {
        if (!waitingForServe) return;
        waitingForServe = false;
        if (!timer.isRunning()) timer.start();
    }

    private void randomizeBallDirection() {
        ballVx = 6 * (Math.random() < 0.5 ? 1 : -1);
        ballVy = 4 * (Math.random() < 0.5 ? 1 : -1);
    }

    private void centerBall() {
        int x = (panel1.getWidth() - ball.getWidth()) / 2;
        int y = (panel1.getHeight() - ball.getHeight()) / 2;
        ball.setLocation(Math.max(0, x), Math.max(0, y));
    }

    private void moveY(JComponent c, int dy, int panelH) {
        int newY = Math.max(0, Math.min(c.getY() + dy, panelH - c.getHeight()));
        c.setLocation(c.getX(), newY);
    }

    private void stopForServe() {
        waitingForServe = true;
        if (timer.isRunning()) timer.stop();
    }

    private void tick() {
        int panelH = panel1.getHeight();
        int panelW = panel1.getWidth();

        moveY(thingL, leftVel, panelH);
        moveY(thingR, rightVel, panelH);

        ball.setLocation(ball.getX() + ballVx, ball.getY() + ballVy);

        if (ball.getY() <= 0) ballVy = Math.abs(ballVy);
        if (ball.getY() + ball.getHeight() >= panelH) ballVy = -Math.abs(ballVy);

        if (ball.getBounds().intersects(thingL.getBounds()) && ballVx < 0) ballVx = Math.abs(ballVx);
        if (ball.getBounds().intersects(thingR.getBounds()) && ballVx > 0) ballVx = -Math.abs(ballVx);

        if (ball.getX() + ball.getWidth() < 0) {
            scoreR++;
            scoreRight.setText(Integer.toString(scoreR));
            centerBall();
            randomizeBallDirection();
            stopForServe();
            return;
        } else if (ball.getX() > panelW) {
            scoreL++;
            scoreLeft.setText(Integer.toString(scoreL));
            centerBall();
            randomizeBallDirection();
            stopForServe();
            return;
        }

        panel1.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    JFrame frame = new JFrame("who needs window titles");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    Thing content = new Thing(frame);
                    frame.setContentPane(content.panel1);
                    frame.setSize(900, 500);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    SwingUtilities.invokeLater(content::centerBall);
                });
    }
}