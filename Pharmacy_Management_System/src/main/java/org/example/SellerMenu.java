package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerMenu extends JFrame {
    JLabel labelHeading, name;
    JTextField nameInput;
    JButton Search, Buy,AddDrug,SalesDetails,homeButton, SellDrug;

    SellerMenu(String sellerName) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setBackground(Color.WHITE);
        labelHeading = new JLabel("Hey there, "+sellerName);

        labelHeading.setForeground(new Color(66, 106, 108));
        labelHeading.setFont(new Font("Calibri", Font.BOLD, 50));

        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        north.setBackground(new Color(184, 222,222));
        south.setBackground(new Color(184, 222,222));
        center.setBackground(new Color(184, 222,222));
        east.setBackground(new Color(184, 222,222));
        west.setBackground(new Color(184, 222,222));

        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);

        center.setLayout(null);

        name = new JLabel("ENTER MEDICINE NAME");
        name.setForeground(new Color(0xFF070707, true));
        name.setBackground(new Color(0xFF426A6C, true));
        name.setFont(new Font("Calibri",Font.BOLD,25));
        name.setBounds(400,100,500,75);
        name.setVisible(false);

        nameInput = new JTextField();
        nameInput.setBackground(new Color(0xFFFFFFFF, true));
        nameInput.setFont(new Font("Calibri",Font.BOLD,25));
        nameInput.setBounds(400,220,500,75);
        nameInput.setVisible(false);

        Search = new JButton("SEARCH");
        Search.setForeground(new Color(0xFFFFFFFF, true));
        Search.setBackground(new Color(0xFF426A6C, true));
        Search.setFont(new Font("Calibri",Font.BOLD,25));
        Search.setBounds(400,340,500,75);
        Search.setVisible(false);

        Buy = new JButton("BUY");
        Buy.setForeground(new Color(0xFFFFFFFF, true));
        Buy.setBackground(new Color(0xFF426A6C, true));
        Buy.setFont(new Font("Calibri",Font.BOLD,25));
        Buy.setBounds(400,340,500,75);
        Buy.setVisible(false);

        AddDrug = new JButton("ADD MEDICINE");
        AddDrug.setForeground(new Color(0xFFFFFFFF, true));
        AddDrug.setBackground(new Color(0xFF426A6C, true));
        AddDrug.setFont(new Font("Calibri",Font.BOLD,25));
        AddDrug.setBounds(400,100,500,75);

        SalesDetails = new JButton("SEE SALES DETAILS");
        SalesDetails.setForeground(new Color(0xFFFFFFFF, true));
        SalesDetails.setBackground(new Color(0xFF426A6C, true));
        SalesDetails.setFont(new Font("Calibri",Font.BOLD,25));
        SalesDetails.setBounds(400,220,500,75);

        SellDrug = new JButton("SELL DRUG");
        SellDrug.setForeground(new Color(0xFFFFFFFF, true));
        SellDrug.setBackground(new Color(0xFF426A6C, true));
        SellDrug.setFont(new Font("Calibri",Font.BOLD,25));
        SellDrug.setBounds(400,340,500,75);

        homeButton = new JButton("LOGOUT");
        homeButton.setForeground(new Color(0xFFFFFFFF, true));
        homeButton.setBackground(new Color(0xFF426A6C, true));
        homeButton.setFont(new Font("Calibri",Font.BOLD,25));
        homeButton.setBounds(400,460,500,75);

        MyActionListener act1 = new MyActionListener(),
                act2 = new MyActionListener(),
                act3 = new MyActionListener(),
                act4 = new MyActionListener(),
                act5 = new MyActionListener();

        SellDrug.addActionListener(act1);
        Search.addActionListener(act2);
        AddDrug.addActionListener(act3);
        SalesDetails.addActionListener(act4);
        homeButton.addActionListener(act5);

        north.add(labelHeading);
        center.add(Search);
        center.add(SellDrug);
        center.add(name);
        center.add(nameInput);
        center.add(AddDrug);
        center.add(SalesDetails);
        center.add(homeButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SupplierMenu();
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADD MEDICINE")) {
                JOptionPane.showMessageDialog(new JFrame(), "In Process");
            }
            else if (e.getActionCommand().equals("SEE SALES DETAILS")) {
                JOptionPane.showMessageDialog(new JFrame(), "In Process");
            }
            else if (e.getActionCommand().equals("SELL DRUG")) {
                AddDrug.setVisible(false);
                SalesDetails.setVisible(false);
                SellDrug.setVisible(false);
                homeButton.setVisible(false);

                Search.setText("SEARCH");
                Search.setVisible(true);
                name.setText("ENTER CUSTOMER SSN TO CONTACT");
                name.setVisible(true);
                nameInput.setVisible(true);

            }
            else if (e.getActionCommand().equals("SEARCH")) {
                nameInput.setText("");
                JOptionPane.showMessageDialog(new JFrame(), "FOUND");
                name.setText("ENTER YOUR MESSAGE TO DISTRIBUTOR");
                Search.setText("SEND MESSAGE");
            }
            else if (e.getActionCommand().equals("SEND MESSAGE")) {
                nameInput.setText("");
                Search.setVisible(false);
                name.setVisible(false);
                nameInput.setVisible(false);

                AddDrug.setVisible(true);
                SalesDetails.setVisible(true);
                SellDrug.setVisible(true);
                homeButton.setVisible(true);
                nameInput.setText("");
            }
            else if (e.getActionCommand().equals("LOGOUT")) {
                dispose();
                new EmployeeChild();
            }
        }
    }
}