package Examinepackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class null implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		(new Login()).setVisible(true);
		Answers.this.dispose();
	}
}