import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    ArrayList<Product>a=new ArrayList<>();
    public GUI() {
        dropdown.setModel(new DefaultComboBoxModel(Category.values()));
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ProductManager  productManager = new ProductManager(textField3.getText());
                Product product = productManager.loadProduct();
                System.out.println(product.toString());
                output.setText(product.toString());
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder result = new StringBuilder();
                Pattern pattern = Pattern.compile("name='(.*?)'");

                for (Object item : a) {
                    Matcher matcher = pattern.matcher(item.toString());

                    if (matcher.find()) {
                        String name = matcher.group(1);
                        if (name.toLowerCase().contains(nameInput.getText().toLowerCase())) {
                            result.append(item).append("\n");
                        }
                    }
                }

                output.setText(result.toString());
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ProductManager  productManager = new ProductManager(textField3.getText());
                String name = nameInput.getText();
                int price = Integer.parseInt(priceInput.getText());
                Category category = (Category) dropdown.getSelectedItem();
                Product product = new Product(name,price,category);
                //System.out.println(category);
                a.add(product);
                output.setText(product.toString());
                FileWriter fw = null;
                productManager.saveProduct(a);
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
