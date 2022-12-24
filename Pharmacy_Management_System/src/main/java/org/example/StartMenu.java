package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartMenu extends JFrame {
    JButton employee, customer, distributor, doctor;
    JPanel panel1,panel2,panel3;
    JLabel label;
    StartMenu(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy Management System");
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        Color primary = new Color(66, 106, 108);

        setLayout(new BorderLayout());
        panel2 = new JPanel();
        label = new JLabel("WELCOME IN PHARMACY MANAGEMENT SYSTEM!");
        label.setForeground(primary);
        label.setFont(new Font("Serif",Font.PLAIN,50));
        panel2.add(label);
        getContentPane().add(panel2).setBackground(Color.WHITE);
        add(panel2,BorderLayout.NORTH);

        panel1 = new JPanel();
        employee = new JButton("EMPLOYEE");
        employee.setForeground(new Color(0xFFFAF9F4, true));
        employee.setBackground(primary);
        employee.setFont(new Font("Calibri",Font.BOLD,25));

        customer = new JButton("CUSTOMER");
        customer.setForeground(new Color(0xFFFAF9F4, true));
        customer.setBackground(primary);
        customer.setFont(new Font("Calibri",Font.BOLD,25));

        doctor = new JButton("DOCTOR");
        doctor.setForeground(new Color(0xFFFAF9F4, true));
        doctor.setBackground(primary);
        doctor.setFont(new Font("Calibri",Font.BOLD,25));

        distributor = new JButton("DISTRIBUTOR");
        distributor.setForeground(new Color(0xFFFAF9F4, true));
        distributor.setBackground(primary);
        distributor.setFont(new Font("Calibri",Font.BOLD,25));

        panel1.add(employee);panel1.add(customer);panel1.add(doctor);panel1.add(distributor);
        getContentPane().add(panel1).setBackground(Color.WHITE);
        add(panel1,BorderLayout.SOUTH);

        panel3 = new JPanel();
        ImageIcon myPicture = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Pharmacy_Management_System\\src\\main\\java\\org\\images\\confused_director.gif");
        JLabel picLabel = new JLabel(myPicture);
        panel3.add(picLabel);
        add(panel3,BorderLayout.CENTER);
        getContentPane().add(panel3).setBackground(Color.WHITE);

        MyActionListener myActionListener = new MyActionListener();
        employee.addActionListener(myActionListener);
        customer.addActionListener(myActionListener);
        doctor.addActionListener(myActionListener);
        distributor.addActionListener(myActionListener);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("DOCTOR")){
                dispose();
                new CheckOccurance();
            }else if (e.getActionCommand().equals("DISTRIBUTOR")){
                dispose();
                new CheckOccurance();
            }else if (e.getActionCommand().equals("EMPLOYEE")){
                dispose();
                new CheckOccurance();
            }else if (e.getActionCommand().equals("CUSTOMER")){
                dispose();
                new CheckOccurance();
            }
        }
    }
}
