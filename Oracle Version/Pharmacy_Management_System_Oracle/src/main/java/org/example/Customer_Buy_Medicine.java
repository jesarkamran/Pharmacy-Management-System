package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer_Buy_Medicine extends JFrame {
    JTextField orderDetailsIDInput, orderQunatityInput, orderPurchaseDateInput, drugTypeInput, orderBillInput;
    JButton addButton,cancel;
    String customerNameAccessed = "";
    Customer_Buy_Medicine(String customerName){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        customerNameAccessed = customerName;

        JLabel orderDetailsID = new JLabel("Enter Order ID");
        orderDetailsID.setFont(new Font("Calibri",Font.BOLD,25));
        orderDetailsIDInput = new JTextField();

        JLabel orderQunatity = new JLabel("Enter Order Quantity");
        orderQunatity.setFont(new Font("Calibri",Font.BOLD,25));
        orderQunatityInput = new JTextField();

        JLabel orderPurchaseDate = new JLabel("Enter Purchase Date");
        orderPurchaseDate.setFont(new Font("Calibri",Font.BOLD,25));
        orderPurchaseDateInput = new JTextField();

        JLabel drugType = new JLabel("Enter Drug Type");
        drugType.setFont(new Font("Calibri",Font.BOLD,25));
        drugTypeInput = new JTextField();

        JLabel orderBill = new JLabel("Enter Total Bill");
        drugType.setFont(new Font("Calibri",Font.BOLD,25));
        orderBillInput = new JTextField();

        addButton = new JButton("ADD");
        addButton.setForeground(new Color(0xFFFAF9F4, true));
        addButton.setBackground(new Color(66, 106, 108));
        addButton.setFont(new Font("Calibri",Font.BOLD,30));

        cancel = new JButton("CANCEL");
        cancel.setForeground(new Color(0xFFFAF9F4, true));
        cancel.setBackground(new Color(66, 106, 108));
        cancel.setFont(new Font("Calibri",Font.BOLD,30));

        add(orderDetailsID);add(orderDetailsIDInput);
        add(orderQunatity);add(orderQunatityInput);
        add(orderPurchaseDate);add(orderPurchaseDateInput);
        add(drugType);add(drugTypeInput);
        add(orderBill);add(orderBillInput);
        add(addButton);add(cancel);

        setLayout(new GridLayout(6,2,10,10));
        setVisible(true);
        MyActionListener myActionListener = new MyActionListener();
        addButton.addActionListener(myActionListener);
        cancel.addActionListener(myActionListener);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADD")) {

                int orderDetailsID = Integer.parseInt(orderDetailsIDInput.getText());
                int orderQunatity = Integer.parseInt(orderQunatityInput.getText());
                String orderPurchaseDate = orderPurchaseDateInput.getText();
                String drugType = drugTypeInput.getText();
                int orderBill = Integer.parseInt(orderBillInput.getText());

                ConnectionDB connectionDB = new ConnectionDB();
                try {
                    boolean check = true;
                    ResultSet query  = connectionDB.statement.executeQuery("SELECT order_details_id FROM order_details");
                    while (query.next()){
                        if (query.getInt(1) == orderDetailsID) {
                            check = false;
                        }
                    }
                    if (check) {
                        PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO order_details_id VALUES(?,?,?,?,?)");
                        stmt.setInt(1,orderDetailsID);
                        stmt.setInt(2,orderQunatity);
                        stmt.setString(3,orderPurchaseDate);
                        stmt.setString(4,drugType);
                        stmt.setInt(5,orderBill);
                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(new JFrame(),"Medicine Bought Successfully");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(),"Order Already Exists!!!");                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }else if (e.getActionCommand().equals("CANCEL")){
                dispose();
                new Customer_Menu(customerNameAccessed);
            }
        }
    }
}

