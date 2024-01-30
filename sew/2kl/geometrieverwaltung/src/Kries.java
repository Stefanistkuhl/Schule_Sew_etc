import java.util.*;
public class Kries {
    public int radius;

    public Kries(){
        this.radius = radius;
    }
    @Override
    public String toString(){
        return "radius:"+radius;
    }
    public double Fläche(){
        return (radius*radius)*Math.PI;
    }
    public double umfang(){
        return 2*Math.PI*radius;
    }
}
