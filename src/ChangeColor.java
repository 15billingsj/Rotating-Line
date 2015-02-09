import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;


public class ChangeColor extends JButton implements ActionListener{
	private Color C;
	private Random R;
	private Random G;
	private Random B;

	public ChangeColor(){
		super("Change Color");
		addActionListener(this);
		R = new Random();
		G = new Random();
		B = new Random();
	}

	public void actionPerformed(ActionEvent arg0) {
		C = new Color(R.nextInt(256),G.nextInt(256),B.nextInt(256));
	}
	
	public Color getC() {
		return C;
	}

}

