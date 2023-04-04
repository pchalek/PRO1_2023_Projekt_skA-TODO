package cz.uhk.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<ShoppingItem> items;
    private String name;
    private List<ActionListener> listeners = new ArrayList<>();

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
    public void addActionListener(ActionListener add){
        listeners.add(add);
    }
    public void addItem(ShoppingItem newItem){
        items.add(newItem);
        raiseEventItemsChanged();
    }

    private void raiseEventItemsChanged(){
        for (ActionListener al :
                listeners) {
            al.actionPerformed(new ActionEvent(this, 1, "itemsChanged"));
        }
    }
}
