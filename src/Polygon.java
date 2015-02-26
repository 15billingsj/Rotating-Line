/* Rotating Line Project
 * 
 * Jack Billings & Bob Colley  Period 5  02/23/2015
 * 
 * The purpose of this class is to rotate a given polygon.
 */
public class Polygon {
	private double angle;
	private double radius;
	private int numSides;
	private double centerX;
	private double centerY;
	
	/*
	 * Constructor: Constructs an instance of this object from
	 * the given parameters.
	 * 
	 * Parameters:
	 * 	double radius: the radius of the polygon
	 * 	int numSides: the number of sides of the polygon (a line will be created if numSides = 2)
	 * 	double centerX: the x-coordinate of the center of the polygon
	 * 	double centerY: the y-coordinate of the center of the polygon
	 * 	double angle: the angle at which the polygon will be drawn
	 */
	public Polygon(double radius, int numSides, double centerX, double centerY, double angle){
		this.radius = radius;
		this.numSides = numSides;
		this.centerX = centerX;
		this.centerY = centerY;
		this.angle = angle;
	}
	
	/*
	 * This method constructs an instance of the polygon object, given a radius and number of sides
	 * 
	 * Parameters:
	 * 	double radius: the radius of the polygon
	 * 	int numSides: the number of sides of the polygon (a line will be created if numSides = 2)
	 */
	public Polygon(double radius, int numSides){
		this.radius = radius;
		this.numSides = numSides;
	}
	
	/*
	 * This method calculates the verticies of the polygon based on the radius,
	 * number of sides, angle, centerX and centerY
	 */
	public double[][] getVertices(){
		double[][] coordinates = new double[numSides][2];
		double xCoord = centerX;
		double yCoord = centerY;
		double tempAngle = angle;
		for(int i = 0; i < numSides; i++){
			xCoord = centerX + radius * Math.cos(tempAngle * Math.PI / 180);
			coordinates[i][0] = xCoord;
			tempAngle += 360 / (double)numSides;
		}
		tempAngle =  angle;
		for(int i = 0; i < numSides; i++){
			yCoord = centerY + radius * Math.sin(tempAngle * Math.PI / 180);
			coordinates[i][1] = yCoord;
			tempAngle += 360 / (double)numSides;
		}
		return coordinates;
	}
	
	/*
	 * This method rotates the polygon by incrementing the angle and calling the getVertices() method
	 */
	public double[][] rotate(double angleChange){
		angle += angleChange;
		return getVertices();
	}
	
	/*
	 * This method creates a string from a 2D array of double values that represent the x and y coordinates
	 * of the vertices of a polygon so that the coordinates can be printed
	 */
	private static String toString(double[][] coordinates){
		String s = "";
		for(int i = 0; i < coordinates.length; i++){
			s += "\n";
			for(int j = 0; j < coordinates[0].length; j++){
				s += coordinates[i][j] + "                         ";
			}
		}
		return s;
	}
	
	/*
	 * this main() method helps test the methods in my Polygon class.
	 */
	public static void main(String[] args){
		Polygon p = new Polygon(Math.sqrt(2), 2, 0, 0, 45);
		System.out.println(toString(p.getVertices()));
		p.rotate(12);
		System.out.println(toString(p.getVertices()));
		
		Polygon a = new Polygon(4, 7, 3, 2, 370);
		System.out.println(toString(a.getVertices()));
		a.rotate(4000.65);
		System.out.println(toString(a.getVertices()));
		a.rotate(-40.65);
		System.out.println(toString(a.getVertices()));
		a.rotate(0);
		System.out.println(toString(a.getVertices()));
	}
	
	/*
	 * Getters and setters
	 */
	public double getAngle() {
		return angle;
	}

	public double getRadius() {
		return radius;
	}

	public int getNumSides() {
		return numSides;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}
}