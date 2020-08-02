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
/**
* 
*/
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author SriL3kh@ and G0v@rdhan
 *
 */

public class Answers extends JFrame
{
	private JPanel contentPane; 
	private JButton Again;
	private JButton Exit;
	int j=0;
	String[][] NumberStorage;
	String[][] ans;
	public static String results;
	private String sub;
//	public static void main(String[] args) 
//	{		
//		EventQueue.invokeLater(new Runnable() 
//		{
//			public void run() 
//			{
//				try  
//				{
//					Answers frame = new Answers();
//					frame.setVisible(true);
//				} 
//				catch (Exception e) 
//				{
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	

	public Answers(String sub) {
		setTitle("Answers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MCQTest qusobj = new MCQTest(sub);
		String[][] qarr = qusobj.qarray();
		MCQTest ansobj = new MCQTest(sub);
		String[][] aarr = ansobj.ansarray();
		System.out.println(qarr[1][0]);
		for(int i=0;i<qarr.length;i++) {
		
		JLabel qns = new JLabel((i+1)+") "+qarr[i][0]);
		qns.setBounds(60, 10+j, 400, 30);
                qns.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));            
                
		contentPane.add(qns);
		
		JLabel ans = new JLabel("Ans) "+aarr[i][1]);
		ans.setBounds(60, 30+j, 250, 30);
		ans.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));            
                
                contentPane.add(ans);
		j=j+60;
		
		}
		Exit = new JButton("Exit");
		Exit.setBounds(270, 530, 89, 30);
                Exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));            
                
		contentPane.add(Exit);
		Exit.addActionListener(new ActionListener() 
                {
		                public void actionPerformed(ActionEvent e) 
                                {				
                                
		                	System.exit(0);
                                }
		});
	
	
		Again = new JButton("Retake Test");
		Again.setBounds(180, 530, 89, 30);
                Again.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));            
                
		contentPane.add(Again);
	
		Again.addActionListener(new ActionListener() 
		{

		    public void actionPerformed(ActionEvent e) {

		    	new Login().setVisible(true);
		        
		        dispose();
		    }

		});
		
}
	
}


