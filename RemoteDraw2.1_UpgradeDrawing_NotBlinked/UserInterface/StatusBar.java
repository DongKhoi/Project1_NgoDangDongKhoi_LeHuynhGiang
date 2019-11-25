import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class StatusBar extends JPanel{
	private int xSize;
	private int ySize;
	public StatusBar(int xSize, int ySize) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(30,28,28,255));
		this.setPreferredSize(new Dimension(xSize,ySize));
	}
}
