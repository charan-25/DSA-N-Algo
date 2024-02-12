package Recursion;

public class NumberPower {
    public static void main(String[] args) {
        int n = 2147483647;
        double x= 0.00001;
        double pow = power(x,Math.abs(n));
        if(n<0)
            System.out.println(1/pow);
        else
            System.out.println(pow);
    }

    //half Recursion Method
    public static double power(double x,int n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
        double half = power(x,n/2);
        if(n%2!=0)
            return half * half * x;
        else
            return half * half;
    }
}
