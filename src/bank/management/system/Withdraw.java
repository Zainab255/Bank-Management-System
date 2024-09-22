package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener {

    JTextField amount;
    JLabel text;
    JButton withdraw, back;
    String pinnumber;

    Withdraw(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter the amount you want to withdraw:");
        text.setBounds(170, 300, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 30);
        amount.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        image.add(amount);

        // Create button styles
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonColor = new Color(34, 193, 195);
        Color hoverColor = new Color(253, 187, 45);

        withdraw = createStyledButton("Withdraw", buttonFont, buttonColor, hoverColor);
        withdraw.setBounds(355, 485, 150, 30);
        image.add(withdraw);

        back = createStyledButton("Back", buttonFont, buttonColor, hoverColor);
        back.setBounds(355, 520, 150, 30);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
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
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw:");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'withdraw', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully.");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Withdraw("");  // Test with a sample PIN number
    }
}
