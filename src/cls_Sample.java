import java.awt.*;
import java.awt.event.*;
import java.applet.*;
@SuppressWarnings("serial")
public class cls_Sample extends Applet implements ActionListener{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	Label lblNo1 = new Label ("1st No: ");
	Label lblNo2 = new Label ("2nd No: ");
	Label lblRes = new Label ("Result: ");
	Font l = new Font (Font.MONOSPACED, Font.BOLD, 22);
	Font t = new Font (Font.MONOSPACED, Font.PLAIN, 12);
	static TextField txtNo1 = new TextField(5);
	static TextField txtNo2 = new TextField(5);
	static TextField txtRes = new TextField(5);
	Button btnAdd = new Button("Add");
	Button btnSub = new Button("Subtract");
	Button btnMul = new Button("Multiply");
	Button btnDiv = new Button("Divide");
	Button btnClr = new Button("Clear");
	static int no1, no2;
	public void init() {
		add(lblNo1); add(txtNo1);
		lblNo1.setFont(l);
		lblNo1.setForeground(Color.CYAN);
		txtNo1.setFont(t);
		txtNo1.setBackground(Color.LIGHT_GRAY);
		txtNo1.setForeground(Color.WHITE);
		txtNo1.setEchoChar((char) 3);
		add(lblNo2); add(txtNo2);
		lblNo2.setFont(l);
		lblNo2.setForeground(Color.CYAN);
		txtNo2.setFont(t);
		txtNo2.setBackground(Color.LIGHT_GRAY);
		txtNo2.setForeground(Color.WHITE);
		add(lblRes); add(txtRes);
		lblRes.setFont(l);
		lblRes.setForeground(Color.CYAN);
		txtRes.setFont(t);
		txtRes.setBackground(Color.PINK);
		txtRes.setForeground(Color.WHITE);
		txtRes.setEditable(false);
		//txtRes.isEditable();
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
