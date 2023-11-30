/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bmicalculatorapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorApp extends JFrame {
    private JTextField heightField, weightField, resultField;

    public BMICalculatorApp() {
        setTitle("BMI Calculator");
        setSize(400, 250); // Adjusted height for better visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Added gaps between components

        JLabel heightLabel = new JLabel("Enter Height (m):");
        heightField = new JTextField();

        JLabel weightLabel = new JLabel("Enter Weight (kg):");
        weightField = new JTextField();

        JButton calculateButton = new JButton("Calculate BMI");

        JLabel resultLabel = new JLabel("BMI Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        mainPanel.add(heightLabel);
        mainPanel.add(heightField);
        mainPanel.add(weightLabel);
        mainPanel.add(weightField);
        mainPanel.add(new JLabel()); // Empty label for spacing
        mainPanel.add(calculateButton);
        mainPanel.add(resultLabel);
        mainPanel.add(resultField);

        add(mainPanel);
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());

            double bmi = weight / (height * height);

            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 24.9) {
                status = "Normal";
            } else if (bmi < 29.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            resultField.setText(String.format("BMI: %.2f (%s)", bmi, status));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for height and weight.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMICalculatorApp());
    }
}