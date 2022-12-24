package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login extends JFrame {
    JTextField emailInput;
    JPasswordField passwordNameInput;

    Login() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        Color primary = new Color(66, 106, 108);
        Color secondary = new Color(0xFFFAF9F4, true);

        JLabel email = new JLabel("EMAIL:");
        email.setFont(new Font("Calibri",Font.BOLD,30));
        add(email);
        emailInput = new JTextField();
        add(emailInput);

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
        loginButton.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        setLayout(new GridLayout(3, 2, 0, 200));
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Login Now")) {

            }else if (e.getActionCommand().equals("Go Back")){
                dispose();
                new CheckOccurance();
            }
        }
    }
}