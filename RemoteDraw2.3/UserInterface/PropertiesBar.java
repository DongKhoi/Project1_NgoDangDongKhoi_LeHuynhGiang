import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PropertiesBar extends JPanel{
	public PropertiesBar(int xSize, int ySize, ActionListener action) {
		//this.setLayout();
		this.setBackground(new Color(105,105,105,255));
		this.setPreferredSize(new Dimension(xSize,ySize));
		
		this.AddButton(action);
	}
	private void AddButton(ActionListener action) {
		this.add(new MyButton("white","    ", Color.WHITE, action));
		this.add(new MyButton("black", "    ", Color.BLACK, action));
		this.add(new MyButton("red", "    ", Color.RED, action));
		this.add(new MyButton("orange", "    ", Color.ORANGE, action));
		this.add(new MyButton("yellow", "    ", Color.YELLOW, action));
		this.add(new MyButton("green", "    ", Color.GREEN, action));
		this.add(new MyButton("blue", "    ", Color.BLUE, action));
		this.add(new MyButton("pink", "    ", Color.PINK, action));
		this.add(new MyButton("gray", "    ", Color.GRAY, action));
	}
	private int getxSize() {
		return this.getSize().width;
	}
	private int getySize() {
		return this.getSize().height;
	}
}
