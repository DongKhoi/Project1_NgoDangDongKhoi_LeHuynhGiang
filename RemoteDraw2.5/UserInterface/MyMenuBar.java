import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyMenuBar extends JPanel implements ActionListener{
	private JMenuBar menuBar;
	private JMenu menuFile,menuExport,menuMode,menuHelp;
	private JMenuItem itemFileNew, itemFileOpen, itemFileSave;
	private JMenuItem itemExportPng, itemExportJPG;
	public static MyCanvas myCanvas;
	public static void setMyCanvas(MyCanvas canvas) {
		myCanvas=canvas;
	}
	public MyMenuBar(int xSize, int ySize) {
		this.setBackground(new Color(70,130,180,255));
		this.setPreferredSize(new Dimension(xSize, ySize));
		this.add(CreateMenu());
	}
	private JMenuBar CreateMenu() {
		menuBar=new JMenuBar();
		menuBar.setLayout(new GridLayout(15,1));
		//
		menuFile=new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuExport=new JMenu("Export");
		menuExport.setMnemonic(KeyEvent.VK_E);
		menuMode=new JMenu("Mode");
		menuMode.setMnemonic(KeyEvent.VK_M);
		menuHelp=new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		menuHelp.setBackground(new Color(0,0,0,0));
		//
		
		itemFileNew=new JMenuItem("New File",new ImageIcon(MyButton.ReSizeImg("image/newFile.png", 40, 40)));
		itemFileOpen=new JMenuItem("Open File",new ImageIcon(MyButton.ReSizeImg("image/openFile.png", 40, 40)));
		itemFileSave=new JMenuItem("Save",new ImageIcon(MyButton.ReSizeImg("image/saveFile.png", 40, 40)));
		itemExportPng=new JMenuItem("To PNG",new ImageIcon(MyButton.ReSizeImg("image/exportPng.png", 60, 60)));
		itemExportJPG=new JMenuItem("To JPG",new ImageIcon(MyButton.ReSizeImg("image/exportJPG.png", 60, 60)));
		itemFileSave.addActionListener(this);
		//
		menuFile.add(itemFileNew);menuFile.add(itemFileOpen);menuFile.add(itemFileSave);
		menuExport.add(itemExportJPG);menuExport.add(itemExportPng);
		menuHelp.add(new JMenuItem("0383990754 or Email:17110128student.hcmute.edu.vn"));
		//
		menuBar.add(menuFile);
		menuBar.add(menuExport);
		menuBar.add(menuMode);
		menuBar.add(menuHelp);
		menuBar.setBackground(new Color(0,0,0,0));
		menuBar.setBorder(BorderFactory.createEmptyBorder());
		//
		return menuBar;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		SavePaint();
		//OpenPaint();
	}
	 public void SavePaint() 
	 {
		 
		 try {
		        BufferedImage image = new BufferedImage(myCanvas.getWidth(),
		                myCanvas.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		        JFileChooser jFile = new JFileChooser();
		        jFile.showSaveDialog(null);
		        Path pth = jFile.getSelectedFile().toPath();
		        JOptionPane.showMessageDialog(null, pth.toString()+".png");
		        Graphics g = image.getGraphics();
		        myCanvas.printAll(g);
		        g.dispose();
		        ImageIO.write(image, "png", new File(pth.toString()+".png"));
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	 }
	 public void OpenPaint() {
		 
		 BufferedImage bi = null;
         //System.err.println("....setimg...." + fileName);

         try {
             bi = ImageIO.read(new File("D://moa.png")); 

         } catch (IOException e) {
             e.printStackTrace();
             System.out.println("Image could not be read");
             System.exit(1);
         }
	}
}
