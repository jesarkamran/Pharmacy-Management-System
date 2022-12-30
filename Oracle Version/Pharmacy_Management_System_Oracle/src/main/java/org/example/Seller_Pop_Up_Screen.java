package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Seller_Pop_Up_Screen extends JFrame {
    JLabel drug_name;
    JButton submit;
    JTextField drug_name_input;
    String operationTypeAccessed = "";
    Seller_Pop_Up_Screen(String title, String buttonType, String operationType){
        JFrame dealSupplierInput = new JFrame();
        dealSupplierInput.setSize(400,400);
        dealSupplierInput.setTitle(title);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());

        dealSupplierInput.setLayout(new BorderLayout());
        dealSupplierInput.setBackground(Color.WHITE);

        operationTypeAccessed = operationType;

        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        north.setBackground(Color.WHITE);
        south.setBackground(Color.WHITE);
        center.setBackground(Color.WHITE);
        east.setBackground(Color.WHITE);
        west.setBackground(Color.WHITE);
        center.setLayout(null);

        dealSupplierInput.add(center, BorderLayout.CENTER);
        dealSupplierInput.add(north, BorderLayout.NORTH);
        dealSupplierInput.add(south, BorderLayout.SOUTH);
        dealSupplierInput.add(east, BorderLayout.EAST);
        dealSupplierInput.add(west, BorderLayout.WEST);

        drug_name = new JLabel("ENTER DRUG NAME");
        drug_name_input = new JTextField();
        MyActionListener act = new MyActionListener();
        submit = new JButton(buttonType);
        submit.addActionListener(act);

        drug_name.setForeground(new Color(0xFF070707, true));
        drug_name.setFont(new Font("Calibri",Font.BOLD,18));
        drug_name.setBounds(50,50,200,40);

        drug_name_input.setForeground(new Color(0xFF426A6C, true));
        drug_name_input.setFont(new Font("Calibri",Font.BOLD,18));
        drug_name_input.setBounds(50,100,200,40);

        submit.setForeground(new Color(0xFFFFFFFF, true));
        submit.setBackground(new Color(0xFF426A6C, true));
        submit.setFont(new Font("Calibri",Font.BOLD,18));
        submit.setBounds(50,150,200,40);

        center.add(drug_name);
        center.add(drug_name_input);
        center.add(submit);
        dealSupplierInput.setVisible(true);
    }
    public  int generateRandom(){
        Random rand = new Random();
        // Generate a random integer between 0 and 99999999 (inclusive)
        int randomNumber = rand.nextInt(100000000);
        return randomNumber;
    }
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String drugName = drug_name_input.getText();
            int drugId = 0;
            String manufactured_date = "";
            String expiry_date = "";
            int manufacturer_company_id = 0;
            String manufacturer_company_name = "";
            int drug_manufactured_price = 0;
            int drug_b2b_price = 0;
            int drug_b2c_price = 0;

            ConnectionDB connectionDB = new ConnectionDB();
            try {
                boolean check = false;
                ResultSet query  = connectionDB.statement.executeQuery("SELECT drug_name FROM drug");
                while (query.next()){
                    if (query.getString("drug_name").equals(drugName)) {
                        check = true;
                    }
                }

                if (check) {

                    query  = connectionDB.statement.executeQuery("SELECT drug_id FROM drug where drug_name='"+drugName+"'");
                    while (query.next()){
                        drugId = query.getInt(1);
                    }

                    query  = connectionDB.statement.executeQuery("SELECT * FROM drug_dates where drug_id='"+drugId+"'");
                    while (query.next()){
                        manufactured_date = query.getString(2);
                        expiry_date = query.getString(3);
                    }

                    query  = connectionDB.statement.executeQuery("SELECT * FROM drug_manufacter_details where drug_id='"+drugId+"'");
                    while (query.next()){
                        manufacturer_company_id = query.getInt(2);
                        manufacturer_company_name = query.getString(3);
                    }

                    query  = connectionDB.statement.executeQuery("SELECT * FROM drug_price where drug_id='"+drugId+"'");
                    while (query.next()){
                        drug_manufactured_price = query.getInt(2);
                        drug_b2b_price = query.getInt(3);
                        drug_b2c_price = query.getInt(4);
                    }

                    switch (operationTypeAccessed) {

                        case "buy":

                            // BACKEND LOGIC
                            int seller_drug_details_id = generateRandom();

                            PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO seller_drug_details VALUES(?,?,?,?,?,?,?,?,?,?)");
                            stmt.setInt(1, seller_drug_details_id);
                            stmt.setInt(2, drugId);
                            stmt.setString(3, drugName);
                            stmt.setString(4, expiry_date);
                            stmt.setString(5, manufactured_date);
                            stmt.setInt(6, drug_manufactured_price);
                            stmt.setInt(7, drug_b2b_price);
                            stmt.setInt(8, drug_b2c_price);
                            stmt.setInt(9, manufacturer_company_id);
                            stmt.setString(10, manufacturer_company_name);
                            stmt.executeUpdate();

                            JOptionPane.showMessageDialog(new JFrame(), "Drug Bought!!");
                            break;

                        case "delete":

                            break;

                        case "search":

                            // BACKEND LOGIC
                            String outputData = "Here's the search data from Drug ID:"+drugId+"\n \n \n \n "+
                                    "Drug Name: "+drugName+"\n"+
                                    "Drug Expiry Date: "+expiry_date+"\n"+
                                    "Drug Manufacture Date: "+manufactured_date+"\n"+
                                    "Price: "+drug_b2b_price+"\n"+
                                    "Company Name: "+manufacturer_company_name+
                                    "\n \n ";
                            JOptionPane.showMessageDialog(new JFrame(),outputData);

                            break;
                    }

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Drug not found!!");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

