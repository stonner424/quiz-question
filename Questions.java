/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Adminpackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Shivraj
 */


public class Question extends JFrame implements ActionListener{
  //  private JPanel contentPane;
    private JLabel lblQuestion,lblOpt1,lblOpt2,lblOpt3,lblOpt4,lblAns;
    private JTextArea txtQuestion;
    private JTextField txtOpt1,txtOpt2,txtOpt3,txtOpt4,txtAns;
    private JComboBox cmbSub;
    private JButton btnConfirm,btnBack;
    private String setid;
    Question(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        Container c=getContentPane();
        c.setVisible(true);
        c.setLayout(null);
        
        lblQuestion=new JLabel("Question");
        lblQuestion.setBounds(30, 50, 150, 58);
        lblQuestion.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        lblOpt1=new JLabel("Option 1");
        lblOpt1.setBounds(30, 115, 150, 30);
        lblOpt1.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

        lblOpt2=new JLabel("Option 2");
        lblOpt2.setBounds(30, 150, 150, 30);
        lblOpt2.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

        lblOpt3=new JLabel("Option 3");
        lblOpt3.setBounds(30, 185, 150, 30);
        lblOpt3.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

        lblOpt4=new JLabel("Option 4");
        lblOpt4.setBounds(30, 220, 150, 30);
        lblOpt4.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

        lblAns=new JLabel("Answer");
        lblAns.setBounds(30, 255, 150, 30);
        lblAns.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

       
        txtQuestion=new JTextArea();
        txtQuestion.setBounds(190, 50, 400, 60);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        txtQuestion.setBorder(border);
        txtQuestion.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
      
        
        txtOpt1=new JTextField();
        txtOpt1.setBounds(190, 115, 200, 30);
        txtOpt1.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));       

        txtOpt2=new JTextField();
        txtOpt2.setBounds(190, 150, 200, 30);
        txtOpt2.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

        txtOpt3=new JTextField();
        txtOpt3.setBounds(190, 185, 200, 30);
        txtOpt3.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        
        txtOpt4=new JTextField();
        txtOpt4.setBounds(190, 220, 200, 30);
        txtOpt4.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        
        txtAns=new JTextField();
        txtAns.setBounds(190, 255, 200, 30);
        txtAns.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        
        cmbSub=new JComboBox();
        cmbSub.setBounds(190, 10, 200, 30);
        cmbSub.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        cmbSub.addItem("Java");
        cmbSub.addItem("C");
        cmbSub.addItem("C#");
        cmbSub.addItem("C++");
      
        btnConfirm=new JButton("Save&Next");
        btnConfirm.setBounds(50, 310, 160, 30);
        btnConfirm.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        
        btnBack=new JButton("Close");
        btnBack.setBounds(220, 310, 120, 30);
        btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));     
        c.add(lblQuestion);
        c.add(lblOpt1);
        c.add(lblOpt2);
        c.add(lblOpt3);
        c.add(lblOpt4);
        c.add(lblAns);
        c.add(txtQuestion);
        c.add(txtOpt1);
        c.add(txtOpt2);
        c.add(txtOpt3);
        c.add(txtOpt4);   
        c.add(txtAns);
        c.add(btnConfirm);
        c.add(btnBack);
        c.add(cmbSub);
        btnConfirm.addActionListener(this);        
        btnBack.addActionListener(this);
        
    }
    
    public static void main(String[] args)
        {       
        Question cr = new Question();
        cr.setVisible(true);
        
        }
        

    @Override
    public void actionPerformed(ActionEvent ae) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    JButton btn=(JButton) ae.getSource();
    if(btn==btnConfirm)
    {               
        Connection conn = null;
        PreparedStatement stmt=null;
       
       		   try{
       
			      String qn=txtQuestion.getText();
                              String o1=txtOpt1.getText();
                              String sub=(String) cmbSub.getSelectedItem();
                              String o2=txtOpt2.getText();
                              String o3=txtOpt3.getText();
                              String o4=txtOpt4.getText();
                              String ans=txtAns.getText();
                              
                            
                              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb","root", "");
			      stmt = conn.prepareStatement("INSERT INTO questions(qns,opt1,opt2,opt3,opt4,ans,sub) VALUES(?,?,?,?,?,?,?)");         
                              stmt.setString(1,qn);
                              stmt.setString(2,o1);
                              stmt.setString(3,o2);
                              stmt.setString(4,o3);                              
                              stmt.setString(5,o4);   
                              stmt.setString(6,ans);
                              stmt.setString(7,sub);
                              
                              int i=stmt.executeUpdate();   
                              if(i>0)
                              {
                              JOptionPane.showMessageDialog(null,"Question Added for"+sub+"","Message",JOptionPane.PLAIN_MESSAGE);                          
                              }
                              else
                              {
                              JOptionPane.showMessageDialog(null,"Unsuccessful","Message",JOptionPane.PLAIN_MESSAGE);                                                       
                              }
                              txtQuestion.setText("");
                              txtOpt1.setText("");
                              txtOpt2.setText("");
                              txtOpt3.setText("");
                              txtOpt4.setText("");
                              txtAns.setText("");   
                              cmbSub.setVisible(false);
                              cmbSub.setEnabled(false);
                              
                              
                              }catch(SQLException se){
                                  se.printStackTrace();
                         }
    }               
    else
    {
       this.dispose();
       
    }
    
    }
}




