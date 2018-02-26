package com.dontworryaboutit.dungeonsanddank;


public abstract class Items {
    private String name;
    private int cost;
    private double weight;

    public Items(String name, int cost, double weight){
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }
    public double getWeight(){
        return weight;
    }
}
