public class Kreis {
    private double radius;
    public Kreis(){
        this.setRadius(getRadius());
    }
    public double getRadius(){
        return radius;
    }
    public double setRadius(double radius){
        return this.radius = radius;
    }
    @Override
    public String toString(){
        return "radius:"+this.getRadius();
    }
    public double Fläche(){
        return (this.getRadius()*this.getRadius())*Math.PI;
    }
    public double umfang(){
        return 2*Math.PI*this.getRadius();
    }
}
