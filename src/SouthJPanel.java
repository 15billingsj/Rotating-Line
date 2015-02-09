import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class SouthJPanel extends JPanel{
	private Polygon poly;
	private double[] xPoints;
	private double[] yPoints;
	private int nPoints;
	
	public SouthJPanel(){
		setSize(500,400);
		this.poly = new Polygon(400,2,250,300, 0);
		Graphics g;
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i <  poly.getVertices()[i][0]; i++){
			xPoints[i] = poly.getVertices()[i][0];
		}
		for(int i = 0; i <  poly.getVertices()[i][1]; i++){
			xPoints[i] = poly.getVertices()[i][1];
		}
		
	}
	 public void paint(Graphics g) {
	      g.drawPolyline(xPoints, yPoints, poly.getNumSides());

	  
	  }

	public Polygon getPoly() {
		return poly;
	}

	public void setPoly(Polygon poly) {
		this.poly = poly;
	}

}
