import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SpeedJSlider extends JSlider implements ChangeListener{
	private int speed;

	public SpeedJSlider(){
		super(0,400);
		super.setMajorTickSpacing(20);
		setMinorTickSpacing(10);
		setPaintTicks(true);
		addChangeListener(this);
	}

	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		speed = (int)source.getValue();
	}

	public int getSpeed() {
		return speed;
	}

}
