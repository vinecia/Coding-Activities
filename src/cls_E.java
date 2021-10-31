import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class cls_E extends Applet implements ActionListener{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 7651260595715123322L;
	Label lbl1 = new Label ("1st No: ");
	 Label lbl2 = new Label ("2nd No: ");
	 Label lbl3 = new Label ("Result: ");
	 TextField txt1 = new TextField (10);
	 TextField txt2 = new TextField (10);
	 TextField txt3 = new TextField (10);
	 Button btnDiv = new Button("Divide");
	 public void init() {
		 add(lbl1); add(txt1); add(lbl2); add(txt2);
		 add(lbl3); add(txt3); add(btnDiv);
		 btnDiv.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent ae) {
		 int no1, no2;
		 double div = 0;
		 int val[] = new int [3];
		 if (ae.getSource()==btnDiv){
			 try {
				 no1 = Integer.parseInt(txt1.getText());
				 no2 = Integer.parseInt(txt2.getText());
				 div = (double)no1/no2;
				 val[3]=10;
			 }
			 catch(NumberFormatException nf) {
				 JOptionPane.showMessageDialog(null, "Invalid Input/s", "ERROR", JOptionPane.ERROR_MESSAGE);
			 }
			 catch(ArithmeticException ame) {
				 JOptionPane.showMessageDialog(null, "Cannot be", "WARNING", JOptionPane.WARNING_MESSAGE);
			 }
			 catch(ArrayIndexOutOfBoundsException ai){
				 JOptionPane.showMessageDialog(null, "Invalid Index", "INVALID", JOptionPane.INFORMATION_MESSAGE);
			 }
			 finally{
				 JOptionPane.showMessageDialog(null, "End of Program", "END", JOptionPane.PLAIN_MESSAGE);
				 txt3.setText(String.valueOf(div));
			 }
		 } 
	 }
	 
}
