package Strings;
/*Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.*/
public class ReverseString {
    public static void main(String[] args) {
        char[] ch = {'h','e','l','l','o'};
        reverseString(ch);
        System.out.println(new String(ch));
    }

    public static void reverseString(char[] ch){
        int start = 0,end=ch.length-1;
        while(start<end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}
