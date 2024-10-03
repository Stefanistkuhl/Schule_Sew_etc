public class Auto extends Fahrzeug {

    public int getAnzahlTüren() {
        return anzahlTüren;
    }

    public void setAnzahlTüren(int anzahlTüren) {
        this.anzahlTüren = anzahlTüren;
    }

    private int anzahlTüren;

    public Auto(int anzahlTüren) {
        this.anzahlTüren = anzahlTüren;
    }

    public void fahren() {
        System.out.println("Das Auto fährt " + getGeschwindigkeit() + " km/h und hat " + this.anzahlTüren + " Türen");
    }

}
