public class Rechteck {
    private int länge;
    private int breite;
    public  Rechteck(){
        this.setLänge(getLänge());
        this.setBreite(getLänge());
    }
    @Override
    public String toString(){
        return "länge:"+this.getLänge()+" breite:"+this.getBreite();
    }

    public int Fläche(){
        return this.getLänge()*this.getBreite();
    }
    public int umfang(){
        return 2*(this.getLänge()+this.getBreite());
    }
    public int getLänge(){
        return länge;
    }
    public int setLänge(double radius){
        return this.länge = länge;
    }
    public int getBreite(){
        return breite;
    }
    public int setBreite(double radius){
        return this.länge = breite;
    }
}
