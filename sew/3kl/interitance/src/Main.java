import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! :3");
        ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
        Auto auto = new Auto(120, 3);
        // auto.setGeschwindigkeit(69);
        auto.fahren();
        Fahrrad fahrrad = new Fahrrad(169, true);
        // fahrrad.setGeschwindigkeit(169);
        fahrrad.fahren();
        fahrzeuge.add(auto);
        fahrzeuge.add(fahrrad);
        for (Fahrzeug fahrzeug : fahrzeuge) {
            System.out.println("Geschwindigkeit: " + fahrzeug.getGeschwindigkeit());
        }

    }
}
