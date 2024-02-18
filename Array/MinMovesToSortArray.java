package Array;

public class MinMovesToSortArray {
    public static void main(String[] args) {
        int[] arr = {5,1,3,2};
        System.out.println(minMoves(arr));
    }

    public static int minMoves(int[] arr){
        int n = arr.length,moves=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1])
                moves++;
        }
        return moves;
    }
}
