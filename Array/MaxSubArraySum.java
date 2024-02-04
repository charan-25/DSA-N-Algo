package Array;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-1,-2,-3,-4,-5,-6};
        System.out.println(maxSubSum(arr));
        System.out.println(bruteMaxSubSum(arr));
    }


    public static int bruteMaxSubSum(int[] arr){
        int n = arr.length,max = arr[0];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum =0;
                for(int k = i;k<=j;k++){
                    sum = sum + arr[k];
                }
                max = Math.max(sum,max);
            }
        }
        return max;
    }

    //Optimized Kadane's Algorithm
    public static int maxSubSum(int[] arr){
        int n =arr.length,sum=arr[0],max=arr[0];
        for(int i=1;i<n;i++){
            if(sum < 0)
                sum = 0;
            sum = sum + arr[i];
            max = Math.max(sum,max);
        }
        return max;
    }
}
