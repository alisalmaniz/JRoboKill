/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.applet.Applet;
import java.applet.AudioClip;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static jrobokill.Level1.Health;
import static jrobokill.Level1.T1l;
import static jrobokill.Level1.T1r;
import static jrobokill.Level1.healthBar1;
import static jrobokill.Level1.healthBar2;
import static jrobokill.Level1.healthBar3;
import static jrobokill.Level1.healthBar4;
import static jrobokill.Level1.healthBar5;
import static jrobokill.Level1.Xrobot;
import static jrobokill.Level1.Yrobot;
import static jrobokill.Level1.robots;
import static jrobokill.Level1.tirCunter;
import static jrobokill.Level1.tirCunterT;
import static jrobokill.Level1.tirVector;
import static jrobokill.Level2.RoboPanel3;
import static jrobokill.Level2.enemy1l;
import static jrobokill.Level2.enemy1r;
import static jrobokill.Level2.enemyCunter;
import static jrobokill.Level2.enemyDeth;
import static jrobokill.Level2.enemyVector;

/**
 *
 * @author Asus
 */
public class Level3 extends JPanel implements Runnable {

    private BufferedImage zamin3;
    private BufferedImage gun;
    private BufferedImage robot3;
    private Image dbImage;
    private Graphics dbg;

    private BufferedImage ChaleFaza;
    private BufferedImage Fall;

    public int pause3 = 0;

    public static Level4 RoboPanel4;
    private boolean Robo3IsAlive;
    public static Level2 RoboPanel3Back2;
    public static Map map3;
    private int getPool = 0;

    //terkidan
    private BufferedImage pool;
    private BufferedImage bang;
    private BufferedImage box;
    private int bangBox1 = 0;
    private int bangBox2 = 0;
    private int bangBoxCounter1 = 0;
    private int bangBoxCounter2 = 0;
    private int xBox1 = 100;
    private int yBox1 = 100;
    private int xBox2 = 600;
    private int yBox2 = 100;
    private int xPool = 200;
    private int yPool = 200;
    public static TanzimRobat tanzimRob3;
    int enemydethflag;
    
    private int moveRobots;

