package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Company_to_Manage extends JFrame
{
    JLabel labelHeading = new JLabel("AddCOMPANY FORM"),
            comp_id;
    JTextField comp_id_input;
    JButton submit, go_back;
    String userNameAccessed = "";
    int companyId = 0;
    Company_to_Manage(String userName)
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setBackground(Color.WHITE);
        userNameAccessed = userName;

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

        comp_id = new JLabel("ENTER COMPANY ID TO MANAGE");
        comp_id.setForeground(new Color(0xFF426A6C, true));
        comp_id.setFont(new Font("Calibri",Font.BOLD,25));
        comp_id.setBounds(250,220,400,75);

        comp_id_input = new JTextField();
        comp_id_input.setForeground(new Color(0xFF426A6C, true));
        comp_id_input.setFont(new Font("Calibri",Font.BOLD,25));
        comp_id_input.setBounds(750,220,400,75);

        go_back = new JButton("GO BACK");
        go_back.setForeground(new Color(0xFFFFFFFF, true));
        go_back.setBackground(new Color(0xFF426A6C, true));
        go_back.setFont(new Font("Calibri",Font.BOLD,25));
        go_back.setBounds(250,320,400,75);

        submit = new JButton("SUBMIT");
        submit.setForeground(new Color(0xFFFFFFFF, true));
        submit.setBackground(new Color(0xFF426A6C, true));
        submit.setFont(new Font("Calibri",Font.BOLD,25));
        submit.setBounds(750,320,400,75);

        MyActionListener act = new MyActionListener();
        submit.addActionListener(act);
        go_back.addActionListener(act);

        north.add(labelHeading);
        center.add(comp_id);
        center.add(comp_id_input);
        center.add(submit);
        center.add(go_back);

        setVisible(true);
    }

    class MyActionListener  implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("SUBMIT")) {
                dispose();
                companyId = Integer.parseInt(comp_id_input.getText());
                new ManageCompany(userNameAccessed,companyId);
            }
            else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new Company_Connector(userNameAccessed);
            }
        }
    }
}