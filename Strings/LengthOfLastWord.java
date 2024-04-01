package Strings;
/*Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
 consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.*/
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfWord("   fly me   to   the moon  "));
        System.out.println(bruteLengthOfWord("   fly me   to   the moon  "));
    }

    public static int lengthOfWord(String str){
        str = str.trim();
        int n = str.length(),length=0;
        for(int i=n-1;i>=0;i--){
            if(str.charAt(i)==' ')
                break;
            else
                length++;
        }
        return length;
    }

    public static int bruteLengthOfWord(String str){
        str = str.trim();
        String[] s = str.split(" ");
        int len = s.length;
        String res = s[len-1];
        return res.length();
    }
}
