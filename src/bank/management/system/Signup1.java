package bank.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class Signup1 extends JFrame implements ActionListener {

    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JRadioButton male, female, single, married;
    long random;
    JButton next;
    JDateChooser dateChooser;
    JLabel name, forms, fname, personalDetails, dob, gender, email, marital, address, city, state, pincode;

 public Signup1() {

    setLayout(null);
    
    // Create the main panel for the form
    JPanel formPanel = new JPanel();
    formPanel.setLayout(null);
    formPanel.setBackground(Color.WHITE);
    formPanel.setBounds(50, 50, 750, 700); // Adjust bounds as needed
    add(formPanel);

    // Random form number
    Random ran = new Random();
    random = Math.abs((ran.nextLong() % 9000L) + 1000L);

    // Form Number
    forms = new JLabel("Application Form No: " + random);
    forms.setFont(new Font("Raleway", Font.BOLD, 38));
    forms.setForeground(new Color(34, 45, 65));
    forms.setBounds(140, 20, 600, 40);
    formPanel.add(forms);

    // Page Title
    personalDetails = new JLabel("Page 1: Personal Details");
    personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
    personalDetails.setForeground(new Color(58, 63, 85));
    personalDetails.setBounds(290, 90, 400, 30);
    formPanel.add(personalDetails);

    // Name Label & Input
    name = new JLabel("Name: ");
    name.setFont(new Font("Raleway", Font.BOLD, 20));
    name.setBounds(100, 140, 150, 30);
    formPanel.add(name);

    nameTextField = new JTextField();
    nameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    nameTextField.setBounds(300, 140, 400, 35);
    nameTextField.setBackground(new Color(245, 245, 245));
    nameTextField.setBorder(BorderFactory.createEmptyBorder());
    formPanel.add(nameTextField);

    // Father's Name
    fname = new JLabel("Father Name: ");
    fname.setFont(new Font("Raleway", Font.BOLD, 20));
    fname.setBounds(100, 190, 200, 30);
    formPanel.add(fname);

    fnameTextField = new JTextField();
    fnameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    fnameTextField.setBounds(300, 190, 400, 35);
    fnameTextField.setBackground(new Color(245, 245, 245));
    fnameTextField.setBorder(BorderFactory.createEmptyBorder());
    formPanel.add(fnameTextField);

    // Date of Birth
    dob = new JLabel("Date of Birth: ");
    dob.setFont(new Font("Raleway", Font.BOLD, 20));
    dob.setBounds(100, 240, 200, 30);
    formPanel.add(dob);

    dateChooser = new JDateChooser();
    dateChooser.setBounds(300, 240, 300, 35);
    formPanel.add(dateChooser);

    // Gender
    gender = new JLabel("Gender: ");
    gender.setFont(new Font("Raleway", Font.BOLD, 20));
    gender.setBounds(100, 290, 100, 30);
    formPanel.add(gender);

    male = new JRadioButton("Male");
    male.setBounds(300, 290, 100, 30);
    male.setBackground(Color.WHITE);
    formPanel.add(male);

    female = new JRadioButton("Female");
    female.setBounds(430, 290, 100, 30);
    female.setBackground(Color.WHITE);
    formPanel.add(female);

    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);

    // Email
    email = new JLabel("Email: ");
    email.setFont(new Font("Raleway", Font.BOLD, 20));
    email.setBounds(100, 340, 100, 30);
    formPanel.add(email);

    emailTextField = new JTextField();
    emailTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    emailTextField.setBounds(300, 340, 400, 35);
    emailTextField.setBackground(new Color(245, 245, 245));
    emailTextField.setBorder(BorderFactory.createEmptyBorder());
    formPanel.add(emailTextField);

    // Marital Status
    marital = new JLabel("Marital Status: ");
    marital.setFont(new Font("Raleway", Font.BOLD, 20));
    marital.setBounds(100, 390, 200, 30);
    formPanel.add(marital);

    single = new JRadioButton("Single");
    single.setBounds(300, 390, 100, 30);
    single.setBackground(Color.WHITE);
    formPanel.add(single);

    married = new JRadioButton("Married");
    married.setBounds(450, 390, 100, 30);
    married.setBackground(Color.WHITE);
    formPanel.add(married);

    ButtonGroup maritalGroup = new ButtonGroup();
    maritalGroup.add(single);
    maritalGroup.add(married);

    // Address
    address = new JLabel("Address: ");
    address.setFont(new Font("Raleway", Font.BOLD, 20));
    address.setBounds(100, 440, 100, 30);
    formPanel.add(address);

    addressTextField = new JTextField();
    addressTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    addressTextField.setBounds(300, 440, 400, 35);
    addressTextField.setBackground(new Color(245, 245, 245));
    addressTextField.setBorder(BorderFactory.createEmptyBorder());
    formPanel.add(addressTextField);

    // City
    city = new JLabel("City: ");
    city.setFont(new Font("Raleway", Font.BOLD, 20));
    city.setBounds(100, 490, 100, 30);
    formPanel.add(city);

    cityTextField = new JTextField();
    cityTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    cityTextField.setBounds(300, 490, 400, 35);
    cityTextField.setBackground(new Color(245, 245, 245));
    cityTextField.setBorder(BorderFactory.createEmptyBorder());
    formPanel.add(cityTextField);

    // State
    state = new JLabel("State: ");
    state.setFont(new Font("Raleway", Font.BOLD, 20));
    state.setBounds(100, 540, 100, 30);
    formPanel.add(state);

    stateTextField = new JTextField();
    stateTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    stateTextField.setBounds(300, 540, 400, 35);
    stateTextField.setBackground(new Color(245, 245, 245));
    stateTextField.setBorder(BorderFactory.createEmptyBorder());
    formPanel.add(stateTextField);

    // Pincode
    pincode = new JLabel("Pincode: ");
    pincode.setFont(new Font("Raleway", Font.BOLD, 20));
    pincode.setBounds(100, 590, 100, 30);
    formPanel.add(pincode);

    pinTextField = new JTextField();
    pinTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    pinTextField.setBounds(300, 590, 400, 35);
    pinTextField.setBackground(new Color(245, 245, 245));
    pinTextField.setBorder(BorderFactory.createEmptyBorder());
    formPanel.add(pinTextField);

    // Next Button
    next = new JButton("Next");
    next.setFont(new Font("Raleway", Font.BOLD, 16));
    next.setBounds(620, 660, 100, 40);
    next.setBackground(new Color(34, 139, 230));
    next.setForeground(Color.WHITE);
    next.setFocusPainted(false);
    next.setBorder(BorderFactory.createEmptyBorder());
    next.addActionListener(this);
    formPanel.add(next);

    // Frame Settings
    getContentPane().setBackground(Color.WHITE);
    setSize(850, 800);
    setLocation(350, 10);
    setVisible(true);
}



   public void actionPerformed(ActionEvent ex) {
    String forms = "" + random;
    String name = nameTextField.getText();
    String fname = fnameTextField.getText();
    String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if (male.isSelected()) {
        gender = "Male";
    } else if (female.isSelected()) {
        gender = "Female";
    }

    String email = emailTextField.getText();
    String marital = null;
    if (single.isSelected()) {
        marital = "single";
    } else if (married.isSelected()) {
        marital = "married";
    }

    String address = addressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pin = pinTextField.getText();

    try {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is Required");
        } else {
            Conn c = new Conn();
            // Corrected the query, removed extra space before form number
            String query = "insert into signup1 values('" + forms + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            // Pass correct form number to Signup2
            new Signup2(forms).setVisible(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}


    public static void main(String args[]) {
        new Signup1().setVisible(true);
    }

}
