package Examinepackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
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

public class Login extends JFrame {
	  Connection con;
	  
	  private JTextField txtUsername;
	  
	  private JPasswordField txtPassword;
	  
	  private JButton btnLogin;
	  
	  private JButton btnClose;
	  
	  private JButton btnSignup;
	  
	  private JLabel lblTitle;
	  
	  private JLabel lblUsername;
	  
	  private JLabel lblPassword;
	  
	  private JPanel contentPane;
	  
	  Login() {
	    setDefaultCloseOperation(3);
	    setBounds(450, 190, 900, 500);
	    setResizable(false);
	    this.contentPane = new JPanel();
	    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(this.contentPane);
	    this.contentPane.setLayout((LayoutManager)null);
	    this.lblTitle = new JLabel("Login");
	    this.lblTitle.setForeground(Color.BLACK);
	    this.lblTitle.setFont(new Font("Ebrima", 1, 35));
	    this.lblTitle.setBounds(350, 13, 120, 50);
	    this.contentPane.add(this.lblTitle);
	    this.lblUsername = new JLabel("Email");
	    this.lblUsername.setBackground(Color.BLACK);
	    this.lblUsername.setForeground(Color.BLACK);
	    this.lblUsername.setFont(new Font("Ebrima", 0, 25));
	    this.lblUsername.setBounds(200, 120, 193, 40);
	    this.contentPane.add(this.lblUsername);
	    this.lblPassword = new JLabel("Password");
	    this.lblPassword.setForeground(Color.BLACK);
	    this.lblPassword.setBackground(Color.CYAN);
	    this.lblPassword.setFont(new Font("Ebrima", 0, 25));
	    this.lblPassword.setBounds(200, 210, 193, 40);
	    this.contentPane.add(this.lblPassword);
	    this.txtUsername = new JTextField();
	    this.txtUsername.setFont(new Font("Ebrima", 0, 25));
	    this.txtUsername.setBounds(400, 120, 300, 40);
	    this.contentPane.add(this.txtUsername);
	    this.txtUsername.setColumns(10);
	    this.txtPassword = new JPasswordField();
	    this.txtPassword.setFont(new Font("Ebrima", 0, 25));
	    this.txtPassword.setBounds(400, 210, 300, 40);
	    this.contentPane.add(this.txtPassword);
	    this.btnLogin = new JButton("Login");
	    this.btnLogin.setFont(new Font("Ebrima", 0, 25));
	    this.btnLogin.setBounds(260, 320, 120, 40);
	    this.btnLogin.addActionListener(e -> {
	          String userName = this.txtUsername.getText();
	          String password = String.valueOf(this.txtPassword.getPassword());
	          try {
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb", "root", "");
	            PreparedStatement st = connection.prepareStatement("Select email, _password from examinees where email=? and _password=?");
	            st.setString(1, userName);
	            st.setString(2, password);
	            ResultSet rs = st.executeQuery();
	            if (rs.next()) {
	              dispose();
	              UserHome h = new UserHome();
	              h.setVisible(true);
	              JOptionPane.showMessageDialog(this.btnLogin, "You have successfully logged in");
	            } else {
	              JOptionPane.showMessageDialog(this.btnLogin, "Invalid Username or Password");
	            } 
	          } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	          } 
	        });
	    this.btnSignup = new JButton("Register");
	    this.btnSignup.setFont(new Font("Ebrima", 0, 25));
	    this.btnSignup.setBounds(420, 320, 130, 40);
	    this.btnSignup.addActionListener(e -> {
	          dispose();
	          Registration reg = new Registration();
	          reg.setVisible(true);
	        });
	    this.btnClose = new JButton("Back");
	    this.btnClose.setFont(new Font("Ebrima", 0, 25));
	    this.btnClose.setBounds(590, 320, 120, 40);
	    this.btnClose.addActionListener(e -> {
	          dispose();
	          MCQExamApp app = new MCQExamApp();
	          app.setVisible(true);
	        });
	    this.contentPane.add(this.btnLogin);
	    this.contentPane.add(this.btnClose);
	    this.contentPane.add(this.btnSignup);
	  }
	}

