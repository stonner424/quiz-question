/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adminpackage;

import examineePackage.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Shivraj
 */
public class AdminDashboard extends JFrame {

	 private JPanel contentPane;
	    private JButton btnViewStudents,btnLogout,btnAddSub;
	    private JTable tblRecord;
	    String[] columns = {"StudentName","CandidateNo","Section", "Email", "Password"};
	    AdminDashboard(){
	         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1000, 600);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	       btnLogout = new JButton("Logout");
	       btnLogout.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int a = JOptionPane.showConfirmDialog(btnLogout, "Are you sure?");
	                // JOptionPane.setRootFrame(null);
	                if (a == JOptionPane.YES_OPTION) {
	                    dispose();
	                    AdminLogin obj = new AdminLogin();
	                    obj.setVisible(true);
	                }
	                dispose();
	                AdminLogin obj = new AdminLogin();

	                obj.setVisible(true);

	            }
	        });
	        btnLogout.setBounds(650, 10, 150, 30);
	        contentPane.add(btnLogout);
	        btnViewStudents = new JButton("View Examinees");
	        btnViewStudents.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	             showTableData();
	            }
	        });
	        btnViewStudents.setFont(new Font("Tahoma", Font.PLAIN, 25));
	        btnViewStudents.setBounds(200, 200, 220, 30);
	        contentPane.add(btnViewStudents);
	        
//	          btnAddSets = new JButton("Add Subject");
//	        btnAddSets.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	             QuestionSets set=new QuestionSets();
//	             set.setVisible(true);
//	            }
//	        });
//	             btnAddSets.setFont(new Font("Tahoma", Font.PLAIN, 25));
//	        btnAddSets.setBounds(200, 350, 250, 30);
//	        contentPane.add(btnAddSets);
//	        
	         btnAddSub = new JButton("Add QuestionSets");
	        btnAddSub.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	             Question qns=new Question();
	             qns.setVisible(true);
	            }
	        });
	             btnAddSub.setFont(new Font("Tahoma", Font.PLAIN, 25));
	        btnAddSub.setBounds(200, 280, 250, 30);
	        contentPane.add(btnAddSub);
	   
	      
	        
	        
	    }
	       public void showTableData() {

	        JFrame tframe = new JFrame("Students Record");

	        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        tframe.setLayout(new BorderLayout());

	//TableModel tm = new TableModel();

	        DefaultTableModel model = new DefaultTableModel();

	            model.setColumnIdentifiers(columns);

	        tblRecord = new JTable();
	        tblRecord.setRowHeight(30);
	        tblRecord.setFont(new Font("Serif", Font.PLAIN, 22));

	        tblRecord.setModel(model);

	        tblRecord.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

	        tblRecord.setFillsViewportHeight(true);

	        JScrollPane scroll = new JScrollPane(tblRecord);

	        scroll.setHorizontalScrollBarPolicy(

	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        scroll.setVerticalScrollBarPolicy(

	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	    
	//String textvalue = textbox.getText();

	        int candidateId=0;
	        String sname = "";

	        String email = "";

	        String pass = "";

	        String section = "";
	        try {
	            Connection conn=null;
	            PreparedStatement pst=null;
	             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb",
	                        "root", "");
	                
	            pst = conn.prepareStatement("select * from examinees");

	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                candidateId=rs.getInt(1);
	                sname = rs.getString(2)+rs.getString(3);
	                section = rs.getString(4);

	                email = rs.getString(5);

	                pass = rs.getString(6);

	                model.addRow(new Object[]{sname,candidateId, section, email,pass});
	            }

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

	        }

	        tframe.add(scroll);

	        tframe.setVisible(true);

	        tframe.setBounds(400,300,700, 400);

	    }
	       public static void main(String[] args)
	       {
	       new AdminDashboard().setVisible(true);
	       }
	 }


