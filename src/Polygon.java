
public class Polygon {
	private double angle;
	private double radius;
	private int numSides;
	private double centerX;
	private double centerY;
	
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
			tempAngle += 360 / numSides;
		}
		for(int i = 0; i < numSides; i++){
			yCoord = centerY + radius * Math.sin(tempAngle * Math.PI / 180);
			tempAngle += 360 / numSides;
			coordinates[i][1] = yCoord;
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
	}
}
