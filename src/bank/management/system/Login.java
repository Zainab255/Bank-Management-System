package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
    setTitle("Bank Management System");
    setLayout(null);

    // ATM Machine Icon
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo1.jpeg"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(50, 10, 100, 100);
    add(label);

    // Welcome Text
    JLabel text = new JLabel("Welcome to ATM");
    text.setFont(new Font("Osward", Font.BOLD, 30));
    text.setForeground(new Color(34, 45, 65));
    text.setBounds(200, 30, 400, 50);
    add(text);

    // Card Number Label
    JLabel cardno = new JLabel("Card No:");
    cardno.setFont(new Font("Raleway", Font.BOLD, 24));
    cardno.setForeground(new Color(58, 63, 85));
    cardno.setBounds(120, 150, 150, 30);
    add(cardno);

    // Card Number Input
    cardTextField = new JTextField();
    cardTextField.setFont(new Font("Arial", Font.PLAIN, 18));
    cardTextField.setBounds(300, 150, 250, 35);
    cardTextField.setBorder(BorderFactory.createEmptyBorder());
    cardTextField.setBackground(new Color(245, 245, 245));
    add(cardTextField);

    // PIN Label
    JLabel pin = new JLabel("PIN:");
    pin.setFont(new Font("Raleway", Font.BOLD, 24));
    pin.setForeground(new Color(58, 63, 85));
    pin.setBounds(120, 220, 150, 30);
    add(pin);

    // PIN Input
    pinTextField = new JPasswordField();
    pinTextField.setFont(new Font("Arial", Font.PLAIN, 18));
    pinTextField.setBounds(300, 220, 250, 35);
    pinTextField.setBorder(BorderFactory.createEmptyBorder());
    pinTextField.setBackground(new Color(245, 245, 245));
    add(pinTextField);

    // Login Button
    login = new JButton("Login");
    login.setBounds(300, 300, 100, 40);
    login.setBackground(new Color(34, 139, 230));
    login.setForeground(Color.WHITE);
    login.setFont(new Font("Arial", Font.BOLD, 16));
    login.setFocusPainted(false);
    login.setBorder(BorderFactory.createEmptyBorder());
    login.addActionListener(this);
    add(login);

    // Clear Button
    clear = new JButton("Clear");
    clear.setBounds(430, 300, 100, 40);
    clear.setBackground(new Color(255, 69, 58));
    clear.setForeground(Color.WHITE);
    clear.setFont(new Font("Arial", Font.BOLD, 16));
    clear.setFocusPainted(false);
    clear.setBorder(BorderFactory.createEmptyBorder());
    clear.addActionListener(this);
    add(clear);

    // Signup Button
    signup = new JButton("Sign Up");
    signup.setBounds(300, 350, 230, 40);
    signup.setBackground(new Color(39, 174, 96));
    signup.setForeground(Color.WHITE);
    signup.setFont(new Font("Arial", Font.BOLD, 16));
    signup.setFocusPainted(false);
    signup.setBorder(BorderFactory.createEmptyBorder());
    signup.addActionListener(this);
    add(signup);

    // Frame Settings
    getContentPane().setBackground(Color.WHITE);
    setSize(700, 500);
    setVisible(true);
    setLocation(350, 200);
}


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "' ";
            try {
               ResultSet rs = conn.s.executeQuery(query);
               if (rs.next()){
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
               }
               else {
                   JOptionPane.showMessageDialog(null, "incorrect card number and pin");
               }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signup) {
            // Signup logic
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
