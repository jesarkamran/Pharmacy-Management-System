package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Add_Company extends JFrame
{
    JLabel labelHeading,
            comp_id, company_name;
    JTextField comp_id_input, company_name_Input;
    JButton submit, go_back;
    String userNameAccessed = "";
    Add_Company(String companyConnector)
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setBackground(Color.WHITE);
        userNameAccessed = companyConnector;

        labelHeading = new JLabel(companyConnector+", Please add correct details");
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

        comp_id = new JLabel("ENTER COMPANY ID");
        comp_id.setForeground(new Color(0xFF426A6C, true));
        comp_id.setFont(new Font("Calibri",Font.BOLD,25));
        comp_id.setBounds(250,220,400,75);

        company_name = new JLabel("ENTER COMPANY NAME");
        company_name.setForeground(new Color(0xFF426A6C, true));
        company_name.setFont(new Font("Calibri",Font.BOLD,25));
        company_name.setBounds(250,320,400,75);

        comp_id_input = new JTextField();
        comp_id_input.setForeground(new Color(0xFF426A6C, true));
        comp_id_input.setFont(new Font("Calibri",Font.BOLD,25));
        comp_id_input.setBounds(750,220,400,75);

        company_name_Input = new JTextField();
        company_name_Input.setForeground(new Color(0xFF426A6C, true));
        company_name_Input.setFont(new Font("Calibri",Font.BOLD,25));
        company_name_Input.setBounds(750,320,400,75);

        go_back = new JButton("GO BACK");
        go_back.setForeground(new Color(0xFFFFFFFF, true));
        go_back.setBackground(new Color(0xFF426A6C, true));
        go_back.setFont(new Font("Calibri",Font.BOLD,25));
        go_back.setBounds(250,420,400,75);

        submit = new JButton("SUBMIT");
        submit.setForeground(new Color(0xFFFFFFFF, true));
        submit.setBackground(new Color(0xFF426A6C, true));
        submit.setFont(new Font("Calibri",Font.BOLD,25));
        submit.setBounds(750,420,400,75);

        MyActionListener act = new MyActionListener();
        submit.addActionListener(act);
        go_back.addActionListener(act);

        north.add(labelHeading);
        center.add(comp_id);center.add(company_name);center.add(comp_id_input);
        center.add(company_name_Input);center.add(submit);center.add(go_back);

        setVisible(true);
    }
    public  int generateRandom(){
        Random rand = new Random();
        // Generate a random integer between 0 and 99999999 (inclusive)
        return rand.nextInt(100000000);
    }

    class MyActionListener  implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("SUBMIT")) {

                // BACKEND
                int companyId = Integer.parseInt(comp_id_input.getText());
                String companyName = company_name_Input.getText();

                ConnectionDB connectionDB = new ConnectionDB();
                try {
                    boolean check = true;
                    ResultSet query  = connectionDB.statement.executeQuery("SELECT company_id FROM company");
                    while (query.next()){
                        if (query.getInt(1) == companyId) {
                            check = false;
                        }
                    }
                    if (check) {
                        PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO company VALUES(?,?)");
                        stmt.setInt(1,companyId);
                        stmt.setString(2,companyName);
                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(new JFrame(), "Company Added Successfully");
                        dispose();
                        new Company_Connector(userNameAccessed);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Company Already Exists");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new Company_Connector(userNameAccessed);
            }
        }
    }
}