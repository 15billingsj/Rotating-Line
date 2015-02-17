

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Display extends JFrame implements ComponentListener{
	private static int frameWidth = 600;
	private static int frameHieght = 500;
	private JPanel north;
	private JPanel south;
	
	public Display(){
		super("Rotating Line Project");
		super.addComponentListener(this);
		
		setSize(frameWidth,frameHieght);
		super.setMinimumSize(new Dimension(frameWidth,frameHieght));
		this.south = new PolygonDrawer();
		this.north = new NorthJPanel();
		south.setBackground(Color.WHITE);
		
		north.setPreferredSize(new Dimension(frameWidth,50));
		south.setPreferredSize(new Dimension(frameHieght,frameWidth));
		super.add(north, BorderLayout.PAGE_START);
		super.add(south, BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
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

	public static void main(String[] args){
		Display t = new Display();
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
	public void componentResized(ComponentEvent arg0) {
		Display.frameHieght = super.getHeight();
		Display.frameWidth = super.getWidth();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

