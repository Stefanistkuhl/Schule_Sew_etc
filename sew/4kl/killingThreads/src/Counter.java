import javax.swing.*;

public class Counter extends Thread {
    JLabel l;
    int c;

    public Counter(JLabel l, int c) {
        this.l = l;
        this.c = c;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            c++;
            l.setText(String.valueOf(c));
            try {
                sleep(500);
            } catch (InterruptedException e) {
                interrupt();
            }

        }
    }
}
