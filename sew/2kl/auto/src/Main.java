import java.util.*;

public class Main {
    public static void main(String[] args) {
        //auto klasse in main fragen wv autos auto arr auto obj mit properties
        Scanner sc = new Scanner(System.in);
        int länge = sc.nextInt();
        Auto autos[] = new Auto[länge];
        for(int i=0; i<länge;i++){
            Auto a = new Auto();
            a.marke = sc.next();
            a.farbe = sc.next();
            a.caballostärke = sc.nextInt();
            a.räder = sc.nextInt();
            autos[i]=a;
        }
    }
}