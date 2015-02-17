import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class CounterRotateJButton extends JButton implements ActionListener{
	private static boolean direction = true;
	
	public CounterRotateJButton(){
		super("Change Direction");
		addActionListener(this);
	}

	public static int getDirection() {
		if(direction)return 1;
		return -1;
	}

	public static void setDirection(boolean direction) {
		CounterRotateJButton.direction = direction;
	}
	
	public void actionPerformed(ActionEvent e) {
		setDirection(!direction);
		
	}
	
	

}
