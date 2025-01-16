import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panel1;
    private JTextField nameInput;
    private JTextField priceInput;
    private JComboBox dropdown;
    private JButton searchButton;
    private JButton loadButton;
    private JTextField textField3;
    private JButton saveButton;
    private JTextArea output;

    public GUI() {
        dropdown.setModel(new DefaultComboBoxModel(Category.values()));
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i =0;i<Category.values().length;i++){
                    output.append(Category.values()[i].toString()+"\n");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("who has titlebars enabled anyways");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUI().panel1);
        frame.pack();
        frame.setVisible(true);
    }
}
