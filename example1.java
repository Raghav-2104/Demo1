import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class example1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create AWT components
        Label num1Label = new Label("Number 1:");
        Label num2Label = new Label("Number 2:");
        Label resultLabel = new Label("Result:");

        TextField num1Field = new TextField(10);
        TextField num2Field = new TextField(10);

        // Create Swing components
        JButton addButton = new JButton("Add");
        JButton clearButton = new JButton("Clear");

        // Create ActionListener for addition
        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 + num2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {  
                    resultLabel.setText("Result: Invalid input");
                }
            }
        };

        // Attach ActionListener to the "Add" button
        addButton.addActionListener(addListener);

        // Create ActionListener for clearing fields
        ActionListener clearListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1Field.setText("");
                num2Field.setText("");
                resultLabel.setText("Result:");
            }
        };

        // Attach ActionListener to the "Clear" button
        clearButton.addActionListener(clearListener);

        // Create layout using BorderLayout
        frame.setLayout(new BorderLayout());

        // Create panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);
        inputPanel.add(addButton);
        inputPanel.add(clearButton);

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultLabel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }
}
