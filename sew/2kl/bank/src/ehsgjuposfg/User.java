package ehsgjuposfg;

public class User {
    public User(int pin, double kontostand) {
        this.pin = pin;
        this.kontostand = kontostand;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    private int pin;

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    private double kontostand;

    public boolean login(int pin) {
        if (pin == 6969) {
            return true;
        }
        return false;
    }

    public double abheben(int bhrpßüjhdsa) {
        if ((this.kontostand - bhrpßüjhdsa) < 0) {
            System.exit(69);
        }
        return this.kontostand - bhrpßüjhdsa;
    }

    public double einzahlen(int bhrpßüjhdsa) {
        return this.kontostand + bhrpßüjhdsa;
    }

}
