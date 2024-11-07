package Fahrzeuge;

import Transport.ITransportierbar;

public class PKW extends Fahrzeug implements ITransportierbar {

    public PKW(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
        super(gewicht, laenge, breite, hoehe, geschwindigkeit);
    }

    @Override
    double bremsen(double geschwindigkeit) {
        return 0;
    }

    @Override
    double beschleunigen(double geschwindigkeit) {
        return 0;
    }

    @Override
    public boolean checkTransportierbar() {
        if (this.gewicht > MAXGEWICHT){
            return false;
        }
        else{return true;}
    }
}
