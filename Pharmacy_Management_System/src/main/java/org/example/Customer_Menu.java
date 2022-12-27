package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer_Menu extends JFrame {
    JLabel labelHeading;

    JButton buy_drugs_from_Seller, delete_drugs, view, search,go_back;
    String customerNameAccessed = "";
    Customer_Menu(String customer_name) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setBackground(Color.WHITE);
        customerNameAccessed = customer_name;
        labelHeading = new JLabel("Hey,there "+customerNameAccessed);

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

        buy_drugs_from_Seller = new JButton("BUY DRUGS");
        buy_drugs_from_Seller.setForeground(new Color(0xFFFFFFFF, true));
        buy_drugs_from_Seller.setBackground(new Color(0xFF426A6C, true));
        buy_drugs_from_Seller.setFont(new Font("Calibri",Font.BOLD,25));
        buy_drugs_from_Seller.setBounds(250,150,400,75);

        delete_drugs = new JButton("DELETE DRUGS");
        delete_drugs.setForeground(new Color(0xFFFFFFFF, true));
        delete_drugs.setBackground(new Color(0xFF426A6C, true));
        delete_drugs.setFont(new Font("Calibri",Font.BOLD,25));
        delete_drugs.setBounds(250,250,400,75);

        view = new JButton("VIEW");
        view.setForeground(new Color(0xFFFFFFFF, true));
        view.setBackground(new Color(0xFF426A6C, true));
        view.setFont(new Font("Calibri",Font.BOLD,25));
        view.setBounds(750,150,400,75);

        search = new JButton("SEARCH DRUGS");
        search.setForeground(new Color(0xFFFFFFFF, true));
        search.setBackground(new Color(0xFF426A6C, true));
        search.setFont(new Font("Calibri",Font.BOLD,25));
        search.setBounds(750,250,400,75);

        go_back = new JButton("GO BACK");
        go_back.setForeground(new Color(0xFFFFFFFF, true));
        go_back.setBackground(new Color(0xFF426A6C, true));
        go_back.setFont(new Font("Calibri",Font.BOLD,25));
        go_back.setBounds(400,350,600,75);

        MyActionListener myActionListener = new MyActionListener();

        buy_drugs_from_Seller.addActionListener(myActionListener);
        view.addActionListener(myActionListener);
        search.addActionListener(myActionListener);
        delete_drugs.addActionListener(myActionListener);
        go_back.addActionListener(myActionListener);

        north.add(labelHeading);
        center.add(buy_drugs_from_Seller);
        center.add(delete_drugs);
        center.add(view);
        center.add(search);
        center.add(go_back);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("BUY DRUGS")) {

                // BUY DRUGS POP-UP SCREEN FRONTEND
                new Pop_Up_Screen("BUY DRUGS","BUY","buy");

                // BUY DRUGS POP-UP SCREEN BACKEND


            }
            else if (e.getActionCommand().equals("DELETE DRUGS")) {

                // DELETE DRUGS POP-UP SCREEN FRONTEND
                new Pop_Up_Screen("DELETE DRUGS","DELETE","delete");

                // DELETE DRUGS POP-UP SCREEN BACKEND


            }
            else if (e.getActionCommand().equals("VIEW")) {
                JOptionPane.showMessageDialog(new JFrame(), "VIEW Clicked");

            }
            else if (e.getActionCommand().equals("SEARCH DRUGS")) {

                // SEARCH DRUGS POP-UP SCREEN FRONTEND
                new Pop_Up_Screen("SEARCH DRUGS","SEARCH","search");

                // SEARCH DRUGS POP-UP SCREEN BACKEND

            }
            else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new StartMenu();
            }
        }
    }
}