/* Bengco, Dana Kirstie C.
 * Garcia, Divine D.
 * BSCS 2-Petition
 */
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.JOptionPane;

public class cls_StudentInfo extends Applet implements ItemListener, ActionListener {
	/**s
	 * 
	 */
	private static final long serialVersionUID = -2584736695143520124L;
	Label lblNo = new Label("STUDENT NO: ");
	Label lblName = new Label("STUDENT NAME: ");
	Label lblCrs = new Label("COURSE: ");
	Label lblYr = new Label("YEAR: ");
	Label lblSec = new Label("SECTION: ");
	Label lblStudType = new Label("STUDENT TYPE: ");
	Label lblSub = new Label("SUBJECTS: ");
	TextField txtNo = new TextField(10);
	TextField txtName = new TextField(15);
	CheckboxGroup cgCrs = new CheckboxGroup();
	Checkbox chCS = new Checkbox("BSCS", cgCrs, true);
	Checkbox chIS = new Checkbox("BSIS", cgCrs, false);
	Checkbox chIT = new Checkbox("BSIT", cgCrs, false);
	Choice chYr = new Choice();
	List lstSec = new List();
	CheckboxGroup cgStudType = new CheckboxGroup();
	Checkbox chReg = new Checkbox("REGULAR", cgStudType, true);
	Checkbox chIrreg = new Checkbox("IRREGULAR", cgStudType, false);
	Checkbox chCom = new Checkbox("COMPUTER");
	Checkbox chMat = new Checkbox("MATH");
	Checkbox chEng = new Checkbox("ENGLISH");
	Checkbox chHis = new Checkbox("HISTORY");
	Checkbox chFil = new Checkbox("FILIPINO");
	Checkbox chPsy = new Checkbox("PSYCHOLOGY");
	Button btnAdd = new Button ("ADD");
	Button btnNew = new Button ("NEW");
	Button btnCom = new Button ("COMPUTE");
	TextArea taInfo = new TextArea(30,100);
	
	static String sno, sname, crs, yr, sec, type, sub="", info="";
	static int cs=0, csreg=0, csirreg=0, is=0, isreg=0, isirreg=0, it=0, itreg=0, itirreg=0, reg=0, irreg=0;
	
	public void init() {
		add(lblNo); add(txtNo); add(lblName); add(txtName); 
		add(lblCrs); add(chCS); add(chIS); add(chIT);
		add(lblYr); chYr.add("SELECT..."); chYr.add("1st"); chYr.add("2nd"); chYr.add("3rd"); chYr.add("4th"); add(chYr);
		add(lblSec); lstSec.add("CHOOSE"); lstSec.add("1"); lstSec.add("2"); lstSec.add("3"); lstSec.add("1N"); lstSec.add("2P"); add(lstSec);
		lstSec.select(0);
		add(lblStudType); add(chReg); add(chIrreg);
		add(lblSub); add(chCom); add(chMat); add(chEng); add(chHis);add(chFil); add(chPsy); 
		add(taInfo); taInfo.setEditable(false); taInfo.setText("STUDENT NO.\t\tSTUDENT NAME\t\tCOURSE\tYEAR\tSECTION\tTYPE\t\tSUBJECTS\n");
		add(btnAdd); add(btnNew); add(btnCom);
		
		setLayout(null); 
		lblNo.setBounds(10, 10, 90, 20);
		txtNo.setBounds(130, 10, 200, 20);
		lblName.setBounds(10, 50, 120, 20);
		txtName.setBounds(130, 50, 200, 20);
		lblCrs.setBounds(10, 90, 120, 20);
		chCS.setBounds(130, 90, 70, 20);
		chIS.setBounds(200, 90, 70, 20);
		chIT.setBounds(270, 90, 70, 20);
		lblYr.setBounds(10, 130, 90, 20);
		chYr.setBounds(130, 130, 100, 20);
		lblSec.setBounds(10, 170, 100, 20);
		lstSec.setBounds(130, 170, 100, 95);
		lblStudType.setBounds(10, 285, 100, 20);
		chReg.setBounds(130, 285, 90, 20);
		chIrreg.setBounds(130, 325, 90, 20);
		lblSub.setBounds(10, 365, 90, 20);
		chCom.setBounds(130, 365, 90, 20);
		chMat.setBounds(230, 365, 90, 20);
		chEng.setBounds(130, 405, 90, 20);
		chHis.setBounds(230, 405, 90, 20);
		chFil.setBounds(130, 445, 90, 20);
		chPsy.setBounds(230, 445, 100, 20);
		btnAdd.setBounds(70, 490, 70, 20);
		btnNew.setBounds(160, 490, 70, 20);
		btnCom.setBounds(250, 490, 80, 20);
		taInfo.setBounds(400, 10, 800, 510);
		
		
		chCS.addItemListener(this); chIS.addItemListener(this); chIT.addItemListener(this);
		chYr.addItemListener(this); lstSec.addItemListener(this);
		chReg.addItemListener(this); chIrreg.addItemListener(this);
		chCom.addItemListener(this); chMat.addItemListener(this); chEng.addItemListener(this); 
		chHis.addItemListener(this); chFil.addItemListener(this); chPsy.addItemListener(this);
		btnAdd.addActionListener(this); btnNew.addActionListener(this); btnCom.addActionListener(this);
	}
	
