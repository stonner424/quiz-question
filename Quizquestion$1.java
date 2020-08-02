package Examinepackage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

class null implements ActionListener {
  int time = 600;
  
  public void actionPerformed(ActionEvent e) {
    this.time--;
    timer.setText(QuizquestionTest.access$000(this.time / 60) + ":" + MCQTest.access$000(this.time % 60));
    if (MCQTest.this.c >= 10) {
      Timer timer = (Timer)e.getSource();
      timer.stop();
    } else if (this.time == 0) {
      if (MCQTest.this.c >= 10) {
        Timer timer = (Timer)e.getSource();
        timer.stop();
      } else {
        JOptionPane.showMessageDialog(null, "Time Up Click Ok To Check Your Score", "bye..", 0);
        System.out.println(QuizquestionTest.score);
        (new Result(QuizquestionTest.this.sub)).setVisible(true);
        QuizquestionTest.this.dispose();
      } 
    } 
  }
}

