package DesignPatterns;
/*This Pattern allow a class to instantiate only once through out its life time, It is mostly used for creating configuration class objects
* In MMS Project Hibernate Util class is designed using single design pattern
*/
public class SingletonDesignPattern {

    private static SingletonDesignPattern singleton;

    private SingletonDesignPattern(){
    }

    public static SingletonDesignPattern getInstance(){
        if(singleton == null){
            synchronized (SingletonDesignPattern.class){
                if(singleton==null)
                    singleton = new SingletonDesignPattern();
            }
        }
        return singleton;
    }

    public static void close(){
        singleton = null;
    }
}
