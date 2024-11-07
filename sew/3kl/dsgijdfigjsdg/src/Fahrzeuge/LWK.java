package Fahrzeuge;

import Transport.ITransportierbar;

public class LWK extends Fahrzeug implements ITransportierbar {
    public LWK(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
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
        if (this.gewicht*0.2 > MAXGEWICHT){
            return false;
        }
        else{return true;}
    }
}
