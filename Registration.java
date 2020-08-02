/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examineePackage;
/**
*
* @author Shivraj
*/
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class Registration extends JFrame{
	JLabel lblFname,lblLname,lblCandidateId,lblEmail,lblSection,lblTitle;
	
	JTextField txtFname,txtLname,txtCandidateId,txtEmail,txtSection;
//	JRadioButton rdbFemale,rdbMale,rdbOthers;
//	
	JButton btnRegister,btnClose;
	private JPanel contentPane;
        
	
	Registration(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setTitle("Student Registration");
		setBounds(550,250,700,500);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Container c=getContentPane();
		c.setVisible(true);
		c.setLayout(null);
		//Comic Sans MS
                //Ebrima
                
		lblTitle=new JLabel("New Registration");
		lblTitle.setBounds(55, 10, 350, 35);
                lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
                
		lblFname=new JLabel("First Name");
		lblFname.setBounds(30, 110, 150, 35);
                lblFname.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
                lblLname=new JLabel("Last Name");
		lblLname.setBounds(30, 150, 150, 35);
		lblLname.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
                lblCandidateId=new JLabel("Examinee Id");
		lblCandidateId.setBounds(30, 75, 150, 35);
		lblCandidateId.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
                lblSection=new JLabel("Section");
		lblSection.setBounds(30, 190, 150, 35);
		lblSection.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
                lblEmail=new JLabel("Email");
		lblEmail.setBounds(30, 230, 150, 35);
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
		
		txtFname=new JTextField();
		txtFname.setBounds(190, 110, 250, 35);		
		txtFname.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
                txtLname=new JTextField();
		txtLname.setBounds(190, 150, 250, 35);
		txtLname.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
                txtCandidateId=new JTextField();
		txtCandidateId.setBounds(190, 75, 200, 35);
		txtCandidateId.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
                txtSection=new JTextField();
		txtSection.setBounds(190, 190, 200, 35);
		txtSection.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
               
                txtEmail=new JTextField();
		txtEmail.setBounds(190, 230, 350, 35);
		txtEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
                             
		btnRegister=new JButton("Register");
		btnRegister.setBounds(50, 280, 140, 35);
                btnRegister.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));          
                btnRegister.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ex)
                {
                    Connection conn = null;
                    PreparedStatement stmt=null;
			   try{
                               Random rnd= new Random();
                              int password= (10000+rnd.nextInt(100000-10000));                               
			      String fname=txtFname.getText();
                              String lname=txtLname.getText();
                              String candId=txtCandidateId.getText();
                              String section=txtSection.getText();
                              String email=txtEmail.getText();
                              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb","root", "");
			      stmt = conn.prepareStatement("INSERT INTO examinees(examineeId,fname,lname,section,email,_password) VALUES(?,?,?,?,?,?)");			     
//                          
                            stmt.setString(1,candId);
                            stmt.setString(2,fname);
                            stmt.setString(3,lname);
                            stmt.setString(4,section);
                            stmt.setString(5,email);
                            stmt.setInt(6,password);
                            
			     stmt.executeUpdate();
                             String SMessage = fname+", you are registered for exam. Your username is submitted email. Please consult Exam Office for password";				
	                    JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
                              }catch(SQLException se){
                                 se.printStackTrace();
                              }}

                 });
		btnClose=new JButton("Back");
		btnClose.setBounds(200, 280, 110, 35);
		btnClose.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
                btnClose.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        dispose();
                        new Login().setVisible(true);
                    }
                }
                );
		c.add(lblFname);
		c.add(lblLname);
		c.add(lblCandidateId);
                c.add(lblSection);
		c.add(lblEmail);	
		c.add(txtFname);
		c.add(txtLname);
		c.add(txtCandidateId);
                c.add(txtSection);
		c.add(txtEmail);		
		c.add(btnRegister);
		c.add(btnClose);
                c.add(lblTitle);
	
		}
	public static void main(String[] args) {
		new Registration().setVisible(true);
	}			
		
}
