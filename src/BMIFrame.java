
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

public class BMIFrame extends JFrame {

	public static void main(String[] args) {

		BMIFrame frame = new BMIFrame();
		frame.pack();
		frame.setTitle("BMI");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JTextField jtfHeight = new JTextField();
	private JTextField jtfWeight = new JTextField();
	private JTextField jtfBMI = new JTextField();
	
	private JButton jbtComputeBMI = new JButton("Compute BMI");
	
	public BMIFrame() {
		
		
		
		JPanel p1 = new JPanel(new GridLayout(5, 2));
		p1.add(new JLabel("Height in meters"));
		p1.add(jtfHeight);
		p1.add(new JLabel("Weight in kilograms"));
		p1.add(jtfWeight);
		p1.add(new JLabel("Your BMI is"));
		p1.add(jtfBMI);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtComputeBMI);

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		jbtComputeBMI.addActionListener(new BMIListener());
		
	}
	
	
	private class BMIListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double height = Double.parseDouble(jtfHeight.getText());
			double weight = Double.parseDouble(jtfWeight.getText());
			
			BMI bmi2 = new BMI(height, weight);
			
			jtfBMI.setText(String.format("%.2f" , bmi2.getBMI()));
			
		}
		
	}
	
	
}

class BMI {
	
	private double weight;
	private double height;

	public static final double KILOGRAMS_PER_POUND = 0.45359237;
	public static final double METERS_PER_INCH = 0.0254;
	
	public BMI(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public double getBMI() {
		double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH)*(height * METERS_PER_INCH));
		return Math.round(bmi * 100) / 100.0;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getHeight() {
		return height;
	}
	
}