    public Level3() {

        moveRobots=0;
        Level1.nowMoving=0;
        setLayout(null);

        enemydethflag = 0;

        Level1.Xrobot = 400;
        Level1.Yrobot=500;

        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo3IsAlive = true;

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin3.png");
        try {
            zamin3 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //box
        URL resourceBox = getClass().getResource("/pic/box2.png");
        try {
            box = ImageIO.read(resourceBox);
        } catch (IOException e) {
            System.out.println("invalid adress box");
        }
        //poool
        URL resourcepool = getClass().getResource("/pic/pool.png");
        try {
            pool = ImageIO.read(resourcepool);
        } catch (IOException e) {
            System.out.println("invalid adress box");
        }
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot3 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }
        //gun
        URL resourceGun = getClass().getResource("/pic/gun.png");
        try {
            gun = ImageIO.read(resourceGun);
        } catch (IOException e) {
            System.out.println("invalid adress gun");
        }
        //bang box
        URL resourceBang = getClass().getResource("/pic/bang.png");
        try {
            bang = ImageIO.read(resourceBang);
        } catch (IOException e) {
            System.out.println("invalid adress bang");
        }

        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());

        
        
        
        
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 100.0 ,200.0));
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 600.0 ,200.0));
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 400.0 ,300.0));
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 100.0 ,500.0));
        enemyCunter++;
        enemyVector.add( new EnemyThread(enemyCunter , 1 , 600.0 ,500.0));
        
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
        
        if(moveRobots==15)
            moveRobots=0;
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        if(enemydethflag!=0){
            try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Level2.class.getName()).log(Level.SEVERE, null, ex);
                }
            enemydethflag=0;
        }
        */
        
        g.drawImage(zamin3, 0, 0, this);

        g.drawImage(box, xBox2, yBox2, this);
        g.drawImage(box, xBox1, yBox1, this);
        g.drawImage(box, xBox2, yBox2, this);
        //age rooye pool narafte bood 
        if (getPool == 0) {
            g.drawImage(pool, xPool, yPool, this);
        }

        if (bangBox1 == 1 && bangBoxCounter1 >= 3) {
            g.drawImage(bang, xBox1 - 10, yBox1 - 10, this);
            g.drawImage(pool, xBox1 + 10, yBox1 + 13, this);

        }
        if (bangBox2 == 2 && bangBoxCounter2 >= 3) {
            g.drawImage(bang, xBox2 - 10, yBox2 - 10, this);
            g.drawImage(gun, xBox2+5, yBox2, this);
        }
        
        g.drawImage(robot3, Level1.Xrobot, Level1.Yrobot, this);
        
        if (Health == 100) {
            g.drawImage(healthBar1, 0, 555, this);
        } else if (Health == 80) {
              g.drawImage(healthBar2, 0, 555, this);
        }
        else if (Health == 60) {
             g.drawImage(healthBar3, 0, 555, this);
        }
        else if (Health == 40) {
              g.drawImage(healthBar4, 0, 555, this);
        }
        else if (Health == 20) {
             g.drawImage(healthBar5, 0, 555, this);
        }

        g.drawImage(gun, 350, 100, this);
        
        
        for(enemyCunter=0;enemyCunter<enemyVector.size(); enemyCunter++){
            
            if(enemyVector.get(enemyCunter).getEnemySmash()){
                g.drawImage(enemyDeth,(int) enemyVector.get(enemyCunter).getxEnemy(),(int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    enemyVector.remove(enemyCunter);
                   enemydethflag++; 
                   
                
            }
        }
        
        
        
        
        if (Health>0) {
            g.drawImage(Level1.robots[moveRobots], Level1.Xrobot, Level1.Yrobot, this);
            
            if(Level1.nowMoving>0){
                
                moveRobots++;
                Level1.nowMoving--;
            }
            
        } else {

        }
        
        
        for (tirCunter = 0; tirCunter < tirVector.size(); tirCunter++) {
            //System.out.println(tirVector.size());
        if(Level1.tirVector.get(tirCunter).getruns()){
            g2d.rotate(atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
                System.out.println(tirVector.size()+"/"+tirVector.get(tirCunter).getxMouse()+"/"+tirVector.get(tirCunter).getxTir());
             
            if(tirVector.get(tirCunter).getxMouse()>tirVector.get(tirCunter).getxFirstRobot())
                g.drawImage(T1r,(int)tirVector.get(tirCunter).getxTir(),(int)tirVector.get(tirCunter).getyTir(),this);
            else
                g.drawImage(T1l,(int)tirVector.get(tirCunter).getxTir(),(int)tirVector.get(tirCunter).getyTir(),this);
                    
            g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());

        }
        }
        
        //enemy
        for( enemyCunter=0;enemyCunter<enemyVector.size(); enemyCunter++){
                    
            if(!enemyVector.get(enemyCunter).getEnemySmash()){
                    
            g2d.rotate(atan((enemyVector.get(enemyCunter).getyEnemy()-Level1.Yrobot)/(enemyVector.get(enemyCunter).getxEnemy()-Level1.Xrobot)),enemyVector.get(enemyCunter).getxEnemy(),enemyVector.get(enemyCunter).getyEnemy());
            System.out.println(enemyVector.get(enemyCunter).getyEnemy()+"/"+enemyVector.get(enemyCunter).getxEnemy());
            
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
            //System.out.println(enemyVector.get(enemyCunter).getxEnemy()+"/"+enemyVector.get(enemyCunter).getyEnemy());
        
        }
            else{
                enemydethflag++;
            }
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


            if (JRoboKill.counter == 3) {
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
                if (moveKey == KeyEvent.VK_Q && JRoboKill.counter == 3) {
                    tanzimRob3 = new TanzimRobat();

                    JRoboKill.board.remove(Level2.RoboPanel3);
                    JRoboKill.board.add(Level3.tanzimRob3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_W && JRoboKill.counter == 3) {
                    JRoboKill.board.remove(Level3.tanzimRob3);
                    JRoboKill.board.add(Level2.RoboPanel3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_M && JRoboKill.counter == 3) {
                    map3 = new Map();

                    JRoboKill.board.remove(Level2.RoboPanel3);
                    JRoboKill.board.add(map3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }

                if (moveKey == KeyEvent.VK_N && JRoboKill.counter == 3) {

                    //kelid baraye map robat
                    JRoboKill.board.remove(Level3.map3);
                    JRoboKill.board.add(Level2.RoboPanel3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();

                }

            if (moveKey == KeyEvent.VK_UP) {
                Level1.nowMoving+=2;
                if (Level1.Yrobot >= 0 && pause3 == 0) {
                    Level1.Yrobot = Level1.Yrobot - 5;
                    if (Level1.Xrobot <= xPool + 15 && Level1.Xrobot >= xPool - 15 && Level1.Yrobot <= yPool + 15 && Level1.Yrobot >= yPool - 15) {
                        if (getPool != 1) {
                            getPool = 1;
                            Level1.RoboPool += 500;
                        }

                    }
                    if ((Level1.Xrobot > 200 && Level1.Xrobot < 600) && (Level1.Yrobot < 40) && JRoboKill.counter == 3) {
                        //raftan be level4
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
                Level1.nowMoving+=2;
                if (Level1.Xrobot >= 0 && pause3 == 0) {
                    Level1.Xrobot = Level1.Xrobot - 5;
                    if (Level1.Xrobot <= xPool + 20 && Level1.Xrobot >= xPool - 20 && Level1.Yrobot <= yPool + 20 && Level1.Yrobot >= yPool - 20) {
                        getPool = 1;
                        Level1.RoboPool += 500;

                    }
                }
            }
            if (moveKey == KeyEvent.VK_RIGHT) {
                Level1.nowMoving+=2;
                if (Level1.Xrobot <= 740 && pause3 == 0) {
                    Level1.Xrobot = Level1.Xrobot + 5;
                }
                if (Level1.Xrobot <= xPool + 15 && Level1.Xrobot >= xPool - 15 && Level1.Yrobot <= yPool + 15 && Level1.Yrobot >= yPool - 15) {
                    getPool = 1;
                    Level1.RoboPool += 500;
                }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                Level1.nowMoving+=2;
                if (Level1.Yrobot <= 560 && pause3 == 0) {
                    Level1.Yrobot = Level1.Yrobot + 5;
                    if (Level1.Xrobot <= xPool + 15 && Level1.Xrobot >= xPool - 15 && Level1.Yrobot <= yPool + 15 && Level1.Yrobot >= yPool - 15) {
                        getPool = 1;
                        Level1.RoboPool += 500;
                    }
                }
                


                    if ((Level1.Xrobot > 200 && Level1.Xrobot < 600 && JRoboKill.counter == 3) && (Level1.Yrobot > 540)) {
                        //bargashtan be level 3
                        JRoboKill.counter = 2;
                        Level1.Xrobot = 400;
                        Level1.Yrobot = 30;
                        JRoboKill.board.remove(Level2.RoboPanel3);
                        JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();
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

            //sedaye shlik
            if (Option.OnSound) {
                URL url = getClass().getClassLoader().getResource("seda/Tir.wav");
                AudioClip clip2 = Applet.newAudioClip(url);
                clip2.loop();
            }

            tirVector.add(new TirThread(Level1.Xrobot, Level1.Yrobot, e.getX(), e.getY(), tirCunterT));

            if (e.getX() >= xBox1 - 30 && e.getX() <= xBox1 + 30 && e.getY() >= yBox1 - 30 && e.getY() <= yBox1 + 30) {
                bangBox1 = 1;
                bangBoxCounter1++;
                //JOptionPane.showMessageDialog(null, "khord ", "Game Over", JOptionPane.INFORMATION_MESSAGE);

            }
            if (e.getX() >= xBox2 - 30 && e.getX() <= xBox2 + 30 && e.getY() >= yBox2 - 30 && e.getY() <= yBox2 + 30) {
                bangBox2 = 2;
                bangBoxCounter2++;
                // JOptionPane.showMessageDialog(null, "khord ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
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
}
