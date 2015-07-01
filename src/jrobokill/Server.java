/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ali salmani
 */
public class Server {

    /**
     * @ali
     */
        InputStream input;
	OutputStream output;
	ServerSocket serverSocket;
	Vector<Workstation> v;

	public Server() {
		v = new Vector<Workstation>();
		try {
			serverSocket = new ServerSocket(5002);// port number, MaxClients
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void perform() {
            
                        while(true){                
			try {
				Socket client = serverSocket.accept();
				Workstation w = new Workstation(client, this);
				v.addElement(w);

				w.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

        public synchronized void send(String msg, Workstation source ) {
            
            Workstation so = source;
            
            for (Workstation w : v) {
                
                    if(w!=so){
			try {
				w.output.write(msg.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                    }
            }
            
        }
        
        
        
        
        
	public synchronized void sendToAll(String msg) {
		for (Workstation w : v) {
			try {
				w.output.write(msg.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
    
}
