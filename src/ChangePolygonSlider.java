import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ChangePolygonSlider extends JComponent implements ChangeListener{
	private static int sides = 2;

	public static void setSides(int sides) {
		ChangePolygonSlider.sides = sides;
	}

	public ChangePolygonSlider(int a, int b){
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//		setBorder(BorderFactory.createEtchedBorder(1, Color.WHITE, Color.BLACK));
		//creates the Jlabel
		JLabel label = new JLabel("Sides");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.WHITE);
		
		//creates the JSlider
		JSlider s = new JSlider(a,b);
		s.setBackground(Color.BLACK);
		s.setMajorTickSpacing(3);
		s.setMinorTickSpacing(1);
		s.setValue(a);
		s.setSnapToTicks(true);
		s.setPaintTicks(true);
		s.addChangeListener(this);
		
		add(label);
		add(s);
		
	}

	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		sides = source.getValue();
	}

	public static int getSides() {
		return sides;
	}

}