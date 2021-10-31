import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class cls_Sortt extends Applet implements ActionListener{
	Label lblF = new Label("1st No: ");
	static TextField txtF = new TextField (15);
	TextField txtf = new TextField (15);
	Label lblS = new Label("2nd No: ");
	static TextField txtS = new TextField (15);
	TextField txts = new TextField (15);
	Label lblT = new Label("3rd No: ");
	static TextField txtT = new TextField (15);
	TextField txtt = new TextField (15);
	Button btnAsc = new Button ("ASCENDING");
	Button btnDes = new Button ("DESCENDING");
	Button btnNew = new Button ("NEW");
	static int no1, no2, no3;
	public void init(){
		add(lblF); add(txtF); add(txtf);
		txtf.setEditable(false);
		add(lblS); add(txtS); add(txts);
		txts.setEditable(false);
		add(lblT); add(txtT); add(txtt);
		txtt.setEditable(false);
		add(btnAsc); add(btnDes);
		add(btnNew);
		btnAsc.addActionListener(this);
		btnDes.addActionListener(this);
		btnNew.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		inputs();
		if (ae.getSource()==btnAsc){
			if (no1<no2)
				
		   
			txtf.setText(String.valueOf(no1));
			txts.setText(String.valueOf(no2));
			txtt.setText(String.valueOf(no3));
		
		}
		else if (ae.getSource()==btnDes){
		
			
			txtf.setText(String.valueOf(no1));
			txts.setText(String.valueOf(no2));
			txtt.setText(String.valueOf(no3));
		}
		else{
			txtF.setText(null);
			txtf.setText(null);
			txtS.setText(null);
			txts.setText(null);
			txtT.setText(null);
			txtt.setText(null);
		}
	}
	public static void inputs(){
		no1 = Integer.parseInt(txtF.getText());
		no2 = Integer.parseInt(txtS.getText());
		no3 = Integer.parseInt(txtT.getText());
	}
}
