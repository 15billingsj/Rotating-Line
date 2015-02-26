

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Display extends JFrame implements ActionListener, ComponentListener {
	private Color background = Color.BLACK;
	private static int borderWidth = 5;
	private static int frameWidth = 850;
	private static int frameHieght = 600;

	private static JPanel north;
	private static PolygonDrawer center;
	private static JPanel south;

	private JButton changeColor;
	private CounterRotateJButton changeDirection;
	private JButton stop;
	private static JLabel title;

	private LineThicknessSlider thick;
	private SpeedJSlider speed;
	private RadiusSlider radius;
	private ChangePolygonSlider changePoly;


	public Display(){
		super("Rotating Line Project");
		super.addComponentListener(this);


		setSize(frameWidth,frameHieght);
		super.setMinimumSize(new Dimension(frameWidth,frameHieght));
		setCenter(new PolygonDrawer());
		north = new JPanel();
		south = new JPanel();

		getCenter().setBorder(BorderFactory.createLineBorder(ChangeColorJButton.getC(),borderWidth));
		north.setBorder(BorderFactory.createLineBorder(ChangeColorJButton.getC(),borderWidth));
		south.setBorder(BorderFactory.createLineBorder(ChangeColorJButton.getC(),borderWidth));

		north.setBackground(background);
		getCenter().setBackground(background);
		south.setBackground(background);
		
//		north.setLayout(new GridLayout(1,4));
		
		Display.title = new JLabel("Created By Jack Billings and Robert Colley");
		title.setForeground(ChangeColorJButton.getC());
		
		this.radius = new RadiusSlider(20,500);
		this.stop = new StopJButton();
		this.speed = new SpeedJSlider(1,12);
		this.changePoly = new ChangePolygonSlider(2,32);
		this.changeColor = new ChangeColorJButton();
		this.changeDirection = new CounterRotateJButton();
		this.thick = new LineThicknessSlider(1,30);

		north.add(stop);
		north.add(changeColor);
		north.add(changeDirection);
		north.add(title);

		south.add(thick);
		south.add(speed);
		south.add(changePoly);
		south.add(radius);

		north.setPreferredSize(new Dimension(frameWidth,48));
		getCenter().setPreferredSize(new Dimension(frameWidth,frameHieght));
		south.setPreferredSize(new Dimension(frameWidth,64));

		super.getContentPane().add(north, BorderLayout.PAGE_START);
		super.getContentPane().add(getCenter());
		super.getContentPane().add(south, BorderLayout.PAGE_END);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setVisible(true);
	}

	public static void setBorderColor(Color c) {
		north.setBorder(BorderFactory.createLineBorder(ChangeColorJButton.getC(),borderWidth));
		getCenter().setBorder(BorderFactory.createLineBorder(ChangeColorJButton.getC(),borderWidth));
		south.setBorder(BorderFactory.createLineBorder(ChangeColorJButton.getC(),borderWidth));
		title.setForeground(ChangeColorJButton.getC());
	}

	public static void main(String[] args){
		final Display t = new Display();
	}
	//Listener Methods
	public void componentResized(ComponentEvent arg0) {
		int newFrameHieght = super.getContentPane().getHeight();
		int newFrameWidth = super.getContentPane().getWidth();

		// This prevents the polygon from starting at 0,0
		if ((newFrameHieght != 0) && (newFrameWidth != 0)) {
			if(getCenter().getPoly().getNumSides()== 2){
				getCenter().getPoly().setCenterX(newFrameWidth/2);
				getCenter().getPoly().setCenterY(newFrameHieght/2-58);
			}
		}
	}

	//Getters and setters for some of the private data
	public static int getFrameWidth() {
		return frameWidth;
	}
	public void setFrameWidth(int frameWidth) {
		Display.frameWidth = frameWidth;
	}
	public static int getFrameHieght() {
		return frameHieght;
	}
	public void setFrameHieght(int frameHieght) {
		Display.frameHieght = frameHieght;
	}


	//unused methods only here to make the compiler happy
	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static PolygonDrawer getCenter() {
		return center;
	}

	private static void setCenter(PolygonDrawer center) {
		Display.center = center;
	}



}

