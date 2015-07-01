/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 *
 * @author Ali salmani
 */
public class Workstation extends Thread{
    Server server;
	Socket client;
	InputStream input;
	OutputStream output;

	public Workstation(Socket client, Server server) {
		this.client = client;
		this.server = server;
		try {
			input = client.getInputStream();
			output = client.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean flag = false;
		while (!flag) {
			byte[] b = new byte[200];
			try {
				int i = input.read(b);
				if (i == -1) {
					flag = true;
					continue;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((new String(b)).trim().endsWith("bye"))
				flag = true;
			else
//				System.out.println((new String(b)).trim());
                                server.send((new String(b)).trim(),this);
//				server.sendToAll((new String(b)).trim());

		}
	}
}

    
