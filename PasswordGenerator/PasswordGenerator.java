package PasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350); // Make popup bigger
        frame.setLayout(new GridLayout(0, 2, 15, 15)); // Increase gap between columns and rows
        ((JPanel)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding to edges

        JLabel lengthLabel = new JLabel("Password length:");
        JTextField lengthField = new JTextField("", 5);

        JLabel upperLabel = new JLabel("First Name:");
        JTextField upperField = new JTextField("", 20);

        JLabel lowerLabel = new JLabel("Last Name:");
        JTextField lowerField = new JTextField("", 20);

        JLabel specialLabel = new JLabel("Special characters :");
        JTextField specialField = new JTextField("", 15);

        JLabel numberLabel = new JLabel("Numbers :");
        JTextField numberField = new JTextField("", 10);

        JButton generateButton = new JButton("Generate a strong password");
        JTextField passwordField = new JTextField(25);
        passwordField.setEditable(false);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(lengthField.getText().trim());
                    String uppers = upperField.getText();
                    String lowers = lowerField.getText();
                    String specials = specialField.getText();
                    String numbers = numberField.getText();
                    String password = generateCustomPassword(length, uppers, lowers, specials, numbers);
                    passwordField.setText(password);
                } catch (NumberFormatException ex) {
                    passwordField.setText("Invalid length");
                }
            }
        });

        frame.add(lengthLabel);
        frame.add(lengthField);
        frame.add(upperLabel);
        frame.add(upperField);
        frame.add(lowerLabel);
        frame.add(lowerField);
        frame.add(specialLabel);
        frame.add(specialField);
        frame.add(numberLabel);
        frame.add(numberField);
        frame.add(generateButton);
        frame.add(passwordField);

        frame.setVisible(true);
    }

    // Method to generate a custom password
    public static String generateCustomPassword(int length, String uppers, String lowers, String specials, String numbers) {
        if (uppers.isEmpty()) {
            uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        } else {
            uppers = uppers.toUpperCase();
        }
        if (lowers.isEmpty()) {
            lowers = "abcdefghijklmnopqrstuvwxyz";
        } else {
            lowers = lowers.toLowerCase();
        }
        String chars = uppers + lowers + specials + numbers;
        if (chars.isEmpty()) return "No characters specified";
        StringBuilder password = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(chars.length());
            password.append(chars.charAt(index));
        }
        return password.toString();
    }
}
