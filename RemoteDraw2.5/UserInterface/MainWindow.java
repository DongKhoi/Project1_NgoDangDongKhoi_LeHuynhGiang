import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	private String title="RemoteDraw";
	
	
	private Dimension windowDimension=new Dimension(1050,630);
	public MainWindow(int width, int height) {
		windowDimension=new Dimension(width, height);
		Initial();
	}
	private void Initial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(this.windowDimension);
		setLayout(new BorderLayout());
		setTitle(title);
		pack();
		setLocationRelativeTo(null);
	}
	public void Display() {
		this.setVisible(true);
	}
	public int getxSize() {
		return this.getSize().width;
	}
	public int getySize() {
		return this.getSize().height;
	}
}
