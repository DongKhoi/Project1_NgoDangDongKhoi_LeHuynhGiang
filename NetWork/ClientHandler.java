import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread{
	//private DataInputStream dis; 
    //private DataOutputStream dos;
	private ObjectInputStream oIS;
	private ObjectOutputStream oOS;
    private Socket socket; 
    private int id;
    public ClientHandler(Socket s, int id)  
    { 
        this.socket = s; 
        this.id=id;
    } 
    @Override
    public void run()  
    {
    	/*try {
			//dis=new DataInputStream(socket.getInputStream());
    		oIS=new ObjectInputStream(socket.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        while (true)  
        { 
            try {
            	String received="";
            	//String str=dis.readUTF();
            	//System.out.println(str);
            	oIS=new ObjectInputStream(socket.getInputStream());
            	ListShapes listShapes=(ListShapes)oIS.readObject();
            	System.out.println(listShapes.getStr());
                EventWorkArea.getMyCanvas().setShapes(listShapes.getShapes());
            	
                if(received.equals("Exit")) 
                {  
                    System.out.println("Client " + id + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    //this.s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                }
                else {
					System.out.println(received);
				}
            } catch (IOException e) { 
                e.printStackTrace(); 
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
        } 
          
        try
        { 
            // closing resources 
            //this.dis.close(); 
            //this.dos.close(); 
        	oIS.close();
        	oOS.close();
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    }
    public void Update(List<Shape> shapes) {
    		ListShapes listShapes=new ListShapes();
    		listShapes.setShapes(shapes);
    		listShapes.setStr("from server");
    		try {
				//dos=new DataOutputStream(socket.getOutputStream());
				//dos.writeUTF("from server");
    			oOS=new ObjectOutputStream(socket.getOutputStream());
    			oOS.writeObject(listShapes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    }
}
