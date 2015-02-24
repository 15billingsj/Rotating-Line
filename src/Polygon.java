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
	 * 	double radius = the 
	 * 	char paintCharacter: the character that fills the box
	 * 	int length: the length of the line
	 */
	public Polygon(double radius, int numSides, double centerX, double centerY, double angle){
		this.radius = radius;
		this.numSides = numSides;
		this.centerX = centerX;
		this.centerY = centerY;
		this.angle = angle;
	}
	
	public Polygon(double radius, int numSides){
		this.radius = radius;
		this.numSides = numSides;
	}
	
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
	
	public double[][] rotate(double angleChange){
		angle += angleChange;
		return getVertices();
	}
	
	private static String toString(double[][] board){
		String s = "";
		for(int i = 0; i < board.length; i++){
			s += "\n";
			for(int j = 0; j < board[0].length; j++){
				s += board[i][j] + "                         ";
			}
		}
		return s;
	}
	
	public static void main(String[] args){
		Polygon p = new Polygon(Math.sqrt(2), 2, 0, 0, 45);
		System.out.println(toString(p.getVertices()));
		p.rotate(12);
		System.out.println(toString(p.getVertices()));
	}

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