package Array;

public class MissingElement {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr){
        int n = arr.length;
        int sum1 = (n*(n+1))/2,sum2=0;
        for(int num : arr){
            sum2 += num;
        }
        return sum1-sum2;
    }
}
