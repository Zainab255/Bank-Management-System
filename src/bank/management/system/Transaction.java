package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balance, exit;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(210, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 20));
        image.add(text);

        // Create button styles
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonColor = new Color(34, 193, 195);
        Color hoverColor = new Color(253, 187, 45);

        deposit = createStyledButton("Deposit", buttonFont, buttonColor, hoverColor);
        deposit.setBounds(170, 365, 150, 30);
        image.add(deposit);

        withdrawl = createStyledButton("Withdraw", buttonFont, buttonColor, hoverColor);
        withdrawl.setBounds(355, 365, 150, 30);
        image.add(withdrawl);

        fastcash = createStyledButton("Fast Cash", buttonFont, buttonColor, hoverColor);
        fastcash.setBounds(170, 400, 150, 30);
        image.add(fastcash);

        ministatement = createStyledButton("Mini Statement", buttonFont, buttonColor, hoverColor);
        ministatement.setBounds(355, 400, 150, 30);
        image.add(ministatement);

        pinchange = createStyledButton("Pin Change", buttonFont, buttonColor, hoverColor);
        pinchange.setBounds(170, 435, 150, 30);
        image.add(pinchange);

        balance = createStyledButton("Balance Enquiry", buttonFont, buttonColor, hoverColor);
        balance.setBounds(355, 435, 150, 30);
        image.add(balance);

        exit = createStyledButton("Exit", buttonFont, buttonColor, hoverColor);
        exit.setBounds(355, 470, 150, 30);
        image.add(exit);

        setSize(900, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    private JButton createStyledButton(String text, Font font, Color color, Color hoverColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new Pin(pinnumber).setVisible(true);
        } else if (ae.getSource() == balance) {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transaction("");
    }
}
