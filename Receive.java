package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	private Socket client;
	private DataInputStream dis=null;
	private boolean isRunning;
	public Receive(Socket client) {
		this.client = client;
		isRunning=true;
		 try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void receive() {
		try {
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void release() {
		isRunning=false;
		Utils.close(dis);
	}
	
	public void run() {
		while(isRunning) {
			receive();
		}
		release();
	}

}


