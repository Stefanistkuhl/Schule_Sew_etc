import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! :3");

        Scanner sc = new Scanner(System.in);
        String entscheidung = "";
        int suche = 0;
        ArrayList<Studenten> stundenten_list = new ArrayList();


        while(true){
            System.out.println("typ adden y/n/q");
            entscheidung = sc.next();
            if (entscheidung.equals("y")){
                stundenten_list = eingabe(stundenten_list);
            }
           if (entscheidung.equals("n")){
               System.out.println("alles anzeigen -> ka infos anzeigen nach nummer -> a entfernen nach unmmer -> r");
               entscheidung = sc.next();
               if (entscheidung.equals("a")){
                   System.out.println("nach welcher nummer willst du suchen?");
                   suche = sc.nextInt();
                   suche(suche, stundenten_list);

               }
               if (entscheidung.equals("r")){
                   suche = sc.nextInt();
                   stundenten_list = entfernen(suche, stundenten_list);
               }
               if(entscheidung.equals("ka")){
                   ausgabe(stundenten_list);
               }
           }
           if (entscheidung.equals("q")){
               System.exit(69);
           }

        }



    }
    public static ArrayList<Studenten> eingabe(ArrayList<Studenten> stundenten_list){
        Scanner sc = new Scanner(System.in);
        String name = "";
        int nummer = 0;
        int alter = 0;
        String studiengang = "";
        Studenten tmp = new Studenten(name,nummer,alter,studiengang);
        name = sc.next();
        nummer = sc.nextInt();
        alter = sc.nextInt();
        studiengang = sc.next();
        tmp = new Studenten(name,nummer,alter,studiengang);
        stundenten_list.add(tmp);
        return stundenten_list;
    }
    public static void ausgabe(ArrayList<Studenten> stundenten_list){
        for (int i = 0; i < stundenten_list.size();i++){
            System.out.println(stundenten_list.get(i).toString());
        }
    }
    public static ArrayList<Studenten> suche(int suche, ArrayList<Studenten> stundenten_list){
        for (int i = 0; i < stundenten_list.size();i++){
            if (stundenten_list.get(i).getNummer() == suche){
                System.out.println(stundenten_list.get(0).toString());
            }
        }
        return stundenten_list;
    }
    public static ArrayList<Studenten> entfernen(int suche, ArrayList<Studenten> stundenten_list){
        for (int i = 0; i < stundenten_list.size();i++) {
            if (stundenten_list.get(i).getNummer() == suche) {
                stundenten_list.remove(i);
            }
        }
        return stundenten_list;
    }
}