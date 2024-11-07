package Fahrzeuge;

import Transport.ITransportierbar;

public class LWK extends Fahrzeug implements ITransportierbar {
    public LWK(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
        super(gewicht, laenge, breite, hoehe, geschwindigkeit);
    }

    @Override
    double bremsen(double geschwindigkeit) {
        return this.geschwindigkeit-54;
    }

    @Override
    double beschleunigen(double geschwindigkeit) {
        return this.geschwindigkeit+3456;
    }

    @Override
    public boolean checkTransportierbar() {
        if (this.gewicht*0.2 > MAXGEWICHT || this.laenge*0.2 > MAX_LÄNGE || this.breite*0.2 > MAX_BREITE || this.hoehe*0.2 > MAX_HÖHE){
            return false;
        }
        else{return true;}
    }
}
