public class Auto extends Fahrzeug {

    public int getAnzahlTüren() {
        return anzahlTüren;
    }

    public void setAnzahlTüren(int anzahlTüren) {
        this.anzahlTüren = anzahlTüren;
    }

    private int anzahlTüren;

    public Auto(double geschwindigkeit, int anzahlTüren) {
        super(geschwindigkeit);
        this.anzahlTüren = anzahlTüren;
    }

    @Override
    public void fahren() {
        System.out.println(
                "Das Auto fährt " + super.geschwindigkeit + " km/h und hat " + this.anzahlTüren + " Türen");
    }

}
