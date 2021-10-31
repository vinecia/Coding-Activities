import java.awt.*;
import java.awt.event.*;
import java.applet.*;
@SuppressWarnings("serial")
public class cls_GUIs extends Applet implements ItemListener, ActionListener{
	Label lblNo = new Label("Employee No: ");
	Label lblName = new Label("Employee Name: ");
	Label lblSex = new Label("Sex: ");
	Label lblStatus = new Label("Status: ");
	TextField txtNo = new TextField(10);
	TextField txtName = new TextField(10);
	CheckboxGroup cgS = new CheckboxGroup();
	Checkbox chM = new Checkbox("Male", cgS, true);
	Checkbox chF = new Checkbox("Female", cgS, false);
	Choice chStat = new Choice();
	TextArea taInfo = new TextArea(20,70);
	Button btnAdd = new Button("ADD");
	Button btnCom = new Button("COMPUTE");
	Button btnNew = new Button("NEW");
	
	static String ename, sex, stat, eno, info="";
	static int m=0, f=0, reg=0, prob=0, cas=0, con=0, total=0;
	
	public void init() {
		add(lblNo); add(txtNo); add(lblName); add(txtName);
		add(lblSex); add(chM); add(chF);
		add(lblStatus); chStat.add("Regular"); chStat.add("Probationary"); chStat.add("Casual"); chStat.add("Contractual"); add(chStat);
		add(taInfo); taInfo.setEnabled(false); taInfo.setText("Employee No.\tEmployee Name\t\tSex\t\tStatus\n");
		add(btnAdd); add(btnNew); add(btnCom);
		chM.addItemListener(this); chF.addItemListener(this); chStat.addItemListener(this);
		btnAdd.addActionListener(this); btnNew.addActionListener(this); btnCom.addActionListener(this);
	}
	
	public void itemStateChanged (ItemEvent ie) {	
	if (chM.getState()==true)
		sex = chM.getLabel();
	else  sex = chF.getLabel();
	stat = chStat.getSelectedItem();
	eno = txtNo.getText();
	ename = txtName.getText();
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==btnAdd) {
			if (sex == "Male")
				m++;
			else f++;
			if (stat == "Regular")
				reg++;
			else if (stat == "Probationary")	
				prob++;
			else if (stat == "Casual")	
				cas++;
			else con++;
			total=m+f;
			info += eno+"\t\t"+ename+"\t\t\t"+sex+"\t\t"+stat+"\n";
			taInfo.append(info+"\n");
		}
		else if (ae.getSource()==btnCom) {
			taInfo.append("Total Employees: "+total+"\n");
			taInfo.append("Total Male Employees: "+m+"\n");
			taInfo.append("Total Female Employees: "+f+"\n");
			taInfo.append("Total Regular Employees: "+reg+"\n");
			taInfo.append("Total Probationary Employees: "+prob+"\n");
			taInfo.append("Total Casual Employees: "+cas+"\n");
			taInfo.append("Total Contractual Employees: "+con+"\n");
		}
		else {
			txtNo.setText("");
			txtName.setText("");
			chM.setState(true);
			chStat.select("Regular");
			taInfo.setText(" ");
			taInfo.setText("Employee No.\tEmployee Name\t\tSex\t\tStatus\n");
		}
	}
}