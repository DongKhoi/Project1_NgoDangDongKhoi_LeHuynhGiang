import java.awt.Color;
import java.awt.Graphics2D;


public abstract class Shape implements IShapeMove, IShapeRotation{
	private int xLocation;
	private int yLocation;
	private float anpha;

	private Color color;
	
	public Shape() {
		
	}
	public Shape(int xLocation, int yLocation, Color color) {
		this.xLocation=xLocation;
		this.yLocation=yLocation;
		anpha=0;
		this.color=color;
	}
	//
	public int getxLocation() {
		return xLocation;
	}
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}
	//
	public int getyLocation() {
		return yLocation;
	}
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	//
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	//
	public float getAnpha() {
		return anpha;
	}
	public void setAnpha(float anpha) {
		this.anpha = anpha;
	}
	public abstract boolean IsOnThisShape(int x, int y);
	
	public abstract void Draw(Graphics2D g);
	
	@Override
	public void Move(int x, int y) {
		this.setxLocation(getxLocation()+x);
		this.setyLocation(getyLocation()+y);
	}
	@Override
	public void Rotate(float anpha) {
		this.setAnpha(getAnpha()+anpha);
	}
}
