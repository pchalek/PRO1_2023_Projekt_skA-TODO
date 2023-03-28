package cz.uhk.gui;

import javax.swing.*;
import java.awt.*;

public class NewItemDialog extends JDialog {
    private MainFrame parent;
    public NewItemDialog(MainFrame parent){
        super(parent, "Zadejte novou položku", true);
        this.parent = parent;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initGui();  // volat před visible true
        pack(); // velikost dialogu podle obsahu
        setVisible(true);
    }
    private void initGui(){
        JPanel mainPanel = new JPanel(new GridLayout(4,2));

        mainPanel.add(new JLabel("Název"));
        mainPanel.add(new JTextField(15));

        mainPanel.add(new JLabel("Cena"));
        mainPanel.add(new JTextField(15));

        mainPanel.add(new JLabel("Počet"));
        mainPanel.add(new JTextField(15));

        mainPanel.add(new JPanel());// prázdná pozice

        JButton btnOk =new JButton("Ok");
        mainPanel.add(btnOk);

        btnOk.addActionListener(e -> {
            // TODO validace
            System.out.println("validace nové položky OK");
            parent.addNewItem();
            dispose(); // zahodíme dialog
        });


        add(mainPanel);
    }
}
