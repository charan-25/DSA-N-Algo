package DesignPatterns;
/*Factory Design Pattern provide us an interface for creating objects of super class but allows sub class to alter the type object
* It is used when we don't have clarity which object has to be created until runtime
*
* Connection connection = DriverManager.getConnection(Strung url);
* KeyFactory key = KeyFactory.getInstance(String algorithm);
* */
public class FactoryDesignPattern {
    public static void main(String[] args) {
        Card silver = CardFactory.getCard("Silver");
        System.out.println("limit of Silver Card is :: "+silver.limit);

        Card gold = CardFactory.getCard("Gold");
        System.out.println("limit of Gold Card is :: "+gold.limit);

        Card platinum = CardFactory.getCard("Platinum");
        System.out.println("limit of Gold Card is :: "+platinum.limit);
    }
}

abstract class Card{
    protected double limit;
    public abstract void setCardLimit(double limit);
}

class Silver extends  Card{

    public Silver() {
        setCardLimit(100000);
    }

    @Override
    public void setCardLimit(double limit) {
        this.limit = limit;
    }
}

class Gold extends Card{

    public Gold() {
        setCardLimit(250000);
    }

    @Override
    public void setCardLimit(double limit) {
        this.limit = limit;
    }
}

class Platinum extends Card{

    public Platinum() {
        setCardLimit(500000);
    }

    @Override
    public void setCardLimit(double limit) {
        this.limit = limit;
    }
}

class CardFactory{
    public static Card getCard(String type){
        switch(type){
            case "Silver":
                return new Silver();
            case "Gold":
                return new Gold();
            case "Platinum":
                return new Platinum();
            default:
                return null;
        }
    }
}
