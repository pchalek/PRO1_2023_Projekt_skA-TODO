package cz.uhk.models;

import java.io.FileWriter;
import java.io.IOException;

public class CsvFileOperations implements FileOperations{
    private final static String FILE_NAME = "./shoppingList.csv";
    private final static char DELIMETER = ';';

    @Override
    public ShoppingList load() {
        //TODO load from file - 25.4.

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
