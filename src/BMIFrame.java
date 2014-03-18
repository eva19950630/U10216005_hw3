
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class BMIFrame extends JFrame {
	/** Main method */
	public static void main(String[] args) {
		BMIFrame frame = new BMIFrame();
		frame.pack();
		frame.setTitle("BMI");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	// Create text fields for height, weight, BMI, status
	private JTextField jtfHeight = new JTextField();
	private JTextField jtfWeight = new JTextField();
	private JTextField jtfBMI = new JTextField();
	private JTextField jtfStatus = new JTextField();
	
	// Create a Compute BMI button
	private JButton jbtComputeBMI = new JButton("Compute BMI");
	
	// Constructor
	public BMIFrame() {
		
		// Panel p1 to hold labels and text fields(height, weight)
		JPanel p1 = new JPanel(new GridLayout(2, 1));
		p1.setBorder(new TitledBorder("Enter your height and weight"));
		p1.add(new JLabel("Your height in inches"));
		p1.add(jtfHeight);
		p1.add(new JLabel("Your weight in pounds"));
		p1.add(jtfWeight);
		
		// Panel p2 to hold the button
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p2.add(jbtComputeBMI);

		// Panel p3 to hold labels and text fields(BMI, status)
		JPanel p3 = new JPanel(new GridLayout(2, 1));
		p3.setBorder(new TitledBorder("Result"));
		p3.add(new JLabel("Your BMI is"));
		p3.add(jtfBMI);
		p3.add(new JLabel("Status"));
		p3.add(jtfStatus);
		
		// Add the panels to the frame
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		// Register listener
		jbtComputeBMI.addActionListener(new BMIListener());
		
	}
	
	/** Handle the Compute BMI button */
	private class BMIListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// Get values from text fields
			double height = Double.parseDouble(jtfHeight.getText());
			double weight = Double.parseDouble(jtfWeight.getText());
			
			// Create a bmi2 object
			// BMI defined under this class
			BMI bmi2 = new BMI(height, weight);
			
			// Display BMI and status
			jtfBMI.setText(String.format("%.2f" , bmi2.getBMI()));
			jtfStatus.setText(String.format("%s" , bmi2.getStatus()));
			
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
	
	public String getStatus() {
		double bmi = getBMI();
		if (bmi < 18.5)
			return "Underweight";
		else if (bmi < 25)
			return "Normal";
		else if (bmi < 30)
			return "Overweight";
		else
			return "Obese";
	}
	
}

