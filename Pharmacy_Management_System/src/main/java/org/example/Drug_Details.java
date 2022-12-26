package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Drug_Details extends JFrame {
    JTextField  d_IdInput, price_idInput, manufacturer_idInput, item_detailsIDInput, item_manufactured_dateInput,
            manufacturer_comp_idInput, manufacturer_comp_nameInput, item_expiry_dateInput,
            price_manufacturedInput, b2b_priceInput, b2c_priceInput;
    String sellerNameAccessed = "";
    Drug_Details(String sellerName){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        sellerNameAccessed = sellerName;

        JLabel d_Id = new JLabel("ENTER DRUG ID");
        add(d_Id);
        d_IdInput = new JTextField();
        add(d_IdInput);
        JLabel price_id = new JLabel("ENTER PRICE ID");
        add(price_id);
        price_idInput = new JTextField();
        add(price_idInput);

        JLabel manufacturer_id = new JLabel("ENTER MANUFACTURER ID");
        add(manufacturer_id);
        manufacturer_idInput = new JTextField();
        add(manufacturer_idInput);

        JLabel item_detailsID = new JLabel("ENTER ITEM DETAILS ID");
        add(item_detailsID);
        item_detailsIDInput = new JTextField();
        add(item_detailsIDInput);

        JLabel manufacturer_comp_id = new JLabel("ENTER MANUFACTURING COMPANY ID");
        add(manufacturer_comp_id);
        manufacturer_comp_idInput = new JTextField();
        add(manufacturer_comp_idInput);

        JLabel manufacturer_comp_name = new JLabel("ENTER MANUFACTURING COMPANY NAME");
        add(manufacturer_comp_name);
        manufacturer_comp_nameInput = new JTextField();
        add(manufacturer_comp_nameInput);

        JLabel item_manufactured_date = new JLabel("ENTER MANUFACTURED DATE");
        add(item_manufactured_date);
        item_manufactured_dateInput = new JTextField();
        add(item_manufactured_dateInput);

        JLabel item_expiry_date = new JLabel("ENTER EXPIRY DATE");
        add(item_expiry_date);
        item_expiry_dateInput = new JTextField();
        add(item_expiry_dateInput);

        JLabel price_manufactured = new JLabel("ENTER MANUFACTURING PRICE");
        add(price_manufactured);
        price_manufacturedInput = new JTextField();
        add(price_manufacturedInput);

        JLabel b2b_price = new JLabel("ENTER B2B PRICE");
        add(b2b_price);
        b2b_priceInput = new JTextField();
        add(b2b_priceInput);

        JLabel b2c_price = new JLabel("ENTER B2C PRICE");
        add(b2c_price);
        b2c_priceInput = new JTextField();
        add(b2c_priceInput);

        JLabel empty1 = new JLabel(""),
                empty2 = new JLabel(""),
                empty3 = new JLabel("");
        add(empty1); add(empty2); add(empty3);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setForeground(new Color(0xFFFFFFFF, true));
        submitButton.setBackground(new Color(0xFF426A6C, true));
        submitButton.setFont(new Font("Calibri",Font.BOLD,25));
        submitButton.setSize(300,50);

        JButton homeButton = new JButton("GO BACK");
        homeButton.setForeground(new Color(0xFFFFFFFF, true));
        homeButton.setBackground(new Color(0xFF426A6C, true));
        homeButton.setFont(new Font("Calibri",Font.BOLD,25));
        homeButton.setSize(300,50);
        add(submitButton);
        add(homeButton);


        setLayout(new GridLayout(8,2,20,20));

        MyActionListener myActionListener = new MyActionListener();
        submitButton.addActionListener(myActionListener);
        homeButton.addActionListener(myActionListener);

        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("SUBMIT")) {

                // DRUG
                int drug_id = Integer.parseInt(d_IdInput.getText());
                int drug_price = Integer.parseInt(price_idInput.getText());
                int item_details_id = Integer.parseInt(item_detailsIDInput.getText());
                int manufacturer_id = Integer.parseInt(manufacturer_comp_idInput.getText());

                // ITEMS DETAILS
                String manufactered_date = item_manufactured_dateInput.getText();
                String expiry_date = item_expiry_dateInput.getText();

                // MANFACTURER DETAILS
                String manufactererCompanyId = manufacturer_comp_idInput.getText();
                String manfactererCompanyName = manufacturer_comp_nameInput.getText();

                // PRICE DETAILS
                int manfacterer_price = Integer.parseInt(price_manufacturedInput.getText());
                int b2bPrice = Integer.parseInt(b2b_priceInput.getText());
                int b2cPrice = Integer.parseInt(b2c_priceInput.getText());


                ConnectionDB connectionDB = new ConnectionDB();
                try {
                    boolean check = true;
                    ResultSet query  = connectionDB.statement.executeQuery("SELECT drug_id FROM DRUG");
                    while (query.next()){
                        if (query.getInt(1) == drug_id) {
                            check = false;
                        }
                    }
                    if (check) {
                        PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO ITEM_DETAILS VALUES(?,?,?)");
                        stmt.setInt(1,item_details_id);
                        stmt.setString(2,manufactered_date);
                        stmt.setString(3,expiry_date);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO manufactorer_details VALUES(?,?,?)");
                        stmt.setInt(1,manufacturer_id);
                        stmt.setString(2,manufactererCompanyId);
                        stmt.setString(3,manfactererCompanyName);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO price_details VALUES(?,?,?,?)");
                        stmt.setInt(1,drug_price);
                        stmt.setInt(2,manfacterer_price);
                        stmt.setInt(3,b2bPrice);
                        stmt.setInt(4,b2cPrice);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO drug VALUES(?,?,?,?)");
                        stmt.setInt(1,drug_id);
                        stmt.setInt(2,drug_price);
                        stmt.setInt(3,item_details_id);
                        stmt.setInt(4,manufacturer_id);
                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(new JFrame(), "DRUG ADDED SUCCESSFULLY");
                        dispose();
                        new SellerMenu(sellerNameAccessed);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "DRUG Already Exists");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                new SellerMenu(sellerNameAccessed);
            }
        }
    }
}