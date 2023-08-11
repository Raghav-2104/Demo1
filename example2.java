
//import com.mysql.cj.jdbc.Driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

public class example2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create AWT components
        Label num1Label = new Label("Roll No:");
        Label num2Label = new Label("Name:");
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

                String url = "jdbc:mysql://localhost:3306/student_data?useSSL=false&serverTimezone=UTC";
                // String username = "root";
                // String password = "soham";

                try {
                    int roll_no = Integer.parseInt(num1Field.getText());
                    String name = num2Field.getText();

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection connection = DriverManager.getConnection(url);

                    Statement statement = connection.createStatement();

                    String query = "INSERT INTO student_data (roll_no, name) VALUES (" + roll_no + ", '" + name + "')";

                    int rowsAffected = statement.executeUpdate(query);

                    resultLabel.setText("Result: Values added");

                    statement.close();
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    resultLabel.setText("Result: Added");
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
