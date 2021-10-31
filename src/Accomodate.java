import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Accomodate {

	private JFrame frame;
	private JTextField txtTa1;	private JTextField txtTa2;	private JTextField txtTa3; private JTextField txtTa4;	private JTextField txtTa5;	private JTextField txtTb1;	private JTextField txtTb2;	private JTextField txtTb3;
	private JTextField txtTb4;
	private JTextField txtTb5;
	private JTextField txtTc1;
	private JTextField txtTc2;
	private JTextField txtTc3;
	private JTextField txtTc4;
	private JTextField txtTc5;
	private JTextField txtTd1;
	private JTextField txtTd2;
	private JTextField txtTd3;
	private JTextField txtTd4;
	private JTextField txtTd5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accomodate window = new Accomodate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accomodate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAvailableTables = new JLabel("Available Tables");
		GridBagConstraints gbc_lblAvailableTables = new GridBagConstraints();
		gbc_lblAvailableTables.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvailableTables.gridx = 1;
		gbc_lblAvailableTables.gridy = 0;
		frame.getContentPane().add(lblAvailableTables, gbc_lblAvailableTables);
		
		JLabel lblTablesForTwo = new JLabel("Tables for Two:");
		GridBagConstraints gbc_lblTablesForTwo = new GridBagConstraints();
		gbc_lblTablesForTwo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTablesForTwo.gridx = 1;
		gbc_lblTablesForTwo.gridy = 1;
		frame.getContentPane().add(lblTablesForTwo, gbc_lblTablesForTwo);
		
		JToggleButton tglTa1 = new JToggleButton("TA1:");
		tglTa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(tglTa1.isSelected()) {
						txtTa1.setBackground(Color.RED);
						txtTa1.setText("OCCUPIED");
					}
					else {
						txtTa1.setBackground(Color.GREEN);
						txtTa1.setText("UNOCCUPIED");
					}
			}
		});
		GridBagConstraints gbc_tglTa1 = new GridBagConstraints();
		gbc_tglTa1.insets = new Insets(0, 0, 5, 5);
		gbc_tglTa1.gridx = 2;
		gbc_tglTa1.gridy = 2;
		frame.getContentPane().add(tglTa1, gbc_tglTa1);
		
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
		frame.getContentPane().add(txtTa1, gbc_txtTa1);
		txtTa1.setColumns(10);
		
		JToggleButton tglTa2 = new JToggleButton("TA2:");
		tglTa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTa2.isSelected()) {
					txtTa2.setBackground(Color.RED);
					txtTa2.setText("OCCUPIED");
				}
				else {
					txtTa2.setBackground(Color.GREEN);
					txtTa2.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTa2 = new GridBagConstraints();
		gbc_tglTa2.insets = new Insets(0, 0, 5, 5);
		gbc_tglTa2.gridx = 4;
		gbc_tglTa2.gridy = 2;
		frame.getContentPane().add(tglTa2, gbc_tglTa2);
		
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
		frame.getContentPane().add(txtTa2, gbc_txtTa2);
		
		JToggleButton tglTa3 = new JToggleButton("TA3:");
		tglTa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTa3.isSelected()) {
					txtTa3.setBackground(Color.RED);
					txtTa3.setText("OCCUPIED");
				}
				else {
					txtTa3.setBackground(Color.GREEN);
					txtTa3.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTa3 = new GridBagConstraints();
		gbc_tglTa3.insets = new Insets(0, 0, 5, 5);
		gbc_tglTa3.gridx = 6;
		gbc_tglTa3.gridy = 2;
		frame.getContentPane().add(tglTa3, gbc_tglTa3);
		
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
		frame.getContentPane().add(txtTa3, gbc_txtTa3);
		
		JToggleButton tglTa4 = new JToggleButton("TA4:");
		tglTa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTa4.isSelected()) {
					txtTa4.setBackground(Color.RED);
					txtTa4.setText("OCCUPIED");
				}
				else {
					txtTa4.setBackground(Color.GREEN);
					txtTa4.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTa4 = new GridBagConstraints();
		gbc_tglTa4.insets = new Insets(0, 0, 5, 5);
		gbc_tglTa4.gridx = 8;
		gbc_tglTa4.gridy = 2;
		frame.getContentPane().add(tglTa4, gbc_tglTa4);
		
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
		frame.getContentPane().add(txtTa4, gbc_txtTa4);
		
		JToggleButton tglTa5 = new JToggleButton("TA5:");
		tglTa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTa5.isSelected()) {
					txtTa5.setBackground(Color.RED);
					txtTa5.setText("OCCUPIED");
				}
				else {
					txtTa5.setBackground(Color.GREEN);
					txtTa5.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTa5 = new GridBagConstraints();
		gbc_tglTa5.insets = new Insets(0, 0, 5, 5);
		gbc_tglTa5.gridx = 10;
		gbc_tglTa5.gridy = 2;
		frame.getContentPane().add(tglTa5, gbc_tglTa5);
		
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
		frame.getContentPane().add(txtTa5, gbc_txtTa5);
		
		JLabel lblTablesForFour = new JLabel("Tables for Four:");
		GridBagConstraints gbc_lblTablesForFour = new GridBagConstraints();
		gbc_lblTablesForFour.insets = new Insets(0, 0, 5, 5);
		gbc_lblTablesForFour.gridx = 1;
		gbc_lblTablesForFour.gridy = 3;
		frame.getContentPane().add(lblTablesForFour, gbc_lblTablesForFour);
		
		JToggleButton tglTb1 = new JToggleButton("TB1:");
		tglTb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTb1.isSelected()) {
					txtTb1.setBackground(Color.RED);
					txtTb1.setText("OCCUPIED");
				}
				else {
					txtTb1.setBackground(Color.GREEN);
					txtTb1.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTb1 = new GridBagConstraints();
		gbc_tglTb1.insets = new Insets(0, 0, 5, 5);
		gbc_tglTb1.gridx = 2;
		gbc_tglTb1.gridy = 4;
		frame.getContentPane().add(tglTb1, gbc_tglTb1);
		
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
		frame.getContentPane().add(txtTb1, gbc_txtTb1);
		
		JToggleButton tglTb2 = new JToggleButton("TB2:");
		tglTb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTb2.isSelected()) {
					txtTb2.setBackground(Color.RED);
					txtTb2.setText("OCCUPIED");
				}
				else {
					txtTb2.setBackground(Color.GREEN);
					txtTb2.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTb2 = new GridBagConstraints();
		gbc_tglTb2.insets = new Insets(0, 0, 5, 5);
		gbc_tglTb2.gridx = 4;
		gbc_tglTb2.gridy = 4;
		frame.getContentPane().add(tglTb2, gbc_tglTb2);
		
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
		frame.getContentPane().add(txtTb2, gbc_txtTb2);
		
		JToggleButton tglTb3 = new JToggleButton("TB3:");
		tglTb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTb3.isSelected()) {
					txtTb3.setBackground(Color.RED);
					txtTb3.setText("OCCUPIED");
				}
				else {
					txtTb3.setBackground(Color.GREEN);
					txtTb3.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTb3 = new GridBagConstraints();
		gbc_tglTb3.insets = new Insets(0, 0, 5, 5);
		gbc_tglTb3.gridx = 6;
		gbc_tglTb3.gridy = 4;
		frame.getContentPane().add(tglTb3, gbc_tglTb3);
		
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
		frame.getContentPane().add(txtTb3, gbc_txtTb3);
		
		JToggleButton tglTb4 = new JToggleButton("TB4:");
		tglTb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTb4.isSelected()) {
					txtTb4.setBackground(Color.RED);
					txtTb4.setText("OCCUPIED");
				}
				else {
					txtTb4.setBackground(Color.GREEN);
					txtTb4.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTb4 = new GridBagConstraints();
		gbc_tglTb4.insets = new Insets(0, 0, 5, 5);
		gbc_tglTb4.gridx = 8;
		gbc_tglTb4.gridy = 4;
		frame.getContentPane().add(tglTb4, gbc_tglTb4);
		
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
		frame.getContentPane().add(txtTb4, gbc_txtTb4);
		
		JToggleButton tglTb5 = new JToggleButton("TB5:");
		tglTb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTb5.isSelected()) {
					txtTb5.setBackground(Color.RED);
					txtTb5.setText("OCCUPIED");
				}
				else {
					txtTb5.setBackground(Color.GREEN);
					txtTb5.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTb5 = new GridBagConstraints();
		gbc_tglTb5.insets = new Insets(0, 0, 5, 5);
		gbc_tglTb5.gridx = 10;
		gbc_tglTb5.gridy = 4;
		frame.getContentPane().add(tglTb5, gbc_tglTb5);
		
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
		frame.getContentPane().add(txtTb5, gbc_txtTb5);
		
		JLabel lblTablesForSix = new JLabel("Tables for Six:");
		GridBagConstraints gbc_lblTablesForSix = new GridBagConstraints();
		gbc_lblTablesForSix.insets = new Insets(0, 0, 5, 5);
		gbc_lblTablesForSix.gridx = 1;
		gbc_lblTablesForSix.gridy = 5;
		frame.getContentPane().add(lblTablesForSix, gbc_lblTablesForSix);
		
		JToggleButton tglTc1 = new JToggleButton("TC1:");
		tglTc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTc1.isSelected()) {
					txtTc1.setBackground(Color.RED);
					txtTc1.setText("OCCUPIED");
				}
				else {
					txtTc1.setBackground(Color.GREEN);
					txtTc1.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTc1 = new GridBagConstraints();
		gbc_tglTc1.insets = new Insets(0, 0, 5, 5);
		gbc_tglTc1.gridx = 2;
		gbc_tglTc1.gridy = 6;
		frame.getContentPane().add(tglTc1, gbc_tglTc1);
		
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
		frame.getContentPane().add(txtTc1, gbc_txtTc1);
		
		JToggleButton tglTc2 = new JToggleButton("TC2:");
		tglTc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTc2.isSelected()) {
					txtTc2.setBackground(Color.RED);
					txtTc2.setText("OCCUPIED");
				}
				else {
					txtTc2.setBackground(Color.GREEN);
					txtTc2.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTc2 = new GridBagConstraints();
		gbc_tglTc2.insets = new Insets(0, 0, 5, 5);
		gbc_tglTc2.gridx = 4;
		gbc_tglTc2.gridy = 6;
		frame.getContentPane().add(tglTc2, gbc_tglTc2);
		
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
		frame.getContentPane().add(txtTc2, gbc_txtTc2);
		
		JToggleButton tglTc3 = new JToggleButton("TC3:");
		tglTc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTc3.isSelected()) {
					txtTc3.setBackground(Color.RED);
					txtTc3.setText("OCCUPIED");
				}
				else {
					txtTc3.setBackground(Color.GREEN);
					txtTc3.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTc3 = new GridBagConstraints();
		gbc_tglTc3.insets = new Insets(0, 0, 5, 5);
		gbc_tglTc3.gridx = 6;
		gbc_tglTc3.gridy = 6;
		frame.getContentPane().add(tglTc3, gbc_tglTc3);
		
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
		frame.getContentPane().add(txtTc3, gbc_txtTc3);
		
		JToggleButton tglTc4 = new JToggleButton("TC4:");
		tglTc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTc4.isSelected()) {
					txtTc4.setBackground(Color.RED);
					txtTc4.setText("OCCUPIED");
				}
				else {
					txtTc4.setBackground(Color.GREEN);
					txtTc4.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTc4 = new GridBagConstraints();
		gbc_tglTc4.insets = new Insets(0, 0, 5, 5);
		gbc_tglTc4.gridx = 8;
		gbc_tglTc4.gridy = 6;
		frame.getContentPane().add(tglTc4, gbc_tglTc4);
		
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
		frame.getContentPane().add(txtTc4, gbc_txtTc4);
		
		JToggleButton tglTc5 = new JToggleButton("TC5:");
		tglTc5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTc5.isSelected()) {
					txtTc5.setBackground(Color.RED);
					txtTc5.setText("OCCUPIED");
				}
				else {
					txtTc5.setBackground(Color.GREEN);
					txtTc5.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTc5 = new GridBagConstraints();
		gbc_tglTc5.insets = new Insets(0, 0, 5, 5);
		gbc_tglTc5.gridx = 10;
		gbc_tglTc5.gridy = 6;
		frame.getContentPane().add(tglTc5, gbc_tglTc5);
		
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
		frame.getContentPane().add(txtTc5, gbc_txtTc5);
		
		JLabel lblTablesForEight = new JLabel("Tables for Eight:");
		GridBagConstraints gbc_lblTablesForEight = new GridBagConstraints();
		gbc_lblTablesForEight.insets = new Insets(0, 0, 5, 5);
		gbc_lblTablesForEight.gridx = 1;
		gbc_lblTablesForEight.gridy = 7;
		frame.getContentPane().add(lblTablesForEight, gbc_lblTablesForEight);
		
		JToggleButton tglTd1 = new JToggleButton("TD1:");
		tglTd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTd1.isSelected()) {
					txtTd1.setBackground(Color.RED);
					txtTd1.setText("OCCUPIED");
				}
				else {
					txtTd1.setBackground(Color.GREEN);
					txtTd1.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTd1 = new GridBagConstraints();
		gbc_tglTd1.insets = new Insets(0, 0, 5, 5);
		gbc_tglTd1.gridx = 2;
		gbc_tglTd1.gridy = 8;
		frame.getContentPane().add(tglTd1, gbc_tglTd1);
		
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
		frame.getContentPane().add(txtTd1, gbc_txtTd1);
		
		JToggleButton tglTd2 = new JToggleButton("TD2:");
		tglTd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTd2.isSelected()) {
					txtTd2.setBackground(Color.RED);
					txtTd2.setText("OCCUPIED");
				}
				else {
					txtTd2.setBackground(Color.GREEN);
					txtTd2.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTd2 = new GridBagConstraints();
		gbc_tglTd2.insets = new Insets(0, 0, 5, 5);
		gbc_tglTd2.gridx = 4;
		gbc_tglTd2.gridy = 8;
		frame.getContentPane().add(tglTd2, gbc_tglTd2);
		
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
		frame.getContentPane().add(txtTd2, gbc_txtTd2);
		
		JToggleButton tglTd3 = new JToggleButton("TD3:");
		tglTd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTd3.isSelected()) {
					txtTd3.setBackground(Color.RED);
					txtTd3.setText("OCCUPIED");
				}
				else {
					txtTd3.setBackground(Color.GREEN);
					txtTd3.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTd3 = new GridBagConstraints();
		gbc_tglTd3.insets = new Insets(0, 0, 5, 5);
		gbc_tglTd3.gridx = 6;
		gbc_tglTd3.gridy = 8;
		frame.getContentPane().add(tglTd3, gbc_tglTd3);
		
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
		frame.getContentPane().add(txtTd3, gbc_txtTd3);
		
		JToggleButton tglTd4 = new JToggleButton("TD4:");
		tglTd4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTd4.isSelected()) {
					txtTd4.setBackground(Color.RED);
					txtTd4.setText("OCCUPIED");
				}
				else {
					txtTd4.setBackground(Color.GREEN);
					txtTd4.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTd4 = new GridBagConstraints();
		gbc_tglTd4.insets = new Insets(0, 0, 5, 5);
		gbc_tglTd4.gridx = 8;
		gbc_tglTd4.gridy = 8;
		frame.getContentPane().add(tglTd4, gbc_tglTd4);
		
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
		frame.getContentPane().add(txtTd4, gbc_txtTd4);
		
		JToggleButton tglTd5 = new JToggleButton("TD5:");
		tglTd5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglTd5.isSelected()) {
					txtTd5.setBackground(Color.RED);
					txtTd5.setText("OCCUPIED");
				}
				else {
					txtTd5.setBackground(Color.GREEN);
					txtTd5.setText("UNOCCUPIED");
				}
			}
		});
		GridBagConstraints gbc_tglTd5 = new GridBagConstraints();
		gbc_tglTd5.insets = new Insets(0, 0, 5, 5);
		gbc_tglTd5.gridx = 10;
		gbc_tglTd5.gridy = 8;
		frame.getContentPane().add(tglTd5, gbc_tglTd5);
		
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
		frame.getContentPane().add(txtTd5, gbc_txtTd5);
		
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
		frame.getContentPane().add(btnConfirm, gbc_btnConfirm);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Resto.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 8;
		gbc_btnCancel.gridy = 11;
		frame.getContentPane().add(btnCancel, gbc_btnCancel);
	}




}
