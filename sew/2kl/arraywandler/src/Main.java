import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int arr[] = new int[70];
        for(int i=0;i<arr.length;i++){
            arr[i]= (int) (Math.random()*70)+1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(min(arr));
        System.out.println(max(arr));
        System.out.println(durchschnitt(arr));
        umdrehen(arr);
        vorkommen(arr, 69);
        ersetzen(arr, 10,69);

    }
    public static int min(int arr[]){
        int min=0;
        for(int i=0; i<arr.length;i++){
            if(i==0){
                min = arr[i];
            }else {
                if ((arr[i] < arr[i - 1])&&arr[i]<min) {
                    min = arr[i];
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
    public static int durchschnitt(int arr[]){
        int durchschnitt=0;
        int summe=0;
        for(int i=0; i<arr.length;i++){
            summe += arr[i];
        }
        durchschnitt=summe/arr.length;
        return durchschnitt;
    }
    public static void umdrehen(int arr[]){
        int arr2[] = new int[arr.length];
        int j=arr.length;
        for(int i=0; i<arr.length;i++) {
            arr2[j-1]=arr[i];
            j -= 1;
        }System.out.println(Arrays.toString(arr2));
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
        System.out.println(Arrays.toString(index));
    }
    public static void ersetzen(int arr[], int x, int y){
        for(int i=0; i<arr.length;i++){
            if(arr[i]==x){
                arr[i]=y;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}