package Examinepackage;

import java.awt.ActionEvent;
import java.awt.ActionListener;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFRame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Answer extends JFrame {
	private JPanel contentPane;
	private JButton Again;
	private JButton Exist;
	
	int j=0;
	String[][] NumberStorage;
	String[][] ans;
	
	public static String results;
	
	private String sub;
	
public Answer(String sub) {
	setTitle("Answers");
	setDefaultcloseOperation (3);
	setBounds (100, 100, 550, 700);
	this.contentPane = neww JPanel();
	this.contentPane.setBorder (new EmptyBorder)(10, 10, 10, 10));
	setContentPane(this.contentPane);
	this.contentPane.setLayout((LayoutManager)null);
	Quiz questions qusobj = new Quiz questions(sub);
	String [][] qarr = qusobj.ansarray();
	System.out.println(qarr[1][0]);
	for (int i=0; i<qarr.lenght; i++) {
		JLabel Qns = new JLAbel ((i+1)+")"+qarr[i][0]);
		Qns.setBounds(60, 30+ this.j, 250,30);
		Qns.setFont(new Font ("Comic Sans MS",0,20));
		this.contentPane.add(Qns);
		JLabel Ans = new JLabel("Ans)" + aarr[i][1];
		Ans.setBounds(60,30 + this.j, 250,40);
		Ans.setFont(new Font ("Comic Sans Ms", 0, 30));
		this.contentPane.add(Ans);
		this.j +=70;
		
	}
	this.Exist =new JButton("Exist");
	this.Exist.setBounds(260, 540, 90, 40);
	this.Exist.setFont(new Font ("Comic Sans MS", 0, 30));
	this.contentPane.add(this.Exist);
	this.Exist.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		System.exist(0);
	}
	});
	this.Again = new JButton ("Retake Test");
	this.Again.setBounds(190, 540, 90, 20);
	this.Again.setFont (new Font("Comic Sans MS", 0, 25));
	this.contentPane.add(this.Again);
	this.Again.addActionListener(new ActionListener){
		public void actionPerformed(ActionEvent e) {
			(new Login()).setVisible(true);
			Answers.this.dispose();
		}
	});
	
	



	


	

	
	
	
	
	
	
	
	
	
	
	
	

}
