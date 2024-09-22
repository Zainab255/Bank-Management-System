package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pin extends JFrame implements ActionListener {

    JPasswordField pin1, pin2;
    JLabel repintext, text, pintext;
    JButton change, back;
    String pinnumber;

    Pin(String pinnumber) {
        this.pinnumber = pinnumber;

        // Set layout and background
        setLayout(null);
        getContentPane().setBackground(new Color(34, 34, 34));

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Header text
        text = new JLabel("Change your PIN");
        text.setBounds(250, 280, 500, 35);
        text.setForeground(new Color(255, 215, 0));
        text.setFont(new Font("Arial", Font.BOLD, 24));
        image.add(text);

        // New PIN label
        pintext = new JLabel("New PIN:");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(pintext);

        // New PIN field
        pin1 = new JPasswordField();
        pin1.setFont(new Font("Arial", Font.PLAIN, 16));
        pin1.setBounds(330, 320, 180, 30);
        pin1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        image.add(pin1);

        // Re-enter PIN label
        repintext = new JLabel("Re-enter your PIN:");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(repintext);

        // Re-enter PIN field
        pin2 = new JPasswordField();
        pin2.setFont(new Font("Arial", Font.PLAIN, 16));
        pin2.setBounds(330, 360, 180, 30);
        pin2.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        image.add(pin2);

        // Change button
        change = new JButton("Change");
        change.setBounds(355, 405, 150, 40);
        change.setFont(new Font("Arial", Font.BOLD, 18));
        change.setBackground(new Color(0, 128, 0));
        change.setForeground(Color.WHITE);
        change.setBorderPainted(false);
        change.setFocusPainted(false);
        change.addActionListener(this);
        image.add(change);

        // Back button
        back = new JButton("Back");
        back.setBounds(355, 460, 150, 40);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(new Color(128, 0, 0));
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.addActionListener(this);
        image.add(back);

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin1.getText();
                String rpin = pin2.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a new PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter the new PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin = '" + rpin + "' WHERE pin='" + pinnumber + "'";
                String query2 = "UPDATE login SET pin = '" + rpin + "' WHERE pin='" + pinnumber + "'";
                String query3 = "UPDATE signup3 SET pin = '" + rpin + "' WHERE pin='" + pinnumber + "'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Pin("").setVisible(true);
    }
}
