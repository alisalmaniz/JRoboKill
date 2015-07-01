/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author Ali salmani
 */
public class Client extends JFrame implements Runnable , KeyListener , MouseListener{

    /**
     * @ali 
     */
    
        private JButton send;
        private JTextField message;
	private JTextArea log;
	private JScrollPane logScroll;
	private InputStream input;
	private OutputStream output;
	private Socket socket;

	public Client() {
            
                String name = JOptionPane.showInputDialog(null);
		setName(name);
		setSize(500, 500);
		setLocation(300, 200);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                send = new JButton("Send");
		message = new JTextField();
		log = new JTextArea();
		logScroll = new JScrollPane(log);
                
                send.addMouseListener(this);
		message.addKeyListener(this);
                
                send.setSize(70, 30);
                send.setLocation(410, 420);
                
		message.setSize(290, 30);
		message.setLocation(110, 420);
                
		logScroll.setSize(370, 400);
		logScroll.setLocation(110, 10);
                add(send);
		add(logScroll);
		add(message);
                
                
		setVisible(true);
		try {
			System.out.println(InetAddress.getLocalHost());
			socket = new Socket(InetAddress.getByName("alisalmani"),5002);
			input = socket.getInputStream();
			output = socket.getOutputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

        	@Override
	public void run() {
		int i = 0;
		while (i != -1){
                    
                    
                    //writes
                    String t="";
                    for(int h=0;h<Level1.tirVector.size();h++){
                        t=Level1.tirVector.get(h).getxMouse()+","+Level1.tirVector.get(h).getyMouse()+"-"+t;
                    }
                    
                        String s = Level1.Xrobot +","+ Level1.Yrobot +","+ Level1.nowMoving+","+t;
//			log.append(getName() + " : " + s + "\n");
			try {
				output.write((getName() + ":" + s ).getBytes());
//                                output.write(s.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                        
			byte [] b = new byte[200];
			
                        
                   //reads     
                        try {
				i = input.read(b);
				if (i != -1){
                                    
                                    
                                    //System.out.println(getName()+"/"+(new String(b)).trim());
                                    
                                    log.append((new String(b)).trim() + "\n");
                                    
                                    String d[]=((new String(b)).trim()).split(":");
                                    String e[] = d[1].split(",", 4);

                                        Level1.XrobotSh = Integer.parseInt(e[0]);
                                        Level1.YrobotSh = Integer.parseInt(e[1]);
                                        Level1.nowMovingSh = Integer.parseInt(e[2]);
                                        
                                        String f[]= e[3].split("-");
                                        for(int g=0;g<f.length;g++){
                                            String j[]=f[g].split(",");
                                            
                                            Level1.tirVector.add(new TirThread(Level1.XrobotSh, Level1.YrobotSh, Double.parseDouble(j[0]), Double.parseDouble(j[1]), Level1.tirCunterT));
                                            
                                            
                                        }
                                        
                                        
                                        log.append((new String(b)).trim() + "\n");
                                    
                                    
                                        
                                    
                                        
					
                                        
                                        
                                }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
                      
		}
                
                
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			String s = message.getText();
			try {
				output.write((getName() + " : " + s + "\n").getBytes());
			} catch (IOException er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
			}
			message.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	




    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == send){
            String s = message.getText();
			try {
				output.write((getName() + " : " + s + "\n").getBytes());
			} catch (IOException er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
			}
			message.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
