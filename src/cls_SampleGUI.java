import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class cls_SampleGUI extends Applet implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label lblNo1 = new Label ("1st No: ");
	Label lblNo2 = new Label ("2nd No: ");
	Label lblRes = new Label ("Result: ");
	static TextField txtNo1 = new TextField();
	static TextField txtNo2 = new TextField(5);
	static TextField txtRes = new TextField(10);
	Button btnAdd = new Button("Add");
	Button btnSub = new Button("Subtract");
	Button btnMul = new Button("Multiply");
	Button btnDiv = new Button("Divide");
	Button btnClr = new Button("Clear");
	static int no1, no2;
	public void init() {
		add(lblNo1); add(txtNo1);
		add(lblNo2); add(txtNo2);
		add(lblRes); add(txtRes);
		add(btnAdd); add(btnSub);
		add(btnMul); add(btnDiv);
		add(btnClr);
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		btnClr.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		int sum, diff; long prod; double quo;
		inputs();
		if (ae.getSource()==btnAdd)
		{
			sum = no1 + no2;
			txtRes.setText(String.valueOf(sum));
		}
		else if (ae.getSource()==btnSub)
		{
			diff = no1 - no2;
			txtRes.setText(String.valueOf(diff));
		}
		else if (ae.getSource()==btnMul)
		{
			prod = no1 * no2;
			txtRes.setText(String.valueOf(prod));
		}
		else if (ae.getSource()==btnDiv)
		{
			quo = (double)no1 / no2;
			txtRes.setText(String.valueOf(quo));
		}
		else {
			txtNo1.setText(" ");
			txtNo2.setText(" ");
			txtRes.setText(null);
		}
	}
	public static void inputs() {
		no1 = Integer.parseInt(txtNo1.getText());
		no2 = Integer.parseInt(txtNo2.getText());
	}
}
