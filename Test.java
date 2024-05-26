public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        child.printFinalVariables();
    }
}


class Parent{
    public final int var = 42;
    public final String str = "Hello";
}

class Child extends Parent{
    public void printFinalVariables(){

        System.out.println("Final Variable :: "+var);
        System.out.println("Final String :: "+str);
    }
}
