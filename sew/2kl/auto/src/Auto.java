public class Auto {

    public String marke;
    public String farbe;
    public int caballostärke;
    public int räder;
    public Auto() {
        this.marke = marke;
        this.farbe = farbe;
        this.caballostärke = caballostärke;
        this.räder = räder;
    }
    @Override
    public String toString(){
        return "Marke:"+marke+" Farbe:"+farbe+" Pferdestärke:"+caballostärke+" Räder:"+räder;
    }
}
