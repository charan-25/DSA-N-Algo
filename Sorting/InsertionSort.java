package Sorting;
/*Insertion Sort is an Inpalce(whose relative order of elements doesn't change and
   Stable Algorithm(which doesn't use extra space
 * TC : O(N^2) SC:O(1)
 * */
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {10,3,6,8,2,5};
        sort(arr);
        insertSort(arr);
    }

    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i;j>=0;j--){
                if(arr[j+1]<arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
