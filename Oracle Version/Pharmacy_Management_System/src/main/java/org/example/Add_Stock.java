package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Add_Stock extends JFrame{
    JTextField stockIDInput, stockItemsQunatityInput, itemsToBeDelieveredInput, mostSaleItemInput;
    JButton addButton,cancel;

    Add_Stock(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        JLabel stockID = new JLabel("Enter Stock ID");
        stockID.setFont(new Font("Calibri",Font.BOLD,25));
        stockIDInput = new JTextField();
        JLabel stockItemsQuantity = new JLabel("Enter Item Quantity");
        stockItemsQuantity.setFont(new Font("Calibri",Font.BOLD,25));

        stockItemsQunatityInput = new JTextField();
        JLabel itemsToBeDelievered = new JLabel("Enter Item to be delivered");
        itemsToBeDelievered.setFont(new Font("Calibri",Font.BOLD,25));

        itemsToBeDelieveredInput = new JTextField();
        JLabel mostSaleItem = new JLabel("Enter Most Sale Item");
        mostSaleItem.setFont(new Font("Calibri",Font.BOLD,25));

        mostSaleItemInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFFFAF9F4, true));
        addButton.setBackground(new Color(66, 106, 108));
        addButton.setFont(new Font("Calibri",Font.BOLD,30));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFFFAF9F4, true));
        cancel.setBackground(new Color(66, 106, 108));
        cancel.setFont(new Font("Calibri",Font.BOLD,30));

        add(stockID);add(stockIDInput);
        add(stockItemsQuantity);add(stockItemsQunatityInput);
        add(itemsToBeDelievered);add(itemsToBeDelieveredInput);
        add(mostSaleItem);add(mostSaleItemInput);
        add(addButton);add(cancel);

        setLayout(new GridLayout(5,2,10,10));
        setVisible(true);
        MyActionListener myActionListener = new MyActionListener();
        addButton.addActionListener(myActionListener);
        cancel.addActionListener(myActionListener);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADD")) {

                int stockId = Integer.parseInt(stockIDInput.getText());
                int stockItemsQuantity = Integer.parseInt(stockItemsQunatityInput.getText());
                String itemsToBeDelivered = itemsToBeDelieveredInput.getText();
                String mostSaleItem = mostSaleItemInput.getText();

                ConnectionDB connectionDB = new ConnectionDB();
                try {
                    boolean check = true;
                    ResultSet query  = connectionDB.statement.executeQuery("SELECT stock_Id FROM STOCK");
                    while (query.next()){
                        if (query.getInt(1) == stockId) {
                            check = false;
                        }
                    }
                    if (check) {
                        PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO STOCK VALUES(?,?,?,?)");
                        stmt.setInt(1,stockId);
                        stmt.setInt(2,stockItemsQuantity);
                        stmt.setString(3,itemsToBeDelivered);
                        stmt.setString(4,mostSaleItem);
                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(new JFrame(),"Stock Added Successfully");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(),"Stock Already Exists!!!");                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }else if (e.getActionCommand().equals("CANCEL")){
                dispose();
//                new SupplierMenu();
            }
        }
    }
}
