package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Company_Pop_Up_Screen extends JFrame {
    JLabel drug_name;
    JButton submit;
    JTextField drug_name_input;
    String operationTypeAccessed = "";
    Company_Pop_Up_Screen(String title, String buttonType, String operationType){
        JFrame dealSupplierInput = new JFrame();
        dealSupplierInput.setSize(400,400);
        dealSupplierInput.setTitle(title);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
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

        center.add(drug_name);center.add(drug_name_input);center.add(submit);
        dealSupplierInput.setVisible(true);
    }
    public  int generateRandom(){
        Random rand = new Random();
        return rand.nextInt(100000000);
    }
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String drugName = drug_name_input.getText();

            ConnectionDB connectionDB = new ConnectionDB();
            try {
                boolean check = false;
                ResultSet query  = connectionDB.statement.executeQuery("SELECT drug_name FROM company_drug_details");
                while (query.next()){
                    if (query.getString("drug_name").equals(drugName)) {
                        check = true;
                    }
                }
                if (check) {

                    // Company Drug Details Entity Attributes
                    drugName = drug_name_input.getText();
                    int drugId = 0;
                    String manufactured_date = "";
                    String expiry_date = "";
                    int manufacturer_company_id = 0;
                    String manufacturer_company_name = "";
                    int drug_manufactured_price = 0;
                    int drug_b2b_price = 0;
                    int drug_b2c_price = 0;
                    int supplier_drug_details_id = 0;

                    query  = connectionDB.statement.executeQuery("SELECT * FROM company_drug_details where drug_name='"+drugName+"'");
                    while (query.next()){
                        drugId = query.getInt(2);
                        // drug name
                        expiry_date = query.getString(4);
                        manufactured_date = query.getString(5);
                        drug_manufactured_price = query.getInt(6);
                        drug_b2b_price = query.getInt(7);
                        drug_b2c_price = query.getInt(8);
                        manufacturer_company_id = query.getInt(9);
                        manufacturer_company_name = query.getString(10);
                    }

                    query  = connectionDB.statement.executeQuery("SELECT * FROM distributor_drug_details where drug_name='"+drugName+"'");
                    while (query.next()){
                        manufacturer_company_id = query.getInt(9);
                        manufacturer_company_name = query.getString(10);
                    }

                    switch (operationTypeAccessed) {

                        case "sell_to_supplier":

                            // BACKEND LOGIC
                            supplier_drug_details_id = generateRandom();

                            PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO supplier_drug_details VALUES(?,?,?,?,?,?,?,?,?,?)");
                            stmt.setInt(1, supplier_drug_details_id);
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

                            break;

                        case "delete":
                            // BACKEND LOGIC
                            try {
                                stmt = connectionDB.connection.prepareStatement("DELETE FROM company_drug_details where drug_name='"+drugName+"'");
                                stmt.executeUpdate();
                                JOptionPane.showMessageDialog(new JFrame(),"Drug Removed Successfully");
                            }catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                            break;

                        case "search":
                            // BACKEND LOGIC
                            String outputData = "Here's the search data from Drug Name:"+drugName+"\n \n"+
                                    "Drug Name: "+drugName+"\n"+
                                    "Drug Expiry Date: "+expiry_date+"\n"+
                                    "Drug Manufacture Date: "+manufactured_date+"\n"+
                                    "Manufacture Price: "+drug_manufactured_price+"\n"+
                                    "B2B Price: "+drug_b2b_price+"\n"+
                                    "B2C Price: "+drug_b2c_price+"\n"+
                                    "Company ID: "+manufacturer_company_id+"\n"+
                                    "Company Name: "+manufacturer_company_name+
                                    "\n";
                            JOptionPane.showMessageDialog(new JFrame(),outputData);

                            break;
                    }

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Drug doesn't Exists");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
