import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class cls_Stud extends Applet implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label lblSno = new Label("Student No: ");
	Label lblSn = new Label("Student Name:");
	Label lblMid = new Label("Midterm Grade: ");
	Label lblFin = new Label("Final Grade: ");
	Label lblAve = new Label("Average: ");
	Label lblRem = new Label("Remarks: ");
	TextField txtSno = new TextField (15);
	TextField txtSn = new TextField (20);
	static TextField txtMid = new TextField (15);
	static TextField txtFin = new TextField (15);
	TextField txtAve = new TextField (15);
	TextField txtRem = new TextField (15);
	Button btnCompute = new Button ("Compute");
	Button btnClear = new Button ("Clear");
	static double mid, fin, ave;
	static String rem;
	public void init(){
		add(lblSno); add(txtSno);
		add(lblSn); add(txtSn);
		add(lblMid); add(txtMid);
		add(lblFin); add(txtFin);
		add(lblAve); add(txtAve);
		txtAve.setEnabled(false);
		add(lblRem); add(txtRem);
		txtRem.setEnabled(false);
		add(btnCompute); add(btnClear); 
		btnCompute.addActionListener(this);
		btnClear.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		inputs();
		if(ae.getSource()==btnCompute){
			ave = (mid+fin)/2;
			if (ave<=3.12)
				rem = "Passed";
			else 
				rem = "Failed";
			txtAve.setText(String.valueOf(ave));
			txtRem.setText(rem);
		}
		else
		{
			txtSno.setText(" ");
			txtSn.setText(" ");
			txtMid.setText(" ");
			txtFin.setText(" ");
			txtAve.setText(null);
			txtRem.setText(" ");
		}
	}
	public static void inputs(){
		mid = Double.parseDouble(txtMid.getText());
		fin = Double.parseDouble(txtFin.getText());
	}
}
