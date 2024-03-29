import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventWorkArea implements MouseListener, MouseMotionListener{
	public static String command="";
	public static MyCanvas myCanvas;
	public static ConnectWindow connectWindow= new ConnectWindow();
	private static int shapeSlected=-1;
	private static int previousX;
	private static int previousY;
	
	//
	public int getCurrentX() {
		return MouseInfo.getPointerInfo().getLocation().x-myCanvas.getLocationOnScreen().x;
	}
	public int getCurrentY() {
		return MouseInfo.getPointerInfo().getLocation().y-myCanvas.getLocationOnScreen().y;
	}
	//
	
	
	//Set property
	public static void setMyCanvas(MyCanvas canvas) {
		myCanvas=canvas;
	}
	public static MyCanvas getMyCanvas() {
		return myCanvas;
	}
	
	//**//
	//Click
	@Override
	public void mouseClicked(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse has clicked");
		switch (command) {
		default:
		}
	}
	
	//press
	@Override
	public void mousePressed(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse has pressed");
		switch (command) {
		case "move":
			shapeSlected=myCanvas.selectShape(getCurrentX(), getCurrentY());
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "fillColor":
			shapeSlected=myCanvas.selectShape(getCurrentX(), getCurrentY()); ;
		case "rotate":
			shapeSlected=myCanvas.selectShape(getCurrentX(), getCurrentY());
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "rectangle":
			System.out.println(myCanvas.getLocation().x+" "+myCanvas.getLocation().y);
			System.out.println(getCurrentX()+" "+getCurrentY());
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "line":
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "circle":
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "triangle":
			previousX=getCurrentX();
			previousY=getCurrentY();
		case "elipse":
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		default:
		}		
	}

	//release
	@Override
	public void mouseReleased(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse has released");
		switch (command) {
		case "move":
			EventWorkArea.shapeSlected=-1;
			break;
		case "fillColor":
			myCanvas.fillColor(shapeSlected, EventPropertiesBar.getColor());
			break;
		case "rotate":
			break;
		case "rectangle":
			myCanvas.addShape();
			break;
		case "line":
			myCanvas.addShape();
			break;
		case "circle":
			myCanvas.addShape();
			break;
		case "triangle":
			myCanvas.addShape();
			break;
		case "elipse":
			myCanvas.addShape();
			break;
		case "":
			break;
		default:
		}
		
		//**
		if(!NetWork.network.getMode().equals("not"))NetWork.network.Update(myCanvas.getShapes());
		//**
	}

	//entered
	@Override
	public void mouseEntered(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse has entered");
		System.out.println(getCurrentX()+" "+getCurrentY());
	}

	//exit
	@Override
	public void mouseExited(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse has exited");
	}
	
	//drag
	@Override
	public void mouseDragged(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse is dragging");
		switch (command) {
		case "move":
			myCanvas.moveShape(shapeSlected,getCurrentX()-previousX,getCurrentY()-previousY);
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "rotate":
			myCanvas.rotateShape(shapeSlected, (((float)(getCurrentX()-previousX)%50)/100));
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "rectangle":
			RectangleDirection(previousX, previousY);
			break;
		case "line":
			Line line=new Line();
			line.setxLocation(previousX);
			line.setyLocation(previousY);
			line.setDesX(getCurrentX());
			line.setDesY(getCurrentY());
			line.setColor(EventPropertiesBar.getColor());
			//Graphics2D g2 =(Graphics2D)myCanvas.getGraphics();
			//g2.setStroke(new BasicStroke(PropertiesBar.getStroke()));
			//PropertiesBar.labelstroke.setText("value is: "+ PropertiesBar.getStroke());
			myCanvas.drawShape(line);
			break;
		case "circle":
			CicrleDirection();
			break;
		case "elipse":
			Elipse elipse=new Elipse();
			elipse.setxLocation(previousX);
			elipse.setyLocation(previousY);
			int d=(int) Math.sqrt(Math.pow(previousX-(getCurrentX()), 2)+Math.pow(previousY-getCurrentY(), 2));
			elipse.setRadius(d/2);
			elipse.setHeight(getCurrentX()/2);
			elipse.setColor(EventPropertiesBar.getColor());
			myCanvas.drawShape(elipse);
			break;
		case "triangle":
			Triangle triangle=new Triangle();
			triangle.setxLocation(previousX);
			triangle.setyLocation(previousY);
			triangle.setDesX(getCurrentX());
			triangle.setDesY(getCurrentY());
			triangle.setColor(EventPropertiesBar.getColor());
			myCanvas.drawShape(triangle);
			break;
		default:
			
		}
		
	}
	public void CicrleDirection() {
		if(previousX<getCurrentX()&&previousY<getCurrentY()) 
		{
			Circle circle=new Circle();
			circle.setxLocation(previousX);
			circle.setyLocation(previousY);
			int d=(int) Math.sqrt(Math.pow(previousX-(getCurrentX()), 2)+Math.pow(previousY-getCurrentY(), 2));
			circle.setRadius(d/2);
			circle.setColor(EventPropertiesBar.getColor());
			myCanvas.drawShape(circle);
		}
	}
	public void RectangleDirection(int previousX,int previousY) {
		Rectangle rectangle=new Rectangle();			
		if(previousX<getCurrentX()&&previousY<getCurrentY())
		{
			rectangle.setxLocation(previousX);
			rectangle.setyLocation(previousY);
			rectangle.setWidth(getCurrentX()-previousX);
			rectangle.setHeight(getCurrentY()-previousY);
		}
		if(previousX>getCurrentX()&&previousY>getCurrentY())
		{
			rectangle.setxLocation(getCurrentX());
			rectangle.setyLocation(getCurrentY());
			rectangle.setWidth(-getCurrentX()+previousX);
			rectangle.setHeight(-getCurrentY()+previousY);
		}
		if(previousX<getCurrentX()&&previousY>getCurrentY())
		{
			rectangle.setxLocation(previousX);
			rectangle.setyLocation(getCurrentY());
			rectangle.setWidth(getCurrentX()-previousX);
			rectangle.setHeight(-getCurrentY()+previousY);
		}
		if(previousX>getCurrentX()&&previousY<getCurrentY())
		{
			rectangle.setxLocation(getCurrentX());
			rectangle.setyLocation(previousY);
			rectangle.setWidth(-getCurrentX()+previousX);
			rectangle.setHeight(getCurrentY()-previousY);
		}
		rectangle.setColor(EventPropertiesBar.getColor());
		myCanvas.drawShape(rectangle);
	}
	//move
	@Override
	public void mouseMoved(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse is moving");
	}
}