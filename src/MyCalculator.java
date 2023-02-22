import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculator extends JFrame implements ActionListener {
	private JTextField textField;
	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	private JButton decButton = new JButton(".");
	private JButton equButton = new JButton("=");
	private JButton delButton = new JButton("Del");
	private JButton clrButton = new JButton("Clr");
	private JButton[] numberButtons = new JButton[10];
	private JButton[] functionButtons = {addButton, subButton, mulButton, divButton ,
			decButton, equButton, delButton, clrButton};
	private JPanel panel;
	private double num1, num2, result;
	private char operator;
	private Font myFont = new Font("Arial", Font.PLAIN, 25);
	
	public MyCalculator() {
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420, 550);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setBackground(Color.black);
		textField.setForeground(Color.green);
		textField.setBorder(BorderFactory.createLineBorder(Color.green));
		textField.setEditable(false);

		for (int i=0; i<8; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setForeground(Color.green);
			functionButtons[i].setBackground(Color.black);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.green));
		}
		for (int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setForeground(Color.green);
			numberButtons[i].setBackground(Color.black);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.green));
		}
		
		delButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setBackground(Color.black);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		this.setLocationRelativeTo(null);
	    this.add(panel);
		this.add(delButton);
		this.add(clrButton);
		this.add(textField);
		this.setLayout(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
				textField.setText(textField.getText().concat(i+""));
			}
		}
		if(e.getSource()==decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1=Double.parseDouble(textField.getText());
			operator='+';
			textField.setText("");
		}
		if(e.getSource()==subButton) {
			num1=Double.parseDouble(textField.getText());
			operator='-';
			textField.setText("");
		}
		if(e.getSource()==mulButton) {
			num1=Double.parseDouble(textField.getText());
			operator='*';
			textField.setText("");
		}
		if(e.getSource()==divButton) {
			num1=Double.parseDouble(textField.getText());
			operator='/';
			textField.setText("");
		}
		if(e.getSource()==equButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch (operator) {
			case '+': result = num1+num2; break;
			case '-': result = num1-num2; break;
			case '*': result = num1*num2; break;
			case '/': result = num1/num2; break;
			}
			textField.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textField.setText("");
		}		
		if(e.getSource()==delButton) {
			String string = textField.getText().substring(0, textField.getText().length()-1);
			textField.setText(string);			
		}		

	}

}
