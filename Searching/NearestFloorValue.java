package Searching;

public class NearestFloorValue {
    public static void main(String[] args) {
        int[] arr = {-5,2,3,6,9,10,11,14,18};
        int k = 12;
        System.out.println(bruteSearchNearestFloor(arr,k));
   //     System.out.println(searchNearestFloor(arr,k));
    }

    //Brute Force Approach
    public static int bruteSearchNearestFloor(int[] arr,int target){
        int n = arr.length,ans = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]<=target)
                ans = arr[i];
        }
        return ans;
    }

    //Optimized Binary Search TC:O(logN) SC:O(1)
    public static int searchNearestFloor(int[] arr,int target){
        int low=0,high =arr.length-1,ans = arr[0];
        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid] == target)
                return arr[mid];
            else if(arr[mid]<target){
                ans = arr[mid];
                low = mid + 1;
            }else
                high = mid - 1;
        }
        return ans;
    }
}
