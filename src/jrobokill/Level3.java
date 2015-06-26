/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.atan;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static jrobokill.Level1.T1l;
import static jrobokill.Level1.T1r;
import static jrobokill.Level1.tirCunter;
import static jrobokill.Level1.tirCunterT;
import static jrobokill.Level1.tirVector;
import static jrobokill.Level2.RoboPanel3;

/**
 *
 * @author Asus
 */
public class Level3 extends JPanel implements Runnable{

    private BufferedImage zamin3;
    private BufferedImage robot3;
    private Image dbImage;
    private Graphics dbg;

    private BufferedImage ChaleFaza;
    private BufferedImage Fall;

    public int pause3 = 0;
    private int Xrobot3 = 400;
    private int Yrobot3 = 500;
    public static Level4 RoboPanel4;
    private boolean Robo3IsAlive;
    public static Level2 RoboPanel3Back2;

    public Level3() {
        
        setLayout(null);
        
        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);
        
        Robo3IsAlive=true;
        
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin.png");
        try {
            zamin3 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot3 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }

        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());
        
        (new Thread(this)).start();
    }

    // ba dbuffeting

    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(zamin3, 0, 0, this);

        g.drawImage(robot3, Xrobot3, Yrobot3, this);
        
        
        for( tirCunter=0;tirCunter<tirVector.size();tirCunter++){
            //System.out.println(tirVector.size());
            g2d.rotate(atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxFirstRobot(), tirVector.get(tirCunter).getyFirstRobot());
                System.out.println(tirVector.size()+"/"+tirVector.get(tirCunter).getxMouse()+"/"+tirVector.get(tirCunter).getxTir());
             
            if(tirVector.get(tirCunter).getxMouse()>tirVector.get(tirCunter).getxFirstRobot())
                g.drawImage(T1r,tirVector.get(tirCunter).getxTir(),tirVector.get(tirCunter).getyTir(),this);
            else
                g.drawImage(T1l,tirVector.get(tirCunter).getxTir()-35,tirVector.get(tirCunter).getyTir()-10,this);
                    
            g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxFirstRobot(), tirVector.get(tirCunter).getyFirstRobot());
        }
        
    }

    @Override
    public void run() {
        while (true) {            
            repaint();
        }
    }

    class moving implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            int moveKey = e.getKeyCode();

            if (moveKey == KeyEvent.VK_ESCAPE) {

                System.exit(0);
            }
            //button O & P for pause and continue
            if (moveKey == KeyEvent.VK_P) {
                pause3 = 1;
                JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if (moveKey == KeyEvent.VK_O) {
                pause3 = 0;
                JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
            }

            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot3 >= 0 && pause3 == 0) {
                    Yrobot3 = Yrobot3 - 5;
                        if ((Xrobot3 > 200 && Xrobot3 < 600) && (Yrobot3 < 40) && JRoboKill.counter==3) {
                        JRoboKill.counter = 4;
                        RoboPanel4 = new Level4();
                        JRoboKill.board.remove(Level2.RoboPanel3);
                        JRoboKill.board.add(RoboPanel4, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();
                    }
                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot3 >= 0 && pause3 == 0) {
                    Xrobot3 = Xrobot3 - 5;
                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot3 <= 740 && pause3 == 0) {
                    Xrobot3 = Xrobot3 + 5;
                }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot3 <= 560 && pause3 == 0) {
                    Yrobot3 = Yrobot3 + 5;
                }
                
                if ((Xrobot3 > 200 && Xrobot3 < 600 && JRoboKill.counter == 3) && (Yrobot3 > 540)) {
                    JRoboKill.counter = 2;
                  
                    JRoboKill.board.remove(Level2.RoboPanel3);
                    JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                    tirVector.removeAllElements();
                }
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }
    
    private class TirHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            tirVector.add( new TirThread(Xrobot3,Yrobot3, e.getX(),e.getY(),tirCunterT));
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
}
