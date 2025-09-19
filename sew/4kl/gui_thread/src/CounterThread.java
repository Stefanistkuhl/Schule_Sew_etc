import javax.swing.*;

public class CounterThread extends Thread{
    private JLabel jb;
    public void run(){
        for (int i = 0; i < 10; i++) {
            jb.setText(""+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public CounterThread(JLabel jb){
        this.jb = jb;
    }
}
