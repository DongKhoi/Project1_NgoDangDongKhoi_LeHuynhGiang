import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class MyCanvas extends JPanel{
	private static List<Shape> shapes;
	private int flagAdd=1;
	private int n;
	
	public int getNoShape() {
		return n;
	}
	
	public static List<Shape> getShapes() {
		return shapes;
	}
	
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
		this.n=shapes.size();
		repaint();
		if(NetWork.network.getMode().equals("server"))NetWork.network.Update(this.shapes);
	}

	public MyCanvas() {
		shapes=new ArrayList<Shape>();
		this.setBorder(new LineBorder(Color.BLACK,3));
		this.addMouseListener(new EventWorkArea());
		this.addMouseMotionListener(new EventWorkArea());
		EventWorkArea.setMyCanvas(this);
		n=0;
	}
	
	public void drawShape(Shape shape) {
		remove();
		shape.setStroke(PropertiesBar.getStroke());	
		this.shapes.add(n,shape);
		n++;
		repaint();
		flagAdd=0;
	}
	public void addShape() {
		flagAdd=1;
	}
	//remove shape at top 
	private void remove() {
		if(n>=1&&flagAdd==0) {
			this.shapes.remove(n-1);
			n--;
		}
	}
	//move shape base on index
	public void moveShape(int index, int x, int y) {
		if(index>=0 && index < n) {
			shapes.get(index).Move(x, y);
			repaint();
		}
	}
	//rotate shape
	public void rotateShape(int index, float anpha) {
		if(index>=0 && index < n) {
			shapes.get(index).Rotate(anpha);
			repaint();
		}
	}
	//fill color 
	public void fillColor(int index, Color color) {
		if(index>=0 && index < n) {
			shapes.get(index).setColor(color);
			repaint();
		}
	}
	//shape is selected when mouse press
	public int selectShape(int locationX, int locationY) {
		int i=n-1;
		for(;i>=0;i--)
			if(shapes.get(i).IsOnThisShape(locationX, locationY)) {
				
				//
				Shape shape = shapes.get(i);
				StatusBar.setInfor(shape.getClass().getName(), shape.getxLocation(), shape.getyLocation(), i+1, n);
				//
				
				return i;
			}
		return i;
	}
	
	public void undo() {
		
	}
	public void redo() {
		
	}
	
	
	//remove shape at bottom
	public void removeLastShape() {
		if(n>=1) {
			this.shapes.remove(n-1);
			repaint();
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		//super.paint(g);
		for(Shape shape: shapes) {
			shape.Draw((Graphics2D)g);
		}
		this.getParent().repaint();
		//NetWork.Update(shapes);
	}
}
