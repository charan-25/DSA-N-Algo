package Concurrency;

public class FizzBuzzMultithreaded {

    private final int n;
    private int i = 1;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzzMultithreaded fbz = new FizzBuzzMultithreaded(15);

        Thread fizz = new Thread(() -> {
            try {
                fbz.fizz(() -> {
                    System.out.print("Fizz,");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread buzz = new Thread(() -> {
            try {
                fbz.buzz(() -> {
                    System.out.print("Buzz,");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread fizzBuzz = new Thread(() -> {
            try {
                fbz.fizzbuzz(() -> {
                    System.out.print("FizzBuzz,");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread number = new Thread(() -> {
            try {
                fbz.number(() -> {
                    System.out.print(",");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        fizz.start();
        buzz.start();
        fizzBuzz.start();
        number.start();
        fizz.join();
        buzz.join();
        fizzBuzz.join();
        number.join();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 5 == 0 & i % 3 != 0) {
                    printBuzz.run();
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 15 == 0) {
                    printFizzBuzz.run();
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }

    public void number(Runnable printNumber) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 != 0 && i % 5 != 0) {
                    System.out.print(i);
                    printNumber.run();
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }
}
