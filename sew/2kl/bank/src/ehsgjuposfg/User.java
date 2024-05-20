package ehsgjuposfg;

import static javax.swing.JOptionPane.showMessageDialog;

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
        if (pin == this.pin) {
            return true;
        }
        return false;
    }

    public boolean abheben(double bhrpßüjhdsa) {
        if ((this.kontostand - bhrpßüjhdsa) < 0) {
            showMessageDialog(null, "du hast kein geld dafür oida");
            return false;
        }
        this.kontostand -= bhrpßüjhdsa;
        return true;
    }

    public double einzahlen(double bhrpßüjhdsa) {
        this.kontostand += bhrpßüjhdsa;
        return this.kontostand + bhrpßüjhdsa;
    }

}
