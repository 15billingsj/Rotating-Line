import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ChangePolygonJButton extends JButton implements ActionListener{
	private static int numberOfSides = 2;
	public ChangePolygonJButton(){
		super("Change Polygon");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(1 < numberOfSides && numberOfSides < 10 ){
			numberOfSides++;
		}
		else{
			numberOfSides = 2;
		}
	}

	public static int getNumberOfSides(){
		return numberOfSides;
	}


}
