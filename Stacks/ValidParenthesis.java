package Stacks;

import java.util.Stack;

/*Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true


Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'*/
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(checkValidString("())"));
    }

    public static boolean checkValidString(String str){
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch =='(')
                leftStack.push(i);
            else if(ch=='*')
                starStack.push(i);
            else{
                if(leftStack.size()>0)
                    leftStack.pop();
                else if(starStack.size()>0)
                    starStack.pop();
                else
                    return false;
            }
        }
        while(leftStack.size()>0 && starStack.size()>0){
            if(leftStack.pop()>starStack.pop())
                return false;
        }
        return leftStack.isEmpty();
    }

}
