import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public abstract class Employee extends JFrame implements ActionListener{
	static String ename;
	static int hr=0,eno=0;
	static double rate, gp, deduc, net;
	static JFrame frame1 = new JFrame("MAIN");
	static JTextArea txtInfo = new JTextArea(10,50);
	
	public static void main (String [] args) {
		JPanel panel1 = new JPanel();
		
		JButton btnInfo = new JButton("EMPLOYEE INFO");
		JButton btnRh = new JButton("EMPLOYEE RATE AND HOUR");
		JButton btnCom = new JButton("COMPUTE");
		JButton btnVie = new JButton("VIEW");
		panel1.setLayout(new GridLayout(4,1));
		panel1.add(btnInfo); panel1.add(btnRh);
		panel1.add(btnCom); panel1.add(btnVie);
		frame1.add(panel1);
		frame1.setVisible(true);
		frame1.setSize(300,200);
		
		btnInfo.addActionListener(new ActionListener()
		{ @SuppressWarnings("deprecation")
		  public void actionPerformed(ActionEvent ae){
		  JFrame frame2 = new JFrame("EMPLOYEE INFO");
		  JButton btnBac = new JButton("BACK");
		  JLabel lblNo = new JLabel("Employee No: ");
		  JLabel lblName = new JLabel("Employee Name: ");
		  JTextField txtNo = new JTextField (15);
		  JTextField txtName = new JTextField (15);
		  JPanel panel2 = new JPanel();
		  panel2.setLayout(new GridLayout(3,2));
		  panel2.add(lblNo); panel2.add(txtNo);
		  panel2.add(lblName); panel2.add(txtName);
		  panel2.add(btnBac);
		  frame2.add(panel2);
		  frame1.hide();
		  frame2.setSize(400,150);
		  frame2.show(true);
		  btnBac.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent ae){
				 // if (ename == " "|eno==0)
				//	  JOptionPane.showMessageDialog(null, "Incomplete Input!", "Error", JOptionPane.ERROR_MESSAGE);
				  eno = Integer.parseInt(txtNo.getText());
				  ename = txtName.getText();
				  
				 // else
				  frame2.hide();
				  frame1.show(true); 
				  
			  }
		  });
		}
		});
		
		btnRh.addActionListener(new ActionListener()
		{  @SuppressWarnings("deprecation")
		  public void actionPerformed(ActionEvent ae){
			  JFrame frame3 = new JFrame("RATE & HOUR");
			  JButton btnBac = new JButton("BACK");
			  JLabel lblRt = new JLabel("Rate: ");
			  JLabel lblHr = new JLabel("Hour: ");
			  JTextField txtRt = new JTextField (15);
			  JTextField txtHr = new JTextField (15);
			  JPanel panel3 = new JPanel();
			  panel3.setLayout(new GridLayout(3,2));
			  panel3.add(lblRt); panel3.add(txtRt);
			  panel3.add(lblHr); panel3.add(txtHr);
			  panel3.add(btnBac);
			  frame3.add(panel3);
			  frame1.hide();
			  frame3.setSize(400,150);
			  frame3.show(true);
			  btnBac.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent ae){
					  rate = Double.parseDouble(txtRt.getText());
					  hr = Integer.parseInt(txtHr.getText());
					  frame3.hide();
					  frame1.show(true);
				  }
			  });
		  }
	});
		
		btnCom.addActionListener(new ActionListener()
		{  @SuppressWarnings("deprecation")
		  public void actionPerformed(ActionEvent ae){
			  JFrame frame4 = new JFrame("COMPUTE");
			  JButton btnGp = new JButton("Gross Pay");
			  JButton btnNet = new JButton("Net Pay");
			  JButton btnAdd = new JButton("ADD TO FILE");
			  JButton btnBac = new JButton("BACK");
			  JLabel lblDeduc = new JLabel("Deduction: ");
			  JTextField txtGp = new JTextField (10);
			  JTextField txtDeduc = new JTextField (10);
			  JTextField txtNet = new JTextField (10);
			  JPanel panel4 = new JPanel();
			  panel4.setLayout(new GridLayout(4,4));
			  panel4.add(btnGp); panel4.add(txtGp);
			  panel4.add(lblDeduc); panel4.add(txtDeduc);
			  panel4.add(btnNet); panel4.add(txtNet);
			  panel4.add(btnAdd); panel4.add(btnBac);
			  frame4.add(panel4);
			  frame1.hide();
			  frame4.setSize(400,200);
			  frame4.show(true);
			  
			  btnGp.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent ae){
					  gp = rate*hr;
					  txtGp.setText(String.valueOf(gp));
				  }
			  });
			  
			  btnNet.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent ae){
					  deduc = Double.parseDouble(txtDeduc.getText());
					  net = gp-deduc;
					  txtNet.setText(String.valueOf(net));
				  }
			  });
			  
			  btnAdd.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent ae){
					 txtGp.setText(null);
					 txtDeduc.setText(null);
					 txtNet.setText(null);
					 cls_AddRecord();
				  }
			  });
			  
			  btnBac.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent ae){
					  frame4.hide();
					  frame1.show(true);
				  }
			  });
		}
		});
		
		btnVie.addActionListener(new ActionListener()
		{  @SuppressWarnings("deprecation")
		  public void actionPerformed(ActionEvent ae){
			  JFrame frame5 = new JFrame("VIEW");
			  JButton btnBac = new JButton("BACK");
			  
			  frame5.setLayout(new BorderLayout());
			  frame5.add(txtInfo,BorderLayout.CENTER); frame5.add(btnBac,BorderLayout.SOUTH);
			  
			  frame5.setSize(500,400);
			  frame5.setVisible(true);
			  frame1.hide();
			  frame5.show(true);
			  cls_ViewRecord();
			  
			  btnBac.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent ae){
					  frame5.hide();
					  frame1.show(true);
				  }
			  });
		}
		});
		
			
}
	protected static void cls_ViewRecord() {
		
		try {
			
			txtInfo.setText("");
			File fyl = new File("Employee.txt");
			BufferedReader br = new BufferedReader(new FileReader(fyl));
			String line = br.readLine();
			
			while(line!=null) {
				txtInfo.append(line);
				txtInfo.append("\n");
				line = br.readLine();
			}
			br.close();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "File does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	protected static void cls_AddRecord() {
		int enoo;
		String eneym;
		double gpp, nett;
		try {
			File fyl = new File("Employee.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(fyl, true));
			EmInfo em = new EmInfo();
			if(fyl.canWrite()) {
				em.setEname(ename);
				em.setEno(eno);
				em.setGross(gp);
				em.setNet(net);
				eneym = em.getEname();
				enoo = em.getEno();
				gpp = em.getGross();
				nett = em.getNet();
				bw.append(eneym + "\t" + enoo + "\t" + gpp +"\t"+ nett +"\n");
				bw.newLine();
				JOptionPane.showMessageDialog(null, "Record added successfully!", "Confirm", JOptionPane.INFORMATION_MESSAGE);
			//	txtnum.setText(null);
			//	txtname.setText(null);
			}
			bw.close();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Cannot add record", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
