/*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].*/
import java.util.*;
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(arr));
    }

    public static int evalRPN(String[] tokens) {
        int n = tokens.length,sum=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            String str = tokens[i];
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int oprnd2 = stack.pop();
                int oprnd1 = stack.pop();
                stack.push(evaluateExpression(str,oprnd1,oprnd2));
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
    public static int evaluateExpression(String str,int oprnd1,int oprnd2){
        switch(str){
            case "+" :
                return oprnd1 + oprnd2;

            case "-" :
                return oprnd1 - oprnd2;

            case "*" :
                return oprnd1 * oprnd2;

            case "/" :
                return oprnd1 / oprnd2 ;

        }
        return 0;
    }
}
