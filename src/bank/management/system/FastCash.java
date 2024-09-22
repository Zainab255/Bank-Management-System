package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balance, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(text);

        deposit = createStyledButton("Rs 100");
        deposit.setBounds(170, 365, 150, 30);
        image.add(deposit);

        withdrawl = createStyledButton("Rs 500");
        withdrawl.setBounds(355, 365, 150, 30);
        image.add(withdrawl);

        fastcash = createStyledButton("Rs 1000");
        fastcash.setBounds(170, 400, 150, 30);
        image.add(fastcash);

        ministatement = createStyledButton("Rs 2000");
        ministatement.setBounds(355, 400, 150, 30);
        image.add(ministatement);

        pinchange = createStyledButton("Rs 5000");
        pinchange.setBounds(170, 435, 150, 30);
        image.add(pinchange);

        balance = createStyledButton("Rs 10000");
        balance.setBounds(355, 435, 150, 30);
        image.add(balance);

        exit = createStyledButton("Back");
        exit.setBounds(355, 470, 150, 30);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(34, 193, 195));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(253, 187, 45));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(34, 193, 195));
            }
        });

        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3); // Get the amount from the button text
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "' ");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                // Check for sufficient balance
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }

                // Insert the transaction as a withdrawal
                Date date = new Date();
                String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                c.s.executeUpdate(query);

                // Show confirmation message
                JOptionPane.showMessageDialog(null, "Rs " + amount + " debited successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new FastCash("");  // Test with a sample PIN number
    }
}
