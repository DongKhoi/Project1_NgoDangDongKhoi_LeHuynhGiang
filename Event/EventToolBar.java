import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class EventToolBar implements ActionListener{
	public static String command="";
	
	private ConnectWindow connectWin=new ConnectWindow(); 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		command=e.getActionCommand();
		switch (command) {
		case "network":
			connectWin.Display(750, 100);
			break;
		case "rectangle":
			break;
		case "circle":
			break;
		default:
		}
	}
	public static String getCommand() {
		return command;
	}
	
}
