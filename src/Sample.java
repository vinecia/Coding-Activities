import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Sample extends JFrame implements ActionListener {
	static double tot_sales=0;
	static JButton btnTot = new JButton ("Total");
	
	public static void main (String [] args){
		JFrame frame = new JFrame ("Sample Frame");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel ();
		GridLayout gl = new GridLayout(2,2);
		JLabel lblNum = new JLabel ("Salesman Number:");
		JLabel lblName = new JLabel ("Salesman Name:");
		JLabel lblAmt = new JLabel ("Sales Amount:");
		JTextField txtNum = new JTextField (10);
		JTextField txtName = new JTextField (10);
		JTextField txtAmt = new JTextField (10);
		JTextField txtTot = new JTextField (10);
		panel1.setLayout(gl);
		panel1.add(lblNum); panel1.add(txtNum);
		panel1.add(lblName); panel1.add(txtName);
		
		panel2.setLayout(new FlowLayout());
		panel2.add(lblAmt); panel2.add(txtAmt);
		panel2.add(btnTot); panel2.add(txtTot);
		panel2.add(txtTot);
		frame.setLayout(new BorderLayout());
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		
		btnTot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				double sales = Double.parseDouble(txtAmt.getText());
				tot_sales += sales;
				txtTot.setText(String.valueOf(tot_sales));
			}
		});
		
		frame.setVisible(true);
		frame.setSize(700, 400);
	}
}
