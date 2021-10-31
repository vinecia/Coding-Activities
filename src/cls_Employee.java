import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.JOptionPane;
public class cls_Employee extends Applet implements ActionListener {
	Label lblEn = new Label("Employee Name: ");
	Label lblHrs = new Label("No. of Hours Worked:");
	Label lblRph = new Label("Rate per hour: ");
	Label lblDed = new Label("Deduction: ");
	Label lblYrs = new Label("Years of Service: ");
	static TextField txtEn = new TextField (10);
	static TextField txtHrs = new TextField (10);
	static TextField txtRph = new TextField (10);
	static TextField txtDed = new TextField (10);
	static TextField txtYrs = new TextField (10);
	static TextField txtGp = new TextField (15);
	static TextField txtNet= new TextField (15);
	static TextField txtBon = new TextField (17);
	Button btnGp = new Button ("Gross Pay");
	Button btnNet = new Button ("Net Pay");
	Button btnBon = new Button ("Bonus");
	Button btnNew = new Button ("New");
	public void init(){
		add(lblEn); add(txtEn); 
		add(lblHrs); add(txtHrs); 
		add(lblRph); add(txtRph); 
		add(lblDed); add(txtDed); 
		add(lblYrs); add(txtYrs); 
		add(btnGp); add(txtGp);
		txtGp.setEnabled(false);
		add(btnNet); add(txtNet);
		txtNet.setEnabled(false);
		add(btnBon); add(txtBon);
		txtBon.setEnabled(false);
		add(btnNew);
		btnGp.addActionListener(this);
		btnNet.addActionListener(this);
		btnBon.addActionListener(this);
		btnNew.addActionListener(this);
	}
	static int hrs, yrs;
	static double rate, deduction, gp, net, bonus;
	public void actionPerformed (ActionEvent ae){
		
		if (ae.getSource()==btnGp){
			try{
				hrs = Integer.parseInt(txtHrs.getText());
				rate = Double.parseDouble(txtRph.getText());
				if (hrs<0  && rate<0)
				{	JOptionPane.showMessageDialog(null, "Invalid Input/s", "ERROR!", JOptionPane.ERROR_MESSAGE); }
				else{
				gp = (double) hrs*rate;
				txtGp.setText(String.valueOf(gp));
				}
			}
			catch(NumberFormatException nf1){
				JOptionPane.showMessageDialog(null, "Invalid Input/s", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (ae.getSource()==btnNet){
			try{
				deduction = Double.parseDouble(txtDed.getText());
				if (gp == 0)
					JOptionPane.showMessageDialog(null, "Invalid Input/s", "ERROR!", JOptionPane.ERROR_MESSAGE);
				else{
				net = (double) gp - deduction;
				txtNet.setText(String.valueOf(net));
				}
			}
			catch(NumberFormatException nf2){
				JOptionPane.showMessageDialog(null, "Invalid Input/s", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
	}
		else if(ae.getSource()==btnBon){
			try{
				yrs = Integer.parseInt(txtYrs.getText());
				if (yrs<0||gp==0)
					JOptionPane.showMessageDialog(null, "Invalid Input/s", "ERROR!", JOptionPane.ERROR_MESSAGE);
				else{
				if (yrs<=5)
					bonus = gp*.20;
				else if (yrs<=10)
					bonus = gp*.30;
				else if (yrs<=15)
					bonus = gp*.40;
				else if (yrs<=20)
					bonus = gp*.50;
				else if (yrs>20){
					bonus = gp*.75;
					if (bonus<10000)
						bonus = 10000;
				}     
				txtBon.setText(String.valueOf(bonus));
			}
			}
			catch(NumberFormatException nf4){
				JOptionPane.showMessageDialog(null, "Invalid Input/s", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			txtEn.setText(" ");
			txtHrs.setText(null);
			txtRph.setText(null);
			txtDed.setText(null);
			txtYrs.setText(null);
			txtGp.setText(null);
			txtNet.setText(null);
			txtBon.setText(null);
		}
	}
}
