package Examinepackage;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Quizquestiontest extends JFrame {

	  private JPanel contentPane;
	  
	  private JButton Next;
	  
	  private JButton Back;
	  
	  private ButtonGroup opg;
	  
	  private JRadioButton op1;
	  
	  private JRadioButton op2;
	  
	  private JRadioButton op3;
	  
	  private JRadioButton op4;
	  
	  private JLabel question;
	  
	  String[][] a;
	  
	  String[][] q;
	  
	  static int score = 0;
	  
	  int count = 0;
	  
	  int c = 0;
	  
	  int no = 0;
	  
	  String sub;
	  
	  Connection conn = null;
	  
	  PreparedStatement stmt1 = null;
	  
	  PreparedStatement stmt2 = null;
	  
	  public MCQTest(String sub) {
	    setDefaultCloseOperation(3);
	    score = 0;
	    this.sub = sub;
	    testload();
	    try {
	      this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb", "root", "");
	      String query1 = "select count(*) FROM questions WHERE sub='" + sub + "'";
	      String query2 = "SELECT qns,opt1,opt2,opt3,opt4,ans FROM questions WHERE sub='" + sub + "'";
	      this.stmt1 = this.conn.prepareStatement(query1);
	      this.stmt2 = this.conn.prepareStatement(query2);
	      ResultSet rs1 = this.stmt1.executeQuery();
	      while (rs1.next())
	        this.no = rs1.getInt("count(*)"); 
	      ResultSet rs2 = this.stmt2.executeQuery();
	      this.q = new String[this.no][5];
	      this.a = new String[10][5];
	      this.count = 0;
	      while (rs2.next()) {
	        this.q[this.count][0] = rs2.getString(1);
	        this.q[this.count][1] = rs2.getString(2);
	        this.q[this.count][2] = rs2.getString(3);
	        this.q[this.count][3] = rs2.getString(4);
	        this.q[this.count][4] = rs2.getString(5);
	        this.a[this.count][1] = rs2.getString(6);
	        this.count++;
	      } 
	    } catch (SQLException se) {
	      se.printStackTrace();
	    } 
	    start(0);
	  }
	  
	  public String[][] qarray() {
	    return (String[][])this.q.clone();
	  }
	  
	  public String[][] ansarray() {
	    return (String[][])this.a.clone();
	  }
	  
	  private void testload() {
	    setTitle("Quizquestion Test");
	    setDefaultCloseOperation(3);
	    setBounds(100, 100, 900, 500);
	    this.contentPane = new JPanel();
	    this.contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	    setContentPane(this.contentPane);
	    this.contentPane.setLayout((LayoutManager)null);
	    this.opg = new ButtonGroup();
	    this.op1 = new JRadioButton();
	    this.op2 = new JRadioButton();
	    this.op3 = new JRadioButton();
	    this.op4 = new JRadioButton();
	    this.question = new JLabel();
	    this.Next = new JButton();
	    this.Back = new JButton();
	    this.question.setBounds(30, 40, 850, 30);
	    this.question.setFont(new Font("Comic Sans MS", 0, 20));
	    this.op1.setBounds(50, 90, 400, 30);
	    this.op1.setFont(new Font("Comic Sans MS", 0, 20));
	    this.op2.setBounds(50, 125, 400, 30);
	    this.op2.setFont(new Font("Comic Sans MS", 0, 20));
	    this.op3.setBounds(50, 160, 400, 30);
	    this.op3.setFont(new Font("Comic Sans MS", 0, 20));
	    this.op4.setFont(new Font("Comic Sans MS", 0, 20));
	    this.op4.setBounds(50, 195, 400, 30);
	    this.Back.setBounds(100, 260, 200, 30);
	    this.Back.setFont(new Font("Comic Sans MS", 0, 20));
	    this.Next.setBounds(270, 260, 200, 30);
	    this.Next.setFont(new Font("Comic Sans MS", 0, 20));
	    setDefaultCloseOperation(3);
	    final JLabel timer = new JLabel("01:00");
	    timer.setBounds(10, 10, 100, 30);
	    Timer t = new Timer(1000, new ActionListener() {
	          int time = 600;
	          
	          public void actionPerformed(ActionEvent e) {
	            this.time--;
	            timer.setText(MCQTest.format(this.time / 60) + ":" + MCQTest.format(this.time % 60));
	            if (MCQTest.this.c >= 10) {
	              Timer timer = (Timer)e.getSource();
	              timer.stop();
	            } else if (this.time == 0) {
	              if (MCQTest.this.c >= 10) {
	                Timer timer = (Timer)e.getSource();
	                timer.stop();
	              } else {
	                JOptionPane.showMessageDialog(null, "Time Up Click Ok To Check Your Score", "bye..", 0);
	                System.out.println(MCQTest.score);
	                (new Result(MCQTest.this.sub)).setVisible(true);
	                MCQTest.this.dispose();
	              } 
	            } 
	          }
	        });
	    t.start();
	    this.opg.add(this.op1);
	    this.op1.setText("option1");
	    this.op1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent evt) {
	            MCQTest.this.op1Selected(evt);
	          }
	        });
	    this.opg.add(this.op2);
	    this.op2.setText("option2");
	    this.op2.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent evt) {
	            MCQTest.this.op2selected(evt);
	          }
	        });
	    this.opg.add(this.op3);
	    this.op3.setText("option3");
	    this.op3.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent evt) {
	            MCQTest.this.op3selected(evt);
	          }
	        });
	    this.opg.add(this.op4);
	    this.op4.setText("option4");
	    this.op4.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent evt) {
	            MCQTest.this.op4selected(evt);
	          }
	        });
	    this.question.setHorizontalAlignment(0);
	    this.question.setText("Question");
	    this.Next.setText("Next");
	    this.Next.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent evt) {
	            QuizquestionTest.this.NextClicked(evt);
	          }
	        });
	    this.Back.setText("Back");
	    this.Back.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent evt) {
	            QuizquestionTest.this.BackClicked(evt);
	          }
	        });
	    this.contentPane.add(this.question);
	    this.contentPane.add(this.op1);
	    this.contentPane.add(this.op2);
	    this.contentPane.add(this.op3);
	    this.contentPane.add(this.op4);
	    this.contentPane.add(this.Next);
	    this.contentPane.add(this.Back);
	    this.contentPane.add(timer);
	  }
	  
	  protected void BackClicked(ActionEvent evt) {
	    if (this.c != 0)
	      if (score == this.c) {
	        score--;
	        this.c--;
	        start(this.c);
	      } else {
	        this.c--;
	        start(this.c);
	      }  
	  }
	  
	  protected void NextClicked(ActionEvent evt) {
	    if ((getSelectedButtonText(this.opg) == null) ? (this.a[this.c][1] == null) : getSelectedButtonText(this.opg).equals(this.a[this.c][1])) {
	      score++;
	      this.count++;
	      this.c++;
	    } else {
	      this.c++;
	      this.count++;
	    } 
	    if (this.c != this.no) {
	      start(this.c);
	      System.out.println(score);
	    } else {
	      System.out.println(score);
	      (new Result(this.sub)).setVisible(true);
	      dispose();
	    } 
	  }
	  
	  protected void op4selected(ActionEvent evt) {}
	  
	  protected void op3selected(ActionEvent evt) {}
	  
	  protected void op2selected(ActionEvent evt) {}
	  
	  protected void op1Selected(ActionEvent evt) {}
	  
	  String getSelectedButtonText(ButtonGroup buttonGroup) {
	    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
	      AbstractButton button = buttons.nextElement();
	      if (button.isSelected())
	        return button.getText(); 
	    } 
	    return null;
	  }
	  
	  public void start(int i) {
	    this.question.setText(this.q[i][0]);
	    this.op1.setText(this.q[i][1]);
	    this.op2.setText(this.q[i][2]);
	    this.op3.setText(this.q[i][3]);
	    this.op4.setText(this.q[i][4]);
	    this.opg.clearSelection();
	  }
	  
	  private static String format(int i) {
	    String result = String.valueOf(i);
	    if (result.length() == 1)
	      result = "0" + result; 
	    return result;
	  }
	}

