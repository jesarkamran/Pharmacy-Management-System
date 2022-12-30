package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Company_Connector extends JFrame {
    JLabel labelHeading;

    JButton add_Company, manage_Company,  go_back;
    String userNameAccessed = "";
    Company_Connector(String companyConnectorName) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setBackground(Color.WHITE);
        userNameAccessed = companyConnectorName;
        labelHeading = new JLabel("Hey, there "+userNameAccessed);

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

        add_Company = new JButton("ADD COMPANY");
        add_Company.setForeground(new Color(0xFFFFFFFF, true));
        add_Company.setBackground(new Color(0xFF426A6C, true));
        add_Company.setFont(new Font("Calibri",Font.BOLD,25));
        add_Company.setBounds(400,100,500,75);

        manage_Company = new JButton("MANAGE COMPANY");
        manage_Company.setForeground(new Color(0xFFFFFFFF, true));
        manage_Company.setBackground(new Color(0xFF426A6C, true));
        manage_Company.setFont(new Font("Calibri",Font.BOLD,25));
        manage_Company.setBounds(400,220,500,75);

        go_back = new JButton("GO BACK");
        go_back.setForeground(new Color(0xFFFFFFFF, true));
        go_back.setBackground(new Color(0xFF426A6C, true));
        go_back.setFont(new Font("Calibri",Font.BOLD,25));
        go_back.setBounds(400,340,500,75);

        MyActionListener act1 = new MyActionListener(),
                act2 = new MyActionListener(),
                act3 = new MyActionListener(),
                act4 = new MyActionListener();

        add_Company.addActionListener(act1);
        manage_Company.addActionListener(act2);
        go_back.addActionListener(act4);

        north.add(labelHeading);
        center.add(add_Company);
        center.add(manage_Company);
        center.add(go_back);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADD COMPANY")) {
                dispose();
                new Add_Company(userNameAccessed);
            }
            else if (e.getActionCommand().equals("MANAGE COMPANY")) {
                dispose();
                new Company_to_Manage(userNameAccessed);
            }
            else if (e.getActionCommand().equals("GO BACK")) {
                new StartMenu();
                dispose();
            }
        }
    }
}