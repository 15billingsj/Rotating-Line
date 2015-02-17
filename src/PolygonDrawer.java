import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PolygonDrawer extends JPanel implements ActionListener{
	private int radius = 1000;
	private double speed = SpeedJSlider.getSpeed();
	private static Color C;
	private Polygon poly = new Polygon(radius,2,Display.getFrameWidth()/2,Display.getFrameHieght()/2,0);

	public static void setC(Color c) {
		C = c;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	Timer t = new Timer(50, this);

	private int[] xpoints = new int[poly.getNumSides()];
	private int[] ypoints = new int[poly.getNumSides()];

	public void rotate(Polygon poly){
		poly.setNumSides(ChangePolygonJButton.getNumberOfSides());
		xpoints = new int[poly.getNumSides()];
		ypoints = new int[poly.getNumSides()];
		
		if(poly.getNumSides() != 2)
			poly.setRadius(100);
		if(poly.getNumSides() == 2)
			poly.setRadius(1000);
			
		for(int i = 0; i < poly.getVertices().length; i++){
			xpoints[i] = (int) poly.rotate(SpeedJSlider.getSpeed())[i][0];
		}
		for(int i = 0; i < poly.getVertices().length; i++){
			ypoints[i] = (int) poly.rotate(SpeedJSlider.getSpeed())[i][1];
		}
	}

	public void paintComponent(Graphics g){
		if(!StopJButton.getStopped())
			rotate(poly);

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(new BasicStroke(10));
		
		poly.setCenterX(Display.getFrameWidth()/2);
		poly.setCenterY(Display.getFrameHieght()/2);
		
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setRenderingHints(rh);

		g.setColor(C);
		
		g2.drawPolygon(xpoints, ypoints, poly.getVertices().length);
		
		t.start();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();	
	}



}
