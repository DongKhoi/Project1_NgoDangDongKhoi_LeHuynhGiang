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
			this.color=color;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "white":
			this.color=Color.WHITE;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "black":
			this.color=Color.BLACK;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "red":
			this.color=Color.RED;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "orange":
			this.color=Color.ORANGE;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "yellow":
			this.color=Color.YELLOW;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "green":
			this.color=Color.GREEN;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "blue":
			this.color=Color.BLUE;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "pink":
			this.color=Color.PINK;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		case "gray":
			this.color=Color.GRAY;
			PropertiesBar.getB().setBackground(EventPropertiesBar.getColor());
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}
	}
	
	public static Color getColor() {
		return color;
	}

}
