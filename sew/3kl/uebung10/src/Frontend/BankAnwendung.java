package Frontend;
import Backend.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class BankAnwendung {
    public static final ArrayList<Konto> konten = new ArrayList<>();
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IllegalAccessException {
        String eingbabe = "";
        while (true) {
            System.out.println("epic bank programm\n" +
                    "[c]reate account \n" +
                    "[d]eposit\n" +
                    "[w]ithdraw \n" +
                    "[s]how balance \n" +
                    "[q]uit");
            eingbabe = sc.nextLine();
            if (eingbabe.equals("q")){
                break;
            }
                switch (eingbabe){
                    case "c" -> createAccount(konten);
                    case "d" -> deposit();
                    case "w" -> withdraw();
                    case "s" -> showBalance();
                    default -> System.out.println("please use a valid command");
                }

        }
    }
    public static void createAccount(ArrayList<Konto>konten){
        String accountNumber = "";
        String input = "";
        String name = "";
        double dispoLimit = 0;
        double zinssatz = 0;
        System.out.println("---Account Creation---");
        System.out.println("Account Owner Name:");
        name = sc.nextLine();
        System.out.println("Accountnumber:");
        accountNumber = sc.nextLine();
        while (true) {
            System.out.println("Type of Account ([g]irokonto, [s]parkonto):");
            input = sc.nextLine();
            if (input.equals("g")) {
                while (true) {
                    dispoLimit = 0;
                    System.out.println("Dispo-Limit:");
                    try {
                        dispoLimit = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Please enter a valid number");
                        break;
                    }
                }
                Girokonto g = new Girokonto(name,accountNumber,dispoLimit);
                konten.add(g);
            } else if (input.equals("s")) {
                while (true) {
                    System.out.println("Dispo-Limit:");
                    try {
                        zinssatz = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Please enter a valid number");
                    }
                }
                Sparkonto s = new Sparkonto(name,accountNumber,zinssatz);
                konten.add(s);
            }else{
                System.out.println("Please enter a valid option");
            }

        }
    }
    public static void deposit(){
        System.out.println("Enter your account number to deposit to");

    }
    public static void withdraw(){

    }
    public static void showBalance(){

    }
}
