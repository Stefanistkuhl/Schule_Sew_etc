package Backend;

public abstract class Konto implements IKontoInterface{
    protected String kontoinhaber;
    protected String kontonummer;
    protected double kontostand;

    public Konto(String kontoinhaber, String kontonummer, double kontostand) {
        kontoinhaber="";
        kontostand=0;
        this.kontoinhaber = kontoinhaber;
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
    }
    @Override
    public double getKontostand() {
        return kontostand;
    }
    public abstract void einzahlen(double betrag);
    public abstract void auszahlen(double betrag);
}
