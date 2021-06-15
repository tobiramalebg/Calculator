package fr.gonzyui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculs implements ActionListener {

    JFrame frame;
    JTextField textField;

    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];

    JButton addButton, subButton, multiButton, clearButton, negativeButton, divButton, decButton, exeButton, delButton;
    JPanel panel;

    Font  font = new Font ("Arial", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculs() {
        frame = new JFrame("Calculator by gonzyui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        exeButton = new JButton("=");
        delButton = new JButton("Del");
        clearButton = new JButton("Clr");
        negativeButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = multiButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = exeButton;
        functionButton[6] = delButton;
        functionButton[7] = clearButton;
        functionButton[8] = negativeButton;

        for (int i = 0; i < 9; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(font);
            functionButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(font);
            numberButton[i].setFocusable(false);
        }

        negativeButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(exeButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negativeButton);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == multiButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == exeButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");

            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == negativeButton) {
            double time = Double.parseDouble(textField.getText());
            time *= 1;
            textField.setText(String.valueOf(time));
        }
    }
}
