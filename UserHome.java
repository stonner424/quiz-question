/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examineePackage;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Shivraj
 */
public class UserHome extends JFrame {
	 private JPanel contentPane;
	    private JLabel lblTitle;
	    UserHome(){
	         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1014, 597);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	     
	        lblTitle=new JLabel("Take Test");
	        lblTitle.setBounds(100, 10, 350, 35);
	         lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
	                
	                   
	         JButton btnNewButton = new JButton("Java");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	                MCQTest test=new MCQTest("Java");    
	                test.setVisible(true);
	                
	            }
	        });
	         btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
	      
	        btnNewButton.setBounds(200, 90,200, 35);
	        contentPane.add(btnNewButton);
	                
	        JButton btnNewButton1 = new JButton("C");
	        btnNewButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	                MCQTest test=new MCQTest("C");    
	                test.setVisible(true);
	                
	            }
	        });
	          btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 35));
	      
	        btnNewButton1.setBounds(200, 130,200, 35);
	        contentPane.add(btnNewButton1);
	        JButton button2 = new JButton("C++");
	        button2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	             MCQTest bo=new MCQTest("C++");
	                bo.setVisible(true);

	            }
	        });
	        button2.setFont(new Font("Tahoma", Font.PLAIN, 35));
	        button2.setBounds(200, 190, 200, 35);
	        contentPane.add(button2);
	          JButton button3 = new JButton("C#");
	        button3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                MCQTest bo=new MCQTest("C#");
	                bo.setVisible(true);

	            }
	        });
	        button3.setFont(new Font("Tahoma", Font.PLAIN, 35));
	        button3.setBounds(200, 240, 201, 40);
	        contentPane.add(button3);
	        contentPane.add(lblTitle);
	    }
	 }


