package Backend;

public class Sparkonto extends Konto implements IKontoInterface{
    protected double zinssatz;

    public Sparkonto(String kontoinhaber, String kontonummer, double kontostand) {
        super(kontoinhaber, kontonummer, kontostand);
    }

    @Override
    public void einzahlen(double betrag) {
        if(betrag <= 0){
            try {
                throw new IllegalAccessException("ungültige eingabe");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        kontostand += betrag;
    }

    @Override
    public void auszahlen(double betrag) {
        if(betrag <= 0 || betrag > kontostand){
            try {
                throw new IllegalAccessException("ungültige eingabe");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        kontostand -= betrag;
    }
    public void auszahlen(){
        kontostand -= 50;
    }
    public void zinsenBerechnen(){
        kontostand += kontostand * (zinssatz/100);
    }
}
