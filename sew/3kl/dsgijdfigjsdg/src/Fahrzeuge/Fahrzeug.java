package Fahrzeuge;

public abstract class Fahrzeug {
    protected double gewicht;
    protected double laenge;
    protected double breite;
    protected double hoehe;
    protected double geschwindigkeit;

    public Fahrzeug(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
        this.gewicht = gewicht;
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;
        this.geschwindigkeit = geschwindigkeit;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" +
                "gewicht=" + gewicht +
                ", laenge=" + laenge +
                ", breite=" + breite +
                ", hoehe=" + hoehe +
                ", geschwindigkeit=" + geschwindigkeit +
                '}';
    }
    abstract double bremsen(double geschwindigkeit);
    abstract double beschleunigen(double geschwindigkeit);
}
