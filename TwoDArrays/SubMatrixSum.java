package TwoDArrays;

import java.util.Arrays;

public class SubMatrixSum {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int[] b = {1,2};
        int[] c = {1,2};
        int[] d = {2,3};
        int[] e = {2,3};
        int[] res = subMatrixSum(arr,b,c,d,e);
        System.out.println(Arrays.toString(res));
    }
//rowIndex += goingDown ? 1 : -1;
    public static int[] subMatrixSum(int[][] arr,int[] b,int[] c,int[] d,int[] e){
        int n = arr.length,m=arr[0].length;
        int[][] pf = new int[n][m];
        for(int i=0;i<n;i++){
            pf[i][0] = arr[i][0];
            for(int j=1;j<m;j++){
                pf[i][j] = pf[i][j-1] + arr[i][j];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                pf[i][j] = pf[i-1][j] + pf[i][j];
            }
        }
        int[] res = new int[b.length];
        for(int i=0;i<b.length;i++){
            int r1=b[i]-1,c1=c[i]-1;
            int r2=d[i]-1,c2=e[i]-1;
            int sum = pf[r2][c2];
            if(r1-1>=0){
                sum -= pf[r1-1][c2];
            }
            if(c1-1>=0)
                sum -= pf[r2][c1-1];
            if(r1-1>=0 && c1-1>=0)
                sum += pf[r1-1][c1-1];
            res[i] = sum;
        }

        return res;
    }
}
