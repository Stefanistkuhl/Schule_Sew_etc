public class Rechteck {
    private double länge;
    private double breite;
    public  Rechteck(){
        this.setLänge(getLänge());
        this.setBreite(getLänge());
    }
    @Override
    public String toString(){
        return "länge:"+this.getLänge()+" breite:"+this.getBreite();
    }

    public double Fläche(){
        return this.getLänge()*this.getBreite();
    }
    public double umfang(){
        return 2*(this.getLänge()+this.getBreite());
    }
    public double getLänge(){
        return länge;
    }
    public double setLänge(double länge){
        return this.länge = länge;
    }
    public double getBreite(){
        return breite;
    }
    public double setBreite(double breite){
        return this.breite = breite;
    }
}
