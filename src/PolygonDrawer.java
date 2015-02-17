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
	
	private int radius = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2;
	private double speed = SpeedJSlider.getSpeed();
	private static Color C;
	private Polygon poly = new Polygon(radius,2,Display.getFrameWidth()/2,Display.getFrameHieght()/2,0);
	private int[] xpoints;
	private int[] ypoints;

	public static void setC(Color c) {
		C = c;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	Timer t = new Timer(1, this);
	
	public void radius(Polygon poly){
		if(poly.getNumSides() != 2)
			poly.setRadius(150);
		if(poly.getNumSides() == 2)
			poly.setRadius(1000);
	}

	public void rotate(Polygon poly){
		poly.setNumSides(ChangePolygonJButton.getNumberOfSides());
		xpoints = new int[poly.getNumSides()];
		ypoints = new int[poly.getNumSides()];
		
		radius(poly);

		for(int i = 0; i < poly.getVertices().length; i++){
			xpoints[i] = (int) Math.round(poly.rotate(SpeedJSlider.getSpeed()/10 *CounterRotateJButton.getDirection())[i][0]);
		}
		for(int i = 0; i < poly.getVertices().length; i++){
			ypoints[i] = (int) Math.round(poly.rotate(SpeedJSlider.getSpeed()/10*CounterRotateJButton.getDirection())[i][1]);
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if(!StopJButton.getStopped()){
			rotate(poly);
		}

		g2.setStroke(new BasicStroke(20));

		poly.setCenterX(Display.getFrameWidth()/2);
		poly.setCenterY(Display.getFrameHieght()/2);

		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(rh);

		g.setColor(C);

		g2.drawPolygon(xpoints, ypoints, poly.getVertices().length);
		
		t.start();

	}

	public void actionPerformed(ActionEvent e) {
		
		repaint();	
	}



}
