package Searching;
/*Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.


Constraints:

0 <= x <= 2^31 - 1*/
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(squareRoot(2147395600));
    }

    public static int squareRoot(int num){
        long start = 0,end = num,ans=0;
        while(start<=num){
            long mid = start + (end-start)/2;
            if(mid*mid == num)
                return (int) mid;
            else if(mid*mid<=num){
                ans = mid;
                start = mid + 1;
            }else
                end = mid - 1;
        }
        return (int)ans;
    }
}
