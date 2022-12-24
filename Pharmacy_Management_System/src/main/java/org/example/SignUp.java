package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {
    JTextField firstNameInput, middleNameInput, lastNameInput, phoneInput,
            b_dateInput, genderInput, emailInput, passwordInput, confirmPasswordInput,
            zipCodeInput, stateNameInput, cityNameInput, addressInput;

    SignUp(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

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

        JLabel cityName = new JLabel("ENTER YOUR CITY NAME");
        add(cityName);
        cityNameInput = new JTextField();
        add(cityNameInput);

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

        JLabel empty1 = new JLabel(""),
                empty2 = new JLabel(""),
                empty3 = new JLabel("");
        add(empty1);add(empty2);add(empty3);

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
                dispose();
//                Action to be performed
            }else if (e.getActionCommand().equals("HOME")){
                dispose();
                new StartMenu();
            }
        }
    }
}