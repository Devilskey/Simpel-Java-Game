package Debugger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DebugWindow extends JFrame {

    private static JTextArea logTextArea  = new JTextArea();
    private JTextField inputField;

    public DebugWindow() {
        setTitle("Debug Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false); // Make it read-only
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Enter key press in the input field
                processInput();
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void log(float number) {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());

        String logMessage = "[" + timeStamp + "] " + number + "\n";

        logTextArea.append(logMessage);

        logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
    }

    public static void log(int number) {
        Logger.LogDebug(String.valueOf(number));
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());

        String logMessage = "[" + timeStamp + "] " + number + "\n";

        logTextArea.append(logMessage);

        logTextArea.setCaretPosition(logTextArea.getDocument().getLength());

    }

    public static void log(String message) {
        Logger.LogDebug(message);

        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());

        String logMessage = "[" + timeStamp + "] " + message + "\n";

        logTextArea.append(logMessage);

        logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
    }

    private void processInput() {
        String inputText = inputField.getText();
        if (!inputText.isEmpty()) {
            DebugCMD.CMD(inputText);
            inputField.setText("");
        }
    }
}