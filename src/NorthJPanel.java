import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class NorthJPanel extends JPanel {
	private JButton stop;
	private JSlider speed;
	private JButton changePoly;
	private JButton changeColor;

	public NorthJPanel(){
		super();
		
		setBackground(Color.WHITE);
		this.stop = new StopJButton();
		this.speed = new SpeedJSlider();
		this.changePoly = new ChangePolygonJButton();
		this.changeColor = new JButton("Change Polygon Color");

		add(stop);
		add(speed);
		add(changePoly);
		add(changeColor);
		
		setVisible(true);
	}
}
