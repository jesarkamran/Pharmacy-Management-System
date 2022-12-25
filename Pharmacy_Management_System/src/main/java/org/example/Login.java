package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame {
    JTextField emailInput;
    JPasswordField passwordNameInput;
    String userTypeAccessed = "";

    Login(String userType) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        userTypeAccessed = userType;
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
                User user = null;

                String userEmail = emailInput.getText();
                String userPassword = passwordNameInput.getText();

                Connection conn = null;
                Statement stmt = null;
                try {
                    conn = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:orcl", "finalProject", "db");
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Person WHERE email='"+userEmail+"'");

                    while (rs.next()) {
                           String email = rs.getString("email");
                           String password = rs.getString("user_password");
                           if (userEmail.equals(email) && userPassword.equals(password)){
                               JOptionPane.showMessageDialog(new JFrame(), "Right Creditionals");
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
                new CheckOccurance(userTypeAccessed);
            }
        }
    }
}