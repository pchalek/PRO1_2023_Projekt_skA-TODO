package cz.uhk.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<ShoppingItem> items;
    private String name;
    public ShoppingList(){
        items = new ArrayList<>();
    }
    public List<ShoppingItem> getItems() {
        return items;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
