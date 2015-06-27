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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Level1 extends JPanel implements Runnable {
    

    static int Xrobot = 400;
    public static int Yrobot = 500;
    public static int x = 0;
    public static int y = 0;
    private Image dbImage;
    private Graphics dbg;
    private BufferedImage zamin;
    private BufferedImage robot;
    private BufferedImage Jet;
    private BufferedImage exit;
    private BufferedImage shop;
    private BufferedImage makanAval;
    private BufferedImage ChaleFaza;
    private BufferedImage Fall;
    private static int pause = 0;
    public static Level2 RoboPanel2;
   
    private boolean Robo1IsAlive;
    
    //thread
    public static int tirCunter=0;
    public static int tirCunterT=0;
    public static Vector<TirThread> tirVector;
    public static BufferedImage T1r;
    public static BufferedImage T1l;

    public Level1() {
        setLayout(null);

        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);
        
        Robo1IsAlive = true;
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin.png");
        try {
            zamin = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }
        //soghot
        URL resourceFall = getClass().getResource("/pic/fall.png");
        try {
            Fall = ImageIO.read(resourceFall);
        } catch (IOException e) {
            System.out.println("invalid adress Fall");
        }
        //chaleh
        URL resourceChale = getClass().getResource("/pic/faza.png");
        try {
            ChaleFaza = ImageIO.read(resourceChale);
        } catch (IOException e) {
            System.out.println("invalid adress faza");
        }
        //shop
        URL resourceShop = getClass().getResource("/pic/shop.png");
        try {
            shop = ImageIO.read(resourceShop);
        } catch (IOException e) {
            System.out.println("invalid adress shop");
        }
        //place aval
        URL resourcePlace = getClass().getResource("/pic/place.png");
        try {
            makanAval = ImageIO.read(resourcePlace);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }
        //exit
        URL resourceExit = getClass().getResource("/pic/exit.png");
        try {
            exit = ImageIO.read(resourceExit);
        } catch (IOException e) {
            System.out.println("invalid adress exit");
        }
        //chaleh
        URL resourceJet = getClass().getResource("/pic/12.png");
        try {
            Jet = ImageIO.read(resourceJet);
        } catch (IOException e) {
            System.out.println("invalid adress pic chaleh");
        }
        //tamoom
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }

        //Tir1 right
        URL resourceT1r = getClass().getResource("/pic/T1r.png");
        try {
            T1r = ImageIO.read(resourceT1r);
        } catch (IOException e) {
            System.out.println("invalid adress exit");
        }
        //Tir1 left
        URL resourceT1l = getClass().getResource("/pic/T1l.png");
        try {
            T1l = ImageIO.read(resourceT1l);
        } catch (IOException e) {
            System.out.println("invalid adress exit");
        }

        
        tirVector = new Vector<TirThread>();
        
        
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

        g.drawImage(zamin, 0, 0, this);
        g.drawImage(shop, 600, 200, this);
        //rasm chale 
        g.drawImage(makanAval, 400, 500, this);
        for (int i = 20; i <= 530; i += 70) {
            for (int j = 20; j <= 280;) {
                g.drawImage(ChaleFaza, j, i, this);
                j = j + 70;
            }
        }

        g.drawImage(exit, 350, 50, this);

        g.drawImage(Jet, 20, 90, this);

        if (Robo1IsAlive) {
            g.drawImage(robot, Xrobot, Yrobot, this);
        } else {
            g.drawImage(Fall, Xrobot, Yrobot, this);
        }

        
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
            
            if(JRoboKill.counter == 1){
            
            if (moveKey == KeyEvent.VK_ESCAPE) {

                System.exit(0);
            }
            //button O & P for pause and continue
            if (moveKey == KeyEvent.VK_P) {
                pause = 1;
                JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if (moveKey == KeyEvent.VK_O) {
                pause = 0;
                JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
            }

            if (moveKey == KeyEvent.VK_M) {

                Map map = new Map();

            }

            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot >= 0 && pause == 0) {
                    Yrobot = Yrobot - 5;
                    //agar az x,y door gozasht bere marhale 2
                    if ((Xrobot > 200 && Xrobot < 600 && JRoboKill.counter == 1) && (Yrobot < 40)) {
                        
                        JRoboKill.counter = 2;
                        RoboPanel2 = new Level2();
                        //JRoboKill.board.panelChanger();
                        JRoboKill.board.remove(StartMenu.RoboPanel);
                        JRoboKill.board.add(RoboPanel2, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();
                    }
                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot >= 0 && pause == 0) {
                    Xrobot = Xrobot - 5;
                }
                //soghot robat dar chale
                if (Xrobot < 300 ) {
                                Robo1IsAlive=false;
                    try {
                        Thread.sleep(80);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "You fall in a hole ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot <= 740 && pause == 0) {
                    Xrobot = Xrobot + 5;
                }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot <= 560 && pause == 0) {
                    Yrobot = Yrobot + 5;
                }
            }
            
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }
        
        

    }

    private class TirHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tirVector.add( new TirThread(Xrobot,Yrobot, e.getX(),e.getY(),tirCunterT));
            //tirCunterT++;
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
