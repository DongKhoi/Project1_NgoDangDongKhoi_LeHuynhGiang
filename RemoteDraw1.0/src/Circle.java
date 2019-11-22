import java.awt.Graphics2D;

public class Circle extends Shape{
	private int r;
	private int height;
	public Circle() {
		super();
	}
	public int getr() {
		return r;
	}
	public void setr(int r) {
		this.r = r;
	}
	@Override
	public boolean IsOnThisShape(int x, int y) {
		return false;
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.fillOval(100, 100, 100, 100);
	}
}
