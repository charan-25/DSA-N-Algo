package Greedy;

import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219",3));
    }

    public static String removeKDigits(String str,int k){
        int n = str.length();
        if(n==k)
            return "0";
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            while(k>0 && !list.isEmpty() && list.getLast() > str.charAt(i)){
                list.removeLast();
                k--;
            }
            list.addLast(str.charAt(i));
        }

        while(k-->0) list.removeLast();
        StringBuffer sb = new StringBuffer();
        for(char ch : list) {
            if(sb.length()==0 && ch=='0')
                continue;
            sb.append(ch);
        }
        return sb.length()==0 ? "0" :sb.toString();
    }
}
