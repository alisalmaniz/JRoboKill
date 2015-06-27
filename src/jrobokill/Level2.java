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
import java.awt.event.MouseAdapter;
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
import static jrobokill.Level1.RoboPanel2;
import static jrobokill.Level1.T1l;
import static jrobokill.Level1.T1r;
import static jrobokill.Level1.Xrobot;
import static jrobokill.Level1.Yrobot;
import static jrobokill.Level1.tirCunter;
import static jrobokill.Level1.tirCunterT;
import static jrobokill.Level1.tirVector;

/**
 *
 * @author Asus
 */
public class Level2 extends JPanel implements Runnable {



   
    private Image dbImage;
    private Graphics dbg;
    private BufferedImage pol;
    private BufferedImage zamin2;
    private BufferedImage robot2;
    private BufferedImage Tir;
    private BufferedImage box;
    public static BufferedImage enemy1r;
    public static BufferedImage enemy2r;
    public static BufferedImage enemy3r;
    public static BufferedImage enemy4r;
    public static BufferedImage enemy1l;
    public static BufferedImage enemy2l;
    public static BufferedImage enemy3l;
    public static BufferedImage enemy4l;
    public static Level3 RoboPanel3;
    
    private boolean Robo2IsAlive;
    
    public static Vector<EnemyThread> enemyVector;
    public static int enemyNumber=0;
    public static int enemyCunter=0;

    public Level2() {
        setLayout(null);
        
        Level1.Xrobot=400;
        Level1.Yrobot=500;
        
        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);
        
        enemyVector = new Vector<EnemyThread>();
        
        Robo2IsAlive = true;
        //zamin
        URL resourceZamin = getClass().getResource("/pic/back2.png");
        try {
            zamin2 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }
        //box
        URL resourceBox = getClass().getResource("/pic/box2.png");
        try {
            box = ImageIO.read(resourceBox);
        } catch (IOException e) {
            System.out.println("invalid adress box");
        }
        //pol
        URL resourcePol = getClass().getResource("/pic/22.png");
        try {
            pol = ImageIO.read(resourcePol);
        } catch (IOException e) {
            System.out.println("invalid adress pol");
        }
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot2.png");
        try {
            robot2 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }
        //Tir
        URL resourceTir = getClass().getResource("/pic/Tir.png");
        try {
            Tir = ImageIO.read(resourceTir);
        } catch (IOException e) {
            System.out.println("invalid adress Tir");
        }
        //enemy
        URL resourceEnemy1r = getClass().getResource("/pic/enemy1r.png");
        try {
            enemy1r = ImageIO.read(resourceEnemy1r);
        } catch (IOException e) {
            System.out.println("invalid adress enemy1r");
        }
        
        URL resourceEnemy2r = getClass().getResource("/pic/enemy2r.png");
        try {
            enemy2r = ImageIO.read(resourceEnemy2r);
        } catch (IOException e) {
            System.out.println("invalid adress enemy2r");
        }
        
        URL resourceEnemy3r = getClass().getResource("/pic/enemy3r.png");
        try {
            enemy3r = ImageIO.read(resourceEnemy3r);
        } catch (IOException e) {
            System.out.println("invalid adress enemy3r");
        }
        
        URL resourceEnemy4r = getClass().getResource("/pic/enemy4r.png");
        try {
            enemy4r = ImageIO.read(resourceEnemy4r);
        } catch (IOException e) {
            System.out.println("invalid adress enemy4r");
        }
        URL resourceEnemy1l = getClass().getResource("/pic/enemy1l.png");
        try {
            enemy1l = ImageIO.read(resourceEnemy1l);
        } catch (IOException e) {
            System.out.println("invalid adress enemy1l");
        }
        
        URL resourceEnemy2l = getClass().getResource("/pic/enemy2l.png");
        try {
            enemy2l = ImageIO.read(resourceEnemy2l);
        } catch (IOException e) {
            System.out.println("invalid adress enemy2l");
        }
        
        URL resourceEnemy3l = getClass().getResource("/pic/enemy3l.png");
        try {
            enemy3l = ImageIO.read(resourceEnemy3l);
        } catch (IOException e) {
            System.out.println("invalid adress enemy3l");
        }
        
