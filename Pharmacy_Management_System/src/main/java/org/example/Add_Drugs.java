package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Add_Drugs extends JFrame
{
    JLabel labelHeading,
            drug_id, name, manufacture_date, expiry_date,
            manufactured_price, b2_B_price, b2_C_price;
    JTextField drug_id_input, drug_name_input, manufacture_date_input, expiry_date_input,
            manufactured_price_input, b2_B_price_input, b2_C_price_input;
    JButton submit, go_back;
    String userNameAccessed = "";
    int companyId = 0;
    Add_Drugs(String userName,int companyIdIN)
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pharmacy Management System");
        setBackground(Color.WHITE);
        userNameAccessed = userName;
        labelHeading = new JLabel("Hello, "+userNameAccessed);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());

        companyId  = companyIdIN;

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

        drug_id = new JLabel("ENTER DRUG ID");
        drug_id.setForeground(new Color(0xFF426A6C, true));
        drug_id.setFont(new Font("Calibri",Font.BOLD,20));
        drug_id.setBounds(0,50,300,75);

        drug_id_input = new JTextField();
        drug_id_input.setForeground(new Color(0xFF426A6C, true));
        drug_id_input.setFont(new Font("Calibri",Font.BOLD,20));
        drug_id_input.setBounds(310,50,300,75);

        name = new JLabel("ENTER DRUG NAME");
        name.setForeground(new Color(0xFF426A6C, true));
        name.setFont(new Font("Calibri",Font.BOLD,20));
        name.setBounds(620,50,300,75);

        drug_name_input = new JTextField();
        drug_name_input.setForeground(new Color(0xFF426A6C, true));
        drug_name_input.setFont(new Font("Calibri",Font.BOLD,20));
        drug_name_input.setBounds(930,50,300,75);

        manufacture_date = new JLabel("ENTER MANUFACTURE DATE");
        manufacture_date.setForeground(new Color(0xFF426A6C, true));
        manufacture_date.setFont(new Font("Calibri",Font.BOLD,20));
        manufacture_date.setBounds(0,150,300,75);

        manufacture_date_input = new JTextField();
        manufacture_date_input.setForeground(new Color(0xFF426A6C, true));
        manufacture_date_input.setFont(new Font("Calibri",Font.BOLD,20));
        manufacture_date_input.setBounds(310,150,300,75);

        expiry_date = new JLabel("ENTER EXPIRY DATE");
        expiry_date.setForeground(new Color(0xFF426A6C, true));
        expiry_date.setFont(new Font("Calibri",Font.BOLD,20));
        expiry_date.setBounds(620,150,300,75);

        expiry_date_input = new JTextField();
        expiry_date_input.setForeground(new Color(0xFF426A6C, true));
        expiry_date_input.setFont(new Font("Calibri",Font.BOLD,20));
        expiry_date_input.setBounds(930,150,300,75);

        manufactured_price = new JLabel("ENTER MANUFACTURE PRICE");
        manufactured_price.setForeground(new Color(0xFF426A6C, true));
        manufactured_price.setFont(new Font("Calibri",Font.BOLD,20));
        manufactured_price.setBounds(0,250,300,75);

        manufactured_price_input = new JTextField();
        manufactured_price_input.setForeground(new Color(0xFF426A6C, true));
        manufactured_price_input.setFont(new Font("Calibri",Font.BOLD,20));
        manufactured_price_input.setBounds(310,250,300,75);

        b2_B_price = new JLabel("ENTER B2B PRICE");
        b2_B_price.setForeground(new Color(0xFF426A6C, true));
        b2_B_price.setFont(new Font("Calibri",Font.BOLD,20));
        b2_B_price.setBounds(620,250,300,75);

        b2_B_price_input = new JTextField();
        b2_B_price_input.setForeground(new Color(0xFF426A6C, true));
        b2_B_price_input.setFont(new Font("Calibri",Font.BOLD,20));
        b2_B_price_input.setBounds(930,250,300,75);

        b2_C_price = new JLabel("ENTER B2C PRICE");
        b2_C_price.setForeground(new Color(0xFF426A6C, true));
        b2_C_price.setFont(new Font("Calibri",Font.BOLD,20));
        b2_C_price.setBounds(0,350,300,75);

        b2_C_price_input = new JTextField();
        b2_C_price_input.setForeground(new Color(0xFF426A6C, true));
        b2_C_price_input.setFont(new Font("Calibri",Font.BOLD,20));
        b2_C_price_input.setBounds(310,350,300,75);


        go_back = new JButton("GO BACK");
        go_back.setForeground(new Color(0xFFFFFFFF, true));
        go_back.setBackground(new Color(0xFF426A6C, true));
        go_back.setFont(new Font("Calibri",Font.BOLD,25));
        go_back.setBounds(250,450,400,75);

        submit = new JButton("SUBMIT");
        submit.setForeground(new Color(0xFFFFFFFF, true));
        submit.setBackground(new Color(0xFF426A6C, true));
        submit.setFont(new Font("Calibri",Font.BOLD,25));
        submit.setBounds(750,450,400,75);

        MyActionListener act = new MyActionListener();
        submit.addActionListener(act);
        go_back.addActionListener(act);

        north.add(labelHeading);
        center.add(drug_id); center.add(drug_id_input);
        center.add(name); center.add(drug_name_input);
        center.add(manufacture_date); center.add(manufacture_date_input);
        center.add(expiry_date); center.add(expiry_date_input);
        center.add(manufactured_price); center.add(manufactured_price_input);
        center.add(b2_B_price); center.add(b2_B_price_input);
        center.add(b2_C_price); center.add(b2_C_price_input);
        center.add(submit); center.add(go_back);

        setVisible(true);
    }

    class MyActionListener  implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("SUBMIT")) {

                // BACKEND
                String drugName = drug_name_input.getText();
                int drugId = Integer.parseInt(drug_id_input.getText());
                String manufactured_date = manufacture_date_input.getText();
                String expiry_date = expiry_date_input.getText();
                int manufacturer_company_id = 0;
                String manufacturer_company_name = "";
                int drug_manufactured_price = Integer.parseInt(manufactured_price_input.getText());
                int drug_b2b_price = Integer.parseInt(b2_B_price_input.getText());
                int drug_b2c_price = Integer.parseInt(b2_C_price_input.getText());
                int customerID = 0;


                ConnectionDB connectionDB = new ConnectionDB();
                try {
                    boolean check = true;
                    ResultSet query  = connectionDB.statement.executeQuery("SELECT drug_id FROM drug");
                    while (query.next()){
                        if (query.getInt(1) == drugId) {
                            check = false;
                        }
                    }
                    if (check) {

                        query  = connectionDB.statement.executeQuery("SELECT * FROM company where company_id='"+companyId+"'");
                        while (query.next()){
                            manufacturer_company_name = query.getString(2);
                        }
                        query  = connectionDB.statement.executeQuery("SELECT ssn FROM NAME where fname='"+userNameAccessed+"'");
                        while (query.next()){
                            customerID = query.getInt(1);
                        }

                        PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO company_drug_details VALUES(?,?,?,?,?,?,?,?,?)");
                        stmt.setInt(1,manufacturer_company_id);
                        stmt.setInt(2,drugId);
                        stmt.setString(3,drugName);
                        stmt.setString(4,expiry_date);
                        stmt.setString(5,manufactured_date);
                        stmt.setInt(6,drug_manufactured_price);
                        stmt.setInt(7,drug_b2b_price);
                        stmt.setInt(8,drug_b2c_price);
                        stmt.setInt(9,customerID);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO drug VALUES(?,?)");
                        stmt.setInt(1,drugId);
                        stmt.setString(2,drugName);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO drug_dates VALUES(?,?,?)");
                        stmt.setInt(1,drugId);
                        stmt.setString(2,manufactured_date);
                        stmt.setString(3,expiry_date);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO drug_manufacter_details VALUES(?,?,?)");
                        stmt.setInt(1,drugId);
                        stmt.setInt(2,manufacturer_company_id);
                        stmt.setString(3,manufacturer_company_name);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO drug_price VALUES(?,?,?,?)");
                        stmt.setInt(1,drugId);
                        stmt.setInt(2,drug_manufactured_price);
                        stmt.setInt(3,drug_b2b_price);
                        stmt.setInt(4,drug_b2c_price);
                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(new JFrame(), "Drug Added Successfully");

                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Drug Already Exists");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new ManageCompany(userNameAccessed,companyId);
            }
        }
    }
}