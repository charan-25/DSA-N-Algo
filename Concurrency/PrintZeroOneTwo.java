package Concurrency;

import java.util.concurrent.Semaphore;

public class PrintZeroOneTwo {


    private static int n;
    private static Semaphore zeroSema = new Semaphore(1);
    private static Semaphore evenSema = new Semaphore(0);
    private static Semaphore oddSema = new Semaphore(0);

    public PrintZeroOneTwo(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public static void zero() throws InterruptedException {
        for(int i=1;i<=n;i++){
            zeroSema.acquire();
            System.out.println(0);
            if(i%2==0)
                evenSema.release();
            else
                oddSema.release();
        }
    }

    public void even() throws InterruptedException {
        for(int i=2;i<=n;i=i+2){
            evenSema.acquire();
            System.out.println(i);
            zeroSema.release();

        }
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {

            oddSema.acquire();
            System.out.println(i);
            zeroSema.release();
        }
    }
}
