package raynal.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ScientificCalculator extends JFrame implements ActionListener, ItemListener{
	private static final long serialVersionUID = 1L;
	
//	JLabel label;
	JTextField display;
	double temp, temp1, m, result;
	boolean floatCalc, mDoubleFlag, radianFlag;
	char ch;
	
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, 
			pow2, pow3, oneByX, sqrt,
			fact, log, ln, dot, e,  pi,
			plus, minus, mul, div, mod, 
			mr, mc, mPlus, mMinus, 
			sin, cos, tan, 
			clr, equals;
	
	JToggleButton degree, inverse;
	
	Container container;
	JPanel textPanel, buttonPanel;
	
	
	public ScientificCalculator() {
		try {   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());   }
		catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
		
		m = 0;
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src\\resources\\calc-icon.png").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		setIconImage(icon);
		setTitle("Scientific Calculator");
		container = getContentPane();
		container.setLayout(new BorderLayout());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	public void createAndShowGUI() {
		textPanel = new JPanel();
//		label = new JLabel("", SwingConstants.LEFT);
		display = new JTextField(36);
		display.setHorizontalAlignment(JTextField.RIGHT);
		textPanel.add(display);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(9, 4, 3, 3));
		
		container.add(textPanel, BorderLayout.NORTH);
		container.add(buttonPanel, BorderLayout.CENTER);
		
		mc = new JButton("MC");
		mc.addActionListener(this);
		buttonPanel.add(mc);
		
		mPlus = new JButton("M+");
		mPlus.addActionListener(this);
		buttonPanel.add(mPlus);
		
		mMinus = new JButton("M-");
		mMinus.addActionListener(this);
		buttonPanel.add(mMinus);
		
		mr = new JButton("MR");
		mr.addActionListener(this);
		buttonPanel.add(mr);
		
		clr = new JButton("C");
		clr.addActionListener(this);
		buttonPanel.add(clr);
		
		div = new JButton("/");
		div.addActionListener(this);
		buttonPanel.add(div);
		
		mul = new JButton("*");
		mul.addActionListener(this);
		buttonPanel.add(mul);
		
		mod = new JButton("%");
		mod.addActionListener(this);
		buttonPanel.add(mod);
		
		b7 = new JButton("7");
		b7.addActionListener(this);
		buttonPanel.add(b7);
		
		b8 = new JButton("8");
		b8.addActionListener(this);
		buttonPanel.add(b8);
		
		b9 = new JButton("9");
		b9.addActionListener(this);
		buttonPanel.add(b9);
		
		minus = new JButton("-");
		minus.addActionListener(this);
		buttonPanel.add(minus);
		
		b4 = new JButton("4");
		b4.addActionListener(this);
		buttonPanel.add(b4);
		
		b5 = new JButton("5");
		b5.addActionListener(this);
		buttonPanel.add(b5);
		
		b6 = new JButton("6");
		b6.addActionListener(this);
		buttonPanel.add(b6);
		
		plus = new JButton("+");
		plus.addActionListener(this);
		buttonPanel.add(plus);
		
		b1 = new JButton("1");
		b1.addActionListener(this);
		buttonPanel.add(b1);
		
		b2 = new JButton("2");
		b2.addActionListener(this);
		buttonPanel.add(b2);
		
		b3 = new JButton("3");
		b3.addActionListener(this);
		buttonPanel.add(b3);
		
		equals = new JButton("=");
		equals.addActionListener(this);
		equals.setBackground(new Color(0,191,255));
//		equals.setBorder(new LineBorder(new Color(0,191,255), 2));
		buttonPanel.add(equals);
		
		inverse = new JToggleButton("inverse");
		inverse.addItemListener(this);
		buttonPanel.add(inverse);
		
		b0 = new JButton("0");
		b0.addActionListener(this);
		buttonPanel.add(b0);
		
		dot = new JButton(".");
		dot.addActionListener(this);
		buttonPanel.add(dot);
		
		degree = new JToggleButton("Deg");
		degree.addItemListener(this);
		buttonPanel.add(degree);
		
		e = new JButton("e");
		e.addActionListener(this);
		buttonPanel.add(e);

		ln = new JButton("ln");
		ln.addActionListener(this);
		buttonPanel.add(ln);
		
		log = new JButton("log");
		log.addActionListener(this);
		buttonPanel.add(log);
		
		pi = new JButton("pi");
		pi.addActionListener(this);
		buttonPanel.add(pi);
		
		sin = new JButton("sin");
		sin.addActionListener(this);
		buttonPanel.add(sin);
		
		cos = new JButton("cos");
		cos.addActionListener(this);
		buttonPanel.add(cos);
		
		tan = new JButton("tan");
		tan.addActionListener(this);
		buttonPanel.add(tan);
		
		sqrt = new JButton("Sqrt");
		sqrt.addActionListener(this);
		buttonPanel.add(sqrt);
	
		pow2 = new JButton("pow2");
		pow2.addActionListener(this);
		buttonPanel.add(pow2);
		
		pow3 = new JButton("pow3");
		pow3.addActionListener(this);
		buttonPanel.add(pow3);
		
		oneByX = new JButton("1 / X");
		oneByX.addActionListener(this);
		buttonPanel.add(oneByX);
		
		fact = new JButton("n !");
		fact.addActionListener(this);
		buttonPanel.add(fact);
		
		
//		pack();
		setSize(350, 350);
		setResizable(false);
	}
	
	
	public static void main(String[] args) {
		new ScientificCalculator();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			display.setText(display.getText() + "1");
		}
		
		if(e.getSource() == b2) {
			display.setText(display.getText() + "2");
		}
		
		if(e.getSource() == b3) {
			display.setText(display.getText() + "3");
		}
		
		if(e.getSource() == b4) {
			display.setText(display.getText() + "4");
		}
		
		if(e.getSource() == b5) {
			display.setText(display.getText() + "5");
		}
		
		if(e.getSource() == b6) {
			display.setText(display.getText() + "6");
		}
		
		if(e.getSource() == b7) {
			display.setText(display.getText() + "7");
		}
		
		if(e.getSource() == b8) {
			display.setText(display.getText() + "8");
		}
		
		if(e.getSource() == b9) {
			display.setText(display.getText() + "9");
		}
		
		if(e.getSource() == b0) {
			display.setText(display.getText() + "0");
		}
		
		if(e.getSource() == clr) {
			display.setText("");
			floatCalc = false;				//floatCalc is a flag which tells if there is a floating point number present, hence the answer calculated will then also be a float/double
		}
		
		if(e.getSource() == mc) {
			m = 0;
			mDoubleFlag = false;			//mDoubleFlag is a flag on top of the FloatCalcFlag, as floatCalc Flag resets when C is pressed, mDoubleFlag keeps track if m is a float
			display.setText("");
		}
		
		if(e.getSource() == mr) {
			if(mDoubleFlag) {
				display.setText("" + m);
			}
			else {
				if(floatCalc) {
					display.setText("" + m);
					mDoubleFlag = true;
				}
				else {
					display.setText("" + (int)m);
				}
			}
		}
		
		if(e.getSource() == mPlus) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				m += Double.parseDouble(display.getText());
				if(mDoubleFlag || floatCalc) {
					mDoubleFlag = true;
					display.setText("" + m);
				}
				else {
					display.setText("" + (int) m);
				}
			}
		}
		
		if(e.getSource() == mMinus) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				m -= Double.parseDouble(display.getText());
				if(mDoubleFlag || floatCalc) {
					mDoubleFlag = true;
					display.setText("" + m);
				}
				else {
					display.setText("" + (int) m);
				}
			}
		}
		
		if(e.getSource() == plus) {
			if(display.getText().equals("")){
				temp = 0;
				display.setText("");
			}
			else {
				temp = Double.parseDouble(display.getText());
				display.setText("");
			}
			ch = '+';
		}
		
		if(e.getSource() == minus) {
			if(display.getText().equals("")){
				temp = 0;
				display.setText("");
			}
			else {
				temp = Double.parseDouble(display.getText());
				display.setText("");
			}
			ch = '-';
		}
		
		if(e.getSource() == mul) {
			if(display.getText().equals("")){
				temp = 1;
				display.setText("");
			}
			else {
				temp = Double.parseDouble(display.getText());
				display.setText("");
				
			}
			ch = '*';
		}
		
		if(e.getSource() == div) {
			if(display.getText().equals("")){
				temp = 1;
				display.setText("");
				
			}
			else {
				temp = Double.parseDouble(display.getText());
				display.setText("");
			}
			ch = '/';
		}
		
		if(e.getSource() == mod){
			if(display.getText().equals("")) {
				temp = 1;
				display.setText("");
			}
			else {
				temp = Double.parseDouble(display.getText());
				display.setText("");
			}
			ch = '%';
			
		}
		
		if(e.getSource() == dot) {
			if(display.getText().equals("")) {
				display.setText("0.");
			}
			else {
				display.setText(display.getText() + ".");
			}
			floatCalc = true;
		}
		
		if(e.getSource() == e) {
			double d = Math.E;
			System.out.println(d);
			display.setText("" + d);
			floatCalc = true;
		}
		
		if(e.getActionCommand().equals("ln")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d = Math.log(Double.parseDouble(display.getText()));
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getActionCommand().equals("e^x")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d = Math.exp(Double.parseDouble(display.getText()));
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getActionCommand().equals("log")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d = Math.log10(Double.parseDouble(display.getText()));
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getActionCommand().equals("10^x")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d = Math.pow(10, Double.parseDouble(display.getText()));
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getSource() == pi) {
			display.setText("" + Math.PI);
			floatCalc = true;
		}
		
		if(e.getActionCommand().equals("sin")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d;
				if(radianFlag)							//radian flag notifies if calc is set to Degrees or Radians
					d = Math.sin(Double.parseDouble(display.getText()));
				else
					d = Math.sin(Math.toRadians(Double.parseDouble(display.getText())));
				
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getActionCommand().equals("sin^-1")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d;
				if(radianFlag)
					d = Math.asin(Double.parseDouble(display.getText()));
				else
					d = Math.asin(Math.toRadians(Double.parseDouble(display.getText())));
				
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getSource() == cos) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d;
				if(radianFlag)
					d = Math.cos(Double.parseDouble(display.getText()));
				else
					d = Math.cos(Math.toRadians(Double.parseDouble(display.getText())));
				
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getActionCommand().equals("cos^-1")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d;
				if(radianFlag)
					d = Math.acos(Double.parseDouble(display.getText()));
				else
					d = Math.acos(Math.toRadians(Double.parseDouble(display.getText())));
				
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getSource() == tan) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d;
				if(radianFlag)
					d = Math.tan(Double.parseDouble(display.getText()));
				else
					d = Math.tan(Math.toRadians(Double.parseDouble(display.getText())));
				
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getActionCommand().equals("tan^-1")) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d;
				if(radianFlag)
					d = Math.atan(Double.parseDouble(display.getText()));
				else
					d = Math.atan(Math.toRadians(Double.parseDouble(display.getText())));
				
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getSource() == sqrt) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d = Math.sqrt(Double.parseDouble(display.getText()));
				display.setText("" + d);
			}
		}
		
		if(e.getSource() == pow2) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d = Math.pow(Double.parseDouble(display.getText()), 2);
				display.setText("" + d);
			}
		}
		
		if(e.getSource() == pow3) {
			if(display.getText().equals("")){
				display.setText("");
			}
			else {
				double d = Math.pow(Double.parseDouble(display.getText()), 3);
				display.setText("" + d);
			}
		}
		
		if(e.getSource() == oneByX) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				double d  = 1 / Double.parseDouble(display.getText());
				display.setText("" + d);
				floatCalc = true;
			}
		}
		
		if(e.getSource() == fact) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				if(floatCalc) {
					display.setText("Error");
				}
				else {
					int i = Integer.parseInt(display.getText());
					int fact_result = 1;
				
					while(i > 0) {
						fact_result *= i;
						i--;
					}
					
					display.setText("" + fact_result);
				}
			}
		}
		
		if(e.getSource() == equals) {
			if(display.getText().equals("")) {
				display.setText("");
			}
			else {
				temp1 = Double.parseDouble(display.getText());
				switch(ch) {
				case '+':
					result = temp + temp1;
					break;
				case '-':
					result = temp + temp1;
					break;
				case '*':
					result = temp * temp1;
					break;
				case '/':
					result = temp * temp1;
					break;
				case '%':
					result = temp % temp1;
				}
				
				if(floatCalc) {
					display.setText("" + result);
				}
				else {
					display.setText("" + (int) result);
				}
			}
		}
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == inverse) {
			if(inverse.isSelected()) {
				inverse.setText("INV");
				inverse.setForeground(Color.RED);
				
				ln.setText("e^x");
				log.setText("10^x");
				sin.setText("sin^-1");
				cos.setText("cos^-1");
				tan.setText("tan^-1");
				
			}
			else {
				inverse.setText("inverse");
				inverse.setForeground(Color.BLACK);
				
				ln.setText("ln");
				log.setText("log");
				sin.setText("sin");
				cos.setText("cos");
				tan.setText("tan");
			}
		}
		
		if(e.getSource() == degree) {
			if(degree.isSelected()) {
				degree.setText("Rad");
				degree.setForeground(Color.RED);
				
				radianFlag = true;
			}
			else {
				degree.setText("Deg");
				degree.setForeground(Color.BLACK);
				
				radianFlag = false;
			}
		}
	}

}
