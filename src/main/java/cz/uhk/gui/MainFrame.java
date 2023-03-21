package cz.uhk.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(int width, int height){
        super("PRO1 2023");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initMenu(); // volat před setVisible(true)
        initGui(); // volat před setVisible(true)

        setVisible(true);
    }
    private void initMenu(){
        JMenuBar bar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu 1");
        bar.add(menu1);
        /*for (int i = 0; i < 5; i++) {
            menu1.add(new JMenuItem("Položka " + i));
        }*/
        JMenuItem polozka1 = new JMenuItem("Položka 1");
        polozka1.addActionListener(e -> {
            System.out.println("clicked");
        });
        menu1.add(polozka1);
        JMenuItem polozka2 = new JMenuItem("Položka 2");
        polozka2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });
        menu1.add(polozka2);
        bar.add(new JMenu("Menu 2"));
        setJMenuBar(bar);
    }
    private void initGui(){
        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.add(initNorthPanel(), BorderLayout.NORTH);
        panelMain.add(initCenterPanel(), BorderLayout.CENTER);
        add(panelMain);
    }
    private JPanel initNorthPanel(){
        JPanel panelNorth = new JPanel(new FlowLayout());
        panelNorth.add(new JLabel("Label 1"));
        JTextField input1 = new JTextField(20);
        panelNorth.add(input1);
        JButton btn1 = new JButton("Tlačítko");
        btn1.addActionListener(e -> System.out.println("Zadán text: " + input1.getText()));
        btn1.addActionListener(e -> System.out.println("výpis 2"));
        panelNorth.add(btn1);
        return panelNorth;
    }
    private JPanel initCenterPanel() {
        JPanel panelCenter = new JPanel();

        Object[][] data = new Object[][] {
                {"0,0", "0,1", "0,2"},
                {"1,0", "1,1", "1,2"},
                {"2,0", "2,1", "2,2"}
        };
        String[] colNames = new String[] {"Col1", "Col2", "Col3"};
        panelCenter.add(new JTable(data, colNames));

        return panelCenter;
    }
}
