import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class NetWork extends Thread{
	private int port=4322;
	private String ip=""; 
	private ServerSocket serverSocket;
	private Socket socket;
	private String mode="not";
	
	//private DataInputStream dis;
	//private DataOutputStream dos;
	private ObjectInputStream oIS;
	private ObjectOutputStream oOS;
	
	private List<ClientHandler> clients;
	

	public String getMode() {
		return mode;
	}
	
	public NetWork(int port) {
		this.port=port;
	}
	
	public NetWork(String mode, String ip) {
		this.mode=mode;
		this.ip=ip;
	}
	@Override
	public void run()
	{
		switch (mode) {
		case "server":
			if(serverSocket==null)
				try {
					serverSocket=new ServerSocket(port);
					server();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("can not open socket:NetWork/setMode/server");
					e1.printStackTrace();
				}
			break ;
		case "client":
			try {
				socket=new Socket(ip, port);
				client();
			} catch (IOException e) {
				System.out.println("can not open socket:NetWork/setMode/client");
				e.printStackTrace();
			}
			break ;
		default:
			break;
		}
	}
	
	//
	private void server() {
		int i=0;
		clients=new ArrayList<ClientHandler>();
		while(1==1) {
			socket=null;
			try {
				System.out.println("1");
				
				socket=serverSocket.accept();
				
				System.out.println("2");
				//*****************
				// obtaining input and out streams 
				// create a new thread object
	            
		        ClientHandler client = new ClientHandler(socket, i); 
		        clients.add(client);
		        clients.get(clients.size()-1).start();
		        
				i++;
				System.out.println("client "+i+" is connected :");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("NetWork/server");
				e.printStackTrace();
			}
		}
	}
	private void client() {
		
		/*try {
			//dis = new DataInputStream(socket.getInputStream());
			oIS=new ObjectInputStream(socket.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("NetWork/client 1");
			e1.printStackTrace();
		} */
		while (true){  
			try {
				//String str=dis.readUTF();
                //System.out.println(str); 
				oIS=new ObjectInputStream(socket.getInputStream());
                ListShapes listShapes=(ListShapes)oIS.readObject();
                System.out.println(listShapes.getStr());
                EventWorkArea.getMyCanvas().setShapes(listShapes.getShapes());
				
                // If client sends exit,close this connection  
                // and then break from the while loop
                String received="";
                if(received.equals("Exit")) 
                { 
                	System.out.println("Closing this connection : " + socket); 
	                socket.close(); 
	                System.out.println("Connection closed"); 
	                break; 
                }
               
                // closing resources     
                //dis.close();
			}catch(Exception e){
				System.out.println("NetWork/client 2");
				e.printStackTrace(); 
				break;
			} 
        }
	}
	
	public void Update(List<Shape> shapes) {
		switch (this.mode) {
		case "server":
			System.out.println("start update to client");
			for(ClientHandler client:clients) {
				client.Update(shapes);
			}
			break ;
		case "client":
			System.out.println("start update to server");
			UpdateToServer(shapes);
		default:
			//not do anything
		}
	}
	private void UpdateToServer(List<Shape> shapes) {
		try {
			//dos = new DataOutputStream(socket.getOutputStream());
            //dos.writeUTF("from client");
			oOS=new ObjectOutputStream(socket.getOutputStream());
			ListShapes listShapes=new ListShapes();
			listShapes.setStr("from client");
    		listShapes.setShapes(shapes);
    		//dos.writeObject(listShapes);
            oOS.writeObject(listShapes);
    		String tosend="";
            if(tosend.equals("Exit")) 
            { 
            	System.out.println("Closing this connection : " + socket); 
            	socket.close(); 
            	System.out.println("Connection closed"); 
            	//dos.close(); 	
            }
        }catch(Exception e){
        	System.out.println("NetWork/UpdateToServer");
            e.printStackTrace(); 
        } 
	}
}
