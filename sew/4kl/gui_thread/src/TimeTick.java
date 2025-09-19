import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimeTick extends Thread{
    private JLabel jb;
    public void run(){
        while(true){
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            jb.setText(String.valueOf(date) + String.valueOf(time));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public TimeTick(JLabel jb){
        this.jb = jb;
    }
}
