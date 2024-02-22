package Strings;
/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/
public class ZigZagConversions {
    public static void main(String[] args) {
        System.out.println(conversion("PAYPALISHIRING",4));
    }

    public static String conversion(String str,int numRows){
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new StringBuilder();
        }
        int rowIndex =0;
        boolean goingDown = false;
        for(char ch : str.toCharArray()){
            rows[rowIndex].append(ch);
            if(rowIndex==0||rowIndex==numRows-1)
                goingDown = !goingDown;
            rowIndex += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb :rows)
            result.append(sb);
        return new String(result);
    }
}
