import java.util.*;
public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int wert = ((int)(Math.random()*(6-1)))+1;
            int eingabe = 0;
            while (true){
                eingabe = scanner.nextInt();
                if (eingabe == wert){
                    System.out.println(("Du hast es erraten! Die Zahl war: " + wert));
                    break;
                }
            }

        }
    }
