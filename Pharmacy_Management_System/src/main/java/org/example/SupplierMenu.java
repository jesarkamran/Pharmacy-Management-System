package org.example;
import javax.swing.*;
import java.awt.*;

public class SupplierMenu extends JFrame {
    JLabel labelHeading = new JLabel("Pharmacy Management System");

    SupplierMenu() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");

        labelHeading.setForeground(new Color(66, 106, 108));
        labelHeading.setFont(new Font("Calibri", Font.BOLD, 50));

        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        north.setBackground(new Color(184, 222, 222));
        south.setBackground(new Color(184, 222, 222));
        center.setBackground(new Color(184, 222, 222));
        east.setBackground(new Color(184, 222, 222));
        west.setBackground(new Color(184, 222, 222));

        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);

        center.setLayout(null);

        JButton CheckStock = new JButton("CHECK DRUGS AT STOCK");
        CheckStock.setForeground(new Color(0xFFFAF9F4, true));
        CheckStock.setBackground(new Color(0xFF426A6C, true));
        CheckStock.setFont(new Font("Calibri",Font.BOLD,25));
        CheckStock.setBounds(400,100,500,100);

        JButton CheckStore = new JButton("CHECK DRUGS AT STORE");
        CheckStore.setForeground(new Color(0xFFFAF9F4, true));
        CheckStore.setBackground(new Color(0xFF426A6C, true));
        CheckStore.setFont(new Font("Calibri",Font.BOLD,25));
        CheckStore.setBounds(400,220,500,100);

        JButton ContactDistributer = new JButton("CONTACT DRUG DISTRIBUTOR");
        ContactDistributer.setForeground(new Color(0xFFFAF9F4, true));
        ContactDistributer.setBackground(new Color(0xFF426A6C, true));
        ContactDistributer.setFont(new Font("Calibri",Font.BOLD,25));
        ContactDistributer.setBounds(400,340,500,100);

        JButton homeButton = new JButton("LOGOUT");
        homeButton.setForeground(new Color(0xFFFAF9F4, true));
        homeButton.setBackground(new Color(0xFF426A6C, true));
        homeButton.setFont(new Font("Calibri",Font.BOLD,25));
        homeButton.setBounds(400,460,500,100);

        north.add(labelHeading);
        center.add(CheckStock);
        center.add(CheckStore);
        center.add(ContactDistributer);
        center.add(homeButton);
        setVisible(true);
    }
}
