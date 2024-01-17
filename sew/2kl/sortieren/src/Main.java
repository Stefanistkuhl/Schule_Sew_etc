import java.util.*;
public class Main {
    public static void main(String[] args) {
        int max = 0;
        int j = 4;
        int[] a = {5,2,8,7,6};
        int index = 0;
        do {
            for(int i=0;i<j+1;i++){
                if(a[i]>max){
                    max = a[i];
                    index = i;
                }
            }
            a[index]=a[j];
            a[j]=max;
            j-=1;
        }while (j>0);
        System.out.println(Arrays.toString(a));
    }
}