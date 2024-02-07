package Sorting;
/*Merge Sort is Inplace algorithm with TC:O(NlogN) SC:O(N)*/
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,3,6,8,10,12,15,17,18};
        int[] res = sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sort(int[] arr,int start,int end){
        if(start==end){
            int[] res = new int[1];
            res[0] = arr[start];
            return res;
        }
        int mid = (start + end)/2;
        int[] right = sort(arr,start,mid);//TC : O(logn)
        int[] left = sort(arr,mid+1,end);//TC : O(logn)
        return mergeSortedArrays(left,right);//TC:O(N)
    }

    public static int[] mergeSortedArrays(int[] left,int[] right){
        int n = left.length,m=right.length,i=0,j=0,k=0;
        int[] res = new int[m+n];
        while(i<n && j<m){
            if(left[i]<right[j]){
                res[k] = left[i];
                i++;
                k++;
            }else{
                res[k] = right[j];
                j++;
                k++;
            }
        }

        while(i<n){
            res[k] = left[i];
            i++;
            k++;
        }

        while(j<m){
            res[k] = right[j];
            j++;
            k++;
        }

        return res;
    }
}
