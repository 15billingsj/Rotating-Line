

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.Color;
import java.awt.Dimension;

public class Display {
	public static void main(String[] args){
		JFrame frame = new JFrame("Rotating Line Project");

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.RED);
		frame.setMinimumSize( new Dimension(200,200) );
		frame.setResizable(false);

		//creates the JPanel for the buttons and the sliders
		JPanel north = new JPanel();
		north.setBackground(Color.GREEN);
		north.setSize(frame.getWidth(), frame.getHeight()/5);
		frame.add(north);
		
		JButton b1 = new JButton("Stop");
		north.add(b1);
		
		b1 = new JButton("change color");
		north.add(b1);
		
		JSlider s1 = new JSlider();
		north.add(s1);

		//creates the south JPanel for drawing the line 
		JPanel south = new JPanel();
		south.setBackground(Color.WHITE);
		south.setSize(frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
		frame.add(south);
		
		//add the graphic to south, update south
	}
}

