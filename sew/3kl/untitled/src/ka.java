public class ka {
    private String datum;

    private double temp;
    private double sonne;
    private double nierschlag;
    private double ndauer;
    private double luftdruck;

    public ka(String datum, double temp, double sonne, double nierschlag, double ndauer, double luftdruck) {
        this.datum = datum;
        this.temp = temp;
        this.sonne = sonne;
        this.nierschlag = nierschlag;
        this.ndauer = ndauer;
        this.luftdruck = luftdruck;
    }

    @Override
    public String toString() {
        return "datum:" + this.getDatum() + " temp:" + this.getTemp() + " niederschalg:" + this.getNierschlag()
                + " ndauer:" + this.getNdauer() + " luftdruck:" + this.getLuftdruck();
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getSonne() {
        return sonne;
    }

    public void setSonne(double sonne) {
        this.sonne = sonne;
    }

    public double getNierschlag() {
        return nierschlag;
    }

    public void setNierschlag(double nierschlag) {
        this.nierschlag = nierschlag;
    }

    public double getNdauer() {
        return ndauer;
    }

    public void setNdauer(double ndauer) {
        this.ndauer = ndauer;
    }

    public double getLuftdruck() {
        return luftdruck;
    }

    public void setLuftdruck(double luftdruck) {
        this.luftdruck = luftdruck;
    }

}
