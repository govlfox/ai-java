package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField num1Field;
    private JTextField num2Field;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JLabel resultLabel;

    // Define a common button size
    private static final Dimension BUTTON_SIZE = new Dimension(60, 40);
    // Define a common font for buttons
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 16);
    // Define a common font for labels
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 14);
    // Define a common font for the result label
    private static final Font RESULT_FONT = new Font("Arial", Font.BOLD, 18);


    public SimpleCalculator() {
        // Frame setup
        setTitle("Trendy Calculator");
        setSize(450, 250); // Slightly larger frame for better spacing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15)); // Increased gaps for a more spacious feel
        getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15)); // Centered flow layout with gaps
        inputPanel.setBackground(new Color(240, 240, 240)); // Match frame background

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);

        // Style input fields
        num1Field.setFont(LABEL_FONT);
        num2Field.setFont(LABEL_FONT);
        num1Field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 1), // Outer border
            BorderFactory.createEmptyBorder(5, 5, 5, 5) // Inner padding
        ));
        num2Field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 1), // Outer border
            BorderFactory.createEmptyBorder(5, 5, 5, 5) // Inner padding
        ));

        inputPanel.add(new JLabel("Number 1:"));
        inputPanel.add(num1Field);
        inputPanel.add(new JLabel("Number 2:"));
        inputPanel.add(num2Field);

        // Operation Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // Increased gaps between buttons
        buttonPanel.setBackground(new Color(240, 240, 240)); // Match frame background

        addButton = createStyledButton("+");
        subtractButton = createStyledButton("-");
        multiplyButton = createStyledButton("*");
        divideButton = createStyledButton("/");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Result Label
        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(RESULT_FONT);
        resultLabel.setHorizontalAlignment(JLabel.CENTER); // Center the result text
        resultLabel.setForeground(new Color(50, 50, 50)); // Darker color for result

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the window
    }

    // Helper method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setPreferredSize(BUTTON_SIZE);
        button.setBackground(new Color(100, 149, 237)); // Cornflower blue for buttons
        button.setForeground(Color.WHITE); // White text
        button.setBorder(BorderFactory.createRaisedBevelBorder()); // Subtle raised effect
        button.setFocusPainted(false); // Remove focus border
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Get input values, trim whitespace
            String num1Text = num1Field.getText().trim();
            String num2Text = num2Field.getText().trim();

            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                resultLabel.setText("Error: Enter both numbers");
                return;
            }

            double num1 = Double.parseDouble(num1Text);
            double num2 = Double.parseDouble(num2Text);
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    resultLabel.setText("Error: Division by zero");
                    return;
                }
                result = num1 / num2;
                resultLabel.setText("Result: " + result);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: Invalid input");
        } catch (Exception ex) {
            // Catch any other unexpected exceptions
            resultLabel.setText("Error: An unexpected error occurred");
            ex.printStackTrace(); // Log the exception for debugging
        }
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}