        URL resourceEnemy4l = getClass().getResource("/pic/enemy4l.png");
        try {
            enemy4l = ImageIO.read(resourceEnemy4l);
        } catch (IOException e) {
            System.out.println("invalid adress enemy4l");
        }
        
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 600.0 ,100.0));
        /*enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 100 ,500));
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 100 ,100));
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 600 ,500));
        
        */
        
        
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
        g.drawImage(zamin2, 0, 0, this);
        g.drawImage(pol, 200, 0, this);
        for (int i = 0; i < 4; i++) {
            g.drawImage(box, 210, 200 + 35 * i, this);
        }

        if (Robo2IsAlive) {
            g.drawImage(robot2, Level1.Xrobot, Level1.Yrobot, this);
        } else {

        }

        //tir
        for( tirCunter=0;tirCunter<tirVector.size();tirCunter++){
            //System.out.println(tirVector.size());
            g2d.rotate(atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxFirstRobot(), tirVector.get(tirCunter).getyFirstRobot());
                System.out.println(atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())));//+"+"+tirVector.get(tirCunter).getxFirstRobot()+"+"+ tirVector.get(tirCunter).getyFirstRobot());
             
            if(tirVector.get(tirCunter).getxMouse()>tirVector.get(tirCunter).getxFirstRobot())
                g.drawImage(T1r,tirVector.get(tirCunter).getxTir(),tirVector.get(tirCunter).getyTir(),this);
            else
                g.drawImage(T1l,tirVector.get(tirCunter).getxTir()-35,tirVector.get(tirCunter).getyTir()-10,this);
                    
            g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxFirstRobot(), tirVector.get(tirCunter).getyFirstRobot());
            //System.out.println("/"+atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot()))+"+"+tirVector.get(tirCunter).getxFirstRobot()+"+"+ tirVector.get(tirCunter).getyFirstRobot());
        }
        
        //enemy
        for( enemyCunter=0;enemyCunter<enemyVector.size(); enemyCunter++){
            
           
            double firstXEnemyforRotate=enemyVector.get(enemyCunter).getxEnemy();
            double firstYEnemyforRotate=enemyVector.get(enemyCunter).getyEnemy();
                    
            g2d.rotate(atan((enemyVector.get(enemyCunter).getyEnemy()-Level1.Yrobot)/(enemyVector.get(enemyCunter).getxEnemy()-Level1.Xrobot)),enemyVector.get(enemyCunter).getxEnemy(),enemyVector.get(enemyCunter).getyEnemy());
            //System.out.println(enemyVector.get(enemyCunter).getyEnemy()+"/"+enemyVector.get(enemyCunter).getxEnemy());//+"+"+enemyVector.get(enemyCunter).getxEnemy()+"+"+enemyVector.get(enemyCunter).getyEnemy());
            
            if(enemyVector.get(enemyCunter).getEnemyNumber()==1){
                
                if(enemyVector.get(enemyCunter).getxEnemy()>Level1.Xrobot){
                    g.drawImage(enemy1r,(int)enemyVector.get(enemyCunter).getxEnemy(),(int)enemyVector.get(enemyCunter).getyEnemy(),this);
                }
                else{
                    g.drawImage(enemy1l,(int)enemyVector.get(enemyCunter).getxEnemy(),(int)enemyVector.get(enemyCunter).getyEnemy(),this);
                }
                      
            }
            else if(enemyVector.get(enemyCunter).getEnemyNumber()==2){
                
            }
            else if(enemyVector.get(enemyCunter).getEnemyNumber()==3){
                
            }
            else if(enemyVector.get(enemyCunter).getEnemyNumber()==4){
                
            }
            
            
            g2d.rotate(-atan((enemyVector.get(enemyCunter).getyEnemy()-Level1.Yrobot)/(enemyVector.get(enemyCunter).getxEnemy()-Level1.Xrobot)),enemyVector.get(enemyCunter).getxEnemy(),enemyVector.get(enemyCunter).getyEnemy() );
            System.out.println(enemyVector.get(enemyCunter).getxEnemy()+"/"+enemyVector.get(enemyCunter).getyEnemy());
        
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

            if (moveKey == KeyEvent.VK_M) {
                JRoboKill.counter = 2;
            }

            if (moveKey == KeyEvent.VK_UP) {
                Level1.Yrobot = Level1.Yrobot - 5;
                //age az door rad shod
                if ((Level1.Xrobot > 200 && Level1.Xrobot < 600) && (Level1.Yrobot < 40) && JRoboKill.counter == 2) {
                    JRoboKill.counter = 3;
                    RoboPanel3 = new Level3();
                    JRoboKill.board.remove(Level1.RoboPanel2);
                    JRoboKill.board.add(RoboPanel3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                    tirVector.removeAllElements();
                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                Level1.Xrobot = Level1.Xrobot - 5;
                //agar az roye pol oonvartar raft biyofte payin
                if (Level1.Xrobot < 180 && JRoboKill.counter == 2) {
                    //g.drawImage(Fall, Xrobot, Yrobot, this);
                    Robo2IsAlive=false;
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
                Level1.Xrobot = Level1.Xrobot + 5;
                //agar az roye pol oonvartar raft biyofte payin
                if (Level1.Xrobot > 550 && JRoboKill.counter == 2) {
                    //g.drawImage(Fall, Xrobot, Yrobot, this);
                    Robo2IsAlive=false;
                    try {
                        Thread.sleep(80);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "You fall in a hole ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

            }
            if (moveKey == KeyEvent.VK_DOWN) {

                Level1.Yrobot = Level1.Yrobot + 5;
                //bara bargashtan
                if ((Level1.Xrobot > 200 && Level1.Xrobot < 600 && JRoboKill.counter == 2) && (Level1.Yrobot > 540)) {
                    JRoboKill.counter = 1;
                  
                   
                    JRoboKill.board.remove(Level1.RoboPanel2);
                    JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                    tirVector.removeAllElements();
                }

            }

            //return false;
            return false;

        }

    }

    private class TirHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tirVector.add( new TirThread(Level1.Xrobot,Level1.Yrobot, e.getX(),e.getY(),tirCunterT));
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
