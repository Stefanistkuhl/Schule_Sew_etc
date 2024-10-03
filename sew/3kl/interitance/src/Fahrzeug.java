public class Fahrzeug {
    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    private double geschwindigkeit;

    public void fahren() {
        System.out.println("Das Fahrzeug fähr mit " + getGeschwindigkeit() + " km/h");
    }
}
