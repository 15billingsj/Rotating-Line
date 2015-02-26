import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class CounterRotateJButton extends JButton implements ActionListener{
	private static boolean direction = true;

	public CounterRotateJButton(){
		super();
		addActionListener(this);
		setText("Change Direction (Counter-Clockwise)");
	}

	public static int getDirection() {
		if(direction){
			return 1;
		}
		return -1;
	}

	public void setDirection(boolean direction) {
		CounterRotateJButton.direction = direction;
		if(direction){
			super.setText("Change Direction (Counter-Clockwise)");
		}
		else{
			super.setText("Change Direction (Clockwise)");
		}
	}

	public void actionPerformed(ActionEvent e) {
		setDirection(!direction);
	}



}
