package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeChild extends JFrame {
    JLabel labelHeading;
    JTextField nameInput;
    JButton supplier, seller, goback;

    EmployeeChild() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        setBackground(Color.WHITE);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        labelHeading = new JLabel("ARE YOU A?");
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

        supplier = new JButton("SUPPLIER");
        supplier.setForeground(new Color(0xFFFFFFFF, true));
        supplier.setBackground(new Color(0xFF426A6C, true));
        supplier.setFont(new Font("Calibri",Font.BOLD,25));
        supplier.setBounds(400,100,500,100);

        seller = new JButton("SELLER");
        seller.setForeground(new Color(0xFFFFFFFF, true));
        seller.setBackground(new Color(0xFF426A6C, true));
        seller.setFont(new Font("Calibri",Font.BOLD,25));
        seller.setBounds(400,220,500,100);

        goback = new JButton("GO BACK");
        goback.setForeground(new Color(0xFFFFFFFF, true));
        goback.setBackground(new Color(0xFF426A6C, true));
        goback.setFont(new Font("Calibri",Font.BOLD,25));
        goback.setBounds(400,340,500,100);

        MyActionListener
                act3 = new MyActionListener(),
                act4 = new MyActionListener(),
                act5 = new MyActionListener();

        supplier.addActionListener(act3);
        seller.addActionListener(act4);
        goback.addActionListener(act5);

        north.add(labelHeading);
        center.add(supplier);
        center.add(seller);
        center.add(goback);

        setVisible(true);
    }
    
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("SUPPLIER")) {
                dispose();
                new CheckOccurrence("Supplier");
            }
            else if (e.getActionCommand().equals("SELLER")) {
                dispose();
                new CheckOccurrence("Seller");
            }
            else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new StartMenu();
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "Error Occurred");
            }
        }
    }
}