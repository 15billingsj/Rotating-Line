import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SpeedJSlider extends JSlider implements ChangeListener{
	private static double speed = 6;

	public static void setSpeed(int speed) {
		SpeedJSlider.speed = speed;
	}

	public SpeedJSlider(){
		super(1,12);
		setBackground(Color.WHITE);
		super.setMajorTickSpacing(1);
//		setMinorTickSpacing(2);
		setSnapToTicks(true);
		setPaintTicks(true);
		addChangeListener(this);
	}

	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		speed = source.getValue();
	}

	public static double getSpeed() {
		return speed;
	}

}
