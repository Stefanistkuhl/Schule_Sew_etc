import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class thing {
    private JTextArea out;
    private JPanel panel1;
    private JTextField inp;
    private JButton gebFib;
    private JButton genFag;
    private JLabel outFib;
    private JTextField inpFak;
    private JLabel outEx;
    private JTextField inpEx2;
    private JTextField inpEx1;
    private JLabel outFak;
    private JButton genEx;

    public thing() {
        gebFib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int imput = Integer.parseInt(inp.getText());
                int res = fibonacci(imput);
                outFib.setText(String.valueOf(res));
            }
        });
        genFag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int imput = Integer.parseInt(inpFak.getText());
                int res = fak(imput);
                outFak.setText(String.valueOf(res));

            }
        });
        genEx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int imput1 = Integer.parseInt(inpEx1.getText());
                int imput2 = Integer.parseInt(inpEx2.getText());
                int res = ex(imput1, imput2);
                outEx.setText(String.valueOf(res));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("grjielocspxigzruisoru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new thing().panel1);
        frame.pack();
        frame.setSize(800, 300);
        frame.setVisible(true);

    }
    public static int ex(int pow, int num) {
        if (pow < 1)
            return 1;
        else
            return num * ex(pow-1, num) ;
    }


    public int fak(int n)  {
            if (n ==1){
                return 1;
            }
            else{
            return n * fak(n-1);
            }

    }

    public int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);

    }
}
