import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;


public class ChangeColorJButton extends JButton implements ActionListener{
	private static Color C = Color.WHITE;
	private Random R;
	private Random G;
	private Random B;

	public ChangeColorJButton(){
		super("Change Color");
		addActionListener(this);
		R = new Random();
		G = new Random();
		B = new Random();
	}

	public void actionPerformed(ActionEvent arg0) {
		C = new Color(R.nextInt(256),G.nextInt(256),B.nextInt(256));
		Display.setBorderColor(C);
	}

	public static Color getC() {
		return C;
	}
	

}

