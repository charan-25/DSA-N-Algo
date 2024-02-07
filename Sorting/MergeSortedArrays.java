package Sorting;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] a = {7,10,11,14};
        int[] b = {3,8,9};
        System.out.println(Arrays.toString(mergeArrays(a,b)));
    }

    public static int[] mergeArrays(int[] a,int[] b){
        int n = a.length,m=b.length,i=0,j=0,k=0;
        int[] res = new int[m+n];
        while(i<n && j<m){
            if(a[i]<b[j]){
                res[k] = a[i];
                k++;
                i++;
            }else{
                res[k] = b[j];
                k++;
                j++;
            }
        }

        while(i<n){
            res[k] = a[i];
            i++;k++;
        }

        while(j<m){
            res[k] = b[j];
            j++;k++;
        }
        return res;
    }
}
