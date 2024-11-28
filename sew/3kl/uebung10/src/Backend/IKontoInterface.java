package Backend;

public interface IKontoInterface {
    void einzahlen(double betrag);
    void auszahlen(double betrag);
    double getKontostand();
}
