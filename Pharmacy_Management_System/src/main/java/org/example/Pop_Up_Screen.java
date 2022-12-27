package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pop_Up_Screen extends JFrame {
    JLabel drug_name;
    JButton submit;
    JTextField drug_name_input;
    String operationTypeAccessed = "";
    Pop_Up_Screen(String title,String buttonType,String operationType){
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

        center.add(drug_name);
        center.add(drug_name_input);
        center.add(submit);
        dealSupplierInput.setVisible(true);
    }
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ENTER DRUG NAME")) {
                JOptionPane.showMessageDialog(new JFrame(), "Clicked");
            }
            else if (e.getActionCommand().equals("DELETE DRUGS")) {
                JOptionPane.showMessageDialog(new JFrame(), "Clicked");
            }
        }
    }
}
