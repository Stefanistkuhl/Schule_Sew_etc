package nix;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class nvim {
    private JPanel panel1;
    private JButton b7;
    private JButton mal;
    private JButton b8;
    private JButton b9;
    private JButton acButton;
    private JButton pm;
    private JButton prozent;
    private JButton dividieren;
    private JButton minus;
    private JButton b6;
    private JButton a5;
    private JButton b4;
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton plus;
    private JButton ergebnis;
    private JButton button18;
    private JButton a0Button1;
    private JTextField textField1;
    ArrayList<Double> input = new ArrayList<>();
    ArrayList<String> rechenoperationen = new ArrayList<>();
    String zahl_input_tmp = "";

    public nvim() {
        rechenoperationen.add("");
        ergebnis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                input.add(Double.parseDouble(zahl_input_tmp));
                System.out.println(input.size());
                // System.out.println(input);
                System.out.println("------------");
                zahl_input_tmp = Double.toString(eval(input, rechenoperationen));
                textField1.setText(Double.toString(eval(input, rechenoperationen)));
                input.clear();
                rechenoperationen.clear();
                rechenoperationen.add("");
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        acButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                zahl_input_tmp = "";
                input.clear();
                rechenoperationen.clear();
                rechenoperationen.add("");
            }
        });
        pm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double tmp = Double.parseDouble(zahl_input_tmp);
                tmp = tmp * -1;
                zahl_input_tmp = Double.toString(tmp);
                textField1.setText(zahl_input_tmp);
            }
        });
        prozent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.add(Double.parseDouble(zahl_input_tmp));
                rechenoperationen.add("%");
                zahl_input_tmp = "";
                textField1.setText("");
            }
        });
        dividieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.add(Double.parseDouble(zahl_input_tmp));
                rechenoperationen.add("/");
                zahl_input_tmp = "";
                textField1.setText("");

            }
        });
        mal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.add(Double.parseDouble(zahl_input_tmp));
                rechenoperationen.add("*");
                zahl_input_tmp = "";
                textField1.setText("");

            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "9";
                textField1.setText(zahl_input_tmp);
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "8";
                textField1.setText(zahl_input_tmp);

            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "7";
                textField1.setText(zahl_input_tmp);

            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "4";
                textField1.setText(zahl_input_tmp);
            }
        });
        a5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "5";
                textField1.setText(zahl_input_tmp);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "6";
                textField1.setText(zahl_input_tmp);
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.add(Double.parseDouble(zahl_input_tmp));
                rechenoperationen.add("-");
                zahl_input_tmp = "";
                textField1.setText("");

            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "1";
                textField1.setText(zahl_input_tmp);
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "2";
                textField1.setText(zahl_input_tmp);
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "3";
                textField1.setText(zahl_input_tmp);

            }
        });
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.add(Double.parseDouble(zahl_input_tmp));
                rechenoperationen.add("+");
                zahl_input_tmp = "";
                textField1.setText("");
            }
        });
        button18.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += ".";
                textField1.setText(zahl_input_tmp);
            }
        });
        a0Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zahl_input_tmp += "0";
                textField1.setText(zahl_input_tmp);

            }
        });
    }

    public static double eval(ArrayList<Double> in, ArrayList<String> re) {

        System.out.println(in);
        // System.out.println(re);
        double ergebnis = 0;
        double tmp = 0;
        for (int i = 0; i < in.size(); i++) {
            // 20 ifs machen für jede rechen operatiion man kann keinen str to zu operator
            // machen
            // +-*/
            // System.out.println(in.get(i));
            if (i == 1) {
                if (re.get(i).equals("+")) {
                    tmp = in.get(i) + in.get(i - 1);
                }
                if (re.get(i).equals("-")) {
                    tmp = in.get(i - 1) - in.get(i);
                }
                if (re.get(i).equals("*")) {
                    tmp = in.get(i) * in.get(i - 1);
                }
                if (re.get(i).equals("/")) {
                    tmp = in.get(i - 1) / in.get(i);
                }
                if (re.get(i).equals("%")) {
                    tmp = in.get(i - 1) % in.get(i);
                }
            }
            if (i > 1) {
                if (re.get(i).equals("+")) {
                    tmp = tmp + in.get(i);
                }
                if (re.get(i).equals("-")) {
                    tmp = tmp - in.get(i);
                }
                if (re.get(i).equals("*")) {
                    tmp = tmp * in.get(i);
                }
                if (re.get(i).equals("/")) {
                    tmp = tmp / in.get(i);
                }
                if (re.get(i).equals("%")) {
                    tmp = tmp % in.get(i);
                }
            }
        }
        ergebnis = tmp;
        System.out.println(tmp);
        return ergebnis;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NEOVIM>VSCODE");
        frame.setContentPane((new nvim().panel1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(690, 690);
        frame.setVisible(true);
    }
}
