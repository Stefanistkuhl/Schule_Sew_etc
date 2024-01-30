import java.util.*;
public class Main {
    public static void main(String[] args) {
        Rechteck r = new Rechteck();
        Kries k = new Kries();
        r.breite = 69;
        r.länge = 169;
        k.radius = 69;
        System.out.println(r.toString());
        System.out.println("rechteck fläche:" + r.Fläche());
        System.out.println("rechteck umfang: "+ r.umfang());
        System.out.println(k.toString());
        System.out.println("kreis fläche: "+k.Fläche());
        System.out.println("kreis umfang: "+k.umfang());

    }
}