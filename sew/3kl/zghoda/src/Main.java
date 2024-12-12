import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
   public static void main(String[] args) {
      System.out.println(":java:");
      String inputPath = "input";
      writeToFile(inputPath);
      readFromFile(inputPath);

   }

   public static void writeToFile(String filePath) {
      try {
         BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
         writer.write(":noJava:");
         writer.close();
         System.out.println("scusesfully written to file");
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }

   private static void readFromFile(String filePath) {
      try {
         BufferedReader reader = new BufferedReader(new FileReader(filePath));
         String line;
         System.out.println("Reading file");
         while ((line = reader.readLine()) != null) {
            System.out.println(line);
         }
         reader.close();
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }

}
