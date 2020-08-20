import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculatorGui extends JFrame implements ActionListener
{
	private JButton off, ac, openningBr, closingBr, arrowBack, mPlus, mMinus, mc, mr, powButton, divButton, mulButton, minusButton, plusButton, equalButton, pointButton, zero, one, two, three, four, five, six, seven, eight, nine;
	private JPanel panel;
	private JLabel inputLabel, outputLabel, signLabel;
	private Font customFont1, customFont1Big, customFont1Small, customFont1Smaller, customFont1Smallest;
	private String input;
	private double number1, number2, memory;
	private DecimalFormat df = new DecimalFormat("###.######");
	int sign = 0;
	public CalculatorGui(String title)
	{
		super(title);
		this.setSize(435, 380);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		
		customFont1 = new Font("Arial", Font.BOLD, 18);
		customFont1Big = new Font("Arial", Font.BOLD, 24);
		customFont1Small = new Font("Arial", Font.BOLD, 16);
		customFont1Smaller = new Font("Arial", Font.BOLD, 14);
		customFont1Smallest = new Font("Arial", Font.BOLD, 12);

		input = "";

		signLabel = new JLabel("");
		signLabel.setFont(customFont1Small);
		signLabel.setForeground(Color.WHITE);
		signLabel.setBounds(395, 25, 15, 15);
		panel.add(signLabel);

		outputLabel = new JLabel("");
		outputLabel.setFont(customFont1);
		outputLabel.setBackground(Color.BLACK);
		outputLabel.setForeground(Color.BLACK);
		outputLabel.setOpaque(true);
		outputLabel.setBounds(225, 10, 185, 35);
		panel.add(outputLabel);

		inputLabel = new JLabel(" " + input);
		inputLabel.setFont(customFont1Big);
		inputLabel.setBackground(Color.WHITE);
		inputLabel.setOpaque(true);
		inputLabel.setBounds(20, 50, 390, 45);
		panel.add(inputLabel);
		
		off = new JButton("OFF");
		off.setFont(customFont1);
		off.setBounds(20, 120, 100, 35);
		off.setBackground(new Color(226,0,0));
		off.setForeground(Color.WHITE);
		off.setOpaque(true);
		off.addActionListener(this);
		panel.add(off);
		
		ac = new JButton("AC");
		ac.setFont(customFont1);
		ac.setBackground(new Color(133,1,1));
		ac.setForeground(Color.WHITE);
		ac.setBounds(130, 120, 100, 35);
		ac.addActionListener(this);
		panel.add(ac);
		
		arrowBack = new JButton("<");
		arrowBack.setBackground(new Color(133,1,1));
		arrowBack.setForeground(Color.WHITE);
		arrowBack.setFont(customFont1);
		arrowBack.setBounds(240, 120, 90, 35);
		arrowBack.addActionListener(this);
		panel.add(arrowBack);

		powButton = new JButton("^");
		powButton.setFont(customFont1);
		powButton.setBounds(340, 120, 70, 35);
		powButton.setBackground(new Color(20,92,8));
		powButton.setForeground(Color.WHITE);
		powButton.addActionListener(this);
		panel.add(powButton);
		
		mPlus = new JButton("M+");
		mPlus.setFont(customFont1);
		mPlus.setBounds(20, 165, 70, 35);
		mPlus.setBackground(new Color(26,22,112));
		mPlus.setForeground(Color.WHITE);
		mPlus.addActionListener(this);
		panel.add(mPlus);
		
		seven = new JButton("7");
		seven.setFont(customFont1);
		seven.setBounds(100, 165, 70, 35);
		seven.setBackground(new Color(56,56,56));
		seven.setForeground(Color.WHITE);
		seven.addActionListener(this);
		panel.add(seven);
		
		eight = new JButton("8");
		eight.setFont(customFont1);
		eight.setBounds(180, 165, 70, 35);
		eight.setBackground(new Color(56,56,56));
		eight.setForeground(Color.WHITE);
		eight.addActionListener(this);
		panel.add(eight);
		
		nine = new JButton("9");
		nine.setFont(customFont1);
		nine.setBounds(260, 165, 70, 35);
		nine.setBackground(new Color(56,56,56));
		nine.setForeground(Color.WHITE);
		nine.addActionListener(this);
		panel.add(nine);
		
		divButton = new JButton("/");
		divButton.setFont(customFont1);
		divButton.setBounds(340, 165, 70, 35);
		divButton.setBackground(new Color(20,92,8));
		divButton.setForeground(Color.WHITE);
		divButton.addActionListener(this);
		panel.add(divButton);
		
		mMinus = new JButton("M-");
		mMinus.setFont(customFont1);
		mMinus.setBounds(20, 210, 70, 35);
		mMinus.setBackground(new Color(26,22,112));
		mMinus.setForeground(Color.WHITE);
		mMinus.addActionListener(this);
		panel.add(mMinus);
		
		four = new JButton("4");
		four.setFont(customFont1);
		four.setBounds(100, 210, 70, 35);
		four.setBackground(new Color(56,56,56));
		four.setForeground(Color.WHITE);
		four.addActionListener(this);
		panel.add(four);
		
		five = new JButton("5");
		five.setFont(customFont1);
		five.setBounds(180, 210, 70, 35);
		five.setBackground(new Color(56,56,56));
		five.setForeground(Color.WHITE);
		five.addActionListener(this);
		panel.add(five);
		
		six = new JButton("6");
		six.setFont(customFont1);
		six.setBounds(260, 210, 70, 35);
		six.setBackground(new Color(56,56,56));
		six.setForeground(Color.WHITE);
		six.addActionListener(this);
		panel.add(six);
		
		mulButton = new JButton("x");
		mulButton.setFont(customFont1);
		mulButton.setBounds(340, 210, 70, 35);
		mulButton.setBackground(new Color(20,92,8));
		mulButton.setForeground(Color.WHITE);
		mulButton.addActionListener(this);
		panel.add(mulButton);
		
		mc = new JButton("MC");
		mc.setFont(customFont1);
		mc.setBounds(20, 255, 70, 35);
		mc.setBackground(new Color(26,22,112));
		mc.setForeground(Color.WHITE);
		mc.addActionListener(this);
		panel.add(mc);
		
		one = new JButton("1");
		one.setFont(customFont1);
		one.setBounds(100, 255, 70, 35);
		one.setBackground(new Color(56,56,56));
		one.setForeground(Color.WHITE);
		one.addActionListener(this);
		panel.add(one);
		
		two = new JButton("2");
		two.setFont(customFont1);
		two.setBounds(180, 255, 70, 35);
		two.setBackground(new Color(56,56,56));
		two.setForeground(Color.WHITE);
		two.addActionListener(this);
		panel.add(two);
		
		three = new JButton("3");
		three.setFont(customFont1);
		three.setBounds(260, 255, 70, 35);
		three.setBackground(new Color(56,56,56));
		three.setForeground(Color.WHITE);
		three.addActionListener(this);
		panel.add(three);
		
		minusButton = new JButton("-");
		minusButton.setFont(customFont1);
		minusButton.setBounds(340, 255, 70, 35);
		minusButton.setBackground(new Color(20,92,8));
		minusButton.setForeground(Color.WHITE);
		minusButton.addActionListener(this);
		panel.add(minusButton);
		
		mr = new JButton("MR");
		mr.setFont(customFont1);
		mr.setBounds(20, 300, 70, 35);
		mr.setBackground(new Color(26,22,112));
		mr.setForeground(Color.WHITE);
		mr.setOpaque(true);
		mr.addActionListener(this);
		panel.add(mr);
		
		zero = new JButton("0");
		zero.setFont(customFont1);
		zero.setBounds(100, 300, 70, 35);
		zero.setBackground(new Color(56,56,56));
		zero.setForeground(Color.WHITE);
		zero.addActionListener(this);
		panel.add(zero);
		
		pointButton = new JButton(".");
		pointButton.setFont(customFont1);
		pointButton.setBounds(180, 300, 70, 35);
		pointButton.setBackground(new Color(56,56,56));
		pointButton.setForeground(Color.WHITE);
		pointButton.addActionListener(this);
		panel.add(pointButton);
		
		equalButton = new JButton("=");
		equalButton.setFont(customFont1);
		equalButton.setBounds(260, 300, 70, 35);
		equalButton.setBackground(new Color(80,80,80));
		equalButton.setForeground(Color.WHITE);
		equalButton.addActionListener(this);
		panel.add(equalButton);
		
		plusButton = new JButton("+");
		plusButton.setFont(customFont1);
		plusButton.setBounds(340, 300, 70, 35);
		plusButton.setBackground(new Color(20,92,8));
		plusButton.setForeground(Color.WHITE);
		plusButton.addActionListener(this);
		panel.add(plusButton);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == off)
		{
			System.exit(0);
		}
		else if(ae.getSource() == one)
		{
			inputAdd('1');
		}
		else if(ae.getSource() == two)
		{
			inputAdd('2');
		}
		else if(ae.getSource() == three)
		{
			inputAdd('3');
		}
		else if(ae.getSource() == four)
		{
			inputAdd('4');
		}
		else if(ae.getSource() == five)
		{
			inputAdd('5');
		}
		else if(ae.getSource() == six)
		{
			inputAdd('6');
		}
		else if(ae.getSource() == seven)
		{
			inputAdd('7');
		}
		else if(ae.getSource() == eight)
		{
			inputAdd('8');
		}
		else if(ae.getSource() == nine)
		{
			inputAdd('9');
		}
		else if(ae.getSource() == zero)
		{
			if(input.length() > 0)
			{
				if(((input.charAt(input.length()-1)) >= '0' && (input.charAt(input.length()-1) <= '9')) || input.charAt(input.length()-1) == '.')
					inputAdd('0');
			}
		}
		else if(ae.getSource() == pointButton)
		{
			if(input.length() > 0)
			{
				boolean validPoint = true;
				for(int i = input.length()-1; i >= 0 && ((input.charAt(i) >= '0' && input.charAt(i) <= '9') || input.charAt(i) == '.'); i--)
				{
					if(input.charAt(i) == '.')
					{
						validPoint = false;
						break;
					}
				}
				if(validPoint)
				{
					if(input.charAt(input.length()-1) >= '0' && input.charAt(input.length()-1) <= '9')
						inputAdd('.');
					else if(input.charAt(input.length()-1) != '.')
					{
						input += '0';
						inputAdd('.');
					}
				}
			}
			else
			{
				input += '0';
				inputAdd('.');
			}
		}
		else if(ae.getSource() == powButton)
		{
			signClicked(4);
		}
		else if(ae.getSource() == divButton)
		{
			signClicked(3);
		}
		else if(ae.getSource() == mulButton)
		{
			signClicked(2);
		}
		else if(ae.getSource() == minusButton)
		{
			signClicked(1);
		}
		else if(ae.getSource() == plusButton)
		{
			signClicked(0);
		}
		else if(ae.getSource() == arrowBack)
		{
			try
			{
				input = input.substring(0,input.length()-1);
				inputAdd('!');
			}
			catch(Exception ex)
			{
				arrowBack.setEnabled(false);
				outputLabel.setBackground(Color.BLACK);
				outputLabel.setForeground(Color.BLACK);
			}
		}
		else if(ae.getSource() == equalButton)
		{
			operate();
			sign = 0;
			input = "";
			signLabel.setText("");
		}
		else if(ae.getSource() == ac)
		{
			input = "";
			outputLabel.setBackground(Color.BLACK);
			outputLabel.setForeground(Color.BLACK);
			outputLabel.setText("");
			signLabel.setText("");
			number1 = 0;
			number2 = 0;
			inputAdd('!');
		}
		else if(ae.getSource() == mr)
		{
			memory = number1;
		}
		else if(ae.getSource() == mc)
		{
			memory = 0.0;
		}
		else if(ae.getSource() == mPlus)
		{
			number1 = memory;
			sign = 0;
			signLabel.setText("+");
			operate();
		}
		else if(ae.getSource() == mMinus)
		{
			number1 = memory;
			sign = 1;
			signLabel.setText("-");
			operate();
		}
	}
	public void inputAdd(char symbol)
	{
		if(symbol != '!') input += symbol;
		if(input.length() > 42) inputLabel.setFont(customFont1Smallest);
		else if(input.length() > 37) inputLabel.setFont(customFont1Small);
		else if(input.length() > 28) inputLabel.setFont(customFont1);
		else inputLabel.setFont(customFont1Big);
		inputLabel.setText(" " + input);
		if(!input.isEmpty()) number2 = Double.parseDouble(input);
		else number2 = 0;
		arrowBack.setEnabled(true);
	}
	public void signClicked(int operator)
	{
		if(operator == 0) signLabel.setText("+");
		else if(operator == 1) signLabel.setText("-");
		else if(operator == 2) signLabel.setText("x");
		else if(operator == 3) signLabel.setText("/");
		else if(operator == 4) signLabel.setText("^");
		operate();
		sign = operator;
		input = "";
	}
	public void operate()
	{
		boolean infinity = false;
		if(sign == 0)
		{
			number1 = number1 + number2;
		}
		else if(sign == 1)
		{
			number1 = number1 - number2;
		} 
		else if(sign == 2)
		{
			number1 = number1 * number2;
		} 
		else if(sign == 3)
		{
			if(number2 != 0.0) number1 = number1 / number2;
			else
			{
				number1 = 0;
				infinity = true;
			}
		} 
		else if(sign == 4)
		{
			number1 = Math.pow(number1 , number2);
		} 
		number2 = 0.0;
		outputLabel.setBackground(new Color(50,50,50));
		outputLabel.setForeground(Color.WHITE);
		
		if(!infinity)
		{
			if(Math.ceil(number1) == Math.floor(number1)) outputLabel.setText(" =   "+(long)number1);
			else outputLabel.setText(" =   "+df.format(number1));
		}
		else outputLabel.setText(" =   infinity");
	}
}