import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class cls_Sort extends Applet implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4495740182918417095L;
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
	static int no[] = new int [3];
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
		int i, j, temp;
		inputs();
		if (ae.getSource()==btnAsc){
			for (i=0; i<3; i++){
			for (j=i+1; j<3; j++){
				if (no[i]>no[j]){
					temp = no[j];
					no[j] = no[i];
					no[i] = temp;
				}
			  }
		   }
			txtf.setText(String.valueOf(no[0]));
			txts.setText(String.valueOf(no[1]));
			txtt.setText(String.valueOf(no[2]));
		
		}
		else if (ae.getSource()==btnDes){
			for (i=0; i<3; i++){
				for (j=i+1; j<3; j++){
					if (no[i]<no[j]){
						temp = no[i];
						no[i] = no[j];
						no[j] = temp;
					}
				  }
			   }
			txtf.setText(String.valueOf(no[0]));
			txts.setText(String.valueOf(no[1]));
			txtt.setText(String.valueOf(no[2]));
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
		no[0] = Integer.parseInt(txtF.getText());
		no[1] = Integer.parseInt(txtS.getText());
		no[2] = Integer.parseInt(txtT.getText());
	}
}
