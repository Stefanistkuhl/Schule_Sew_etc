public class Auto {

    private String marke;
    private String farbe;
    private int caballostärke;
    private int räder;
    public Auto() {
        this.setMarke(getMarke());
        this.setFarbe(getFarbe());
        this.setCaballostärke(getCaballostärke());
        this.setRäder(getRäder());
    }
    @Override
    public String toString(){
        return "Marke:"+ getMarke() +" Farbe:"+ getFarbe() +" Pferdestärke:"+ getCaballostärke() +" Räder:"+ getRäder();
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getCaballostärke() {
        return caballostärke;
    }

    public void setCaballostärke(int caballostärke) {
        this.caballostärke = caballostärke;
    }

    public int getRäder() {
        return räder;
    }

    public void setRäder(int räder) {
        this.räder = räder;
    }

}
