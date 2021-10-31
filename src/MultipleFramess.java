import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("Serial")
public abstract class MultipleFramess extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame1 = new JFrame("Mainframe");
	static double mid, ave, fin;
	static String name, rem;
	static int num;
	static JTextArea txtinfo = new JTextArea(10, 20);
	static JTextField txtnum = new JTextField(10);
	static JTextField txtname = new JTextField(30);
	
	public static void main(String args[]) {
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel lblnum = new JLabel("Student no: ");
		JLabel lblname = new JLabel("Student name: ");
		
		panel1.setLayout(new GridLayout(2, 2));
		panel1.add(lblnum); panel1.add(txtnum);
		panel1.add(lblname); panel1.add(txtname);
		
		JButton btncomp = new JButton("Compute");
		JButton btngrade = new JButton("Grade");
		JButton btnadd = new JButton("Add");
		JButton btnview = new JButton("View");
		
		panel2.setLayout(new BorderLayout());
		panel2.add(txtinfo, BorderLayout.NORTH);
		
		panel3.setLayout(new GridLayout(2, 2));
		panel3.add(btncomp); panel3.add(btngrade);
		panel3.add(btnadd); panel3.add(btnview);
		
		panel2.add(panel3, BorderLayout.SOUTH);
		
		frame1.setLayout(new GridLayout(2, 2));
		frame1.add(panel1); frame1.add(panel2);
		frame1.setVisible(true);
		frame1.setSize(500, 600);
		
		btngrade.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae){
				JFrame frame2 = new JFrame("2nd Frame");
				JButton btnret = new JButton("Return");
				JTextField txtmid = new JTextField(10);
				JTextField txtfin = new JTextField(10);
				JLabel lblmid = new JLabel("Midterm Grade: ");
				JLabel lblfin = new JLabel("Final Grade: ");
				
				JPanel panel4 = new JPanel();
				
				panel4.setLayout(new GridLayout(3, 2));
				panel4.add(lblmid); panel4.add(txtmid);
				panel4.add(lblfin); panel4.add(txtfin);
				panel4.add(btnret);
				
				frame2.add(panel4);
				frame1.hide();
				frame2.setSize(200, 200);
				frame2.show(true);
				
				btnret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						mid = Double.parseDouble(txtmid.getText());
						fin = Double.parseDouble(txtfin.getText());
						frame2.hide();
						frame1.setSize(400, 400);
						frame1.show(true);
						
					}
					
					});
				}
			});	
				
				btncomp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						num = Integer.parseInt(txtnum.getText());
						name = txtname.getText();
						ave = (double)(mid + fin)/2;
						if (ave<=3.12)
							rem = "Passed";
						else
							rem = "Failed";
				
					}

				});
				
				btnadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						cls_AddRecord();
					}
				});
				
				btnview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						cls_ViewRecord();
					}
				});	
					
	
	}
	
	protected static void cls_ViewRecord() {
		
		try {
			txtinfo.setText("");
			File fyl = new File("Grades.txt");
			BufferedReader br = new BufferedReader(new FileReader(fyl));
			String line = br.readLine();
			
			while(line!=null) {
				txtinfo.append(line);
				txtinfo.append("\n");
				line = br.readLine();
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "File does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}	
	protected static void cls_AddRecord() {
		int no;
		String neym, rmk;
		double average;
		try {
			File fyl = new File("Grades.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(fyl, true));
			cls_StudGrd sg = new cls_StudGrd();
			if(fyl.canWrite()) {
				no = num;
				neym = name;
				average = ave;
				rmk = rem;
				bw.append(no + "\t" + neym + "\t" + average +"\t"+ rmk +"\n");
				bw.newLine();
				JOptionPane.showMessageDialog(null, "Record added successfully!", "Confirm", JOptionPane.INFORMATION_MESSAGE);
			}
				txtnum.setText("");
				txtname.setText("");
			bw.close();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Cannot add record", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
}
	



















