import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int länge = sc.nextInt();
        String fach_input = "";
        int intnote =0;
        Notenverwaltung noten[] = new Notenverwaltung[länge];
        for(int i=0; i<länge;i++){
            System.out.println("fach");
            fach_input = sc.next();
            System.out.println("note");
            intnote = sc.nextInt();
            noten[i]=new Notenverwaltung(fach_input,intnote);
            /*
            alternativ geht auch und wär auch besser
            Notenverwaltung n = new Notenverwaltung();
            n.fach=sc.next();
            n.note=sc.nextInt();
            noten[i]=n;
             */
        }
        int fach_eingabe_note = 0;
        int durchschnitt = durchschnitt(noten);
        System.out.println(durchschnitt);
        String schlechteste_fach = noten[vorkommen_index(noten, max(noten))].fach;
        System.out.println(schlechteste_fach);
        String bestes_fach = noten[vorkommen_index(noten, min(noten))].fach;
        System.out.println(bestes_fach);
        String fach_eingabe = "nwt";
        for(int i=0; i<noten.length;i++){
            if(noten[i].fach.equals(fach_eingabe)){
                fach_eingabe_note = noten[i].note;
            }
        }
        System.out.println(fach_eingabe);
        System.out.println(fach_eingabe_note);
        int note_eingabe = 1;
        vorkommen(noten,note_eingabe);
        System.out.println(durchschnitt_besser(noten, durchschnitt));
        System.out.println(durchschnitt_schlechter(noten, durchschnitt));
    }
    public static int durchschnitt(Notenverwaltung arr[]){
        int durchschnitt=0;
        int summe=0;
        for(int i=0; i<arr.length;i++){
            summe += arr[i].note;
        }
        durchschnitt=summe/arr.length;
        return durchschnitt;
    }
    public static int min(Notenverwaltung arr[]){
        int min=0;
        for(int i=0; i<arr.length;i++){
            if(i==0){
                min = arr[i].note;
            }else {
                if ((arr[i].note < arr[i - 1].note)&&arr[i].note<min) {
                    min = arr[i].note;
                    int index = i;
                }
            }
        }
        return min;
    }
    public static int max(Notenverwaltung arr[]){
        int max=0;
        for(int i=0; i<arr.length;i++){
            if(i==0){
                max = arr[i].note;
            }else {
                if ((arr[i].note > arr[i - 1].note)&&max<arr[i].note) {
                    max = arr[i].note;
                }
            }
        }
        return max;
    }
    public static int vorkommen_index(Notenverwaltung arr[], int x){
        int vorkommen=0;
        int index = 0;
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i].note==x){
                index = i;
            }
        }
        return index;
    }
    public static void vorkommen(Notenverwaltung arr[], int x){
        int vorkommen=0;
        int index[] = new int[arr.length+1];
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i].note==x){
                vorkommen +=1;
                index[j]=i;
                j += 1;
            }
        }
        System.out.println(vorkommen);
        //System.out.println(Arrays.toString(index));
    }
    public static int durchschnitt_besser(Notenverwaltung arr[], int x){
        int vorkommen=0;
        int index = 0;
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i].note<x){
                index = i;
                vorkommen += 1;
            }
        }
        return vorkommen;
    }
    public static int durchschnitt_schlechter(Notenverwaltung arr[], int x){
        int vorkommen=0;
        int index = 0;
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i].note>x){
                index = i;
                vorkommen += 1;
            }
        }
        return vorkommen;
    }
}
