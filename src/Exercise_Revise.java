import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Exercise_Revise extends JFrame implements ActionListener {
	static double tot_sales=0;
	static JButton btnTot = new JButton ("Total");
	static JButton btnAdd = new JButton ("Add");
	static JButton btnNew = new JButton ("New");
	static String info="",name,num;
	public static void main (String [] args){
		JFrame frame = new JFrame ("Sample Frame");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel ();
		JPanel panel3 = new JPanel ();
		GridLayout gl = new GridLayout(2,2);
		GridLayout gl2 = new GridLayout(4,2);
		Font f = new Font (Font.MONOSPACED, Font.BOLD, 13);
		JLabel lblNum = new JLabel ("Salesman Number:");
		JLabel lblName = new JLabel ("Salesman Name:");
		JLabel lblAmt = new JLabel ("Sales Amount:");
		JTextField txtNum = new JTextField (10);
		JTextField txtName = new JTextField (10);
		JTextField txtAmt = new JTextField (10);
		JTextField txtTot = new JTextField (10);
		JTextArea taInfo = new JTextArea("\n\t\tSalesman Number\tSalesman Name\tTotal Sales\n",50,70);
		taInfo.setFont(f);
		taInfo.setEditable(false);
		taInfo.setBackground(Color.decode("#f5f5dc"));
		panel1.setLayout(gl);
		panel1.add(lblNum); panel1.add(txtNum);
		panel1.add(lblName); panel1.add(txtName);
		
		panel2.setLayout(gl2);
		panel2.add(lblAmt); panel2.add(txtAmt);
		panel2.add(btnTot); panel2.add(txtTot);
		panel2.add(txtTot);
		
		panel2.add(btnAdd);panel2.add(btnNew);
	
		panel3.setLayout(new FlowLayout());
		panel3.add(taInfo);
		
		frame.setLayout(new BorderLayout());
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.add(panel3, BorderLayout.CENTER);
		
		btnTot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				txtNum.setEnabled(false);
				txtName.setEnabled(false);
				double sales = Double.parseDouble(txtAmt.getText());
				tot_sales += sales;
				txtTot.setText(String.valueOf(tot_sales));
			}
		});
		
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				num=txtNum.getText();
				name=txtName.getText();
				info+="\t\t"+num+"\t\t"+name+"\t\t"+tot_sales;
				taInfo.append(info+"\n");
			}
		});
		
		btnNew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				txtNum.setEnabled(true);
				txtName.setEnabled(true);
				tot_sales=0;
				txtNum.setText("");
				txtName.setText("");
				txtAmt.setText("");
				txtTot.setText("");
				info="";
			}
		});
		
		frame.setVisible(true);
		frame.setSize(700, 400);
	}
}
