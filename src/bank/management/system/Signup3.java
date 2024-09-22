package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton cancle, submit;
    String forms;

   Signup3(String forms) {
    this.forms = forms;
    setLayout(null);

    // Title
    JLabel l1 = new JLabel("Page 3: Account Details");
    l1.setFont(new Font("Raleway", Font.BOLD, 28));
    l1.setBounds(250, 30, 400, 40);
    add(l1);

    // Account Type Section
    JLabel type = new JLabel("Account Type:");
    type.setFont(new Font("Raleway", Font.BOLD, 22));
    type.setBounds(100, 100, 200, 30);
    add(type);

    r1 = new JRadioButton("Saving Account");
    r1.setFont(new Font("Raleway", Font.PLAIN, 18));
    r1.setBounds(100, 140, 200, 30);
    add(r1);

    r2 = new JRadioButton("Fixed Deposit Account");
    r2.setFont(new Font("Raleway", Font.PLAIN, 18));
    r2.setBounds(350, 140, 250, 30);
    add(r2);

    r3 = new JRadioButton("Current Account");
    r3.setFont(new Font("Raleway", Font.PLAIN, 18));
    r3.setBounds(100, 180, 200, 30);
    add(r3);

    r4 = new JRadioButton("Recurring Account");
    r4.setFont(new Font("Raleway", Font.PLAIN, 18));
    r4.setBounds(350, 180, 250, 30);
    add(r4);

    ButtonGroup groupaccount = new ButtonGroup();
    groupaccount.add(r1);
    groupaccount.add(r2);
    groupaccount.add(r3);
    groupaccount.add(r4);

    // Card Number Section
    JLabel card = new JLabel("Card Number");
    card.setFont(new Font("Raleway", Font.BOLD, 22));
    card.setBounds(100, 240, 200, 30);
    add(card);

    JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
    number.setFont(new Font("Raleway", Font.PLAIN, 18));
    number.setBounds(330, 240, 300, 30);
    add(number);

    JLabel carddetail = new JLabel("Your 16-digit card number");
    carddetail.setFont(new Font("Raleway", Font.ITALIC, 14));
    carddetail.setBounds(100, 270, 300, 20);
    add(carddetail);

    // PIN Section
    JLabel pin = new JLabel("PIN:");
    pin.setFont(new Font("Raleway", Font.BOLD, 22));
    pin.setBounds(100, 310, 200, 30);
    add(pin);

    JLabel pnumber = new JLabel("XXXX");
    pnumber.setFont(new Font("Raleway", Font.PLAIN, 18));
    pnumber.setBounds(330, 310, 300, 30);
    add(pnumber);

    JLabel pindetail = new JLabel("Your 4-digit PIN");
    pindetail.setFont(new Font("Raleway", Font.ITALIC, 14));
    pindetail.setBounds(100, 340, 300, 20);
    add(pindetail);

    // Services Section
    JLabel services = new JLabel("Services Required");
    services.setFont(new Font("Raleway", Font.BOLD, 22));
    services.setBounds(100, 400, 300, 30);
    add(services);

    // Checkboxes for Services
    c1 = new JCheckBox("ATM Card");
    c1.setBackground(Color.WHITE);
    c1.setFont(new Font("Raleway", Font.PLAIN, 16));
    c1.setBounds(100, 450, 200, 30);
    add(c1);

    c2 = new JCheckBox("Internet Banking");
    c2.setBackground(Color.WHITE);
    c2.setFont(new Font("Raleway", Font.PLAIN, 16));
    c2.setBounds(350, 450, 200, 30);
    add(c2);

    c3 = new JCheckBox("Mobile Banking");
    c3.setBackground(Color.WHITE);
    c3.setFont(new Font("Raleway", Font.PLAIN, 16));
    c3.setBounds(100, 490, 200, 30);
    add(c3);

    c4 = new JCheckBox("Email and SMS Alerts");
    c4.setBackground(Color.WHITE);
    c4.setFont(new Font("Raleway", Font.PLAIN, 16));
    c4.setBounds(350, 490, 200, 30);
    add(c4);

    c5 = new JCheckBox("Cheque Book");
    c5.setBackground(Color.WHITE);
    c5.setFont(new Font("Raleway", Font.PLAIN, 16));
    c5.setBounds(100, 530, 200, 30);
    add(c5);

    c6 = new JCheckBox("E-Statement");
    c6.setBackground(Color.WHITE);
    c6.setFont(new Font("Raleway", Font.PLAIN, 16));
    c6.setBounds(350, 530, 200, 30);
    add(c6);

    c7 = new JCheckBox("I hereby declare that the above details are correct.");
    c7.setBackground(Color.WHITE);
    c7.setFont(new Font("Raleway", Font.PLAIN, 14));
    c7.setBounds(100, 580, 500, 30);
    add(c7);

    // Submit and Cancel Buttons
    submit = new JButton("Submit");
    submit.setBackground(new Color(0, 123, 255));
    submit.setForeground(Color.WHITE);
    submit.setFont(new Font("Raleway", Font.BOLD, 16));
    submit.setBounds(250, 650, 120, 40);
    submit.setFocusPainted(false);
    submit.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 1, true));
    submit.addActionListener(this);
    add(submit);

    cancle = new JButton("Cancel");
    cancle.setBackground(new Color(220, 53, 69));
    cancle.setForeground(Color.WHITE);
    cancle.setFont(new Font("Raleway", Font.BOLD, 16));
    cancle.setBounds(420, 650, 120, 40);
    cancle.setFocusPainted(false);
    cancle.setBorder(BorderFactory.createLineBorder(new Color(220, 53, 69), 1, true));
    cancle.addActionListener(this);
    add(cancle);

    // Background color
    getContentPane().setBackground(Color.WHITE);
    setSize(850, 820);
    setLocation(350, 50);
    setVisible(true);
}


    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String accounttype = null;
        if (r1.isSelected()) {
            accounttype = "saving account";
        } else if (r2.isSelected()) {
            accounttype = "fixed deposit account";
        } else if (r3.isSelected()) {
            accounttype = "current account";
        } else if (r4.isSelected()) {
            accounttype = "recrring deposit account";
        }

        Random random = new Random();
        String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

        String facility = "";
        if (c1.isSelected()) {
            facility += "ATM Card";
        }
        if (c2.isSelected()) {
            facility += "Internet Banking";
        }
        if (c3.isSelected()) {
            facility += "Mobile Banking";
        }
        if (c4.isSelected()) {
            facility += "Email and SMS Alerts";
        }
        if (c5.isSelected()) {
            facility += "Cheque Book";
        }
        if (c6.isSelected()) {
            facility += "K-Statement";
        }

        try {
            if (accounttype == null) {
                JOptionPane.showMessageDialog(null, "Account Type is required");
            } else {
                Conn conn = new Conn();
                String query1 = "insert into signup3 values('" + forms + "', '" + accounttype + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
                String query2 = "insert into login values('" + forms + "', '" + cardnumber + "', '" + pinnumber + "')";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);

                // After showing the card number and PIN, open the Login class
                setVisible(false); // Close the Signup3 window
                new Login().setVisible(true); // Open the Login window
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    } else if (ae.getSource() == cancle) {
        setVisible(false);
        new Login().setVisible(true);
    }
}


    public static void main(String[] args) {
        new Signup3("");
    }
}
