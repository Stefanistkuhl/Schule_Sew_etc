import java.util.*;

public class Main {
    public static void main(String[] args) {
        //auto klasse in main fragen wv autos auto arr auto obj mit properties
        //methode schreiben für arr ausgeben
        //schnellests auto suchen und ausgeben
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
        ausgabe(autos);
        System.out.println("Das schnelleste auto ist:"+autos[schnellstes(autos)].toString());
    }
    public static void ausgabe(Auto[] arr){
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i].toString());
        }
    }
    public static int schnellstes(Auto[] arr){
        int schnell=arr[0].caballostärke;
        int schnell_index=0;
        for(int i=0; i<arr.length;i++){
            if(schnell<arr[i].caballostärke){
                schnell = arr[i].caballostärke;
                schnell_index = i;
            }
        }
        return schnell_index;
    }
}