package DesignPatterns;

import javax.swing.plaf.ComponentInputMapUIResource;

/*Prototype Design Pattern is a Creational Design Pattern which can be used to create a new object using the existing object itself
*
*
* */
public class PrototypeDesignPattern {
    public static void main(String[] args) {
        BlackSheep baaBaa = new BlackSheep("Baa Baa");
        WhiteSheep fleecy = new WhiteSheep("Fleecy");

        Sheep cloneWhiteSheep = fleecy.clone();
        Sheep cloneBlackSheep = baaBaa.clone();

        cloneWhiteSheep.setName("SnowBall");
        cloneBlackSheep.setName("MidNight");

        System.out.println("Cloned White Sheep :: "+cloneWhiteSheep.getName());
        System.out.println("Cloned Black Sheep :: "+cloneBlackSheep.getName());
    }
}

interface Sheep{

    Sheep clone();
    String getName();
    void setName(String name);
}

class BlackSheep implements Sheep{

    String name;

    public BlackSheep(String name) {
        this.name = name;
    }

    @Override
    public Sheep clone() {
        return new BlackSheep(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

class WhiteSheep implements Sheep{
    String name;

    public WhiteSheep(String name) {
        this.name = name;
    }

    @Override
    public Sheep clone() {
        return new WhiteSheep(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