	public void itemStateChanged(ItemEvent ie) {
		yr = chYr.getSelectedItem();
		sec = lstSec.getSelectedItem();
		
		if (chCS.getState()==true) {
			crs = chCS.getLabel();
			if(chReg.getState()==true) 
				type = chReg.getLabel();
			else type = chIrreg.getLabel();
			
		}
		else if (chIS.getState()==true) {
			crs = chIS.getLabel();
			if(chReg.getState()==true) 
				type = chReg.getLabel();
			else type = chIrreg.getLabel();	
		}
		else {
			crs = chIT.getLabel();
			if(chReg.getState()==true) 
				type = chReg.getLabel();
			else type = chIrreg.getLabel();
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==btnAdd) {
			sno = txtNo.getText();
			sname = txtName.getText();
			
			if (chCom.getState()==true)
				sub += chCom.getLabel()+"  ";
			if (chMat.getState()==true)
				sub += chMat.getLabel()+"  ";
			if (chEng.getState()==true)
				sub += chEng.getLabel()+"  ";
			if (chHis.getState()==true)
				sub += chHis.getLabel()+"  ";                                                                              
			if (chFil.getState()==true)
				sub += chFil.getLabel()+"  ";
			 if (chPsy.getState()==true)
				sub += chPsy.getLabel()+"  ";
			 
			if(sno==""|| sname=="" || crs=="" || yr=="SELECT..." || sec=="CHOOSE" || type=="" || sub=="")
				 JOptionPane.showMessageDialog(null, "Incomplete Input! Please fill up properly.", "WARNING", JOptionPane.WARNING_MESSAGE);
			else {
			
			 if(crs=="BSCS") {
					if (type=="REGULAR")
						csreg++;
					else csirreg++;
				}
				else if (crs=="BSIS") {
					if (type=="REGULAR")
						isreg++;
					else isirreg++;
				}
				else {
					if (type=="REGULAR")
						itreg++;                                                     
					else itirreg++;
				}
				cs = csreg + csirreg;
				is = isreg + isirreg;
				it = itreg + itirreg;
				reg = csreg + isreg + itreg;
				irreg = csirreg + isirreg + itirreg;	
				
				info += sno +"\t\t\t"+ sname +"\t\t"+ crs +"\t\t"+ yr +"\t"+ sec +"\t\t"+ type +"\t"+ sub +"\n";
				taInfo.append(info+"\n");
			}	
		}
		else if(ae.getSource()==btnCom) {
			taInfo.append("\nTotal No. of BSCS Students: "+cs+"\n");
				taInfo.append("\tTotal No. of Regular Students  : "+csreg+"\n");
				taInfo.append("\tTotal No. of Irregular Students : "+csirreg+"\n");
			taInfo.append("Total No. of BSIS Students: "+is+"\n");
				taInfo.append("\tTotal No. of Regular Students  : "+isreg+"\n");
				taInfo.append("\tTotal No. of Irregular Students : "+isirreg+"\n");
			taInfo.append("Total No. of BSIT Students: "+it+"\n");
				taInfo.append("\tTotal No. of Regular Students  : "+itreg+"\n");
				taInfo.append("\tTotal No. of Irregular Students : "+itirreg+"\n");
			taInfo.append("\nTotal No. of Regular Students  : "+reg+"\n");
			taInfo.append("\nTotal No. of Irregular Students:  "+irreg+"\n\n");
		}
		else {
			txtNo.setText("");
			txtName.setText("");
			chCS.setState(true);
			chYr.select("SELECT...");
			lstSec.select(0);
			chReg.setState(true);
			info="";
			sub="";
			chCom.setState(false); chMat.setState(false); chEng.setState(false); 
			chHis.setState(false); chFil.setState(false); chPsy.setState(false);
			//taInfo.setText(" ");
			//taInfo.setText("STUDENT NO.\t\tSTUDENT NAME\t\tCOURSE\tYEAR\tSECTION\tTYPE\t\tSUBJECTS\n");
		}
	}
}
