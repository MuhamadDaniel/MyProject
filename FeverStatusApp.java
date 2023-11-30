/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.feverstatusapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeverStatusApp extends JFrame {
    private JTextField temperatureTextField;
    private JButton checkButton;
    private JLabel resultLabel;

    public FeverStatusApp() {
        setTitle("Fever Status Checker");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new GridLayout(4, 1));

        // Components
        JLabel titleLabel = new JLabel("Fever Status Checker");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        temperatureTextField = new JTextField();
        temperatureTextField.setBorder(BorderFactory.createTitledBorder("Enter Temperature"));
        temperatureTextField.setHorizontalAlignment(JTextField.CENTER);

        checkButton = new JButton("Check Fever Status");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFeverStatus();
            }
        });

        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        // Adding components to the frame
        add(titleLabel);
        add(temperatureTextField);
        add(checkButton);
        add(resultLabel);
    }

    private void checkFeverStatus() {
        try {
            double temperature = Double.parseDouble(temperatureTextField.getText());
            String status = determineFeverStatus(temperature);
            resultLabel.setText("Fever Status: " + status);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a numeric temperature.");
        }
    }

    private String determineFeverStatus(double temperature) {
        if (temperature >= 100.4) {
            return "High Fever";
        } else if (temperature >= 99.5) {
            return "Low-Grade Fever";
        } else {
            return "Normal";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FeverStatusApp().setVisible(true);
            }
        });
    }
}