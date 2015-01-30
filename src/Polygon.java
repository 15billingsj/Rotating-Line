
public class Polygon {
	private double angle;
	private double radius;
	private int numSides;
	
	public Polygon(double angle, double radius, int numSides){
		this.angle = angle;
		this.radius = radius;
		this.numSides = numSides;
	}
	
	public double[][] getVertices(){
		double[][] coordinates = new double[2][numSides];
		for(int i = 2; i <= numSides; i++){
			//calc xCoord->make another look to calc yCoord
		}
		return coordinates;
	}
}
