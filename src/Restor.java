package hu;



import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
//import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class Restor extends JFrame implements ActionListener{

	public JFrame frame = new JFrame();;
	public JLabel lblClock = new JLabel("Clock");
	public JTextField txtTa1;	public JTextField txtTa2;	public JTextField txtTa3;   public JTextField txtTa4;	
	public JTextField txtTa5;	public JTextField txtTb1;	public JTextField txtTb2;	public JTextField txtTb3;
	public JTextField txtTb4;   public JTextField txtTb5;	public JTextField txtTc1;	public JTextField txtTc2;
	public JTextField txtTc3;	public JTextField txtTc4;	public JTextField txtTc5;	public JTextField txtTd1;
	public JTextField txtTd2;	public JTextField txtTd3;	public JTextField txtTd4;	public JTextField txtTd5;
	static String Ta1; static String Ta2;	static String Ta3;   static String Ta4;	
	static String Ta5;	static String Tb1;	static String Tb2;	static String Tb3;
	static String Tb4;   static String Tb5;	static String Tc1;	static String Tc2;
	static String Tc3;	static String Tc4;	static String Tc5;	static String Td1;
	static String Td2;	static String Td3;	static String Td4;	static String Td5;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restor window = new Restor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
					Calendar cal = new GregorianCalendar();
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int sec = cal.get(Calendar.SECOND);
					int min = cal.get(Calendar.MINUTE);
					int hr = cal.get(Calendar.HOUR);
					
					lblClock.setText("Date: " +month+"/"+day+"/"+year + "  Time: "+hr+":"+(min<10?"0" : "")+min+":"+(sec < 10 ?"0" : "")+sec);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
		
	}
	
	/**
	 * Create the application.
	 */
	public Restor() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblRestoresto = new JLabel("RestoResto");
		lblRestoresto.setFont(new Font("Segoe Script", Font.BOLD, 20));
		
		JButton btnAccomodateCustomer = new JButton("Accomodate Customer");
		btnAccomodateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameAcco = new JFrame();
				frameAcco.setBounds(100, 100, 1000, 500);
				frameAcco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				frameAcco.getContentPane().setLayout(gridBagLayout);
				
				JLabel lblAvailableTables = new JLabel("Available Tables");
				GridBagConstraints gbc_lblAvailableTables = new GridBagConstraints();
				gbc_lblAvailableTables.insets = new Insets(0, 0, 5, 5);
				gbc_lblAvailableTables.gridx = 1;
				gbc_lblAvailableTables.gridy = 0;
				frameAcco.getContentPane().add(lblAvailableTables, gbc_lblAvailableTables);
				
				JLabel lblTablesForTwo = new JLabel("Tables for Two:");
				GridBagConstraints gbc_lblTablesForTwo = new GridBagConstraints();
				gbc_lblTablesForTwo.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForTwo.gridx = 1;
				gbc_lblTablesForTwo.gridy = 1;
				frameAcco.getContentPane().add(lblTablesForTwo, gbc_lblTablesForTwo);
				
				JToggleButton tglTa1 = new JToggleButton("TA1:");
				tglTa1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							if(tglTa1.isSelected()) {
								txtTa1.setBackground(Color.RED);
								txtTa1.setText("OCCUPIED");
								Ta1 = "OCCUPIED";
							}
							else {
								txtTa1.setBackground(Color.GREEN);
								txtTa1.setText("UNOCCUPIED");
								Ta1 = "UNOCCUPIED";
							}
					}
				});
				GridBagConstraints gbc_tglTa1 = new GridBagConstraints();
				gbc_tglTa1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa1.gridx = 2;
				gbc_tglTa1.gridy = 2;
				frameAcco.getContentPane().add(tglTa1, gbc_tglTa1);
				
				txtTa1 = new JTextField();
				txtTa1.setBackground(Color.GREEN);
				txtTa1.setText("UNOCCUPIED");
				txtTa1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa1.setEditable(false);
				GridBagConstraints gbc_txtTa1 = new GridBagConstraints();
				gbc_txtTa1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa1.gridx = 3;
				gbc_txtTa1.gridy = 2;
				frameAcco.getContentPane().add(txtTa1, gbc_txtTa1);
				txtTa1.setColumns(10);
				
				JToggleButton tglTa2 = new JToggleButton("TA2:");
				tglTa2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTa2.isSelected()) {
							txtTa2.setBackground(Color.RED);
							txtTa2.setText("OCCUPIED");
							Ta2 = "OCCUPIED";
						}
						else {
							txtTa2.setBackground(Color.GREEN);
							txtTa2.setText("UNOCCUPIED");
							Ta2 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTa2 = new GridBagConstraints();
				gbc_tglTa2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa2.gridx = 4;
				gbc_tglTa2.gridy = 2;
				frameAcco.getContentPane().add(tglTa2, gbc_tglTa2);
				
				txtTa2 = new JTextField();
				txtTa2.setText("UNOCCUPIED");
				txtTa2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa2.setEditable(false);
				txtTa2.setColumns(10);
				txtTa2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa2 = new GridBagConstraints();
				gbc_txtTa2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa2.gridx = 5;
				gbc_txtTa2.gridy = 2;
				frameAcco.getContentPane().add(txtTa2, gbc_txtTa2);
				
				JToggleButton tglTa3 = new JToggleButton("TA3:");
				tglTa3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTa3.isSelected()) {
							txtTa3.setBackground(Color.RED);
							txtTa3.setText("OCCUPIED");
							Ta3 = "OCCUPIED";
						}
						else {
							txtTa3.setBackground(Color.GREEN);
							txtTa3.setText("UNOCCUPIED");
							Ta3 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTa3 = new GridBagConstraints();
				gbc_tglTa3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa3.gridx = 6;
				gbc_tglTa3.gridy = 2;
				frameAcco.getContentPane().add(tglTa3, gbc_tglTa3);
				
				txtTa3 = new JTextField();
				txtTa3.setText("UNOCCUPIED");
				txtTa3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa3.setEditable(false);
				txtTa3.setColumns(10);
				txtTa3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa3 = new GridBagConstraints();
				gbc_txtTa3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa3.gridx = 7;
				gbc_txtTa3.gridy = 2;
				frameAcco.getContentPane().add(txtTa3, gbc_txtTa3);
				
				JToggleButton tglTa4 = new JToggleButton("TA4:");
				tglTa4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTa4.isSelected()) {
							txtTa4.setBackground(Color.RED);
							txtTa4.setText("OCCUPIED");
							Ta4 = "OCCUPIED";
						}
						else {
							txtTa4.setBackground(Color.GREEN);
							txtTa4.setText("UNOCCUPIED");
							Ta4 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTa4 = new GridBagConstraints();
				gbc_tglTa4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa4.gridx = 8;
				gbc_tglTa4.gridy = 2;
				frameAcco.getContentPane().add(tglTa4, gbc_tglTa4);
				
				txtTa4 = new JTextField();
				txtTa4.setText("UNOCCUPIED");
				txtTa4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa4.setEditable(false);
				txtTa4.setColumns(10);
				txtTa4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa4 = new GridBagConstraints();
				gbc_txtTa4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa4.gridx = 9;
				gbc_txtTa4.gridy = 2;
				frameAcco.getContentPane().add(txtTa4, gbc_txtTa4);
				
				JToggleButton tglTa5 = new JToggleButton("TA5:");
				tglTa5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTa5.isSelected()) {
							txtTa5.setBackground(Color.RED);
							txtTa5.setText("OCCUPIED");
							Ta5 = "OCCUPIED";
						}
						else {
							txtTa5.setBackground(Color.GREEN);
							txtTa5.setText("UNOCCUPIED");
							Ta5 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTa5 = new GridBagConstraints();
				gbc_tglTa5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa5.gridx = 10;
				gbc_tglTa5.gridy = 2;
				frameAcco.getContentPane().add(tglTa5, gbc_tglTa5);
				
				txtTa5 = new JTextField();
				txtTa5.setText("UNOCCUPIED");
				txtTa5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa5.setEditable(false);
				txtTa5.setColumns(10);
				txtTa5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa5 = new GridBagConstraints();
				gbc_txtTa5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa5.gridx = 11;
				gbc_txtTa5.gridy = 2;
				frameAcco.getContentPane().add(txtTa5, gbc_txtTa5);
				
				JLabel lblTablesForFour = new JLabel("Tables for Four:");
				GridBagConstraints gbc_lblTablesForFour = new GridBagConstraints();
				gbc_lblTablesForFour.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForFour.gridx = 1;
				gbc_lblTablesForFour.gridy = 3;
				frameAcco.getContentPane().add(lblTablesForFour, gbc_lblTablesForFour);
				
				JToggleButton tglTb1 = new JToggleButton("TB1:");
				tglTb1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTb1.isSelected()) {
							txtTb1.setBackground(Color.RED);
							txtTb1.setText("OCCUPIED");
							Tb1 = "OCCUPIED";
						}
						else {
							txtTb1.setBackground(Color.GREEN);
							txtTb1.setText("UNOCCUPIED");
							Tb1 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTb1 = new GridBagConstraints();
				gbc_tglTb1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb1.gridx = 2;
				gbc_tglTb1.gridy = 4;
				frameAcco.getContentPane().add(tglTb1, gbc_tglTb1);
				
				txtTb1 = new JTextField();
				txtTb1.setText("UNOCCUPIED");
				txtTb1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb1.setEditable(false);
				txtTb1.setColumns(10);
				txtTb1.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb1 = new GridBagConstraints();
				gbc_txtTb1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb1.gridx = 3;
				gbc_txtTb1.gridy = 4;
				frameAcco.getContentPane().add(txtTb1, gbc_txtTb1);
				
				JToggleButton tglTb2 = new JToggleButton("TB2:");
				tglTb2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTb2.isSelected()) {
							txtTb2.setBackground(Color.RED);
							txtTb2.setText("OCCUPIED");
							Tb2 = "OCCUPIED";
						}
						else {
							txtTb2.setBackground(Color.GREEN);
							txtTb2.setText("UNOCCUPIED");
							Tb2 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTb2 = new GridBagConstraints();
				gbc_tglTb2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb2.gridx = 4;
				gbc_tglTb2.gridy = 4;
				frameAcco.getContentPane().add(tglTb2, gbc_tglTb2);
				
				txtTb2 = new JTextField();
				txtTb2.setText("UNOCCUPIED");
				txtTb2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb2.setEditable(false);
				txtTb2.setColumns(10);
				txtTb2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb2 = new GridBagConstraints();
				gbc_txtTb2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb2.gridx = 5;
				gbc_txtTb2.gridy = 4;
				frameAcco.getContentPane().add(txtTb2, gbc_txtTb2);
				
				JToggleButton tglTb3 = new JToggleButton("TB3:");
				tglTb3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTb3.isSelected()) {
							txtTb3.setBackground(Color.RED);
							txtTb3.setText("OCCUPIED");
							Tb3 = "OCCUPIED";
						}
						else {
							txtTb3.setBackground(Color.GREEN);
							txtTb3.setText("UNOCCUPIED");
							Tb3 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTb3 = new GridBagConstraints();
				gbc_tglTb3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb3.gridx = 6;
				gbc_tglTb3.gridy = 4;
				frameAcco.getContentPane().add(tglTb3, gbc_tglTb3);
				
				txtTb3 = new JTextField();
				txtTb3.setText("UNOCCUPIED");
				txtTb3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb3.setEditable(false);
				txtTb3.setColumns(10);
				txtTb3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb3 = new GridBagConstraints();
				gbc_txtTb3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb3.gridx = 7;
				gbc_txtTb3.gridy = 4;
				frameAcco.getContentPane().add(txtTb3, gbc_txtTb3);
				
				JToggleButton tglTb4 = new JToggleButton("TB4:");
				tglTb4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTb4.isSelected()) {
							txtTb4.setBackground(Color.RED);
							txtTb4.setText("OCCUPIED");
							Tb4 = "OCCUPIED";
						}
						else {
							txtTb4.setBackground(Color.GREEN);
							txtTb4.setText("UNOCCUPIED");
							Tb4 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTb4 = new GridBagConstraints();
				gbc_tglTb4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb4.gridx = 8;
				gbc_tglTb4.gridy = 4;
				frameAcco.getContentPane().add(tglTb4, gbc_tglTb4);
				
				txtTb4 = new JTextField();
				txtTb4.setText("UNOCCUPIED");
				txtTb4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb4.setEditable(false);
				txtTb4.setColumns(10);
				txtTb4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb4 = new GridBagConstraints();
				gbc_txtTb4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb4.gridx = 9;
				gbc_txtTb4.gridy = 4;
				frameAcco.getContentPane().add(txtTb4, gbc_txtTb4);
				
				JToggleButton tglTb5 = new JToggleButton("TB5:");
				tglTb5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTb5.isSelected()) {
							txtTb5.setBackground(Color.RED);
							txtTb5.setText("OCCUPIED");
							Tb5 = "OCCUPIED";
						}
						else {
							txtTb5.setBackground(Color.GREEN);
							txtTb5.setText("UNOCCUPIED");
							Tb5 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTb5 = new GridBagConstraints();
				gbc_tglTb5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb5.gridx = 10;
				gbc_tglTb5.gridy = 4;
				frameAcco.getContentPane().add(tglTb5, gbc_tglTb5);
				
				txtTb5 = new JTextField();
				txtTb5.setText("UNOCCUPIED");
				txtTb5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb5.setEditable(false);
				txtTb5.setColumns(10);
				txtTb5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb5 = new GridBagConstraints();
				gbc_txtTb5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb5.gridx = 11;
				gbc_txtTb5.gridy = 4;
				frameAcco.getContentPane().add(txtTb5, gbc_txtTb5);
				
				JLabel lblTablesForSix = new JLabel("Tables for Six:");
				GridBagConstraints gbc_lblTablesForSix = new GridBagConstraints();
				gbc_lblTablesForSix.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForSix.gridx = 1;
				gbc_lblTablesForSix.gridy = 5;
				frameAcco.getContentPane().add(lblTablesForSix, gbc_lblTablesForSix);
				
				JToggleButton tglTc1 = new JToggleButton("TC1:");
				tglTc1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTc1.isSelected()) {
							txtTc1.setBackground(Color.RED);
							txtTc1.setText("OCCUPIED");
							Tc1 = "OCCUPIED";
						}
						else {
							txtTc1.setBackground(Color.GREEN);
							txtTc1.setText("UNOCCUPIED");
							Tc1 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTc1 = new GridBagConstraints();
				gbc_tglTc1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc1.gridx = 2;
				gbc_tglTc1.gridy = 6;
				frameAcco.getContentPane().add(tglTc1, gbc_tglTc1);
				
				txtTc1 = new JTextField();
				txtTc1.setText("UNOCCUPIED");
				txtTc1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc1.setEditable(false);
				txtTc1.setColumns(10);
				txtTc1.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc1 = new GridBagConstraints();
				gbc_txtTc1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc1.gridx = 3;
				gbc_txtTc1.gridy = 6;
				frameAcco.getContentPane().add(txtTc1, gbc_txtTc1);
				
				JToggleButton tglTc2 = new JToggleButton("TC2:");
				tglTc2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTc2.isSelected()) {
							txtTc2.setBackground(Color.RED);
							txtTc2.setText("OCCUPIED");
							Tc2 = "OCCUPIED";
						}
						else {
							txtTc2.setBackground(Color.GREEN);
							txtTc2.setText("UNOCCUPIED");
							Tc2 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTc2 = new GridBagConstraints();
				gbc_tglTc2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc2.gridx = 4;
				gbc_tglTc2.gridy = 6;
				frameAcco.getContentPane().add(tglTc2, gbc_tglTc2);
				
				txtTc2 = new JTextField();
				txtTc2.setText("UNOCCUPIED");
				txtTc2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc2.setEditable(false);
				txtTc2.setColumns(10);
				txtTc2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc2 = new GridBagConstraints();
				gbc_txtTc2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc2.gridx = 5;
				gbc_txtTc2.gridy = 6;
				frameAcco.getContentPane().add(txtTc2, gbc_txtTc2);
				
				JToggleButton tglTc3 = new JToggleButton("TC3:");
				tglTc3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTc3.isSelected()) {
							txtTc3.setBackground(Color.RED);
							txtTc3.setText("OCCUPIED");
							Tc3 = "OCCUPIED";
						}
						else {
							txtTc3.setBackground(Color.GREEN);
							txtTc3.setText("UNOCCUPIED");
							Tc3 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTc3 = new GridBagConstraints();
				gbc_tglTc3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc3.gridx = 6;
				gbc_tglTc3.gridy = 6;
				frameAcco.getContentPane().add(tglTc3, gbc_tglTc3);
				
				txtTc3 = new JTextField();
				txtTc3.setText("UNOCCUPIED");
				txtTc3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc3.setEditable(false);
				txtTc3.setColumns(10);
				txtTc3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc3 = new GridBagConstraints();
				gbc_txtTc3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc3.gridx = 7;
				gbc_txtTc3.gridy = 6;
				frameAcco.getContentPane().add(txtTc3, gbc_txtTc3);
				
				JToggleButton tglTc4 = new JToggleButton("TC4:");
				tglTc4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTc4.isSelected()) {
							txtTc4.setBackground(Color.RED);
							txtTc4.setText("OCCUPIED");
							Tc4 = "OCCUPIED";
						}
						else {
							txtTc4.setBackground(Color.GREEN);
							txtTc4.setText("UNOCCUPIED");
							Tc4 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTc4 = new GridBagConstraints();
				gbc_tglTc4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc4.gridx = 8;
				gbc_tglTc4.gridy = 6;
				frameAcco.getContentPane().add(tglTc4, gbc_tglTc4);
				
				txtTc4 = new JTextField();
				txtTc4.setText("UNOCCUPIED");
				txtTc4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc4.setEditable(false);
				txtTc4.setColumns(10);
				txtTc4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc4 = new GridBagConstraints();
				gbc_txtTc4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc4.gridx = 9;
				gbc_txtTc4.gridy = 6;
				frameAcco.getContentPane().add(txtTc4, gbc_txtTc4);
				
				JToggleButton tglTc5 = new JToggleButton("TC5:");
				tglTc5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTc5.isSelected()) {
							txtTc5.setBackground(Color.RED);
							txtTc5.setText("OCCUPIED");
							Tc5 = "OCCUPIED";
						}
						else {
							txtTc5.setBackground(Color.GREEN);
							txtTc5.setText("UNOCCUPIED");
							Tc5 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTc5 = new GridBagConstraints();
				gbc_tglTc5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc5.gridx = 10;
				gbc_tglTc5.gridy = 6;
				frameAcco.getContentPane().add(tglTc5, gbc_tglTc5);
				
				txtTc5 = new JTextField();
				txtTc5.setText("UNOCCUPIED");
				txtTc5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc5.setEditable(false);
				txtTc5.setColumns(10);
				txtTc5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc5 = new GridBagConstraints();
				gbc_txtTc5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc5.gridx = 11;
				gbc_txtTc5.gridy = 6;
				frameAcco.getContentPane().add(txtTc5, gbc_txtTc5);
				
				JLabel lblTablesForEight = new JLabel("Tables for Eight:");
				GridBagConstraints gbc_lblTablesForEight = new GridBagConstraints();
				gbc_lblTablesForEight.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForEight.gridx = 1;
				gbc_lblTablesForEight.gridy = 7;
				frameAcco.getContentPane().add(lblTablesForEight, gbc_lblTablesForEight);
				
				JToggleButton tglTd1 = new JToggleButton("TD1:");
				tglTd1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTd1.isSelected()) {
							txtTd1.setBackground(Color.RED);
							txtTd1.setText("OCCUPIED");
							Td1 = "OCCUPIED";
						}
						else {
							txtTd1.setBackground(Color.GREEN);
							txtTd1.setText("UNOCCUPIED");
							Td1 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTd1 = new GridBagConstraints();
				gbc_tglTd1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd1.gridx = 2;
				gbc_tglTd1.gridy = 8;
				frameAcco.getContentPane().add(tglTd1, gbc_tglTd1);
				
				txtTd1 = new JTextField();
				txtTd1.setText("UNOCCUPIED");
				txtTd1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd1.setEditable(false);
				txtTd1.setColumns(10);
				txtTd1.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd1 = new GridBagConstraints();
				gbc_txtTd1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd1.gridx = 3;
				gbc_txtTd1.gridy = 8;
				frameAcco.getContentPane().add(txtTd1, gbc_txtTd1);
				
				JToggleButton tglTd2 = new JToggleButton("TD2:");
				tglTd2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTd2.isSelected()) {
							txtTd2.setBackground(Color.RED);
							txtTd2.setText("OCCUPIED");
							Td2 = "OCCUPIED";
						}
						else {
							txtTd2.setBackground(Color.GREEN);
							txtTd2.setText("UNOCCUPIED");
							Td2 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTd2 = new GridBagConstraints();
				gbc_tglTd2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd2.gridx = 4;
				gbc_tglTd2.gridy = 8;
				frameAcco.getContentPane().add(tglTd2, gbc_tglTd2);
				
				txtTd2 = new JTextField();
				txtTd2.setText("UNOCCUPIED");
				txtTd2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd2.setEditable(false);
				txtTd2.setColumns(10);
				txtTd2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd2 = new GridBagConstraints();
				gbc_txtTd2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd2.gridx = 5;
				gbc_txtTd2.gridy = 8;
				frameAcco.getContentPane().add(txtTd2, gbc_txtTd2);
				
				JToggleButton tglTd3 = new JToggleButton("TD3:");
				tglTd3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTd3.isSelected()) {
							txtTd3.setBackground(Color.RED);
							txtTd3.setText("OCCUPIED");
							Td3 = "OCCUPIED";
						}
						else {
							txtTd3.setBackground(Color.GREEN);
							txtTd3.setText("UNOCCUPIED");
							Td3 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTd3 = new GridBagConstraints();
				gbc_tglTd3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd3.gridx = 6;
				gbc_tglTd3.gridy = 8;
				frameAcco.getContentPane().add(tglTd3, gbc_tglTd3);
				
				txtTd3 = new JTextField();
				txtTd3.setText("UNOCCUPIED");
				txtTd3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd3.setEditable(false);
				txtTd3.setColumns(10);
				txtTd3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd3 = new GridBagConstraints();
				gbc_txtTd3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd3.gridx = 7;
				gbc_txtTd3.gridy = 8;
				frameAcco.getContentPane().add(txtTd3, gbc_txtTd3);
				
				JToggleButton tglTd4 = new JToggleButton("TD4:");
				tglTd4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTd4.isSelected()) {
							txtTd4.setBackground(Color.RED);
							txtTd4.setText("OCCUPIED");
							Td4 = "OCCUPIED";
						}
						else {
							txtTd4.setBackground(Color.GREEN);
							txtTd4.setText("UNOCCUPIED");
							Td4 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTd4 = new GridBagConstraints();
				gbc_tglTd4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd4.gridx = 8;
				gbc_tglTd4.gridy = 8;
				frameAcco.getContentPane().add(tglTd4, gbc_tglTd4);
				
				txtTd4 = new JTextField();
				txtTd4.setText("UNOCCUPIED");
				txtTd4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd4.setEditable(false);
				txtTd4.setColumns(10);
				txtTd4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd4 = new GridBagConstraints();
				gbc_txtTd4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd4.gridx = 9;
				gbc_txtTd4.gridy = 8;
				frameAcco.getContentPane().add(txtTd4, gbc_txtTd4);
				
				JToggleButton tglTd5 = new JToggleButton("TD5:");
				tglTd5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tglTd5.isSelected()) {
							txtTd5.setBackground(Color.RED);
							txtTd5.setText("OCCUPIED");
							Td5 = "OCCUPIED";
						}
						else {
							txtTd5.setBackground(Color.GREEN);
							txtTd5.setText("UNOCCUPIED");
							Td5 = "UNOCCUPIED";
						}
					}
				});
				GridBagConstraints gbc_tglTd5 = new GridBagConstraints();
				gbc_tglTd5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd5.gridx = 10;
				gbc_tglTd5.gridy = 8;
				frameAcco.getContentPane().add(tglTd5, gbc_tglTd5);
				
				txtTd5 = new JTextField();
				txtTd5.setText("UNOCCUPIED");
				txtTd5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd5.setEditable(false);
				txtTd5.setColumns(10);
				txtTd5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd5 = new GridBagConstraints();
				gbc_txtTd5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd5.gridx = 11;
				gbc_txtTd5.gridy = 8;
				frameAcco.getContentPane().add(txtTd5, gbc_txtTd5);
				frameAcco.setVisible(true);
				frame.hide();
				frameAcco.show(true);
				

				JButton btnConfirm = new JButton("CONFIRM");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
				gbc_btnConfirm.fill = GridBagConstraints.VERTICAL;
				gbc_btnConfirm.insets = new Insets(0, 0, 0, 5);
				gbc_btnConfirm.gridx = 4;
				gbc_btnConfirm.gridy = 11;
				frameAcco.getContentPane().add(btnConfirm, gbc_btnConfirm);
				
				JButton btnCancel = new JButton("CANCEL");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frameAcco.hide();
						frame.show(true);
					}
				});
				GridBagConstraints gbc_btnCancel = new GridBagConstraints();
				gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
				gbc_btnCancel.gridx = 8;
				gbc_btnCancel.gridy = 11;
				frameAcco.getContentPane().add(btnCancel, gbc_btnCancel);
			}
		});
		
		JButton btnView = new JButton("View Available Tables");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameView= new JFrame();
				frameView.setBounds(100, 100, 1000, 500);
				frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				frameView.getContentPane().setLayout(gridBagLayout);
				
				JLabel lblAvailableTables = new JLabel("Available Tables");
				GridBagConstraints gbc_lblAvailableTables = new GridBagConstraints();
				gbc_lblAvailableTables.insets = new Insets(0, 0, 5, 5);
				gbc_lblAvailableTables.gridx = 1;
				gbc_lblAvailableTables.gridy = 0;
				frameView.getContentPane().add(lblAvailableTables, gbc_lblAvailableTables);
				
				
				JLabel lblTablesForTwo = new JLabel("Tables for Two:");
				GridBagConstraints gbc_lblTablesForTwo = new GridBagConstraints();
				gbc_lblTablesForTwo.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForTwo.gridx = 1;
				gbc_lblTablesForTwo.gridy = 1;
				frameView.getContentPane().add(lblTablesForTwo, gbc_lblTablesForTwo);
				
				JToggleButton tglTa1 = new JToggleButton("TA1:");
				
							if(Ta1=="OCCUPIED") {
								txtTa1.setBackground(Color.RED);
								txtTa1.setText("OCCUPIED");
							}
							else {
								txtTa1.setBackground(Color.GREEN);
								txtTa1.setText("UNOCCUPIED");
							}
				
			
				GridBagConstraints gbc_tglTa1 = new GridBagConstraints();
				gbc_tglTa1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa1.gridx = 2;
				gbc_tglTa1.gridy = 2;
				frameView.getContentPane().add(tglTa1, gbc_tglTa1);
				
				txtTa1 = new JTextField();
				txtTa1.setBackground(Color.GREEN);
				txtTa1.setText("UNOCCUPIED");
				txtTa1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa1.setEditable(false);
				GridBagConstraints gbc_txtTa1 = new GridBagConstraints();
				gbc_txtTa1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa1.gridx = 3;
				gbc_txtTa1.gridy = 2;
				frameView.getContentPane().add(txtTa1, gbc_txtTa1);
				txtTa1.setColumns(10);
				
				JToggleButton tglTa2 = new JToggleButton("TA2:");

				else if(Ta2=="OCCUPIED") {
							txtTa2.setBackground(Color.RED);
							txtTa2.setText("OCCUPIED");
						}
						else {
							txtTa2.setBackground(Color.GREEN);
							txtTa2.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTa2 = new GridBagConstraints();
				gbc_tglTa2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa2.gridx = 4;
				gbc_tglTa2.gridy = 2;
				frameView.getContentPane().add(tglTa2, gbc_tglTa2);
				
				txtTa2 = new JTextField();
				txtTa2.setText("UNOCCUPIED");
				txtTa2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa2.setEditable(false);
				txtTa2.setColumns(10);
				txtTa2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa2 = new GridBagConstraints();
				gbc_txtTa2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa2.gridx = 5;
				gbc_txtTa2.gridy = 2;
				frameView.getContentPane().add(txtTa2, gbc_txtTa2);
				
				JToggleButton tglTa3 = new JToggleButton("TA3:");
				
				 if(Ta3=="OCCUPIED") {
							txtTa3.setBackground(Color.RED);
							txtTa3.setText("OCCUPIED");
						}
						else {
							txtTa3.setBackground(Color.GREEN);
							txtTa3.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTa3 = new GridBagConstraints();
				gbc_tglTa3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa3.gridx = 6;
				gbc_tglTa3.gridy = 2;
				frameView.getContentPane().add(tglTa3, gbc_tglTa3);
				
				txtTa3 = new JTextField();
				txtTa3.setText("UNOCCUPIED");
				txtTa3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa3.setEditable(false);
				txtTa3.setColumns(10);
				txtTa3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa3 = new GridBagConstraints();
				gbc_txtTa3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa3.gridx = 7;
				gbc_txtTa3.gridy = 2;
				frameView.getContentPane().add(txtTa3, gbc_txtTa3);
				
				JToggleButton tglTa4 = new JToggleButton("TA4:");
				
				 if(Ta4=="OCCUPIED") {
							txtTa4.setBackground(Color.RED);
							txtTa4.setText("OCCUPIED");
						}
						else {
							txtTa4.setBackground(Color.GREEN);
							txtTa4.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTa4 = new GridBagConstraints();
				gbc_tglTa4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa4.gridx = 8;
				gbc_tglTa4.gridy = 2;
				frameView.getContentPane().add(tglTa4, gbc_tglTa4);
				
				txtTa4 = new JTextField();
				txtTa4.setText("UNOCCUPIED");
				txtTa4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa4.setEditable(false);
				txtTa4.setColumns(10);
				txtTa4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa4 = new GridBagConstraints();
				gbc_txtTa4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa4.gridx = 9;
				gbc_txtTa4.gridy = 2;
				frameView.getContentPane().add(txtTa4, gbc_txtTa4);
				
				JToggleButton tglTa5 = new JToggleButton("TA5:");
				
				 if(Ta5=="OCCUPIED") {
							txtTa5.setBackground(Color.RED);
							txtTa5.setText("OCCUPIED");
						}
						else {
							txtTa5.setBackground(Color.GREEN);
							txtTa5.setText("UNOCCUPIED");
						}
				
				GridBagConstraints gbc_tglTa5 = new GridBagConstraints();
				gbc_tglTa5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTa5.gridx = 10;
				gbc_tglTa5.gridy = 2;
				frameView.getContentPane().add(tglTa5, gbc_tglTa5);
				
				txtTa5 = new JTextField();
				txtTa5.setText("UNOCCUPIED");
				txtTa5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTa5.setEditable(false);
				txtTa5.setColumns(10);
				txtTa5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTa5 = new GridBagConstraints();
				gbc_txtTa5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTa5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTa5.gridx = 11;
				gbc_txtTa5.gridy = 2;
				frameView.getContentPane().add(txtTa5, gbc_txtTa5);
				
				JLabel lblTablesForFour = new JLabel("Tables for Four:");
				GridBagConstraints gbc_lblTablesForFour = new GridBagConstraints();
				gbc_lblTablesForFour.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForFour.gridx = 1;
				gbc_lblTablesForFour.gridy = 3;
				frameView.getContentPane().add(lblTablesForFour, gbc_lblTablesForFour);
				
				JToggleButton tglTb1 = new JToggleButton("TB1:");
				
						if(Tb1=="OCCUPIED") {
							txtTb1.setBackground(Color.RED);
							txtTb1.setText("OCCUPIED");
						}
						else {
							txtTb1.setBackground(Color.GREEN);
							txtTb1.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTb1 = new GridBagConstraints();
				gbc_tglTb1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb1.gridx = 2;
				gbc_tglTb1.gridy = 4;
				frameView.getContentPane().add(tglTb1, gbc_tglTb1);
				
				txtTb1 = new JTextField();
				txtTb1.setText("UNOCCUPIED");
				txtTb1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb1.setEditable(false);
				txtTb1.setColumns(10);
				txtTb1.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb1 = new GridBagConstraints();
				gbc_txtTb1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb1.gridx = 3;
				gbc_txtTb1.gridy = 4;
				frameView.getContentPane().add(txtTb1, gbc_txtTb1);
				
				JToggleButton tglTb2 = new JToggleButton("TB2:");
				
						if(Tb2=="OCCUPIED") {
							txtTb2.setBackground(Color.RED);
							txtTb2.setText("OCCUPIED");
						}
						else {
							txtTb2.setBackground(Color.GREEN);
							txtTb2.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTb2 = new GridBagConstraints();
				gbc_tglTb2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb2.gridx = 4;
				gbc_tglTb2.gridy = 4;
				frameView.getContentPane().add(tglTb2, gbc_tglTb2);
				
				txtTb2 = new JTextField();
				txtTb2.setText("UNOCCUPIED");
				txtTb2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb2.setEditable(false);
				txtTb2.setColumns(10);
				txtTb2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb2 = new GridBagConstraints();
				gbc_txtTb2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb2.gridx = 5;
				gbc_txtTb2.gridy = 4;
				frameView.getContentPane().add(txtTb2, gbc_txtTb2);
				
				JToggleButton tglTb3 = new JToggleButton("TB3:");
				
						if(Tb3=="OCCUPIED") {
							txtTb3.setBackground(Color.RED);
							txtTb3.setText("OCCUPIED");
						}
						else {
							txtTb3.setBackground(Color.GREEN);
							txtTb3.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTb3 = new GridBagConstraints();
				gbc_tglTb3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb3.gridx = 6;
				gbc_tglTb3.gridy = 4;
				frameView.getContentPane().add(tglTb3, gbc_tglTb3);
				
				txtTb3 = new JTextField();
				txtTb3.setText("UNOCCUPIED");
				txtTb3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb3.setEditable(false);
				txtTb3.setColumns(10);
				txtTb3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb3 = new GridBagConstraints();
				gbc_txtTb3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb3.gridx = 7;
				gbc_txtTb3.gridy = 4;
				frameView.getContentPane().add(txtTb3, gbc_txtTb3);
				
				JToggleButton tglTb4 = new JToggleButton("TB4:");
				
						if(Tb4=="OCCUPIED") {
							txtTb4.setBackground(Color.RED);
							txtTb4.setText("OCCUPIED");
						}
						else {
							txtTb4.setBackground(Color.GREEN);
							txtTb4.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTb4 = new GridBagConstraints();
				gbc_tglTb4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb4.gridx = 8;
				gbc_tglTb4.gridy = 4;
				frameView.getContentPane().add(tglTb4, gbc_tglTb4);
				
				txtTb4 = new JTextField();
				txtTb4.setText("UNOCCUPIED");
				txtTb4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb4.setEditable(false);
				txtTb4.setColumns(10);
				txtTb4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb4 = new GridBagConstraints();
				gbc_txtTb4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb4.gridx = 9;
				gbc_txtTb4.gridy = 4;
				frameView.getContentPane().add(txtTb4, gbc_txtTb4);
				
				JToggleButton tglTb5 = new JToggleButton("TB5:");
				
						if(Tb5=="OCCUPIED") {
							txtTb5.setBackground(Color.RED);
							txtTb5.setText("OCCUPIED");
						}
						else {
							txtTb5.setBackground(Color.GREEN);
							txtTb5.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTb5 = new GridBagConstraints();
				gbc_tglTb5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTb5.gridx = 10;
				gbc_tglTb5.gridy = 4;
				frameView.getContentPane().add(tglTb5, gbc_tglTb5);
				
				txtTb5 = new JTextField();
				txtTb5.setText("UNOCCUPIED");
				txtTb5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTb5.setEditable(false);
				txtTb5.setColumns(10);
				txtTb5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTb5 = new GridBagConstraints();
				gbc_txtTb5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTb5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTb5.gridx = 11;
				gbc_txtTb5.gridy = 4;
				frameView.getContentPane().add(txtTb5, gbc_txtTb5);
				
				JLabel lblTablesForSix = new JLabel("Tables for Six:");
				GridBagConstraints gbc_lblTablesForSix = new GridBagConstraints();
				gbc_lblTablesForSix.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForSix.gridx = 1;
				gbc_lblTablesForSix.gridy = 5;
				frameView.getContentPane().add(lblTablesForSix, gbc_lblTablesForSix);
				
				JToggleButton tglTc1 = new JToggleButton("TC1:");
				
						if(Tc1=="OCCUPIED") {
							txtTc1.setBackground(Color.RED);
							txtTc1.setText("OCCUPIED");
						}
						else {
							txtTc1.setBackground(Color.GREEN);
							txtTc1.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTc1 = new GridBagConstraints();
				gbc_tglTc1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc1.gridx = 2;
				gbc_tglTc1.gridy = 6;
				frameView.getContentPane().add(tglTc1, gbc_tglTc1);
				
				txtTc1 = new JTextField();
				txtTc1.setText("UNOCCUPIED");
				txtTc1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc1.setEditable(false);
				txtTc1.setColumns(10);
				txtTc1.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc1 = new GridBagConstraints();
				gbc_txtTc1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc1.gridx = 3;
				gbc_txtTc1.gridy = 6;
				frameView.getContentPane().add(txtTc1, gbc_txtTc1);
				
				JToggleButton tglTc2 = new JToggleButton("TC2:");
		
						if(Tc2=="OCCUPIED") {
							txtTc2.setBackground(Color.RED);
							txtTc2.setText("OCCUPIED");
						}
						else {
							txtTc2.setBackground(Color.GREEN);
							txtTc2.setText("UNOCCUPIED");
						}
			
				GridBagConstraints gbc_tglTc2 = new GridBagConstraints();
				gbc_tglTc2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc2.gridx = 4;
				gbc_tglTc2.gridy = 6;
				frameView.getContentPane().add(tglTc2, gbc_tglTc2);
				
				txtTc2 = new JTextField();
				txtTc2.setText("UNOCCUPIED");
				txtTc2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc2.setEditable(false);
				txtTc2.setColumns(10);
				txtTc2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc2 = new GridBagConstraints();
				gbc_txtTc2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc2.gridx = 5;
				gbc_txtTc2.gridy = 6;
				frameView.getContentPane().add(txtTc2, gbc_txtTc2);
				
				JToggleButton tglTc3 = new JToggleButton("TC3:");
				tglTc3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Tc3=="OCCUPIED") {
							txtTc3.setBackground(Color.RED);
							txtTc3.setText("OCCUPIED");
						}
						else {
							txtTc3.setBackground(Color.GREEN);
							txtTc3.setText("UNOCCUPIED");
						}
					
				GridBagConstraints gbc_tglTc3 = new GridBagConstraints();
				gbc_tglTc3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc3.gridx = 6;
				gbc_tglTc3.gridy = 6;
				frameView.getContentPane().add(tglTc3, gbc_tglTc3);
				
				txtTc3 = new JTextField();
				txtTc3.setText("UNOCCUPIED");
				txtTc3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc3.setEditable(false);
				txtTc3.setColumns(10);
				txtTc3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc3 = new GridBagConstraints();
				gbc_txtTc3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc3.gridx = 7;
				gbc_txtTc3.gridy = 6;
				frameView.getContentPane().add(txtTc3, gbc_txtTc3);
				
				JToggleButton tglTc4 = new JToggleButton("TC4:");
						if(Tc4=="OCCUPIED") {
							txtTc4.setBackground(Color.RED);
							txtTc4.setText("OCCUPIED");
						}
						else {
							txtTc4.setBackground(Color.GREEN);
							txtTc4.setText("UNOCCUPIED");
						}
		
				GridBagConstraints gbc_tglTc4 = new GridBagConstraints();
				gbc_tglTc4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc4.gridx = 8;
				gbc_tglTc4.gridy = 6;
				frameView.getContentPane().add(tglTc4, gbc_tglTc4);
				
				txtTc4 = new JTextField();
				txtTc4.setText("UNOCCUPIED");
				txtTc4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc4.setEditable(false);
				txtTc4.setColumns(10);
				txtTc4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc4 = new GridBagConstraints();
				gbc_txtTc4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc4.gridx = 9;
				gbc_txtTc4.gridy = 6;
				frameView.getContentPane().add(txtTc4, gbc_txtTc4);
				
				JToggleButton tglTc5 = new JToggleButton("TC5:");
			
						if(Tc1=="OCCUPIED") {
							txtTc5.setBackground(Color.RED);
							txtTc5.setText("OCCUPIED");
						}
						else {
							txtTc5.setBackground(Color.GREEN);
							txtTc5.setText("UNOCCUPIED");
						}
			
				GridBagConstraints gbc_tglTc5 = new GridBagConstraints();
				gbc_tglTc5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTc5.gridx = 10;
				gbc_tglTc5.gridy = 6;
				frameView.getContentPane().add(tglTc5, gbc_tglTc5);
				
				txtTc5 = new JTextField();
				txtTc5.setText("UNOCCUPIED");
				txtTc5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTc5.setEditable(false);
				txtTc5.setColumns(10);
				txtTc5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTc5 = new GridBagConstraints();
				gbc_txtTc5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTc5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTc5.gridx = 11;
				gbc_txtTc5.gridy = 6;
				frameView.getContentPane().add(txtTc5, gbc_txtTc5);
				
				JLabel lblTablesForEight = new JLabel("Tables for Eight:");
				GridBagConstraints gbc_lblTablesForEight = new GridBagConstraints();
				gbc_lblTablesForEight.insets = new Insets(0, 0, 5, 5);
				gbc_lblTablesForEight.gridx = 1;
				gbc_lblTablesForEight.gridy = 7;
				frameView.getContentPane().add(lblTablesForEight, gbc_lblTablesForEight);
				
				JToggleButton tglTd1 = new JToggleButton("TD1:");
			
						if(Td1=="OCCUPIED") {
							txtTd1.setBackground(Color.RED);
							txtTd1.setText("OCCUPIED");
						}
						else {
							txtTd1.setBackground(Color.GREEN);
							txtTd1.setText("UNOCCUPIED");
						}
				
				GridBagConstraints gbc_tglTd1 = new GridBagConstraints();
				gbc_tglTd1.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd1.gridx = 2;
				gbc_tglTd1.gridy = 8;
				frameView.getContentPane().add(tglTd1, gbc_tglTd1);
				
				txtTd1 = new JTextField();
				txtTd1.setText("UNOCCUPIED");
				txtTd1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd1.setEditable(false);
				txtTd1.setColumns(10);
				txtTd1.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd1 = new GridBagConstraints();
				gbc_txtTd1.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd1.gridx = 3;
				gbc_txtTd1.gridy = 8;
				frameView.getContentPane().add(txtTd1, gbc_txtTd1);
				
				JToggleButton tglTd2 = new JToggleButton("TD2:");
				
						if(Td2=="OCCUPIED") {
							txtTd2.setBackground(Color.RED);
							txtTd2.setText("OCCUPIED");
						}
						else {
							txtTd2.setBackground(Color.GREEN);
							txtTd2.setText("UNOCCUPIED");
						}
			
				GridBagConstraints gbc_tglTd2 = new GridBagConstraints();
				gbc_tglTd2.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd2.gridx = 4;
				gbc_tglTd2.gridy = 8;
				frameView.getContentPane().add(tglTd2, gbc_tglTd2);
				
				txtTd2 = new JTextField();
				txtTd2.setText("UNOCCUPIED");
				txtTd2.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd2.setEditable(false);
				txtTd2.setColumns(10);
				txtTd2.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd2 = new GridBagConstraints();
				gbc_txtTd2.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd2.gridx = 5;
				gbc_txtTd2.gridy = 8;
				frameView.getContentPane().add(txtTd2, gbc_txtTd2);
				
				JToggleButton tglTd3 = new JToggleButton("TD3:");
				
						if(Td3=="OCCUPIED") {
							txtTd3.setBackground(Color.RED);
							txtTd3.setText("OCCUPIED");
						}
						else {
							txtTd3.setBackground(Color.GREEN);
							txtTd3.setText("UNOCCUPIED");
						}
				
				GridBagConstraints gbc_tglTd3 = new GridBagConstraints();
				gbc_tglTd3.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd3.gridx = 6;
				gbc_tglTd3.gridy = 8;
				frameView.getContentPane().add(tglTd3, gbc_tglTd3);
				
				txtTd3 = new JTextField();
				txtTd3.setText("UNOCCUPIED");
				txtTd3.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd3.setEditable(false);
				txtTd3.setColumns(10);
				txtTd3.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd3 = new GridBagConstraints();
				gbc_txtTd3.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd3.gridx = 7;
				gbc_txtTd3.gridy = 8;
				frameView.getContentPane().add(txtTd3, gbc_txtTd3);
				
				JToggleButton tglTd4 = new JToggleButton("TD4:");
				
						if(Td4=="OCCUPIED") {
							txtTd4.setBackground(Color.RED);
							txtTd4.setText("OCCUPIED");
						}
						else {
							txtTd4.setBackground(Color.GREEN);
							txtTd4.setText("UNOCCUPIED");
						}
			
				GridBagConstraints gbc_tglTd4 = new GridBagConstraints();
				gbc_tglTd4.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd4.gridx = 8;
				gbc_tglTd4.gridy = 8;
				frameView.getContentPane().add(tglTd4, gbc_tglTd4);
				
				txtTd4 = new JTextField();
				txtTd4.setText("UNOCCUPIED");
				txtTd4.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd4.setEditable(false);
				txtTd4.setColumns(10);
				txtTd4.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd4 = new GridBagConstraints();
				gbc_txtTd4.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd4.gridx = 9;
				gbc_txtTd4.gridy = 8;
				frameView.getContentPane().add(txtTd4, gbc_txtTd4);
				
				JToggleButton tglTd5 = new JToggleButton("TD5:");
				
						if(Td5=="OCCUPIED") {
							txtTd5.setBackground(Color.RED);
							txtTd5.setText("OCCUPIED");
						}
						else {
							txtTd5.setBackground(Color.GREEN);
							txtTd5.setText("UNOCCUPIED");
						}
			
				GridBagConstraints gbc_tglTd5 = new GridBagConstraints();
				gbc_tglTd5.insets = new Insets(0, 0, 5, 5);
				gbc_tglTd5.gridx = 10;
				gbc_tglTd5.gridy = 8;
				frameView.getContentPane().add(tglTd5, gbc_tglTd5);
				
				txtTd5 = new JTextField();
				txtTd5.setText("UNOCCUPIED");
				txtTd5.setHorizontalAlignment(SwingConstants.CENTER);
				txtTd5.setEditable(false);
				txtTd5.setColumns(10);
				txtTd5.setBackground(Color.GREEN);
				GridBagConstraints gbc_txtTd5 = new GridBagConstraints();
				gbc_txtTd5.insets = new Insets(0, 0, 5, 5);
				gbc_txtTd5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTd5.gridx = 11;
				gbc_txtTd5.gridy = 8;
				frameView.getContentPane().add(txtTd5, gbc_txtTd5);
				
				/*JButton btnConfirm = new JButton("CONFIRM");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
				gbc_btnConfirm.fill = GridBagConstraints.VERTICAL;
				gbc_btnConfirm.insets = new Insets(0, 0, 0, 5);
				gbc_btnConfirm.gridx = 4;
				gbc_btnConfirm.gridy = 11;
				frameView.getContentPane().add(btnConfirm, gbc_btnConfirm);*/
				
				frameView.setVisible(true);
				frame.hide();
				frameView.show(true);
				
				JButton btnCancel = new JButton("CANCEL");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frameView.hide();
						frame.show(true);
					}
				});
				GridBagConstraints gbc_btnCancel = new GridBagConstraints();
				gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
				gbc_btnCancel.gridx = 6;
				gbc_btnCancel.gridy = 11;
				frameView.getContentPane().add(btnCancel, gbc_btnCancel);
			}
		});
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRestoresto)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(lblClock, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(151, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnView)
						.addComponent(btnAccomodateCustomer))
					.addGap(142))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRestoresto))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblClock, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addComponent(btnAccomodateCustomer)
					.addGap(40)
					.addComponent(btnView)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		lblClock.setFont(new Font("Consolas", Font.BOLD, 11));
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		}
	
