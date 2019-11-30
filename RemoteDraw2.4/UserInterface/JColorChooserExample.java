import java.awt.event.*;  
import java.awt.*;

import javax.swing.*;  
  
public class JColorChooserExample extends JFrame implements ActionListener
{  
	JButton b;
	Container c;  
	private static Color color=Color.BLACK;
	public JButton getB() {
		return b;
	}
	public void setB(JButton b) {
		this.b = b;
	}
	public Container getC() {
		return c;
	}
	public void setC(Container c) {
		this.c = c;
	}
	//này too
	public JColorChooserExample()
	{  
		c=getContentPane();  
		c.setLayout(new FlowLayout());  	      
		b=new JButton("Click to set color");  
		b.addActionListener(this);	      
		c.add(b);  
	
	}  
  
	public void actionPerformed(ActionEvent e) {  
		Color initialcolor=Color.RED;  
		Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);  
		c.setBackground(color);
		this.color=color;
	}  
	public static Color getColor() {
		return color;
	}
}