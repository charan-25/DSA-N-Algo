package Array;
/*Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
1 <= n <= 2 * 104*/
public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(rainWaterTrapped(arr));
    }

    public static int rainWaterTrapped(int[] arr){
        int n = arr.length,sum =0;
        int[] pmax = new int[n];
        int[] smax = new int[n];
        pmax[0] = arr[0];
        smax[n-1] = arr[n-1];
        for(int i=1;i<n;i++){
            pmax[i] = Math.max(pmax[i-1],arr[i]);
        }

        for(int i=n-2;i>=0;i--){
            smax[i] = Math.max(smax[i+1],arr[i]);
        }

        for(int i=0;i<n;i++){
            sum = sum + (Math.min(pmax[i],smax[i]) - arr[i]);
        }
        return sum;
    }
}
