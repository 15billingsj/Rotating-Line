import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class LineThicknessSlider extends JComponent implements ChangeListener{
	private static int thickness = 20;

	public static void setThickness(int thickness) {
		LineThicknessSlider.thickness = thickness;
	}

	public LineThicknessSlider(int a, int b){

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//creates the Jlabel
		JLabel label = new JLabel("Line Thickness");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.WHITE);

		//creates the JSlider
		JSlider s = new JSlider(a,b);
		s.setBackground(Color.BLACK);
		s.setMajorTickSpacing(5);
		s.setMinorTickSpacing(1);
		s.setValue(thickness);
		s.setSnapToTicks(true);
		s.setPaintTicks(true);
		s.addChangeListener(this);

		add(label);
		add(s);
	}

	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		thickness = source.getValue();
	}

	public static int getThickness() {
		return thickness;
	}

}



