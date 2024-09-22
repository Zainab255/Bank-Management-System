package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    JLabel mini, bank, card, balance;

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Bank label
        bank = new JLabel("ZM Bank");
        bank.setBounds(200, 20, 200, 30);
        bank.setFont(new Font("Arial", Font.BOLD, 24));
        add(bank);

        // Card label
        card = new JLabel();
        card.setBounds(20, 80, 400, 20);
        card.setFont(new Font("Arial", Font.PLAIN, 16));
        add(card);

        // Mini statement area
        mini = new JLabel();
        mini.setBounds(20, 140, 550, 200);
        mini.setFont(new Font("Arial", Font.PLAIN, 14));
        mini.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mini.setVerticalAlignment(SwingConstants.TOP);
        add(mini);

        // Balance label
        balance = new JLabel();
        balance.setBounds(20, 400, 320, 20);
        balance.setFont(new Font("Arial", Font.BOLD, 16));
        add(balance);

        int balance2 = 0;

        // Fetch card number and initial balance
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");

            while (rs.next()) {
                // Show card number
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "xxxxxxxx" + rs.getString("cardnumber").substring(12));

                // Update balance based on transaction type
                if (rs.getString("type").equals("Deposit")) {
                    balance2 += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance2 -= Integer.parseInt(rs.getString("amount"));
                }
            }

            // Display balance
            balance.setText("Your current account balance is Rs " + balance2);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Fetch and display mini statement
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            StringBuilder statement = new StringBuilder("<html>");
            while (rs.next()) {
                statement.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;Rs ")
                        .append(rs.getString("amount"))
                        .append("<br>");
            }
            statement.append("</html>");
            mini.setText(statement.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(600, 600);
        setLocation(120, 20);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");  // Test with a sample PIN number
    }
}
