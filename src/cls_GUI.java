import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class cls_GUI extends Applet implements ItemListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6249033290182169510L;
	Label lblName = new Label("STUDENT NAME: ");
	Label lblCourse = new Label("COURSE: ");
	Label lblYr = new Label("YEAR: ");
	Label lblSec = new Label("SECTION: ");
	Label lblHob = new Label("HOBBIES: ");
	TextField txtName = new TextField(10);
	CheckboxGroup cgCourse = new CheckboxGroup();
	Checkbox chCS = new Checkbox("BSCS", cgCourse, true);
	Checkbox chIT = new Checkbox("BSIT", cgCourse, false);
	Choice chYr = new Choice();
	List lstSec = new List();
	Checkbox chEat = new Checkbox("Eating"); 
	Checkbox chPlay = new Checkbox("Playing");
	Checkbox chSlip = new Checkbox("Sleeping"); 
	Checkbox chWat = new Checkbox("Watching"); 
	TextArea taInfo = new TextArea(10,50);
	Button btnAdd = new Button ("ADD");
	Button btnNew = new Button ("NEW");
	
	static String name, course, yr, sec, hob=" ", info=" ";
	
	public void init() {
		add(lblName); add(txtName);
		add(lblCourse); add(chCS); add(chIT);
		add(lblYr); chYr.add("1st"); chYr.add("2nd"); chYr.add("3rd"); chYr.add("4th"); add(chYr); 
		add(lblSec); lstSec.add("1"); lstSec.add("2"); lstSec.add("1N"); lstSec.add("1P"); add(lstSec); 
		add(lblHob); add(chEat); add(chPlay); add(chSlip); add(chWat);
		add(taInfo); taInfo.setEditable(false); 
		add(btnAdd); add(btnNew);
		chCS.addItemListener(this); chIT.addItemListener(this); chYr.addItemListener(this);
		lstSec.addItemListener(this); 
		chEat.addItemListener(this); chPlay.addItemListener(this); chSlip.addItemListener(this); chWat.addItemListener(this);
		btnAdd.addActionListener(this); btnNew.addActionListener(this);
	}
	
	public void itemStateChanged(ItemEvent ie) {
		if (chCS.getState()==true)
			course = chCS.getLabel();
		else course = chIT.getLabel();
		
		if(chYr.getSelectedIndex()==0)
			yr = chYr.getSelectedItem();
		else if(chYr.getSelectedItem()=="2nd")
			yr = chYr.getSelectedItem();
		else if(chYr.getSelectedIndex()==2)
			yr = chYr.getSelectedItem();
		else yr = chYr.getSelectedItem();
			
		if(lstSec.getSelectedItem()=="1")
			sec = lstSec.getSelectedItem();
		else if (lstSec.getSelectedIndex()==1)
			sec = lstSec.getSelectedItem();
		else if(lstSec.getSelectedItem()=="1P")
			sec = lstSec.getSelectedItem();
		else sec = lstSec.getSelectedItem();
		
		if (chEat.getState()==true)
			hob += chEat.getLabel() + "\t";
		if (chPlay.getState()==true)
			hob += chPlay.getLabel() + "\t";
		if (chSlip.getState()==true)
			hob += chSlip.getLabel() + "\t";
		if (chWat.getState()==true)
			hob += chWat.getLabel() + "\t";
		name = txtName.getText();
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==btnAdd) {
			//info += name +"\t"+ course +"\t"+ yr +"\t"+ sec +"\t"+ hob +"\n";
			info += name +"\t"+ course +"\t"+ yr +"\t"+ hob +"\n";
			taInfo.append(info+"\n");
		}
		else {
			txtName.setText(" ");
			chCS.setState(true);
			chYr.select("1st");
			lstSec.select(0);
			hob=" ";
			info=" ";
			chEat.setState(false);
			chPlay.setState(false);
			chSlip.setState(false);
			chWat.setState(false);
		}
	}
}
