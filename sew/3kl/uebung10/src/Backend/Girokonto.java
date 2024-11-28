package Backend;

public class Girokonto extends Konto{
    protected double dispoLimit;

    public Girokonto(String kontoinhaber, String kontonummer, double kontostand) {
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
        if(betrag <= 0 || betrag > dispoLimit){
            try {
                throw new IllegalAccessException("ungültige eingabe");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
       kontostand -= betrag;
    }
    public void einzahlen(){
        kontostand += 100;
    }
}
