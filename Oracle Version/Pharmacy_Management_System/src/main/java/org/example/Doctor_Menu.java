package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctor_Menu extends JFrame {
    JLabel labelHeading;

    JButton buy_drugs_from_distributor, delete_drugs, view, search,buy_drugs_from_Seller,go_back;
    String userNameAccessed = "";
    Doctor_Menu(String doctorName) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setTitle("Pharmacy Management System");
        setBackground(Color.WHITE);
        userNameAccessed = doctorName;

        labelHeading = new JLabel("Welcome Dr. "+userNameAccessed);
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

        buy_drugs_from_distributor = new JButton("BUY DRUGS FORM DISTRIBUTOR");
        buy_drugs_from_distributor.setForeground(new Color(0xFFFFFFFF, true));
        buy_drugs_from_distributor.setBackground(new Color(0xFF426A6C, true));
        buy_drugs_from_distributor.setFont(new Font("Calibri",Font.BOLD,25));
        buy_drugs_from_distributor.setBounds(250,120,400,75);

        delete_drugs = new JButton("DELETE DRUGS");
        delete_drugs.setForeground(new Color(0xFFFFFFFF, true));
        delete_drugs.setBackground(new Color(0xFF426A6C, true));
        delete_drugs.setFont(new Font("Calibri",Font.BOLD,25));
        delete_drugs.setBounds(250,220,400,75);

        view = new JButton("VIEW");
        view.setForeground(new Color(0xFFFFFFFF, true));
        view.setBackground(new Color(0xFF426A6C, true));
        view.setFont(new Font("Calibri",Font.BOLD,25));
        view.setBounds(250,320,400,75);

        search = new JButton("SEARCH DRUGS");
        search.setForeground(new Color(0xFFFFFFFF, true));
        search.setBackground(new Color(0xFF426A6C, true));
        search.setFont(new Font("Calibri",Font.BOLD,25));
        search.setBounds(750,120,400,75);

        buy_drugs_from_Seller = new JButton("BUY DRUGS FORM SELLER");
        buy_drugs_from_Seller.setForeground(new Color(0xFFFFFFFF, true));
        buy_drugs_from_Seller.setBackground(new Color(0xFF426A6C, true));
        buy_drugs_from_Seller.setFont(new Font("Calibri",Font.BOLD,25));
        buy_drugs_from_Seller.setBounds(750,220,400,75);

        go_back = new JButton("GO BACK");
        go_back.setForeground(new Color(0xFFFFFFFF, true));
        go_back.setBackground(new Color(0xFF426A6C, true));
        go_back.setFont(new Font("Calibri",Font.BOLD,25));
        go_back.setBounds(750,320,400,75);

        MyActionListener myActionListener = new MyActionListener();

        buy_drugs_from_distributor.addActionListener(myActionListener);
        delete_drugs.addActionListener(myActionListener);
        view.addActionListener(myActionListener);
        search.addActionListener(myActionListener);
        buy_drugs_from_Seller.addActionListener(myActionListener);
        go_back.addActionListener(myActionListener);

        north.add(labelHeading);
        center.add(buy_drugs_from_distributor);center.add(delete_drugs);center.add(view);
        center.add(search);center.add(buy_drugs_from_Seller);center.add(go_back);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("BUY DRUGS FORM DISTRIBUTOR")) {
                new Doctor_Pop_Up_Screen("BUY DRUGS","BUY","buy");
            }
            else if (e.getActionCommand().equals("DELETE DRUGS")) {
                new Doctor_Pop_Up_Screen("DELETE DRUGS","DELETE","delete");
            }
            else if (e.getActionCommand().equals("VIEW")) {
//                JOptionPane.showMessageDialog(new JFrame(), "VIEW Clicked");
            }
            else if (e.getActionCommand().equals("SEARCH DRUGS")) {
                new Doctor_Pop_Up_Screen("SEARCH DRUGS","SEARCH","search");
            }
            else if (e.getActionCommand().equals("BUY DRUGS FORM SELLER")) {
                new Doctor_Pop_Up_Screen("BUY DRUGS","BUY","buy_from_seller");
            }
            else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new StartMenu();
            }
        }
    }
}