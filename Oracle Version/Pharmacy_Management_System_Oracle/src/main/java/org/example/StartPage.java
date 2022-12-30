package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame {
    JLabel labelHeading = new JLabel("Pharmacy Management System");
    JLabel displayImage;
    JButton getStarted;
    StartPage()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH); setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); setTitle("Pharmacy Management System");
        setBackground(Color.WHITE);
        ImageIcon imageIcon = new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\officialLogo.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        labelHeading.setForeground(new Color(66, 106, 108));
        labelHeading.setFont(new Font("Calibri", Font.BOLD,50));

        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        north.setBackground(new Color(166, 225, 225));
        south.setBackground(new Color(166, 225, 225));
        center.setBackground(new Color(166, 225, 225));
        east.setBackground(new Color(166, 225, 225));
        west.setBackground(new Color(166, 225, 225));

        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        try {
            ImageIcon img = new ImageIcon(new ImageIcon("D:\\4th Semester\\DBMS\\DB Project\\Pharmacy-Management-System\\Oracle Version\\Pharmacy_Management_System_Oracle\\src\\main\\java\\org\\images\\startPage.jpeg").getImage()
                    .getScaledInstance(screenSize.width, 700, Image.SCALE_AREA_AVERAGING));
            displayImage =  new JLabel(img);
        }catch (Exception e)
        {
            System.out.println("Problem Loading Image");
        }

        getStarted = new JButton("Get Started");
        getStarted.setFont(new Font("Calibiri", Font.BOLD,15));
        getStarted.setForeground(new Color(237, 239, 239));
        getStarted.setBackground(new Color(66, 106, 108));
        getStarted.setBounds(600, 350, 0, 0);
        getStarted.setFont(new Font("Calibri",Font.BOLD,25));

        MyActionListener myActionListener = new MyActionListener();
        getStarted.addActionListener(myActionListener);

        north.add(labelHeading);
        center.add(getStarted);
        center.add(displayImage);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Get Started")) {
                dispose();
                new StartMenu();
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "Error Occurred");
            }
        }
    }
}