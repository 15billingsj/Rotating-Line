import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RadiusSlider extends JComponent implements ChangeListener{
	private static int radius = 150;

	public static void setRadius(int radius) {
		RadiusSlider.radius = radius;
	}

	public RadiusSlider(int a, int b){

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//			setBorder(BorderFactory.createEtchedBorder(1, Color.WHITE, Color.BLACK));
		//creates the Jlabel
		JLabel label = new JLabel("Radius");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.WHITE);

		//creates the JSlider
		JSlider s = new JSlider(a,b);
		s.setBackground(Color.BLACK);
		s.setMajorTickSpacing(100);
		s.setMinorTickSpacing(20);
		s.setValue(radius);
		s.setSnapToTicks(true);
		s.setPaintTicks(true);
		s.addChangeListener(this);

		add(label);
		add(s);
	}

	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		radius = source.getValue();
	}

	public static int getRadius() {
		return radius;
	}

}



