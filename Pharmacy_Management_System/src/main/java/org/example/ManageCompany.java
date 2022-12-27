package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageCompany extends JFrame {
    JLabel labelHeading;
    JButton add_drugs, delete_drugs, view, search, sell_drugs_to_supplier, go_back;
    String userNameAccessed = "";
    ManageCompany(String companyConnectorName) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setBackground(Color.WHITE);
        userNameAccessed = companyConnectorName;
        labelHeading = new JLabel(companyConnectorName+", what do you wanna do?");
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

        add_drugs = new JButton("ADD DRUGS");
        add_drugs.setForeground(new Color(0xFFFFFFFF, true));
        add_drugs.setBackground(new Color(0xFF426A6C, true));
        add_drugs.setFont(new Font("Calibri",Font.BOLD,25));
        add_drugs.setBounds(250,220,400,75);

        delete_drugs = new JButton("DELETE DRUGS");
        delete_drugs.setForeground(new Color(0xFFFFFFFF, true));
        delete_drugs.setBackground(new Color(0xFF426A6C, true));
        delete_drugs.setFont(new Font("Calibri",Font.BOLD,25));
        delete_drugs.setBounds(250,320,400,75);

        view = new JButton("VIEW");
        view.setForeground(new Color(0xFFFFFFFF, true));
        view.setBackground(new Color(0xFF426A6C, true));
        view.setFont(new Font("Calibri",Font.BOLD,25));
        view.setBounds(250,420,400,75);

        search = new JButton("SEARCH");
        search.setForeground(new Color(0xFFFFFFFF, true));
        search.setBackground(new Color(0xFF426A6C, true));
        search.setFont(new Font("Calibri",Font.BOLD,25));
        search.setBounds(750,220,400,75);

        sell_drugs_to_supplier = new JButton("SELL DRUGS TO SUPPLIER");
        sell_drugs_to_supplier.setForeground(new Color(0xFFFFFFFF, true));
        sell_drugs_to_supplier.setBackground(new Color(0xFF426A6C, true));
        sell_drugs_to_supplier.setFont(new Font("Calibri",Font.BOLD,25));
        sell_drugs_to_supplier.setBounds(750,320,400,75);

        go_back = new JButton("GO BACK");
        go_back.setForeground(new Color(0xFFFFFFFF, true));
        go_back.setBackground(new Color(0xFF426A6C, true));
        go_back.setFont(new Font("Calibri",Font.BOLD,25));
        go_back.setBounds(750,420,400,75);

        MyActionListener myActionListener = new MyActionListener();

        add_drugs.addActionListener(myActionListener);
        view.addActionListener(myActionListener);
        search.addActionListener(myActionListener);
        sell_drugs_to_supplier.addActionListener(myActionListener);
        delete_drugs.addActionListener(myActionListener);
        go_back.addActionListener(myActionListener);

        north.add(labelHeading);
        center.add(add_drugs);center.add(delete_drugs);center.add(view);
        center.add(search);center.add(sell_drugs_to_supplier);center.add(go_back);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADD DRUGS")) {
                JOptionPane.showMessageDialog(new JFrame(), "ADD DRUG Clicked");
            }
            else if (e.getActionCommand().equals("DELETE DRUGS")) {
                JOptionPane.showMessageDialog(new JFrame(), "DELETE DRUGS Clicked");
            }
            else if (e.getActionCommand().equals("VIEW")) {
                JOptionPane.showMessageDialog(new JFrame(), "VIEW Clicked");
            }
            else if (e.getActionCommand().equals("SEARCH")) {
                JOptionPane.showMessageDialog(new JFrame(), "SEARCH Clicked");
            }
            else if (e.getActionCommand().equals("SELL DRUGS TO SUPPLIER")) {
                JOptionPane.showMessageDialog(new JFrame(), "SELL DRUGS TO SUPPLIER Clicked");
            }
            else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new Company_Connector(userNameAccessed);
            }
        }
    }
}