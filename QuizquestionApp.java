package Examinepackage;


import Adminpackage.AdminLogin;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class QuizquestionApp  Extends JFrame{
	 private JButton btnLogin;
	  
	  private JButton btnAdminLogin;
	  
	  private JButton btnClose;
	  
	  private JLabel lblTitle;
	  
	  private JPanel contentPane;
	  
	  public QuizquestionApp() {
	    setDefaultCloseOperation(3);
	    setBounds(650, 270, 400, 300);
	    setResizable(false);
	    this.contentPane = new JPanel();
	    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(this.contentPane);
	    this.contentPane.setLayout((LayoutManager)null);
	    this.lblTitle = new JLabel("<html>Quizquestion Exam Application<br/>(Login Page)<</html>");
	    this.contentPane.setBackground(Color.LIGHT_GRAY);
	    this.lblTitle.setFont(new Font("Ebrima", 1, 28));
	    this.lblTitle.setBounds(40, 20, 320, 70);
	    this.contentPane.add(this.lblTitle);
	    this.btnLogin = new JButton("Examinee ");
	    this.btnLogin.setFont(new Font("Ebrima", 2, 22));
	    this.btnLogin.setBounds(30, 170, 155, 40);
	    this.btnLogin.addActionListener(e -> {
	          Login log = new Login();
	          log.setVisible(true);
	        });
	    this.btnAdminLogin = new JButton("Administrator");
	    this.btnAdminLogin.setFont(new Font("Ebrima", 2, 22));
	    this.btnAdminLogin.setBounds(210, 170, 170, 40);
	    this.btnAdminLogin.addActionListener(e -> {
	          dispose();
	          AdminLogin alog = new AdminLogin();
	          alog.setVisible(true);
	        });
	    this.contentPane.add(this.btnLogin);
	    this.contentPane.add(this.btnAdminLogin);
	  }
	  
	  public static void main(String[] args) {
	    QuizquestionApp app = new QuizquestionApp();
	    app.setVisible(true);
	  }
	}


