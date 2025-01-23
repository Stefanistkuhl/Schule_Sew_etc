import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductManager {
    private String FILE_PATH;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ProductManager(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public void saveProduct(ArrayList<Product> product) {
        ArrayList<ArrayList<Product>> products = new ArrayList<>();
        if (products == null) {
            products = new ArrayList<>();
        }

        products.add(product);
        this.FILE_PATH += ".json";

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(products, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FILE_PATH = FILE_PATH.substring(0, FILE_PATH.length() - 5);
        this.FILE_PATH += ".xml";
        XStream xstream = new XStream();
        xstream.alias("Product", Product.class);
        xstream.alias("Products", ArrayList.class);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            xstream.toXML(products, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Product loadProduct() {
        if ((int) ( Math.random() * 2 + 1)==1){
            this.FILE_PATH += ".json";
            try (FileReader reader = new FileReader(FILE_PATH)) {
                return gson.fromJson(reader, Product.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }else{
        FILE_PATH = FILE_PATH.substring(0, FILE_PATH.length() - 5);
        this.FILE_PATH += ".xml";
        XStream xstream = new XStream();
        xstream.alias("Product", Product.class);
        xstream.alias("Products", ArrayList.class);
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return (Product) xstream.fromXML(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }}
    }
}