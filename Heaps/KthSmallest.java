import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[][] arr = {{5, 9, 11},{9, 11, 13},{10, 12, 15},{13, 14, 16},{16, 20, 21}};
        int k = 12;
       // System.out.println(kthSamllestDigit(arr,k));
        System.out.println(bruteKthSmallestDigit(arr,k));
    }

    //Brute Force Aproach
    public static int bruteKthSmallestDigit(int[][] arr,int b){
        int n= arr.length,m =arr[0].length,k=0;
        int[] res = new int[n*m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[k] = arr[i][j];
                k++;
            }
        }
        Arrays.sort(res);
        return res[b-1];
    }

    //Optimized Approach
    public static int kthSamllestDigit(int[][] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = arr.length,m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pq.size()<k){
                    pq.add(arr[i][j]);
                }else if(pq.peek()>arr[i][j]){
                    pq.remove();
                    pq.add(arr[i][j]);
                }
            }
        }
        System.out.println(pq);
        return pq.peek();
    }
}
