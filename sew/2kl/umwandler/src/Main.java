import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc_str = new Scanner(System.in);
        Scanner sc_double = new Scanner(System.in);
        double eingabe = 0;
        String auswahl = null;
        double ergebnis;
        double[] speichern = new double[50];
        int i = 0;

        while(true) {

            while (true) {
                System.out.println("Welchen Modus möchstest du benutzen? c->k, c->f, m->mi, i-f oder gebe stopp ein um zu stoppen");
                try {
                    auswahl = sc_str.nextLine();
                    if (auswahl.equals("c->k") || auswahl.equals("c->f") || auswahl.equals("m->mi") || auswahl.equals("i->f")) {
                        break;
                    }
                    if (auswahl.equals("stopp")){
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Ungültige eingabe");

                }
            }

            switch (auswahl) {
                case "c->k": {
                    try {
                        System.out.println("Gebe einen Wert ein, den du von Celsius in Kelvin umwandeln willst");
                        eingabe = sc_double.nextDouble();
                    }catch (Exception e){
                        System.out.println("Ungültige eingabe");
                    }
                    ergebnis = eingabe + 273;
                    speichern[i] = ergebnis;
                    System.out.println("Das sind " + ergebnis + " Kelvin");
                    break;
                }
                case "c->f": {
                    try {
                        System.out.println("Gebe einen Wert ein, den du von Celsius in Fahrenheit umwandeln willst");
                        eingabe = sc_double.nextDouble();
                    }catch (Exception e){
                        System.out.println("Ungültige eingabe");
                    }
                    ergebnis = eingabe * 1.8 + 32;
                    speichern[i] = ergebnis;
                    System.out.println("Das sind " + ergebnis + " Fahrendheit");
                    break;
                }
                case "m->mi": {
                    try {
                        System.out.println("Gebe einen Wert ein, den du von Metern in Meilen umwandeln willst");
                        eingabe = sc_double.nextDouble();
                    }catch (Exception e){
                        System.out.println("Ungültige eingabe");
                    }
                    ergebnis = eingabe * 1.6;
                    speichern[i] = ergebnis;
                    System.out.println("Das sind " + ergebnis + " Meilen");
                    break;
                }
                case "i->f": {
                    try {
                        System.out.println("Gebe einen Wert ein, den du von Inch in Foot umwandeln willst");
                        eingabe = sc_double.nextDouble();
                    }catch (Exception e){
                        System.out.println("Ungültige eingabe");
                    }
                    ergebnis = eingabe * 12;
                    speichern[i] = ergebnis;
                    System.out.println("Das sind " + ergebnis + " Kelvin");
                    break;
                }
            }
            i += 1;
            if (auswahl.equals("stopp")){
                break;
            }
        }
        System.out.println(Arrays.toString(speichern));
    }
}