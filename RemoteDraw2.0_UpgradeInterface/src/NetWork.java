import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class NetWork extends Thread{
	private int port=4322;
	private String ip=""; 
	private ServerSocket serverSocket;
	private Socket socket;
	
	private String mode="not";

	public NetWork() {
	}
	
	public String getMode() {
		return mode;
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
					System.out.println("Ok vo roi");

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
		while(1==1) {
			socket=null;
			try {
				socket=serverSocket.accept();
				i++;
				System.out.println("client "+i+" is connected : "); 
                 
	            // obtaining input and out streams 
	            DataInputStream dis = new DataInputStream(socket.getInputStream()); 
	            DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
	                  
	            System.out.println("Assigning new thread for this client"); 
	  
	            // create a new thread object 
	            Thread t = new ClientHandler(socket, dis, dos,i); 
	  
	            // Invoking the start() method 
	            t.start(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void client() {
			try {
				DataInputStream in = new DataInputStream(System.in); 
				DataInputStream dis = new DataInputStream(socket.getInputStream()); 
	            DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
	      
	            // the following loop performs the exchange of 
	            // information between client and client handler 
	            while (true)  
	            { 
	                System.out.println(dis.readUTF()); 
	                String tosend = in.readLine(); 
	                dos.writeUTF(tosend); 
	                  
	                // If client sends exit,close this connection  
	                // and then break from the while loop 
	                if(tosend.equals("Exit")) 
	                { 
	                    System.out.println("Closing this connection : " + socket); 
	                    socket.close(); 
	                    System.out.println("Connection closed"); 
	                    break; 
	                }
	            } 
	              
	            // closing resources 
	            in.close(); 
	            dis.close(); 
	            dos.close(); 			 
	        }catch(Exception e){ 
	            e.printStackTrace(); 
	        } 
	}
}
