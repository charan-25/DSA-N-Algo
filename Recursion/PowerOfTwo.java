package Recursion;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int num){
        if(num==0)
            return false;
        if(num==1)
            return true;
        if(num%2==1)
            return false;
        return isPowerOfTwo(num/2);
    }
}
