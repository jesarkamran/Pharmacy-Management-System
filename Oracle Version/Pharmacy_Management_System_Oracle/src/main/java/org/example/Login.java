package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame {
    JTextField ssnInput;
    JPasswordField passwordNameInput;
    String userTypeAccessed = "";

    Login(String userType) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        userTypeAccessed = userType;
        Color primary = new Color(66, 106, 108);
        Color secondary = new Color(0xFFFAF9F4, true);

        JLabel ssn = new JLabel("SSN:");
        ssn.setFont(new Font("Calibri",Font.BOLD,30));
        add(ssn);
        ssnInput = new JTextField();
        add(ssnInput);

        JLabel password = new JLabel("PASSWORD:");
        password.setFont(new Font("Calibri",Font.BOLD,30));
        add(password);
        passwordNameInput = new JPasswordField();
        add(passwordNameInput);

        JButton loginButton = new JButton("Login Now");
        loginButton.setForeground(secondary);
        loginButton.setBackground(primary);
        loginButton.setFont(new Font("Calibri",Font.BOLD,25));
        add(loginButton);

        JButton goBack = new JButton("Go Back");
        goBack.setForeground(secondary);
        goBack.setBackground(primary);
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        MyActionListener myActionListener = new MyActionListener();
        MyActionListener myActionListener2 = new MyActionListener();
        loginButton.addActionListener(myActionListener2);
        goBack.addActionListener(myActionListener);
        setLayout(new GridLayout(3, 2, 0, 200));
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Login Now")) {

                int userSSN = Integer.parseInt(ssnInput.getText());
                String userPassword = passwordNameInput.getText();

                Connection conn = null;
                Statement stmt = null;
                try {
                    conn = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:orcl", "demo", "db");
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Person WHERE ssn='"+userSSN+"'");

                    while (rs.next()) {
                           int ssn = rs.getInt("ssn");
                           String password = rs.getString("user_password");

                           if (userSSN==ssn && userPassword.equals(password)){
                               String userName = "";
                               ResultSet rs2 = stmt.executeQuery("SELECT * FROM NAME WHERE ssn='"+userSSN+"'");
                               while (rs2.next()) {
                                   userName = rs2.getString("fname");
                               }

                               switch (userTypeAccessed) {
                                   case "Doctor" -> {
                                       dispose();
                                       new Doctor_Menu(userName);
                                   }
                                   case "Distributor" -> {
                                       dispose();
                                       new Distributor_Menu(userName);
                                   }
                                   case "Customer" -> {
                                       dispose();
                                       new Customer_Menu(userName);
                                   }
                                   case "Supplier" -> {
                                       dispose();
                                       new SupplierMenu(userName);
                                   }
                                   case "Seller" -> {
                                       dispose();
                                       new SellerMenu(userName);
                                   }
                                   case "Company Connector" -> {
                                       dispose();
                                       new Company_Connector(userName);
                                   }
                               }
                           } else {
                           JOptionPane.showMessageDialog(new JFrame(), "Invalid Creditionals");
                           }
                        conn.close();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }else if (e.getActionCommand().equals("Go Back")){
                dispose();
                new CheckOccurrence(userTypeAccessed);
            }
        }
    }
}