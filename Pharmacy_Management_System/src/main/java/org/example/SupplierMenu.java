package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierMenu extends JFrame {
    JLabel labelHeading = new JLabel("Pharmacy Management System"),name;
    JTextField nameInput;

    JButton CheckStock, CheckStore, ContactDistributer, homeButton, SearchDrug, AddStock;
    SupplierMenu() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        setBackground(Color.WHITE);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());

        labelHeading.setForeground(new Color(66, 106, 108));
        labelHeading.setFont(new Font("Calibri", Font.BOLD, 50));

        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        north.setBackground(new Color(166, 225, 225));
        south.setBackground(new Color(166, 225, 225));
        center.setBackground(new Color(166, 225, 225));
        east.setBackground(new Color(166, 225, 225));
        west.setBackground(new Color(166, 225, 225));

        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);

        center.setLayout(null);
        name = new JLabel("ENTER DRUG NAME TO CHECK");
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

        AddStock = new JButton("ADD STOCK");
        AddStock.setForeground(new Color(0xFFFFFFFF, true));
        AddStock.setBackground(new Color(0xFF426A6C, true));
        AddStock.setFont(new Font("Calibri",Font.BOLD,25));
        AddStock.setBounds(400,0,500,75);

        CheckStock = new JButton("CHECK DRUGS AT STOCK");
        CheckStock.setForeground(new Color(0xFFFFFFFF, true));
        CheckStock.setBackground(new Color(0xFF426A6C, true));
        CheckStock.setFont(new Font("Calibri",Font.BOLD,25));
        CheckStock.setBounds(400,100,500,75);

        CheckStore = new JButton("CHECK DRUGS AT STORE");
        CheckStore.setForeground(new Color(0xFFFFFFFF, true));
        CheckStore.setBackground(new Color(0xFF426A6C, true));
        CheckStore.setFont(new Font("Calibri",Font.BOLD,25));
        CheckStore.setBounds(400,220,500,75);

        ContactDistributer = new JButton("CONTACT DRUG DISTRIBUTOR");
        ContactDistributer.setForeground(new Color(0xFFFFFFFF, true));
        ContactDistributer.setBackground(new Color(0xFF426A6C, true));
        ContactDistributer.setFont(new Font("Calibri",Font.BOLD,25));
        ContactDistributer.setBounds(400,340,500,75);

        SearchDrug = new JButton("SEARCH");
        SearchDrug.setForeground(new Color(0xFFFFFFFF, true));
        SearchDrug.setBackground(new Color(0xFF426A6C, true));
        SearchDrug.setFont(new Font("Calibri",Font.BOLD,25));
        SearchDrug.setBounds(400,340,500,75);
        SearchDrug.setVisible(false);

        homeButton = new JButton("LOGOUT");
        homeButton.setForeground(new Color(0xFFFFFFFF, true));
        homeButton.setBackground(new Color(0xFF426A6C, true));
        homeButton.setFont(new Font("Calibri",Font.BOLD,25));
        homeButton.setBounds(400,460,500,75);

        MyActionListener act1 = new MyActionListener(),
                act2 = new MyActionListener(),
                act3 = new MyActionListener(),
                act4 = new MyActionListener(),
                act5 = new MyActionListener(),
                act6 = new MyActionListener();

        CheckStock.addActionListener(act1);
        CheckStore.addActionListener(act2);
        ContactDistributer.addActionListener(act3);
        SearchDrug.addActionListener(act4);
        homeButton.addActionListener(act5);
        AddStock.addActionListener(act6);

        north.add(labelHeading);
        center.add(CheckStock);
        center.add(CheckStore);
        center.add(ContactDistributer);
        center.add(homeButton);
        center.add(SearchDrug);
        center.add(name);
        center.add(nameInput);
        center.add(AddStock);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SupplierMenu();
    }
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("CHECK DRUGS AT STOCK")) {
                nameInput.setText("");
                CheckStock.setVisible(false);
                CheckStore.setVisible(false);
                ContactDistributer.setVisible(false);
                homeButton.setVisible(false);
                AddStock.setVisible(false);

                SearchDrug.setText("CHECK STOCK");
                SearchDrug.setVisible(true);
                name.setText("CHECK DRUGS AT STOCK");
                name.setVisible(true);
                nameInput.setVisible(true);
            }
            else if (e.getActionCommand().equals("CHECK DRUGS AT STORE")) {
                nameInput.setText("");
                CheckStock.setVisible(false);
                CheckStore.setVisible(false);
                ContactDistributer.setVisible(false);
                homeButton.setVisible(false);
                AddStock.setVisible(false);

                SearchDrug.setText("CHECK STORE");
                SearchDrug.setVisible(true);
                name.setText("CHECK DRUGS AT STORE");
                name.setVisible(true);
                nameInput.setVisible(true);
            }
            else if (e.getActionCommand().equals("CONTACT DRUG DISTRIBUTOR")) {
                nameInput.setText("");
                CheckStock.setVisible(false);
                CheckStore.setVisible(false);
                ContactDistributer.setVisible(false);
                homeButton.setVisible(false);
                AddStock.setVisible(false);

                SearchDrug.setText("SEARCH");
                SearchDrug.setVisible(true);
                name.setText("ENTER DISTRIBUTOR NAME TO CONTACT");
                name.setVisible(true);
                nameInput.setVisible(true);

            }
            else if (e.getActionCommand().equals("SEARCH")) {
                nameInput.setText("");
                JOptionPane.showMessageDialog(new JFrame(), "FOUND");
                name.setText("ENTER YOUR MESSAGE TO DISTRIBUTOR");
                SearchDrug.setText("SEND MESSAGE");

            }
            else if (e.getActionCommand().equals("SEND MESSAGE")) {
                nameInput.setText("");
                SearchDrug.setVisible(false);
                name.setVisible(false);
                nameInput.setVisible(false);

                CheckStock.setVisible(true);
                CheckStore.setVisible(true);
                ContactDistributer.setVisible(true);
                SearchDrug.setVisible(true);
                homeButton.setVisible(true);
                AddStock.setVisible(true);

            }
            else if (e.getActionCommand().equals("CHECK STOCK")) {
                nameInput.setText("");
                JOptionPane.showMessageDialog(new JFrame(), "Bought");
                SearchDrug.setVisible(false);
                name.setVisible(false);
                nameInput.setVisible(false);

                CheckStock.setVisible(true);
                CheckStore.setVisible(true);
                ContactDistributer.setVisible(true);
                SearchDrug.setVisible(true);
                homeButton.setVisible(true);
                AddStock.setVisible(true);
            }
            else if (e.getActionCommand().equals("CHECK STORE")) {
                nameInput.setText("");
                JOptionPane.showMessageDialog(new JFrame(), "Bought");
                SearchDrug.setVisible(true);
                name.setVisible(false);
                nameInput.setVisible(false);

                CheckStock.setVisible(true);
                CheckStore.setVisible(true);
                ContactDistributer.setVisible(true);
                SearchDrug.setVisible(true);
                homeButton.setVisible(true);
                AddStock.setVisible(true);
            }
            else if (e.getActionCommand().equals("LOGOUT")) {
                dispose();
                new EmployeeChild();
            }else if (e.getActionCommand().equals("ADD STOCK")) {
                dispose();
                new Add_Stock();
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "Error Occured");
            }
        }
    }
}