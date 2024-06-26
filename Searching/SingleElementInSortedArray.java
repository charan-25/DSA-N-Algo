package Searching;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums){
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(nums[0]!=nums[1])
            return nums[0];
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];
        int low =0,high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid-1]!= nums[mid] && nums[mid]!= nums[mid+1])
                return nums[mid];
            int index = mid;
            if(nums[mid-1]==nums[mid])
                index = mid-1;
            if(index%2==0)
                low = index+2;
            else
                high = index-1;
        }
        return -1;
    }
}
