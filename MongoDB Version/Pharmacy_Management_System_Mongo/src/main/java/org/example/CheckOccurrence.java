package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOccurrence extends JFrame {
    JButton newUser,oldUser,goBack;
    JPanel panel1,panel2,panel3;
    JLabel label;
    String userTypeForSignUp = "";
    CheckOccurrence(String userType){
        userTypeForSignUp = userType;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        panel2 = new JPanel();
        label = new JLabel("HEY THERE!");
        label.setForeground(new Color(66, 106, 108));
        label.setFont(new Font("Serif",Font.PLAIN,50));
        panel2.add(label);

        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,BorderLayout.NORTH);

        panel1 = new JPanel();
        newUser = new JButton("NEW USER?");
        newUser.setForeground(new Color(0xFFFAF9F4, true));
        newUser.setBackground(new Color(66, 106, 108));
        newUser.setFont(new Font("Calibri",Font.BOLD,25));

        oldUser = new JButton("ALREADY A USER");
        oldUser.setForeground(new Color(0xFFFAF9F4, true));
        oldUser.setBackground(new Color(66, 106, 108));
        oldUser.setFont(new Font("Calibri",Font.BOLD,25));

        goBack = new JButton("GO BACK");
        goBack.setForeground(new Color(0xFFFAF9F4, true));
        goBack.setBackground(new Color(66, 106, 108));
        goBack.setFont(new Font("Calibri",Font.BOLD,25));
        add(goBack);

        panel1.add(newUser);panel1.add(oldUser);panel1.add(goBack);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,BorderLayout.SOUTH);

        panel3 = new JPanel();
        ImageIcon myPicture = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\confused_3.gif");
        JLabel picLabel = new JLabel(myPicture);
        panel3.add(picLabel);
        getContentPane().add(panel3).setBackground(Color.WHITE);
        add(panel3,BorderLayout.CENTER);

        MyActionListener myActionListener = new MyActionListener();
        newUser.addActionListener(myActionListener);
        oldUser.addActionListener(myActionListener);
        goBack.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("NEW USER?")){
                dispose();
                new SignUp(userTypeForSignUp);
            }else if (e.getActionCommand().equals("ALREADY A USER")){
                dispose();
                new Login(userTypeForSignUp);
            } else if (e.getActionCommand().equals("GO BACK")) {
                dispose();
                if (userTypeForSignUp.equals("Seller") || userTypeForSignUp.equals("Supplier")){
                    new EmployeeChild();
                }else {
                    new StartMenu();
                }
            }
        }
    }
}
