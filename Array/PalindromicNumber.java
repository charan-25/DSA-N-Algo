package Array;
/*Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:
-231 <= x <= 231 - 1*/
public class PalindromicNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindromeOptimized(-121));
    }

    //Brute Force
    public static boolean isPalindrome(int x){
        String str = ""+x;
        int s = 0, e= str.length()-1;
        while(s<e){
            if(str.charAt(s)!=str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }

    //Optimized
    public static boolean isPalindromeOptimized(int x){
        int reversed =0,y=x;
        while(y>0){
            int temp = y%10;
            reversed = reversed*10 + temp;
            y = y/10;
        }
        return reversed==x?true:false;
    }
}
