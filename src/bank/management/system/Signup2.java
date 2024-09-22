package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    JTextField numTextField, panTextField;
    JRadioButton yes, no, eyes, eno;
    JButton next;
    JLabel religion, category, additionalDetails, income, education, occupation, pan, num, citizen, exit;
    JComboBox<String> religionCombo, categoryCombo, incomeCombo, educationCombo, occupationCombo;
    String forms;

    Signup2(String forms) {
        this.forms = forms;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        getContentPane().setBackground(new Color(240, 240, 240));

        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Arial", Font.BOLD, 22));
        additionalDetails.setBounds(290, 40, 400, 30);
        add(additionalDetails);

        religionCombo = createLabelAndComboBox("Religion:", new String[]{"Hindu", "Muslim", "Christian", "Sikh", "Other"}, 100, 100);
        categoryCombo = createLabelAndComboBox("Category:", new String[]{"General", "OBC", "SC", "ST", "Other"}, 100, 150);
        incomeCombo = createLabelAndComboBox("Income:", new String[]{"<1,50,000", "<2,50,000", "<5,00,000", "Up to 10,00,000"}, 100, 200);
        educationCombo = createLabelAndComboBox("Educational:", new String[]{"Matric", "Intermediate", "Undergraduate", "Graduated", "Post-Graduated", "PhD"}, 100, 250);
        occupationCombo = createLabelAndComboBox("Occupation:", new String[]{"Employed", "Unemployed", "Student", "Retired", "Other"}, 100, 300);

        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Arial", Font.BOLD, 20));
        pan.setBounds(100, 350, 200, 30);
        add(pan);
        
        panTextField = createTextField(300, 350);
        
        num = new JLabel("Another Number:");
        num.setFont(new Font("Arial", Font.BOLD, 20));
        num.setBounds(100, 400, 200, 30);
        add(num);
        
        numTextField = createTextField(300, 400);
        
        citizen = new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Arial", Font.BOLD, 20));
        citizen.setBounds(100, 450, 200, 30);
        add(citizen);
        
        yes = new JRadioButton("Yes");
        no = new JRadioButton("No");
        setupRadioButton(yes, 300, 450);
        setupRadioButton(no, 400, 450);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(yes);
        seniorCitizenGroup.add(no);

        exit = new JLabel("Existing Account:");
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setBounds(100, 500, 200, 30);
        add(exit);
        
        eyes = new JRadioButton("Yes");
        eno = new JRadioButton("No");
        setupRadioButton(eyes, 300, 500);
        setupRadioButton(eno, 400, 500);
        
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(new Color(0, 123, 255));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(620, 600, 100, 40);
        next.setBorderPainted(false);
        next.setFocusPainted(false);
        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        next.addActionListener(this);
        add(next);

        setSize(850, 700);
        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JComboBox<String> createLabelAndComboBox(String labelText, String[] options, int x, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(x, y, 200, 30);
        add(label);

        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x + 200, y, 400, 30);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox.setBackground(Color.WHITE);
        add(comboBox);
        
        return comboBox; // Return the JComboBox
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBounds(x, y, 400, 30);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField.setBackground(Color.WHITE);
        add(textField);
        return textField;
    }

    private void setupRadioButton(JRadioButton button, int x, int y) {
        button.setBounds(x, y, 100, 30);
        button.setBackground(Color.WHITE);
        add(button);
    }

    public void actionPerformed(ActionEvent ex) {
        String sreligion = (String) religionCombo.getSelectedItem();
        String scategory = (String) categoryCombo.getSelectedItem();
        String sincome = (String) incomeCombo.getSelectedItem();
        String seducation = (String) educationCombo.getSelectedItem();
        String soccupation = (String) occupationCombo.getSelectedItem();

        String scitizen = yes.isSelected() ? "Yes" : "No";
        String sexit = eyes.isSelected() ? "Yes" : "No";
        String span = panTextField.getText();
        String snum = numTextField.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + forms + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + snum + "', '" + scitizen + "', '" + sexit + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new Signup3(forms).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
