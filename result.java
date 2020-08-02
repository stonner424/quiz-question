/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examineePackage;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import quiz.Questions;
//import quiz.Login;
/**
 *
 * @author Shivraj
 */

public class result extends JFrame {

	private JPanel contentPane;
	private JButton Again;
	private JButton Exit;
	private JButton Answers;
	public static String results;
	private boolean login;
	protected java.lang.String Spassword;
	

	static final String DB_URL = "jdbc:mysql://localhost/Examinationdb";
	
	static final String USER = "root";
	static final String PASS = "";
	protected static final String String = null;
	private String sub;


	public Result(String sub)
	{	
            this.sub=sub;
		setTitle("Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int results=QuizquestionTest.score;
		String result=String.valueOf(results);
		
	
		
                JLabel username = new JLabel("<html>Hey....<html>");
		username.setBounds(220, 40, 200, 200);
		contentPane.add(username);
		results=10-results;
		String wrong=String.valueOf(results);
		
		JLabel finalresult = new JLabel("<html>Your FinalScore is:<html>"+result+"<html><br>Total Right Answers: <html>"+result+"<html><br>Total Wrong Answers: <html>"+wrong);
		finalresult.setBounds(200, 90, 200, 200);
		contentPane.add(finalresult);
		
		
		Exit = new JButton("Exit");
		Exit.setBounds(270, 251, 89, 23);
		contentPane.add(Exit);
		Exit.addActionListener(new ActionListener() 
                {
		                public void actionPerformed(ActionEvent e) 
                                {				
                                
		                	System.exit(0);
                                }
		});
	
	
		Again = new JButton("Take Next Test");
		Again.setBounds(70, 251, 180, 23);
		contentPane.add(Again);	
		Again.addActionListener(new ActionListener() 
		{

		    public void actionPerformed(ActionEvent e) {
		        
		        new UserHome().setVisible(true); 
		        dispose();
		    }

		});
		
		
		Answers = new JButton("Answers");
		Answers.setBounds(225, 291, 89, 23);
		contentPane.add(Answers);	
		Answers.addActionListener(new ActionListener() 
		{

		    public void actionPerformed(ActionEvent e) {
		        
		        new Answers(sub).setVisible(true); 
		        dispose();
		    }

		});
			
		
		
}}

