package cz.uhk.models;

public class ShoppingItem {
    private String name;
    private double price;
    private int pieces;
    private boolean bought;

    public ShoppingItem(String name, double price, int pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
        this.bought = false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
