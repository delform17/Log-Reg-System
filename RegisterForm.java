package praca_dyplomowa_moduly_testowe;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Aplikacja: Modul Rejestracji 
//Autor: Damian Kołakowski
//Data utworzenia: Maj 2019
//Opis: Przedstawiona tutaj aplikacja jest jedna z czesci Systemu Wyswietlania Lotow w alikacji inzynierskiej opartej o baze
//SQL klienta phpmyAdmin.
//Aplikacja pobiera dane z wszystkich pol oraz dodaje wpis do bazy z kontem uzytkownika
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Window.Type;

import com.toedter.calendar.JDateChooser;

public class RegisterForm extends JFrame {
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField repeatPassword;
	private JTextField Adress;
	private String name,lastname,username,password,repeatpass,birthdate,address;
	private JTextField userNamefield;
	private JTextField lastNamefield;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public void insertUser()
	{
	
		name = txtUsername.getText();
		lastname = lastNamefield.getText();
		username = userNamefield.getText();
		password = passwordField.getText();
		repeatpass = repeatPassword.getText();
		
		//System.out.println(name+" "+lastname+" "+username+" "+password+" "+repeatpass);
	}
	
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 433);
		this.setLocationRelativeTo(null);   /* centrowanie okna na ekranie */
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 204));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblUsername = new JLabel("First Name: ");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 2;
		panel_1.add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setText("username");
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.gridx = 3;
		gbc_txtUsername.gridy = 2;
		panel_1.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Last Name : ");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 3;
		panel_1.add(lblPassword, gbc_lblPassword);
		
		lastNamefield = new JTextField();
		GridBagConstraints gbc_lastNamefield = new GridBagConstraints();
		gbc_lastNamefield.insets = new Insets(0, 0, 5, 5);
		gbc_lastNamefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNamefield.gridx = 3;
		gbc_lastNamefield.gridy = 3;
		panel_1.add(lastNamefield, gbc_lastNamefield);
		lastNamefield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		userNamefield = new JTextField();
		GridBagConstraints gbc_userNamefield = new GridBagConstraints();
		gbc_userNamefield.insets = new Insets(0, 0, 5, 5);
		gbc_userNamefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNamefield.gridx = 3;
		gbc_userNamefield.gridy = 4;
		panel_1.add(userNamefield, gbc_userNamefield);
		userNamefield.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password");
		GridBagConstraints gbc_lblPassword_1 = new GridBagConstraints();
		gbc_lblPassword_1.anchor = GridBagConstraints.EAST;
		gbc_lblPassword_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_1.gridx = 2;
		gbc_lblPassword_1.gridy = 5;
		panel_1.add(lblPassword_1, gbc_lblPassword_1);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 5;
		panel_1.add(passwordField, gbc_passwordField);
		
		JLabel repeatPass = new JLabel("Repeat Password");
		GridBagConstraints gbc_repeatPass = new GridBagConstraints();
		gbc_repeatPass.anchor = GridBagConstraints.EAST;
		gbc_repeatPass.insets = new Insets(0, 0, 5, 5);
		gbc_repeatPass.gridx = 2;
		gbc_repeatPass.gridy = 6;
		panel_1.add(repeatPass, gbc_repeatPass);
		
		repeatPassword = new JPasswordField();
		GridBagConstraints gbc_repeatPassword = new GridBagConstraints();
		gbc_repeatPassword.insets = new Insets(0, 0, 5, 5);
		gbc_repeatPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatPassword.gridx = 3;
		gbc_repeatPassword.gridy = 6;
		panel_1.add(repeatPassword, gbc_repeatPassword);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		GridBagConstraints gbc_lblBirthdate = new GridBagConstraints();
		gbc_lblBirthdate.anchor = GridBagConstraints.EAST;
		gbc_lblBirthdate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthdate.gridx = 2;
		gbc_lblBirthdate.gridy = 7;
		panel_1.add(lblBirthdate, gbc_lblBirthdate);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 1);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 7;
		dateChooser.getJCalendar().setPreferredSize(new Dimension(20,30));
		panel_1.add(dateChooser, gbc_dateChooser);
		
		JLabel lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 2;
		gbc_lblAddress.gridy = 8;
		panel_1.add(lblAddress, gbc_lblAddress);
		
		Adress = new JTextField();
		GridBagConstraints gbc_Adress = new GridBagConstraints();
		gbc_Adress.insets = new Insets(0, 0, 5, 5);
		gbc_Adress.fill = GridBagConstraints.HORIZONTAL;
		gbc_Adress.gridx = 3;
		gbc_Adress.gridy = 8;
		panel_1.add(Adress, gbc_Adress);
		Adress.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 9;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Add user");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				insertUser();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 9;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblRejestracja = new JLabel("Rejestracja");
		lblRejestracja.setForeground(new Color(255, 255, 255));
		lblRejestracja.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRejestracja.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblRejestracja.setHorizontalTextPosition(SwingConstants.LEFT);
		lblRejestracja.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblRejestracja);
		
		
		
		JLabel jLabelClose = new JLabel("X");
		jLabelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		
		JLabel JLabelMinimalize = new JLabel("-");
		
		JLabelMinimalize.setForeground(new Color(255, 255, 255));
		JLabelMinimalize.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(JLabelMinimalize);
		
		
		jLabelClose.setForeground(new Color(255, 255, 255));
		jLabelClose.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(jLabelClose);
		getContentPane().setLayout(groupLayout);
	}
}
