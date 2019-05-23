package praca_dyplomowa_moduly_testowe;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Aplikacja: Modul Logowania 
//Autor: Damian Kołakowski
//Data utworzenia: Maj 2019
// Opis: Przedstawiona tutaj aplikacja jest jedna z czesci Systemu Wyswietlania Lotow w alikacji inzynierskiej opartej o baze
//SQL klienta phpmyAdmin.
// Aplikacja wysyla zapytanie do bazy z danymi ozytkownika jesli logowanie sie powiedzie wyswietlany jest odpowiednia informacja
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;

public class LoginModule extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    //data need to right connect with database
    private String host = "localhost";
    private String dbUser = "root";
    private String dbPass = "" ;
    private String userName,passWord;
    private String username;
    
    private JLabel lblEmptySpace1,lblEmptySpace2,lblError;

	private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
	
	public void minWindow()
	{
		this.setState(Frame.ICONIFIED);
	}
    
    public void connectDB() throws Exception
    {
    	
    	try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/baza_lotow",dbUser,dbPass);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from users");
            //writeResultSet(resultSet);
            
            while (resultSet.next()) {
                
                String ID = resultSet.getString("ID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                
                if(userName.equals(username) && passWord.equals(password))
                {
                	System.out.println("User istnieje");
                	RegisterForm register = new RegisterForm();
                	register.show();
                	
                }
                
                
                /*
                System.out.println("ID: " + ID);
                System.out.println("username: " + username);
                System.out.println("password: " + password);
               */
            }
            if(userName != username)
            {
            	System.out.println("Użytkownika brak w bazie");
            }
            } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    public void loginAction() throws Exception
	{
		if(loginField.getText().isEmpty() && passwordField.getText().isEmpty() )
		{
			lblEmptySpace1.setVisible(true);
			lblEmptySpace2.setVisible(true);
		}else
		{
			lblError.setVisible(true);
			System.out.println("Uzupelnij brakuje dane");
		}
		
		//Dodatkowo dodać funkcje blinkblink - mrugajacy napisa braku danych 
		userName = loginField.getText();
		passWord = passwordField.getText();
		
		connectDB();
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginModule frame = new LoginModule();
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
	public LoginModule() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(26,177,136));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 450, 59);
		panel_1.setBackground(new Color(26,177,136));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLoginFrame = new JLabel("Login");
		lblLoginFrame.setForeground(new Color(255, 255, 255));
		lblLoginFrame.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLoginFrame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLoginFrame.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLoginFrame.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginFrame.setBounds(196, 11, 83, 37);
		panel_1.add(lblLoginFrame);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(429, 0, 21, 25);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		panel_1.add(lblX);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				minWindow();
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 30));
		label.setBounds(407, 11, 21, 14);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(19,35,47));
		panel_2.setBounds(0, 60, 450, 240);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLogin = new JLabel("Username :");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		lblLogin.setBounds(104, 35, 100, 20);
		panel_2.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		lblPassword.setBounds(104, 91, 100, 14);
		panel_2.add(lblPassword);
		
		loginField = new JTextField();
		loginField.setBounds(214, 35, 86, 20);
		panel_2.add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 85, 86, 20);
		panel_2.add(passwordField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(104, 148, 89, 23);
		panel_2.add(btnCancel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					loginAction();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(211, 148, 89, 23);
		panel_2.add(btnLogin);
		
		lblEmptySpace1 = new JLabel("Puste pole");
		lblEmptySpace1.setForeground(Color.RED);
		lblEmptySpace1.setBounds(323, 41, 60, 14);
		lblEmptySpace1.setVisible(false);
		panel_2.add(lblEmptySpace1);
		
		lblEmptySpace2 = new JLabel("Puste pole");
		lblEmptySpace2.setForeground(Color.RED);
		lblEmptySpace2.setBounds(323, 94, 60, 14);
		lblEmptySpace2.setVisible(false);
		panel_2.add(lblEmptySpace2);
		
		lblError = new JLabel("Podany urzytkownik lub haslo jest niepoprawne");
		lblError.setForeground(Color.RED);
		lblError.setBounds(81, 197, 242, 14);
		lblError.setVisible(false);
		panel_2.add(lblError);
		
		
	}
}
