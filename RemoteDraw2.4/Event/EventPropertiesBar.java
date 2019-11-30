import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class EventPropertiesBar extends JFrame implements ActionListener{
	private static Color color=Color.BLACK;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "color":
			Color initialcolor=Color.RED;  
			Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);  
			//c.setBackground(color);
			this.color=color;
			break;
		case "white":
			this.color=Color.WHITE;
			break;
		case "black":
			this.color=Color.BLACK;
			break;
		case "red":
			this.color=Color.RED;
			break;
		case "orange":
			this.color=Color.ORANGE;
			break;
		case "yellow":
			this.color=Color.YELLOW;
			break;
		case "green":
			this.color=Color.GREEN;
			break;
		case "blue":
			this.color=Color.BLUE;
			break;
		case "pink":
			this.color=Color.PINK;
			break;
		case "gray":
			this.color=Color.GRAY;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}
	}
	public static Color getColor() {
		return color;
	}

}
