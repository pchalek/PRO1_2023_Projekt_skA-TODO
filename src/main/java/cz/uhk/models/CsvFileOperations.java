package cz.uhk.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileOperations implements FileOperations{
    private final static String FILE_NAME = "./shoppingList.csv";
    private final static char DELIMETER = ';';

    @Override
    public ShoppingList load() {
        //TODO load from file - 25.4.
        try
        {
            FileReader reader = new FileReader(FILE_NAME);
            ShoppingList shoppingList = new ShoppingList();
            BufferedReader bufferedReader = new BufferedReader(reader);
            ArrayList<ShoppingItem> items = new ArrayList<>();
            String line;
            for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
                String[] lineAttributes = line.split(";");
                System.out.println("ITEM " + i + " NUMBER OF ATTRIBUTES: " + lineAttributes.length);
                if (lineAttributes.length == 1) { //SETTING UP NAME OF SHOPPINGLIST
                    shoppingList.setName(lineAttributes[0].substring(6));
                    System.out.println("SHOPPINGLIST NAME: " + shoppingList.getName());
                }
                else {
                    //ADDING ITEM ATTRIBUTES TO CREATE NEW ITEMS
                    ShoppingItem shoppingItem = new ShoppingItem(lineAttributes[0],Double.parseDouble(lineAttributes[1]),Integer.parseInt(lineAttributes[2]));
                    items.add(shoppingItem);
                }
            }
            shoppingList.setItems(items);
            return shoppingList;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return new ShoppingList();
    }

    @Override
    public void write(ShoppingList model) {
        StringBuilder csvText = new StringBuilder();
        csvText.append("name: "+model.getName()).append("\n");

        for (ShoppingItem item:
             model.getItems()) {
            csvText
                    .append(item.getName())
                    .append(DELIMETER)
                    .append(item.getPrice())
                    .append(DELIMETER)
                    .append(item.getPieces())
                    .append(DELIMETER)
                    .append(item.isBought())
                    .append("\n");
        }
        try{
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(csvText.toString());
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
