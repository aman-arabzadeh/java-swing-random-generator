package com.company.xmlxsd;

import javax.swing.*;
import java.awt.*;

public class GUIPracticing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel = new JPanel(new GridBagLayout());

        JTextField textFieldLowerBound = new JTextField(15);
        JTextField textFieldUpperBound = new JTextField(15);
        JLabel jLabelLowerBound = new JLabel("Enter lower bound:");
        JLabel jLabelUpperBound = new JLabel("Enter upper bound:");

        add(new JButton("Button One"), gbc, panel, 0, 0, 1);
        add(new JButton("Button Two"), gbc, panel, 0, 1, 1);
        add(new JButton("Button Three"), gbc, panel, 0, 2, 1);
        add(new JButton("Button Four"), gbc, panel, 0, 3, 1);
        add(new JButton("Button Five"), gbc, panel, 0, 4, 1);

        gbc.gridwidth = 2;
        add(jLabelLowerBound, gbc, panel, 0, 5, 1);
        add(textFieldLowerBound, gbc, panel, 1, 5, 2);
        add(jLabelUpperBound, gbc, panel, 0, 6, 1);
        add(textFieldUpperBound, gbc, panel, 1, 6, 2);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void add(Component component, GridBagConstraints gbc, JPanel panel, int x, int y, int w) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2);
        panel.add(component, gbc);
    }
}
