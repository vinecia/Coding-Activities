import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class cls_Jolly extends Applet implements ActionListener, ItemListener {
	Label lblJol = new Label("JOLLY MANG DONKING");
	Label lblCus = new Label("Customer Name:");
	TextField txtCus = new TextField(15);
	Label lblOr = new Label ("Order:");
	Label lblQua = new Label ("Quantity");
	TextField txtQ1 = new TextField(15);
	TextField txtQ2 = new TextField(15);
	TextField txtQ3 = new TextField(15);
	Label lblEx = new Label ("Extra");
	Choice chExtra = new Choice();

	TextField txt1 = new TextField(15);
	TextField txt2 = new TextField(15);
	TextField txt3 = new TextField(15);
	Checkbox chHam = new Checkbox("Hamburger");
	Checkbox chChi = new Checkbox ("Chicken");
	Checkbox chSpag = new Checkbox ("Spaghetti");
	Label lblDri = new Label("Drinks:");
	Label lblReg = new Label("Regular");
	Label lblLar = new Label("Large");
	Checkbox chJu = new Checkbox("Juice");
	Checkbox chSo = new Checkbox("Soda");
	TextField txt1a = new TextField(15);
	TextField txt2a = new TextField(15);
	CheckboxGroup cgDri = new CheckboxGroup();
	Checkbox chReg = new Checkbox("",cgDri,true);
	Checkbox chLar = new Checkbox("",cgDri,false);
	CheckboxGroup cgDri2 = new CheckboxGroup();
	Checkbox chReg1 = new Checkbox("",cgDri2,true);
	Checkbox chLar1 = new Checkbox("",cgDri2,false);
	
	TextArea taInfo = new TextArea("Offical Receipt", 20,30);

	Button btnTot = new Button ("TOTAL");
	TextField txtTot = new TextField(15);
	Label lblCash = new Label("Cash:");
	TextField txtCash = new TextField(15);
	Button btnChan = new Button ("CHANGE");
	TextField txtChan = new TextField(15);
	Button btnNew = new Button ("NEW");
	static String name,order="",size,drinks,ext;
	static double total, cash, change;
	static int a,b, dri1,dri2,q1,q2,q3,qa,qb,qc;
//	static int juice, soda,ham, chi,spag;
	
	public void init(){
		add(lblJol);
		add(lblCus); add(txtCus);
		add(lblOr); add(chHam); add(txtQ1);add(chChi);add(txtQ2); add(chSpag);add(txtQ3);
		add(lblQua); 
		add(lblEx); chExtra.add("Cheese");chExtra.add("Fries");chExtra.add("Rice");
		add(lblQua); add(txt1);add(txt2);add(txt3);
		add(lblDri); add(chJu); add(chReg); add(chLar);add(chSo); add(chReg1); add(chLar1);
		add(lblQua);add(txt1a);add(txt2a);
		add(btnTot); add(txtTot);
		txtTot.setEnabled(false);
		add(lblCash); add(txtCash);
		add(btnChan); add(txtChan);
		txtChan.setEnabled(false);
		add(btnNew); add(taInfo);
		taInfo.setEditable(false);
		btnTot.addActionListener(this);
		btnChan.addActionListener(this);
		btnNew.addActionListener(this);
		chExtra.addItemListener(this);
		chHam.addItemListener(this);chChi.addItemListener(this);chSpag.addItemListener(this);
		chJu.addItemListener(this);chSo.addItemListener(this);
		chLar.addItemListener(this);chReg.addItemListener(this);
		chLar1.addItemListener(this);chReg1.addItemListener(this);
		
	}
	
	public void itemStateChanged(ItemEvent ie){
		name=txtCus.getText();
		cash=Double.parseDouble(txtCash.getText());
		if(chHam.getState()==true){
			order+=chHam.getLabel()+"\t";
			q1=Integer.parseInt(txtQ1.getText());
			total+=q1*30;
		
		}
		if(chChi.getState()==true){
			order+=chChi.getLabel()+"\t";
			q2=Integer.parseInt(txtQ2.getText());
			total+=q2*75;
		}
		if(chSpag.getState()==true){
			order+=chSpag.getLabel()+"\t";
			q3=Integer.parseInt(txtQ3.getText());
			total+=q3*50;
		}
		
		
		if(chExtra.getSelectedIndex()==0){
			ext=chExtra.getSelectedItem();
			qa=Integer.parseInt(txt1.getText());
		}
		else if(chExtra.getSelectedIndex()==1){
			ext=chExtra.getSelectedItem();
			qb=Integer.parseInt(txt2.getText());
		}
		else{
			ext=chExtra.getSelectedItem();
			qc=Integer.parseInt(txt3.getText());
		}
		
		
		if(chJu.getState()==true){
			drinks+=chJu.getLabel()+"\t";
			dri1=Integer.parseInt(txt1a.getText());
		}
		if(chSo.getState()==true){
			drinks+=chSo.getLabel()+"\t";
			dri2=Integer.parseInt(txt2a.getText());
		}
		
		
		if(chReg.getState()==true){
			size=chReg.getLabel();
			total+=25;
		}
		else {
			size=chLar.getLabel();
			 total+=40;
		}
		
		if(chReg1.getState()==true){
			size=chReg1.getLabel();
			total+=20;
		}
		else{ 
			size=chLar1.getLabel();
			total+=30;
		}
		

 
	}
	

	public void actionPerformed(ActionEvent ae){

		if(ae.getSource()==btnTot){	

			txtTot.setText(String.valueOf(total));
			taInfo.append("Order \t Quantity \t Unit Price \t Subtotal\n " +order);
		}
		
		else if(ae.getSource()==btnChan){
			change=total-cash;
			txtChan.setText(String.valueOf(change));
		}
		
		else{
			txtCus.setText("");
			txtQ1.setText("");
			txtQ2.setText("");
			txtQ3.setText("");
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt1a.setText("");
			txt2a.setText("");
			taInfo.setText("");
			txtTot.setText(null);
			txtCash.setText(null);
			txtChan.setText(null);
			chHam.setState(false);
			chChi.setState(false);
			chSpag.setState(false);
			chReg.setState(true);
			chReg1.setState(true);
			order="";
			chJu.setState(false);
			chSo.setState(false);
		}
	}
}
