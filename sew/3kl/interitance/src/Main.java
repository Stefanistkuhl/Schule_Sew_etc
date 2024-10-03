public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! :3");
        Auto auto = new Auto(3);
        auto.setGeschwindigkeit(69);
        auto.fahren();
        Fahrrad fahrrad = new Fahrrad(true);
        fahrrad.setGeschwindigkeit(169);
        fahrrad.fahren();
    }
}
