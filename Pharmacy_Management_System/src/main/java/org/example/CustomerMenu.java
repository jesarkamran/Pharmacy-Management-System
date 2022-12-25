package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame {
    JLabel labelHeading, name;
    JTextField nameInput;
    JButton Search, Buy,BuyDrug,SearchDrug,homeButton;

    CustomerMenu(String customerName) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        setBackground(Color.WHITE);
        labelHeading = new JLabel("Hey there, "+customerName);

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
        name.setBounds(400,100,500,100);
        name.setVisible(false);

        nameInput = new JTextField();
        nameInput.setBackground(new Color(0xFFFFFFFF, true));
        nameInput.setFont(new Font("Calibri",Font.BOLD,25));
        nameInput.setBounds(400,220,500,100);
        nameInput.setVisible(false);

        Search = new JButton("SEARCH");
        Search.setForeground(new Color(0xFFFFFFFF, true));
        Search.setBackground(new Color(0xFF426A6C, true));
        Search.setFont(new Font("Calibri",Font.BOLD,25));
        Search.setBounds(400,340,500,100);
        Search.setVisible(false);

        Buy = new JButton("BUY");
        Buy.setForeground(new Color(0xFFFFFFFF, true));
        Buy.setBackground(new Color(0xFF426A6C, true));
        Buy.setFont(new Font("Calibri",Font.BOLD,25));
        Buy.setBounds(400,340,500,100);
        Buy.setVisible(false);

        BuyDrug = new JButton("BUY MEDICINE");
        BuyDrug.setForeground(new Color(0xFFFFFFFF, true));
        BuyDrug.setBackground(new Color(0xFF426A6C, true));
        BuyDrug.setFont(new Font("Calibri",Font.BOLD,25));
        BuyDrug.setBounds(400,100,500,100);

        SearchDrug = new JButton("SEARCH MEDICINE");
        SearchDrug.setForeground(new Color(0xFFFFFFFF, true));
        SearchDrug.setBackground(new Color(0xFF426A6C, true));
        SearchDrug.setFont(new Font("Calibri",Font.BOLD,25));
        SearchDrug.setBounds(400,220,500,100);

        homeButton = new JButton("LOGOUT");
        homeButton.setForeground(new Color(0xFFFFFFFF, true));
        homeButton.setBackground(new Color(0xFF426A6C, true));
        homeButton.setFont(new Font("Calibri",Font.BOLD,25));
        homeButton.setBounds(400,340,500,100);

        MyActionListener act1 = new MyActionListener(),
                act2 = new MyActionListener(),
                act3 = new MyActionListener(),
                act4 = new MyActionListener(),
                act5 = new MyActionListener();

        Buy.addActionListener(act1);
        Search.addActionListener(act2);
        BuyDrug.addActionListener(act3);
        SearchDrug.addActionListener(act4);
        homeButton.addActionListener(act5);

        north.add(labelHeading);
        center.add(Search);
        center.add(Buy);
        center.add(name);
        center.add(nameInput);
        center.add(BuyDrug);
        center.add(SearchDrug);
        center.add(homeButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SupplierMenu();
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("BUY MEDICINE")) {
                BuyDrug.setVisible(false);
                SearchDrug.setVisible(false);
                homeButton.setVisible(false);

                Buy.setVisible(true);
                name.setVisible(true);
                nameInput.setVisible(true);
                nameInput.setText("");
            }
            else if (e.getActionCommand().equals("SEARCH MEDICINE")) {
                BuyDrug.setVisible(false);
                SearchDrug.setVisible(false);
                homeButton.setVisible(false);

                Search.setVisible(true);
                name.setVisible(true);
                nameInput.setVisible(true);
                nameInput.setText("");
            }
            else if (e.getActionCommand().equals("SEARCH")) {
                JOptionPane.showMessageDialog(new JFrame(), "Found");
                Search.setVisible(false);
                name.setVisible(false);
                nameInput.setVisible(false);

                BuyDrug.setVisible(true);
                SearchDrug.setVisible(true);
                homeButton.setVisible(true);
                nameInput.setText("");
            }
            else if (e.getActionCommand().equals("BUY")) {
                JOptionPane.showMessageDialog(new JFrame(), "Bought");
                Buy.setVisible(false);
                name.setVisible(false);
                nameInput.setVisible(false);

                BuyDrug.setVisible(true);
                SearchDrug.setVisible(true);
                homeButton.setVisible(true);
                nameInput.setText("");
            }
            else if (e.getActionCommand().equals("LOGOUT")) {
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "Error Occured");
            }
        }
    }
}