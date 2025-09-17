package com.company.xmlxsd;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class GUIGenerateRandoms {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIGenerateRandoms::generateRandoms);
    }

    private static void generateRandoms() {
        JFrame frame = new JFrame("Random Number Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Labels
        JLabel lowerBoundLabel = new JLabel("Add Lower Bound:");
        JLabel upperBoundLabel = new JLabel("Add Upper Bound:");
        JLabel howManyLabel = new JLabel("How many:");

        // Input fields
        JTextField lowerBoundField = new JTextField(10);
        JTextField upperBoundField = new JTextField(10);
        JTextField howManyField = new JTextField(10);

        // Output area with scroll
        JTextArea resultArea = new JTextArea(11, 19);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Buttons
        JButton generateBtn = new JButton("Generate");
        JButton clearBtn = new JButton("Clear");

        // Clear button
        clearBtn.addActionListener(e -> {
            lowerBoundField.setText("");
            upperBoundField.setText("");
            howManyField.setText("");
            resultArea.setText("");
        });

        // Generate button
        generateBtn.addActionListener(e -> {
            resultArea.setText("");
            try {
                int lower = parseToInteger(lowerBoundField);
                int upper = parseToInteger(upperBoundField);
                int howMany = parseToInteger(howManyField);

                if (lower < 0 || upper < 0 || howMany <= 0) {
                    JOptionPane.showMessageDialog(frame, "All values must be positive and 'How many' > 0!");
                    return;
                }

                if (lower > upper) {
                    JOptionPane.showMessageDialog(frame, "Lower bound can't be greater than upper bound");
                    return;
                }

                if (howMany > (upper - lower + 1)) {
                    JOptionPane.showMessageDialog(frame, "Not enough unique numbers in the given range.\n");
                }

                SecureRandom random = new SecureRandom();
                StringBuilder sb = new StringBuilder("Random Numbers CSV:\n\n");
                Set<Integer> randomNumbers = new HashSet<>();

                while (randomNumbers.size() < howMany) {
                    randomNumbers.add(random.nextInt(upper - lower + 1) + lower);
                }
                int count = 0;
                for (int num : randomNumbers) {
                    count++;
                    sb.append(num);
                    if (count < howMany) {
                        sb.append(", ");
                    }

                    if (count % 8 == 0) {
                        sb.append("\n");
                    }

                }
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid integers in all fields!");
            }
        });

        // Layout
        add(panel, lowerBoundLabel, gbc, 0, 0);
        add(panel, lowerBoundField, gbc, 1, 0);

        add(panel, upperBoundLabel, gbc, 0, 1);
        add(panel, upperBoundField, gbc, 1, 1);

        add(panel, howManyLabel, gbc, 0, 2);
        add(panel, howManyField, gbc, 1, 2);

        gbc.gridwidth = 2;
        add(panel, generateBtn, gbc, 0, 3);
        add(panel, clearBtn, gbc, 0, 4);
        add(panel, scrollPane, gbc, 0, 5);

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void add(JPanel parent, Component comp, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        parent.add(comp, gbc);
    }

    private static int parseToInteger(JTextField textField) {
        return Integer.parseInt(textField.getText().trim());
    }
}
