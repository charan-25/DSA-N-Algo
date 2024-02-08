package Searching;

public class FirstOccurrence {

    public static void main(String[] args) {
        int[] arr = {10,20,25,25,25,25,25,25,60,70};
        int k = 25;
        System.out.println(firstOccurrence(arr,k));
    }

    public static int firstOccurrence(int[] arr,int target){
        int low=0;int high = arr.length-1,ans =0;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                ans =mid;
                high = mid - 1;
            }
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return ans;
    }
}
