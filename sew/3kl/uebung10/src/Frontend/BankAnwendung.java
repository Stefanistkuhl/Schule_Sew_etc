package Frontend;
import Backend.*;

import java.util.Scanner;

public class BankAnwendung {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
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
            if (eingbabe.equals("c") || eingbabe.equals("d") || eingbabe.equals("w") || eingbabe.equals("s")){
                eingbabe = "";
                switch (eingbabe){
                    case "c":
                        createAccount();
                        break;
                    case "d":
                        deposit();
                        break;
                    case "w":
                        withdraw();
                        break;
                    case "s":
                        showBalance();
                        break;
                }
            }else {
                eingbabe = "";
                System.out.println("please use a valid command");
            }

        }
    }
    public static void createAccount(){
        String input = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Account Creation\n");
        System.out.println("\nAccount Owner Name:");
        System.out.println("\nAccountnumber:");
        System.out.println("\nType of Account ([g]irokonto, 2 = [s]parkonto):");
        if (input.equals("g")){
            System.out.println("\nDispo-Limit");
        }
        if (input.equals("s")){
            System.out.println("\nZinssatz");
        }
    }
    public static void deposit(){

    }
    public static void withdraw(){

    }
    public static void showBalance(){

    }
}
