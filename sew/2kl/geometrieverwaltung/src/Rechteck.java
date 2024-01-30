public class Rechteck {
    public int länge;
    public int breite;

    public Rechteck(){
        this.länge = länge;
        this.breite = breite;
    }
   @Override
   public String toString(){
       return "länge:"+länge+" breite:"+breite;
   }

   public int Fläche(){
        return länge*breite;
   }
    public int umfang(){
        return 2*(länge+breite);
    }
}
