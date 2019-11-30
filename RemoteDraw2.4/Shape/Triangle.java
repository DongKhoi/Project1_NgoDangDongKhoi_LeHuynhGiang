import java.awt.Graphics2D;

public class Triangle extends Shape{
	private int desX=getxLocation();
	private int desY=getyLocation();
	private int number=3;
	 int x[] = { getxLocation(), 30, 40, 50, 110, desX }; 
	  
     // y coordinates of vertices 
     int y[] = { desY, 110, 50, 40, 30, getyLocation() }; 
	public int getDesX() {
		return desX;
	}

	public void setDesX(int desX) {
		this.desX = desX;
	}

	public int getDesY() {
		return desY;
	}

	public void setDesY(int desY) {
		this.desY = desY;
	}
	@Override
	public boolean IsOnThisShape(int x, int y) {
		if(x<this.getxLocation()) return false;
		if(x>(this.getxLocation()+desX)) return false;
		
		if(y<this.getyLocation()) return false;
		if(y>(this.getyLocation()+desY)) return false;
		return true;
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.rotate(getAnpha(),getxLocation()+(float)getDesX()/2,getyLocation()+(float)getDesY()/2);
		g.drawPolygon(x, y,number);
		g.rotate(-getAnpha(),getxLocation()+(float)getDesX()/2,getyLocation()+(float)getDesY()/2);		
	}

}
