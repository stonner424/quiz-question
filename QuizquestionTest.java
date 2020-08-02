package examineePackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
/**
 * @author Shivraj and Bishwas
 *
 */



public class QuizquestionTest extends JFrame {

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
	static int score=0;
	int count=0;
	int c=0;
	
           int no=0;
        
        String sub;
         Connection conn=null;
         PreparedStatement stmt1=null;
         PreparedStatement stmt2=null;
	
    /**
     * @param value the value to set
     */
  	
	public QuizquestionTest(String sub) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        score=0;
        this.sub=sub;
        
        testload();
       try{
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb","root", "");
               String query1="select count(*) FROM questions WHERE sub='"+sub+"'";    
               String query2="SELECT qns,opt1,opt2,opt3,opt4,ans FROM questions WHERE sub='"+sub+"'";               
               stmt1 =conn.prepareStatement(query1);
               stmt2 = conn.prepareStatement(query2);                          
               ResultSet rs1=stmt1.executeQuery();
               while(rs1.next())
               {
                   no = rs1.getInt("count(*)");
               }
                   ResultSet rs2=stmt2.executeQuery();
                   q =new String[no][5];  
                   a=new String[10][5];
             count=0;
        while (rs2.next()) {
            q[count][0]=rs2.getString(1);
            q[count][1]=rs2.getString(2);
            q[count][2]=rs2.getString(3);
            q[count][3]=rs2.getString(4);
            q[count][4]=rs2.getString(5);
            a[count][1]=rs2.getString(6);
            
            count++;
        }          
     
                 }catch(SQLException se){
                    se.printStackTrace();
                  }
      start(0);
	}
	 
	 public String[][] qarray() {
	        return q.clone();
	    }
	 public String[][] ansarray() {
	        return a.clone();
	    }
    
        
	private void testload()
	{	
		setTitle("MCQ Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		opg=new ButtonGroup();
		op1=new JRadioButton();
		op2=new JRadioButton();
		op3=new JRadioButton();
		op4=new JRadioButton();
		question=new JLabel();
		Next=new JButton();
		Back=new JButton();
                
                question.setBounds(30,40,850,30);
		 question.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));                              
                op1.setBounds(50,90,400,30);               
		op1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));            
                op2.setBounds(50,125,400,30);
		op2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                op3.setBounds(50,160,400,30);
		op3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                op4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                op4.setBounds(50,195,400,30);
		Back.setBounds(100,260,200,30);
		Back.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                Next.setBounds(270,260,200,30);               
                Next.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        final JLabel timer = new JLabel("01:00");
        timer.setBounds(10,10,100,30);             
        final Timer t = new Timer(1000, new ActionListener() {
            int time = 600;
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                timer.setText(format(time / 60) + ":" + format(time % 60));
                if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                	timer.stop();
                }else {
                if (time == 0) {
                	if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                	}else {
                    JOptionPane.showMessageDialog(null,"Time Up Click Ok To Check Your Score","bye..",JOptionPane.ERROR_MESSAGE);
                    System.out.println(score);
        			new Result(sub).setVisible(true);
        			dispose();
                	}
                }
            }
            }
            
        });
        t.start();
       
        opg.add(op1);
        op1.setText("option1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1Selected(evt);
            }

		
        });

        opg.add(op2);
        op2.setText("option2");
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2selected(evt);
            }

		
        });

        opg.add(op3);
        op3.setText("option3");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3selected(evt);
            }

        });

        opg.add(op4);
        op4.setText("option4");
        op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4selected(evt);
            }

			
        });

        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("Question");
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextClicked(evt);
            }

        });
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClicked(evt);
            }

        });
	 contentPane.add(question);
         
        contentPane.add(op1);
        contentPane.add(op2);
        contentPane.add(op3);
        contentPane.add(op4);
        contentPane.add(Next);
        contentPane.add(Back);
        contentPane.add(timer);
        
        
        }

	

	protected void BackClicked(ActionEvent evt) {
	
		if(c==0) {
			
		}else {
			if(score==c)
			{
		score--;
		c--;
		start(c);
			}
			else {
				c--;
				start(c);
			}
		}
		
	}
	protected void NextClicked(ActionEvent evt) {
		
		
		if(getSelectedButtonText(opg) == null ? a[c][1] == null : getSelectedButtonText(opg).equals(a[c][1])) {
			score++;
			count++;
			c++;
		}
		else
		{
			c++;
			count++;
		}
			if(c!=no)
		{
			start(c);
		System.out.println(score);
		}
		else {
			System.out.println(score);
			new Result(sub).setVisible(true);
			this.dispose();
		}
	}
	protected void op4selected(ActionEvent evt) {
	
		
	}
	protected void op3selected(ActionEvent evt) {
	
		
	}
	protected void op2selected(ActionEvent evt) {
		
		
	}
	protected void op1Selected(ActionEvent evt) {
	
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
		    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = (AbstractButton) buttons.nextElement();

		        if (button.isSelected()) {
		            return button.getText();
		        }
		    }
		    return null;
	}
	public void start(int i) {
		
                question.setText(q[i][0]);
	        op1.setText(q[i][1]);
	        op2.setText(q[i][2]);
	        op3.setText(q[i][3]);
	        op4.setText(q[i][4]);
	        opg.clearSelection();
		
	}
	private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
	

}



