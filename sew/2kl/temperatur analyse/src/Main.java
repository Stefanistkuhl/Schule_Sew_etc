import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] temparaturen = {30,-4,3,4,26,39,-19};
        System.out.println(durchschnitt(temparaturen));
        System.out.println(max(temparaturen));
        System.out.println(min(temparaturen));
        vorkommen_größer(temparaturen, 30);
        vorkommen_kleiner(temparaturen, 4);

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
    public static void vorkommen_größer(int arr[], int x){
        int vorkommen=0;
        int index[] = new int[arr.length+1];
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>=x){
                vorkommen +=1;
                index[j]=i;
                j += 1;
            }
        }
        System.out.println(vorkommen);
        //System.out.println(Arrays.toString(index));
    }
    public static void vorkommen_kleiner(int arr[], int x){
        int vorkommen=0;
        int index[] = new int[arr.length+1];
        int j = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]<=x){
                vorkommen +=1;
                index[j]=i;
                j += 1;
            }
        }
        System.out.println(vorkommen);
        //System.out.println(Arrays.toString(index));
    }
}