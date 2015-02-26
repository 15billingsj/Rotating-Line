import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class StopJButton extends JButton implements ActionListener{
	private static boolean stopped = false;
	public StopJButton(){
		super("Stop");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(!stopped) super.setText("Start");
		else{
			super.setText("Stop");
			}
		stopped = !stopped;
	}

	public static boolean getStopped(){
		return stopped;
	}
}
