import java.util.*;
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(arr));
    }

    public int evalRPN(String[] tokens) {
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
    public int evaluateExpression(String str,int oprnd1,int oprnd2){
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
