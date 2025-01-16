import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductManager {
    private static final String FILE_PATH = "product.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveProduct(Product product) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(product, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product loadProduct() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

