import java.awt.Canvas;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventWorkArea implements MouseListener, MouseMotionListener{
	public static String command="";
	public static MyCanvas myCanvas;
	public static NetWork netWork;
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
	public static void setNetWork(NetWork _netWork) {
		netWork=_netWork;
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
		
		case "":
			break;
		default:
		}
		
		//**
		if(netWork!=null)netWork.Update(myCanvas.getShapes());
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
			Rectangle rectangle=new Rectangle();
			rectangle.setxLocation(previousX);rectangle.setyLocation(previousY);
			rectangle.setWidth(getCurrentX()-previousX);
			rectangle.setHeight(getCurrentY()-previousY);
			rectangle.setColor(EventPropertiesBar.getColor());
			myCanvas.drawShape(rectangle);
			break;
		default:
			
		}
		
	}

	//move
	@Override
	public void mouseMoved(MouseEvent e) {
		command=EventToolBar.getCommand();
		System.out.println(command+"mouse is moving");
	}
}