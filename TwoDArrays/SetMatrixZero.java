package TwoDArrays;

import java.util.HashSet;

/*Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
*/
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        setMatrixZeros(arr);
        int n = arr.length,m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        bruteSetMatrixZeros(matrix);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Optimized Approach
    public static void setMatrixZeros(int[][] arr){
        int n = arr.length,m=arr[0].length;
        boolean firstRowZero = false,firstColumnZero=false;

        //Check if any of the 1st row column is set to zero
        for(int j=0;j<m;j++){
            if(arr[0][j]==0){
                firstRowZero = true;
                break;
            }
        }

        //Check if any of the 1st column row is set to zero
        for(int i=0;i<n;i++){
            if(arr[i][0]==0){
                firstColumnZero=true;
                break;
            }
        }

        //Set 0 at 1st row and columns as markers
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]==0){
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for(int i=1;i<n;i++){
            if(arr[i][0]==0){
                for(int j=1;j<m;j++)arr[i][j]=0;
            }
        }

        for(int j=1;j<m;j++){
            if(arr[0][j]==0){
                for(int i=1;i<n;i++)arr[i][j]=0;
            }
        }

        if(firstColumnZero){
            for(int i=0;i<n;i++)arr[i][0] =0;
        }

        if(firstRowZero){
            for(int j=0;j<m;j++)arr[0][j]=0;
        }
    }

    //Brute Force Using Extra Space;
    public static void bruteSetMatrixZeros(int[][] arr){
        int n=arr.length,m=arr[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        //System.out.println("Row :: "+row+" Column ::"+column);
        for(int num : row){
            for(int j=0;j<m;j++){
                arr[num][j]=0;
            }
        }

        for(int i=0;i<n;i++){
            for(int num:column){
                arr[i][num]=0;
            }
        }
    }
}
