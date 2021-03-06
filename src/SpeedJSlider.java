import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SpeedJSlider extends JComponent implements ChangeListener{
	private static double speed = 6;

	public static void setSpeed(int speed) {
		SpeedJSlider.speed = speed;
	}

	public SpeedJSlider(int a, int b){
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//creates the Jlabel
		JLabel label = new JLabel("Speed");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.WHITE);
		
		//creates the JSlider
		JSlider s = new JSlider(a,b);
		s.setBackground(Color.BLACK);
		s.setMajorTickSpacing(3);
		s.setMinorTickSpacing(1);
		s.setValue((a+b)/2);
		s.setName("Sides");
		s.setSnapToTicks(true);
		s.setPaintTicks(true);
		s.addChangeListener(this);
		
		add(label);
		add(s);
	}

	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		speed = source.getValue();
	}

	public static double getSpeed() {
		return speed;
	}

}
