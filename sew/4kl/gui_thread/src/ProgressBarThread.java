import javax.swing.*;
import java.time.LocalTime;

public class ProgressBarThread extends Thread{
    private JProgressBar sec;
    private JProgressBar min;
    private JProgressBar hours;

    public void run(){
        while (true){
            LocalTime time = LocalTime.now();
            int valsec = time.getSecond();
            int valmin = time.getMinute();
            int valhour =  time.getHour();
            sec.setValue(valsec);
            min.setValue(valmin);
            hours.setValue(valhour);
        }
    }
    public ProgressBarThread(JProgressBar sec, JProgressBar min, JProgressBar hours){
        this.sec = sec;
        this.min = min;
        this.hours = hours;
    }
}
