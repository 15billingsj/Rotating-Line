import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolygonDrawer extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	private int width;
	private int hieght;

	private static int radius;
	private double speed;
	public static Polygon poly;

	
	public PolygonDrawer(){
		this.width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		this.hieght = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		poly = new Polygon(radius,2,Display.getFrameWidth()/2,Display.getFrameHieght()/2,0);
		super.addMouseMotionListener(this);
		super.addMouseListener(this);
		
	}
	public Polygon getPoly() {
		return poly;
	}

	private int[] xpoints;
	private int[] ypoints;

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	Timer t = new Timer(1, this);
	
	private int maxRadiusCalc(){
		return Math.round((float)Math.sqrt(width*width + hieght*hieght));
	}

	private void radius(Polygon poly){
		if(poly.getNumSides() != 2)
			poly.setRadius(RadiusSlider.getRadius());
		if(poly.getNumSides() == 2)
			poly.setRadius(maxRadiusCalc());
	}

	public void rotate(Polygon poly){
		speed = SpeedJSlider.getSpeed()/10 *CounterRotateJButton.getDirection();
		if (StopJButton.getStopped())
			speed = 0;
		poly.setNumSides(ChangePolygonSlider.getSides());
		xpoints = new int[poly.getNumSides()];
		ypoints = new int[poly.getNumSides()];

		radius(poly);

		double[][] newPoints = poly.rotate(speed);
		for(int i = 0; i < poly.getVertices().length; i++){
			xpoints[i] = (int) Math.round(newPoints[i][0]);
		}
		for(int i = 0; i < poly.getVertices().length; i++){
			ypoints[i] = (int) Math.round(newPoints[i][1]); // TODO Was Calling rotate twice!!!!
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		rotate(poly);

		g2.setStroke(new BasicStroke(LineThicknessSlider.getThickness()));

		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(rh);

		g.setColor(ChangeColorJButton.getC());

		g2.drawPolygon(xpoints, ypoints, poly.getVertices().length);

		t.start();

	}

	public void actionPerformed(ActionEvent e) {

		repaint();	
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		Display.getCenter().getPoly().setCenterX(arg0.getX());
		Display.getCenter().getPoly().setCenterY(arg0.getY());

	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		Display.getCenter().getPoly().setCenterX(arg0.getX());
		Display.getCenter().getPoly().setCenterY(arg0.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
