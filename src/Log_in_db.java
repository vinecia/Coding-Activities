import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Log_in_db extends JFrame {

	private JPanel contentPane;
	public JTextField username;
	public JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in_db frame = new Log_in_db();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log_in_db() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 351);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new LineBorder(new Color(255, 20, 147), 15, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user = new JLabel("");
		user.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
		user.setForeground(Color.LIGHT_GRAY);
		user.setHorizontalAlignment(SwingConstants.LEFT);
		user.setBounds(112, 113, 110, 14);
		contentPane.add(user);
		
		JLabel pass = new JLabel("");
		pass.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
		pass.setHorizontalAlignment(SwingConstants.RIGHT);
		pass.setForeground(Color.LIGHT_GRAY);
		pass.setBounds(112, 164, 110, 14);
		contentPane.add(pass);
		
		username = new JTextField();
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				user.setText("");
			}
		});
		username.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		username.setBounds(65, 105, 169, 29);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pass.setText("");
			}
		});
		password.setEchoChar('*');
		password.setBounds(65, 157, 169, 29);
		contentPane.add(password);
		
		
		JLabel Label1 = new JLabel("Username");
		Label1.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
		Label1.setBounds(65, 87, 69, 17);
		contentPane.add(Label1);
		
		JLabel label2 = new JLabel("Password");
		label2.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
		label2.setBounds(65, 140, 69, 17);
		contentPane.add(label2);
		
		
		Button login = new Button("LOG IN");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (username.getText().trim().isEmpty())
				{
					user.setText("Username is empty.");
				}
				else if (password.getText().trim().isEmpty())
				{
					pass.setText("Password is empty.");
				}
				else if (username.getText().trim().isEmpty() && password.getText().trim().isEmpty()) 
				{
					user.setText("Username is empty.");
					pass.setText("Password is empty.");
				}
				else
				{
				  try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useTimezone=true&serverTimezone=UTC", "root", "");
					String sql = "Select * from logindatabase where username=? and password=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, username.getText());
					pst.setString(2, password.getText());
					ResultSet rs = pst.executeQuery();
					if (rs.next()){
						JOptionPane.showMessageDialog(null,  "Username and Password Matched");
						username.setText("");
						password.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null,  "Username and Password do not Matched");
					username.setText("");
					password.setText("");
					}
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex, "WARNING", JOptionPane.ERROR_MESSAGE);
				}
			  }
			}
		});
		
		login.setActionCommand("");
		login.setForeground(new Color(224, 255, 255));
		login.setFont(UIManager.getFont("CheckBox.font"));
		login.setBackground(new Color(147, 112, 219));
		login.setBounds(112, 203, 70, 22);
		contentPane.add(login);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Log_in_db.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
		lblNewLabel.setBounds(261, 113, 32, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC5EC\uC790\uCE5C\uAD6C");
		lblNewLabel_1.setBounds(253, 164, 76, 14);
		contentPane.add(lblNewLabel_1);
		
	
	}
}
