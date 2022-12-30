package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignUp extends JFrame {
    JTextField ssnInput, firstNameInput, middleNameInput, lastNameInput, phoneInput,
            b_dateInput, genderInput, emailInput, passwordInput, confirmPasswordInput,
            zipCodeInput, stateNameInput, addressInput;
    String userTypeAccessed = "";

    SignUp(String userType){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        userTypeAccessed = userType;

        JLabel ssn = new JLabel("ENTER YOUR SSN");
        add(ssn);
        ssnInput = new JTextField();
        add(ssnInput);

        JLabel firstName = new JLabel("ENTER YOUR FIRST NAME");
        add(firstName);
        firstNameInput = new JTextField();
        add(firstNameInput);

        JLabel middleName = new JLabel("ENTER YOUR MIDDLE NAME");
        add(middleName);
        middleNameInput = new JTextField();
        add(middleNameInput);

        JLabel lastName = new JLabel("ENTER YOUR LAST NAME");
        add(lastName);
        lastNameInput = new JTextField();
        add(lastNameInput);

        JLabel b_date = new JLabel("ENTER YOUR BIRTH DATE");
        add(b_date);
        b_dateInput = new JTextField();
        add(b_dateInput);

        JLabel gender = new JLabel("ENTER YOUR GENDER");
        add(gender);
        genderInput = new JTextField();
        add(genderInput);

        JLabel phone = new JLabel("ENTER YOUR PHONE");
        add(phone);
        phoneInput = new JTextField();
        add(phoneInput);

        JLabel email = new JLabel("ENTER YOUR EMAIL");
        add(email);
        emailInput = new JTextField();
        add(emailInput);

        JLabel address = new JLabel("ENTER YOUR ADDRESS");
        add(address);
        addressInput = new JTextField();
        add(addressInput);

        JLabel stateName = new JLabel("ENTER YOUR STATE NAME");
        add(stateName);
        stateNameInput = new JTextField();
        add(stateNameInput);

        JLabel zipCode = new JLabel("ENTER YOUR AREA ZIP CODE");
        add(zipCode);
        zipCodeInput = new JTextField();
        add(zipCodeInput);

        JLabel password = new JLabel("ENTER YOUR PASSWORD");
        add(password);
        passwordInput = new JTextField();
        add(passwordInput);

        JLabel confrimPassword = new JLabel("CONFIRM YOUR PASSWORD");
        add(confrimPassword);
        confirmPasswordInput = new JTextField();
        add(confirmPasswordInput);

        JLabel empty3 = new JLabel(""),
                empty2 = new JLabel(""),
                empty1 = new JLabel("");
        add(empty3);add(empty2);add(empty1);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setForeground(new Color(0xFFA6E1E1, true));
        submitButton.setBackground(new Color(0xFF426A6C, true));
        submitButton.setFont(new Font("Calibri",Font.BOLD,25));
        submitButton.setSize(300,50);

        JButton homeButton = new JButton("HOME");
        homeButton.setForeground(new Color(0xFFA6E1E1, true));
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
            if (e.getActionCommand().equals("SUBMIT")){

                int ssn = Integer.parseInt(ssnInput.getText());
                String bdate = b_dateInput.getText();
                String email = emailInput.getText();
                String password = passwordInput.getText();
                String phone = phoneInput.getText();
                String sex = genderInput.getText();

                String firstName = firstNameInput.getText();
                String midName = middleNameInput.getText();
                String lastName = lastNameInput.getText();

                String address = addressInput.getText();
                String stateName = stateNameInput.getText();
                int zipCode = Integer.parseInt(zipCodeInput.getText());

                ConnectionDB connectionDB = new ConnectionDB();




                try {
                    boolean check = true;
                    ResultSet query  = connectionDB.statement.executeQuery("SELECT ssn FROM PERSON");
                    while (query.next()){
                        if (query.getInt(1) == ssn) {
                            check = false;
                        }
                    }
                    if (check) {
                        PreparedStatement stmt = connectionDB.connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?,?,?)");
                        stmt.setInt(1,ssn);
                        stmt.setString(2,bdate);
                        stmt.setString(3,email);
                        stmt.setString(4,password);
                        stmt.setString(5,phone);
                        stmt.setString(6,sex);
                        stmt.setString(7,userTypeAccessed);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO NAME VALUES(?,?,?,?)");
                        stmt.setInt(1,ssn);
                        stmt.setString(2,firstName);
                        stmt.setString(3,midName);
                        stmt.setString(4,lastName);
                        stmt.executeUpdate();

                        stmt = connectionDB.connection.prepareStatement("INSERT INTO ADDRESS VALUES(?,?,?,?)");
                        stmt.setInt(1,ssn);
                        stmt.setString(2,address);
                        stmt.setString(3,stateName);
                        stmt.setInt(4,zipCode);
                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(new JFrame(), "Signed Up Successfully");
                        dispose();
                        new CheckOccurrence(userTypeAccessed);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "User Already Exists");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (e.getActionCommand().equals("HOME")){
                dispose();
                new StartMenu();
            }
        }
    }
}