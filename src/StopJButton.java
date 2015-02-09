import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class StopJButton extends JButton implements ActionListener{
	private boolean stopped = false;
	public StopJButton(){
		super("Stop");
		addActionListener(this);
		setActionCommand("stop");
	}

	public void actionPerformed(ActionEvent arg0) {
		if("stop".equals(arg0.getActionCommand())){
			stopped = true;
			setActionCommand("bleh");
		}
		else{
			stopped = false;
			setActionCommand("stop");
		}
	}
	
	public boolean getStopped(){
		return stopped;
	}
	

}
