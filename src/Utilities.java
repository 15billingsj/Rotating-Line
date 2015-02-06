import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Utilities {	
	public static Timer timer(final Polygon poly){
		ActionListener a = new ActionListener(){
			public void actionPerformed(ActionEvent aE){
				poly.rotate(1);
			}
		};
		Timer t = new Timer(40, a);
		return t;
	}
}
