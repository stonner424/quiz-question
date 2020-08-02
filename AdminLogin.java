/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Adminpackage;

/**
*
* @author shivraj
*/
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

public class AdminLogin {
	import examineePackage.QuizquestionApp;
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;
	import examineePackage.UserHome;
	    
	/**
	 *
	 * @author shivraj
	 */
	public class AdminLogin extends JFrame{
	    Connection con;
	    private JTextField txtUsername;
	    private JPasswordField txtPassword;
	    private JButton btnALogin,btnClose;
	    private JLabel lblTitle,lblUsername,lblPassword,lblHint;
	    private JPanel contentPane;
	   public AdminLogin(){
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1000,500);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        lblTitle = new JLabel("Admin Login");
	        lblTitle.setForeground(Color.BLACK);
	        lblTitle.setFont(new Font("Ebrima", Font.BOLD, 32));
	        lblTitle.setBounds(423, 13, 273, 40);
	        contentPane.add(lblTitle);
	        lblUsername = new JLabel("Email");
	        lblUsername.setBackground(Color.BLACK);
	        lblUsername.setForeground(Color.BLACK);
	        lblUsername.setFont(new Font("Ebrima", Font.PLAIN, 25));
	        lblUsername.setBounds(250, 120, 165, 45);
	        contentPane.add(lblUsername);

	        lblPassword = new JLabel("Password");
	        lblPassword.setForeground(Color.BLACK);
	        lblPassword.setBackground(Color.CYAN);
	        lblPassword.setFont(new Font("Ebrima", Font.PLAIN, 25));
	        lblPassword.setBounds(250, 210, 165, 45);
	        contentPane.add(lblPassword);

	        txtUsername = new JTextField("");
	        txtUsername.setFont(new Font("Ebrima", Font.PLAIN, 25));
	        txtUsername.setBounds(481, 120, 290, 45); 
	        contentPane.add(txtUsername);
	        txtUsername.setColumns(10);

	        txtPassword = new JPasswordField();
	        txtPassword.setFont(new Font("Ebrima", Font.PLAIN, 25));
	        txtPassword.setBounds(481, 210, 290, 45);
	        contentPane.add(txtPassword);

	    
	        btnALogin = new JButton("Login");
	        btnALogin.setFont(new Font("Ebrima", Font.PLAIN, 22));
	        btnALogin.setBounds(340, 320, 140, 40);
	        btnALogin.addActionListener((ActionEvent e) -> {
	            String username = txtUsername.getText();
	            String password = String.valueOf(txtPassword.getPassword());
	            if(username.equals("admin")&& password.equals("admin"))
	            {
	                 JOptionPane.showMessageDialog(btnALogin, "You have successfully logged in");
	                 AdminDashboard adash=new AdminDashboard();
	                 adash.setVisible(true);
	            }
	            else
	            {
	                JOptionPane.showMessageDialog(btnALogin, "Invalid Username or Password");
	            }
	           
//	            try {
//	                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb",
//	                        "root", "");
//	                
//	                PreparedStatement st = connection
//	                        .prepareStatement("Select ausername, _passwd from admin where ausername=? and a_password=?");
//	                
//	                st.setString(1, username);
//	                st.setString(2, password);
//	                ResultSet rs = st.executeQuery();
//	                if (rs.next()) {
//	                    dispose();
//	                  //  UserHome uh = new UserHome(userName);
//	                    //uh.setTitle("Welcome");
//	                    //uh.setVisible(true);
//	                    JOptionPane.showMessageDialog(btnALogin, "You have successfully logged in");
//	                } else {
//	                    JOptionPane.showMessageDialog(btnALogin, "Invalid Username or Password");
//	                }
//	            } catch (SQLException sqlException) {
//	                sqlException.printStackTrace();
//	            }
	        });

	        
	         btnClose = new JButton("Back");
	        btnClose.setFont(new Font("Ebrima", Font.PLAIN, 22));
	        btnClose.setBounds(520, 320, 162, 40);
	        btnClose.addActionListener((ActionEvent e) -> {
	           this.dispose();
	           QuizquestionApp app=new QuizquestionApp();
	           app.setVisible(true);
	        });


	        contentPane.add(btnALogin);
	        contentPane.add(btnClose);
	       
//	        label = new JLabel("");
//	        label.setBounds(0, 0, 2208, 562);
//	        contentPane.add(label);
	    }
	    public static void main(String[] args)
	    {
	        AdminLogin log=new AdminLogin();
	        log.setVisible(true);
	    }
	}




