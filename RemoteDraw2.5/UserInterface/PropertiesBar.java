import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class PropertiesBar extends JPanel implements AdjustmentListener{
	public static JButton setcolor;
	public static int stroke=1;
	public static JButton getB() {
		return setcolor;
	}
	public static int getStroke() {
		return stroke;
	}
	public PropertiesBar(int xSize, int ySize, ActionListener action) {
		this.setLayout(null);
		this.setBackground(new Color(105,105,105,255));
		this.setPreferredSize(new Dimension(xSize,ySize));
		
		MyButton colButton=new MyButton("color" ,20,20, "image/color.png",action);
		MyButton white=new MyButton("white","    ", Color.WHITE, action);
		MyButton black=(new MyButton("black", "    ", Color.BLACK, action));
		MyButton red=(new MyButton("red", "    ", Color.RED, action));
		MyButton orange=(new MyButton("orange", "    ", Color.ORANGE, action));
		MyButton yellow=(new MyButton("yellow", "    ", Color.YELLOW, action));
		MyButton green=(new MyButton("green", "    ", Color.GREEN, action));
		MyButton blue=(new MyButton("blue", "    ", Color.BLUE, action));
		MyButton pink=(new MyButton("pink", "    ", Color.PINK, action));
		MyButton gray=(new MyButton("gray", "    ", Color.GRAY, action));
		//button display color
		setcolor=new JButton("");
		setcolor.setBackground(Color.BLACK);
		setcolor.setPreferredSize(new Dimension(30, 30));
		JLabel currentcolor=new JLabel("Current Color ");
		JLabel Label=new JLabel("Stroke              ");
		JScrollBar scrollBar=new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 255);
		scrollBar.setPreferredSize(new Dimension(130, 15));
	    //scrollBar.setBlockIncrement(16);
	    scrollBar.addAdjustmentListener(this);
	    JLabel Label1=new JLabel("Transparency ");
		JScrollBar scrollBar1=new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 255);
		scrollBar1.setPreferredSize(new Dimension(130, 15));
	    //scrollBar.setBlockIncrement(16);
	    scrollBar1.addAdjustmentListener(this);
	    
	    
	    JPanel panel1=new JPanel();
	    panel1.setLocation(0, 0);
	    panel1.setSize(250, 40);
	    panel1.add(red);
	    panel1.add(orange);
	    panel1.add(yellow);
	    panel1.add(green);
	    panel1.add(pink);
	    panel1.add(gray);
	    panel1.add(blue);
	    panel1.add(black);
	    panel1.add(white);
	    panel1.add(colButton);
	    this.add(panel1);
	    
	    JPanel panel2=new JPanel();
	    panel2.setLocation(0, 40);
	    panel2.setSize(250, 40);
	    panel2.add(Label);
	    panel2.add(scrollBar);
	    this.add(panel2);
	    
	    JPanel panel3=new JPanel();
	    panel3.setLocation(0, 80);
	    panel3.setSize(250, 40);
	    panel3.add(Label1);
	    panel3.add(scrollBar1);
	    this.add(panel3);
	    
	    JPanel panel4=new JPanel();
	    panel4.setLocation(0, 120);
	    panel4.setSize(250,40);
	    panel4.add(currentcolor);
	    panel4.add(setcolor);	    
	    this.add(panel4);
	    
	    
	}
	private int getxSize() {
		return this.getSize().width;
	}
	private int getySize() {
		return this.getSize().height;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub		
		this.stroke=e.getValue();
	}  
}
