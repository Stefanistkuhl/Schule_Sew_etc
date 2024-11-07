package Fahrzeuge;

import Transport.ITransportierbar;

public class PKW extends Fahrzeug implements ITransportierbar {

    public PKW(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
        super(gewicht, laenge, breite, hoehe, geschwindigkeit);
    }

    @Override
    double bremsen(double geschwindigkeit) {
        return this.geschwindigkeit-5839;
    }

    @Override
    double beschleunigen(double geschwindigkeit) {
        return this.geschwindigkeit+495;
    }

    @Override
    public boolean checkTransportierbar() {
        if (this.gewicht > MAXGEWICHT || this.laenge > MAX_LÄNGE || this.breite > MAX_BREITE || this.hoehe > MAX_HÖHE){
            return false;
        }
        else{return true;}
    }
}
