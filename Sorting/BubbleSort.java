package Sorting;
/*Bubble Sort is an Inpalce(whose relative order of elements doesn't change and
  Stable Algorithm(which doesn't use extra space
* TC : O(N^2) SC:O(1)
* */
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {8,2,4,-1,6,7,5,10,-1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
       // System.out.println(Arrays.toString(arr));
        return arr;
    }
}
