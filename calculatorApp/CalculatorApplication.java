package calculatorApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorApplication implements ActionListener{
	
	double num1=0, num2 = 0, result = 0;
	int calculation;
	
	JFrame frame = new JFrame("Calculator");
	JLabel label = new JLabel("");
	JTextField textField = new JTextField();
	JRadioButton onRadioButton = new JRadioButton("on");
	JRadioButton offRadioButton = new JRadioButton("off");
	JButton buttonZero = new JButton("0");
	JButton buttonOne = new JButton("1");
	JButton buttonTwo = new JButton("2");
	JButton buttonThree = new JButton("3");
	JButton buttonFour = new JButton("4");
	JButton buttonFive = new JButton("5");
	JButton buttonSix = new JButton("6");
	JButton buttonSeven = new JButton("7");
	JButton buttonEight = new JButton("8");
	JButton buttonNine = new JButton("9");
	JButton buttonDot = new JButton(".");
	JButton buttonClear = new JButton("C");
	JButton buttonDelete = new JButton("DEL");
	JButton buttonEqual = new JButton("=");
	JButton buttonMul = new JButton("x");
	JButton buttonDiv = new JButton("/");
	JButton buttonMinus = new JButton("-");
	JButton buttonPlus = new JButton("+");
	JButton buttonSquare = new JButton("x\u00B2");
	JButton buttonReciprocal = new JButton("1/x");
	JButton buttonSqrt = new JButton("\u221A");
	
	CalculatorApplication(){
		prepareGui();
		addComponents();
		addActionEvent();
	}
	
	
	public void prepareGui() {
		frame.setSize(305,510);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setLocationRelativeTo(null); //The frame is centred on the screen using the setLocationRelativeTo(null) method.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addComponents() {
		label.setBounds(250,0,50,50);
		label.setForeground(Color.white);//text? in front of background
		frame.add(label);
		
		textField.setBounds(10,40,270,40);
		textField.setFont(new Font("Arial",Font.BOLD,20));
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT); //interface "SwingConstants" in Swing package which provides constants for alignment
		frame.add(textField);
		
		onRadioButton.setBounds(10,95,60,40);
		onRadioButton.setSelected(true);
		onRadioButton.setFont(new Font("Arial",Font.BOLD,14));
		onRadioButton.setBackground(Color.black);
		onRadioButton.setForeground(Color.white);
		onRadioButton.setFocusable(false);//gets rid of the white box around the word
		frame.add(onRadioButton);
		
		offRadioButton.setBounds(10,120,60,40);
		offRadioButton.setSelected(false);
		offRadioButton.setFont(new Font("Arial",Font.BOLD,14));
		offRadioButton.setBackground(Color.black);
		offRadioButton.setForeground(Color.white);
		offRadioButton.setFocusable(false);//gets rid of the white box around the word
		frame.add(offRadioButton);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(onRadioButton);
		buttonGroup.add(offRadioButton);
		
		buttonSeven.setBounds(10,230,60,40);
		buttonSeven.setFont(new Font("Arial",Font.BOLD,20));
		buttonSeven.setFocusable(false);
		frame.add(buttonSeven);
		
		buttonEight.setBounds(80,230,60,40);
		buttonEight.setFont(new Font("Arial",Font.BOLD,20));
		buttonEight.setFocusable(false);
		frame.add(buttonEight);
		
		buttonNine.setBounds(150,230,60,40);
		buttonNine.setFont(new Font("Arial",Font.BOLD,20));
		buttonNine.setFocusable(false);
		frame.add(buttonNine);

		buttonFour.setBounds(10,290,60,40);
		buttonFour.setFont(new Font("Arial",Font.BOLD,20));
		buttonFour.setFocusable(false);
		frame.add(buttonFour);
		
		buttonFive.setBounds(80,290,60,40);
		buttonFive.setFont(new Font("Arial",Font.BOLD,20));
		buttonFive.setFocusable(false);
		frame.add(buttonFive);
		
		buttonSix.setBounds(150,290,60,40);
		buttonSix.setFont(new Font("Arial",Font.BOLD,20));
		buttonSix.setFocusable(false);
		frame.add(buttonSix);
		
		buttonOne.setBounds(10,350,60,40);
		buttonOne.setFont(new Font("Arial",Font.BOLD,20));
		buttonOne.setFocusable(false);
		frame.add(buttonOne);
		
		buttonTwo.setBounds(80,350,60,40);
		buttonTwo.setFont(new Font("Arial",Font.BOLD,20));
		buttonTwo.setFocusable(false);
		frame.add(buttonTwo);
	
		buttonThree.setBounds(150,350,60,40);
		buttonThree.setFont(new Font("Arial",Font.BOLD,20));
		buttonThree.setFocusable(false);
		frame.add(buttonThree);
		
		buttonEqual.setBounds(220,350,60,100);
		buttonEqual.setFont(new Font("Arial",Font.BOLD,18));
		buttonEqual.setBackground(new Color(239,188,2));
		buttonEqual.setFocusable(false);
		frame.add(buttonEqual);
		
		buttonDiv.setBounds(220,110,60,40);
		buttonDiv.setFont(new Font("Arial",Font.BOLD,20));
		buttonDiv.setBackground(new Color(239,188,2));
		buttonDiv.setFocusable(false);
		frame.add(buttonDiv);
		
		buttonSqrt.setBounds(10,170,60,40);
		buttonSqrt.setFont(new Font("Arial",Font.BOLD,20));
		buttonSqrt.setFocusable(false);
		frame.add(buttonSqrt);
		
		buttonMul.setBounds(220,170,60,40);
		buttonMul.setFont(new Font("Arial",Font.BOLD,15));
		buttonMul.setBackground(new Color(239,188,2));
		buttonMul.setFocusable(false);
		frame.add(buttonMul);
		
		buttonMinus.setBounds(220,230,60,40);
		buttonMinus.setFont(new Font("Arial",Font.BOLD,20));
		buttonMinus.setBackground(new Color(239,188,2));
		buttonMinus.setFocusable(false);
		frame.add(buttonMinus);
		
		buttonPlus.setBounds(220,290,60,40);
		buttonPlus.setFont(new Font("Arial",Font.BOLD,18));
		buttonPlus.setBackground(new Color(239,188,2));
		buttonPlus.setFocusable(false);
		frame.add(buttonPlus);
		
		buttonSquare.setBounds(80,170,60,40);
		buttonSquare.setFont(new Font("Arial",Font.BOLD,15));
		buttonSquare.setFocusable(false);
		frame.add(buttonSquare);
		
		buttonReciprocal.setBounds(150,170,60,40);
		buttonReciprocal.setFont(new Font("Arial",Font.BOLD,15));
		buttonReciprocal.setFocusable(false);
		frame.add(buttonReciprocal);
		
		buttonDelete.setBounds(150,110,60,40);
		buttonDelete.setFont(new Font("Arial",Font.BOLD,13));
		buttonDelete.setBackground(Color.red);
		buttonDelete.setForeground(Color.white);
		buttonDelete.setFocusable(false);
		frame.add(buttonDelete);
		
		buttonClear.setBounds(80,110,60,40);
		buttonClear.setFont(new Font("Arial",Font.BOLD,15));
		buttonClear.setBackground(Color.red);
		buttonClear.setForeground(Color.white);
		buttonClear.setFocusable(false);
		frame.add(buttonClear);
		
		buttonZero.setBounds(10,410,130,40);
		buttonZero.setFont(new Font("Arial",Font.BOLD,20));
		buttonZero.setFocusable(false);
		frame.add(buttonZero);

		buttonDot.setBounds(150,410,60,40);
		buttonDot.setFont(new Font("Arial",Font.BOLD,20));
		buttonDot.setFocusable(false);
		frame.add(buttonDot);
		
	}
	
	public void addActionEvent() {
		onRadioButton.addActionListener(this);
		offRadioButton.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonDelete.addActionListener(this);
		buttonDiv.addActionListener(this);
		buttonSqrt.addActionListener(this);
		buttonSquare.addActionListener(this);
		buttonReciprocal.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonOne.addActionListener(this);
		buttonTwo.addActionListener(this);
		buttonThree.addActionListener(this);
		buttonFour.addActionListener(this);
		buttonFive.addActionListener(this);
		buttonSix.addActionListener(this);
		buttonSeven.addActionListener(this);
		buttonEight.addActionListener(this);
		buttonNine.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonZero.addActionListener(this);
		buttonDot.addActionListener(this);
		buttonMul.addActionListener(this);
		
	}
	
	

	public static void main(String[] args) {
		CalculatorApplication calculator = new CalculatorApplication();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
	    // Get the source object that triggered the action
	    Object source = e.getSource();
	    // Check if the source is the "onRadioButton"
	    if (source == onRadioButton) {
	        enable();
	    // Check if the source is the "offRadioButton"
	    } else if (source == offRadioButton) {
	        disable();
	    // Check if the source is the "buttonClear"
	    } else if (source == buttonClear) {
	    // Clear the label and text field
	        label.setText("");
	        textField.setText("");
	    } else if (source == buttonDelete) {
	        // Delete the last character from the text field
	        int length = textField.getText().length();
	        if (length > 0) {
	        // Create a StringBuilder from the text field's content
	            StringBuilder back = new StringBuilder(textField.getText());
	         // Remove the last character
	            back.deleteCharAt(length - 1);
	         // Set the modified text back to the text field
	            textField.setText(back.toString());
	        }
	     // Clear the label
	        label.setText("");
	    } else if (source == buttonZero) {
	    	// Append "0" to the text field if it's not already "0"
	        if (!textField.getText().equals("0")) {
	            textField.setText(textField.getText() + "0");
	        }
	     // Check if the source is any of the number buttons (buttonOne, buttonTwo, ..., buttonNine)
	    } else if (source == buttonOne || source == buttonTwo || source == buttonThree ||
	            source == buttonFour || source == buttonFive || source == buttonSix ||
	            source == buttonSeven || source == buttonEight || source == buttonNine) {
	    	// Cast the source to a JButton since it's known to be a number button
	        JButton numberButton = (JButton) source;
	     // Append the button's text to the text field
	        textField.setText(textField.getText() + numberButton.getText());
	    } else if (source == buttonDot) {
	    	// Append a dot (".") to the text field if it doesn't already contain one
	        if (!textField.getText().contains(".")) {
	            textField.setText(textField.getText() + ".");
	        }
	     // Check if the source is any of the operation buttons (buttonPlus, buttonMinus, buttonMul, buttonDiv)
	    } else if (source == buttonPlus || source == buttonMinus || source == buttonMul || source == buttonDiv) {
	    	// Get the content of the text field
	    	String str = textField.getText();
	    	// Check if the text field is not empty
	        if (!str.isEmpty()) {
	        	//try-catch method
	            try {
	            	// Parse the text field content to a double
	                num1 = Double.parseDouble(str);
	             // Set the "calculation" variable based on the source button
	                if (source == buttonPlus) {
	                    calculation = 1;
	                } else if (source == buttonMinus) {
	                    calculation = 2;
	                } else if (source == buttonMul) {
	                    calculation = 3;
	                } else if (source == buttonDiv) {
	                    calculation = 4;
	                }
	             // Clear the text field
	                textField.setText("");
	             // Set the label (not textField) text to show the entered value and the operation
	                label.setText(str + " " + ((JButton) source).getText());
	            } catch (NumberFormatException ex) {
	            // If a NumberFormatException occurs (invalid input), clear the text field and display an error message
	                textField.setText("");
	                label.setText("Invalid input");
	            }
	        }
	     // Check if the source is any of the operation buttons for square, square root, and reciprocal
	    } else if (source == buttonSquare || source == buttonSqrt || source == buttonReciprocal) {
	        String str = textField.getText();
	        if (!str.isEmpty()) {
	            try {
	                num1 = Double.parseDouble(str);
	             // Perform the corresponding operation based on the source button
	                if (source == buttonSquare) {
	                    double square = Math.pow(num1, 2);
	                    textField.setText(formatResult(square));
	                } else if (source == buttonSqrt) {
	                    double sqrt = Math.sqrt(num1);
	                    textField.setText(formatResult(sqrt));
	                } else if (source == buttonReciprocal) {
	                    double reciprocal = 1 / num1;
	                    textField.setText(formatResult(reciprocal));
	                }
	            } catch (NumberFormatException ex) {
	                textField.setText("");
	                label.setText("Invalid input");
	            }
	        }
	    } else if (source == buttonEqual) {
	        String str = textField.getText();
	        if (!str.isEmpty()) {
	            try {
	                num2 = Double.parseDouble(str);
	                switch (calculation) {
	                    case 1:
	                        result = num1 + num2;
	                        break;
	                    case 2:
	                        result = num1 - num2;
	                        break;
	                    case 3:
	                        result = num1 * num2;
	                        break;
	                    case 4:
	                        result = num1 / num2;
	                        break;
	                }
	             // Set the calculated result in the text field
	                textField.setText(formatResult(result));
	             // Clear the label
	                label.setText("");
	             // Update num1 with the result for potential subsequent calculations
	                num1 = result;
	            } catch (NumberFormatException ex) {
	                textField.setText("");
	                label.setText("Invalid input");
	            }
	        }
	    }
	}

	// Helper method to format the result by removing unnecessary decimal places
	private String formatResult(double value) {
		// Convert the double value to a string
	    String string = Double.toString(value);
	    if (string.endsWith(".0")) {
	        return string.replace(".0", "");
	    } else {
	        return string;
	    }
	}
	//enables interaction with UI Components
	
	public void enable() {
		onRadioButton.setEnabled(false);
		offRadioButton.setEnabled(true);
		textField.setEnabled(true);
		label.setEnabled(true);
		label.setText("");
		textField.setText("");
		buttonClear.setEnabled(true);
		buttonDelete.setEnabled(true);
		buttonDiv.setEnabled(true);
		buttonSqrt.setEnabled(true);
		buttonSquare.setEnabled(true);
		buttonReciprocal.setEnabled(true);
		buttonMinus.setEnabled(true);
		buttonOne.setEnabled(true);
		buttonTwo.setEnabled(true);
		buttonThree.setEnabled(true);
		buttonFour.setEnabled(true);
		buttonFive.setEnabled(true);
		buttonSix.setEnabled(true);
		buttonSeven.setEnabled(true);
		buttonEight.setEnabled(true);
		buttonNine.setEnabled(true);
		buttonPlus.setEnabled(true);
		buttonMul.setEnabled(true);
		buttonEqual.setEnabled(true);
		buttonZero.setEnabled(true);
		buttonDot.setEnabled(true);
	}
	
	
	public void disable() {
		onRadioButton.setEnabled(true);
		offRadioButton.setEnabled(false);
		textField.setEnabled(false);
		label.setEnabled(false);
		buttonClear.setEnabled(false);
		buttonDelete.setEnabled(false);
		buttonDiv.setEnabled(false);
		buttonSqrt.setEnabled(false);
		buttonSquare.setEnabled(false);
		buttonReciprocal.setEnabled(false);
		buttonMinus.setEnabled(false);
		buttonOne.setEnabled(false);
		buttonTwo.setEnabled(false);
		buttonThree.setEnabled(false);
		buttonFour.setEnabled(false);
		buttonFive.setEnabled(false);
		buttonSix.setEnabled(false);
		buttonSeven.setEnabled(false);
		buttonEight.setEnabled(false);
		buttonNine.setEnabled(false);
		buttonPlus.setEnabled(false);
		buttonMul.setEnabled(false);
		buttonEqual.setEnabled(false);
		buttonZero.setEnabled(false);
		buttonDot.setEnabled(false);
	}

}
