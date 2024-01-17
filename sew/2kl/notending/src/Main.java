import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int länge = sc.nextInt();
        int noten[] = new int[länge];
        String fach[] = new String[länge];
        for(int i=0; i<länge;i++){
            System.out.println("fach");
            fach[i] = sc.next();
            System.out.println("note");
            noten[i] = sc.nextInt();

        }
        int fach_eingabe_note = 0;
        String fach_alt[]={"nwt","sew","medt"};
        int noten_alt[]={1,2,3};
        int durchschnitt = durchschnitt(noten);
        System.out.println(durchschnitt);
        String schlechteste_fach = fach[vorkommen_index(noten, max(noten))];
        System.out.println(schlechteste_fach);
        String bestes_fach = fach[vorkommen_index(noten, min(noten))];
        System.out.println(bestes_fach);
        String fach_eingabe = "nwt";
        for(int i=0; i<fach.length;i++){
            if(fach[i].equals(fach_eingabe)){
                fach_eingabe_note = noten[i];
            }
        }
        System.out.println(fach_eingabe);
        System.out.println(fach_eingabe_note);
        int note_eingabe = 1;
        vorkommen(noten,note_eingabe);
        System.out.println(durchschnitt_besser(noten, durchschnitt));
        System.out.println(durchschnitt_schlechter(noten, durchschnitt));
    }
    public static int durchschnitt(int arr[]){
        int durchschnitt=0;
        int summe=0;
        for(int i=0; i<arr.length;i++){
            summe += arr[i];
        }
        durchschnitt=summe/arr.length;
        return durchschnitt;
    }
    public static int min(int arr[]){
        int min=0;
        for(int i=0; i<arr.length;i++){
            if(i==0){
                min = arr[i];
            }else {
                if ((arr[i] < arr[i - 1])&&arr[i]<min) {
                    min = arr[i];
                    int index = i;
                }
            }
        }
        return min;
    }
    public static int max(int arr[]){
        int max=0;
        for(int i=0; i<arr.length;i++){
            if(i==0){
                max = arr[i];
            }else {
                if ((arr[i] > arr[i - 1])&&max<arr[i]) {
                    max = arr[i];
                }
            }
        }
        return max;
    }
    public static int vorkommen_index(int arr[], int x){
        int vorkommen=0;
        int index = 0;
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==x){
                index = i;
            }
        }
        return index;
    }
    public static void vorkommen(int arr[], int x){
        int vorkommen=0;
        int index[] = new int[arr.length+1];
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==x){
                vorkommen +=1;
                index[j]=i;
                j += 1;
            }
        }
        System.out.println(vorkommen);
        //System.out.println(Arrays.toString(index));
    }
    public static int durchschnitt_besser(int arr[], int x){
        int vorkommen=0;
        int index = 0;
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]<x){
                index = i;
                vorkommen += 1;
            }
        }
        return vorkommen;
    }
    public static int durchschnitt_schlechter(int arr[], int x){
        int vorkommen=0;
        int index = 0;
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>x){
                index = i;
                vorkommen += 1;
            }
        }
        return vorkommen;
    }
}
