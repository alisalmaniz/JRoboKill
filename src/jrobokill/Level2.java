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
import static jrobokill.Level1.Health;
import static jrobokill.Level1.RoboPanel2;
import static jrobokill.Level1.SeparJ;
import static jrobokill.Level1.T1l;
import static jrobokill.Level1.T1r;
import static jrobokill.Level1.T2l;
import static jrobokill.Level1.T2r;
import static jrobokill.Level1.Xrobot;
import static jrobokill.Level1.Yrobot;
import static jrobokill.Level1.healthBar1;
import static jrobokill.Level1.healthBar2;
import static jrobokill.Level1.healthBar3;
import static jrobokill.Level1.healthBar4;
import static jrobokill.Level1.healthBar5;
import static jrobokill.Level1.separ1;
import static jrobokill.Level1.separ2;
import static jrobokill.Level1.separ3;
import static jrobokill.Level1.separ4;
import static jrobokill.Level1.separ5;
import static jrobokill.Level1.tirCunter;
import static jrobokill.Level1.tirCunterT;
import static jrobokill.Level1.tirVector;
import static jrobokill.Level6.KeySmall;
import static jrobokill.Level6.keyTrue;

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
    private BufferedImage bang;
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
    public static BufferedImage EnemyTir1r;
    public static BufferedImage EnemyTir1l;
    public static BufferedImage enemyDeth;
    public static Level3 RoboPanel3;
    public static TanzimRobat tanzimRob2;
    public static Map map2;
    private int bangBox1 = 0;
    private int bangBox2 = 0;
    private int bangBoxCounter1 = 0;
    private int bangBoxCounter2 = 0;
    private int xBox1 = 210;
    private int yBox1 = 200;

    private boolean Robo2IsAlive;

    
    public static Vector<EnemyThread> enemyVector =  new Vector<EnemyThread>();;
    public static int enemyNumber=0;
    public static int enemyCunter=0;

    int enemydethflag;

    private int moveRobots;


    public Level2() {
        setLayout(null);
        SeparJ = 20;
        moveRobots = 0;
        Level1.nowMoving = 0;

        enemydethflag = 0;


        Level1.Xrobot = 400;
        Level1.Yrobot = 500;

        moveRobots=0;
        Level1.nowMoving=0;
        
        enemydethflag=0;


        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);


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

        //bang box
        URL resourceBang = getClass().getResource("/pic/bang.png");
        try {
            bang = ImageIO.read(resourceBang);
        } catch (IOException e) {
            System.out.println("invalid adress bang");
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

        URL resourceEnemyTir1r = getClass().getResource("/pic/EnemyTir1r.png");
        try {
            EnemyTir1r = ImageIO.read(resourceEnemyTir1r);
        } catch (IOException e) {
            System.out.println("invalid adress EnemyTir1r");
        }

        URL resourceEnemyTir1l = getClass().getResource("/pic/EnemyTir1l.png");
        try {
            EnemyTir1l = ImageIO.read(resourceEnemyTir1l);
        } catch (IOException e) {
            System.out.println("invalid adress EnemyTir1l");
        }

        URL resourceEnemyDeth = getClass().getResource("/pic/enemyDeth.png");
        try {
            enemyDeth = ImageIO.read(resourceEnemyDeth);
        } catch (IOException e) {
            System.out.println("invalid adress enemyDeth");
        }

        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 250.0, 00.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 500.0, 00.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 400.0, 00.0));

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

        if (moveRobots == 15) {
            moveRobots = 0;
        }

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
        g.drawImage(zamin2, 0, 0, this);
        if (keyTrue) {
            g.drawImage(KeySmall, 730, 30, this);
        }
        g.drawImage(pol, 200, 0, this);
        for (int i = 0; i < 2; i++) {
            g.drawImage(box, xBox1, yBox1 + 38 * i, this);
        }
        //tekidan box
        if (bangBox1 == 1 && bangBoxCounter1 >= 4) {
            g.drawImage(bang, 200, 190, this);
        }
        if (bangBox2 == 2 && bangBoxCounter2 >= 4) {
            g.drawImage(bang, 200, 234, this);
        }


        for (enemyCunter = 0; enemyCunter < enemyVector.size(); enemyCunter++) {

            if (enemyVector.get(enemyCunter).getEnemySmash()) {
                g.drawImage(enemyDeth, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                enemyVector.remove(enemyCunter);
                enemydethflag++;

            }
        }
        if (Health > 0) {
            g.drawImage(Level1.robots[moveRobots], Level1.Xrobot, Level1.Yrobot, this);

            if (Level1.nowMoving > 0) {


                moveRobots++;
                Level1.nowMoving--;
            }

        } else {

        }
        //separ
        if (Level4.separTrue) {
            if (SeparJ>= 80) {
                g.drawImage(separ1, 0, 555, this);
            } else if (SeparJ >= 60) {
                g.drawImage(separ2, 0, 555, this);
            } else if (SeparJ >= 40) {
                g.drawImage(separ3, 0, 555, this);
            } else if (SeparJ >= 20) {
                g.drawImage(separ4, 0, 555, this);
            } else if (SeparJ >= 0) {
                g.drawImage(separ5, 0, 555, this);
            }
        }

       //health
   
        if (Health > 80) {
            g.drawImage(healthBar1, 0, 555, this);
        } else if (Health > 60) {
              g.drawImage(healthBar2, 0, 555, this);
        }
        else if (Health > 40) {
             g.drawImage(healthBar3, 0, 555, this);
        }
        else if (Health > 0) {
              g.drawImage(healthBar4, 0, 555, this);
        }
        else {
             g.drawImage(healthBar5, 0, 555, this);
        }

        //tir
        for (tirCunter = 0; tirCunter < tirVector.size(); tirCunter++) {
            if (Level1.tirVector.get(tirCunter).getruns()) {
                g2d.rotate(atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
                if (tirVector.get(tirCunter).getxMouse() > tirVector.get(tirCunter).getxFirstRobot()) {
                    if (!Level3.gunTrue) {
                        g.drawImage(T1r, (int) tirVector.get(tirCunter).getxTir(), (int) tirVector.get(tirCunter).getyTir(), this);
                    } else {
                        g.drawImage(T2r, (int) tirVector.get(tirCunter).getxTir(), (int) tirVector.get(tirCunter).getyTir(), this);
                    }

                } else {
                    if (!Level3.gunTrue) {
                        g.drawImage(T1l, (int) tirVector.get(tirCunter).getxTir(), (int) tirVector.get(tirCunter).getyTir(), this);
                    } else {
                        g.drawImage(T2l, (int) tirVector.get(tirCunter).getxTir(), (int) tirVector.get(tirCunter).getyTir(), this);

                    }
                }
                g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
            }
        }

        //enemy
        for (enemyCunter = 0; enemyCunter < enemyVector.size(); enemyCunter++) {

            if (!enemyVector.get(enemyCunter).getEnemySmash()) {

                g2d.rotate(atan((enemyVector.get(enemyCunter).getyEnemy() - Level1.Yrobot) / (enemyVector.get(enemyCunter).getxEnemy() - Level1.Xrobot)), enemyVector.get(enemyCunter).getxEnemy(), enemyVector.get(enemyCunter).getyEnemy());
                System.out.println(enemyVector.get(enemyCunter).getyEnemy() + "/" + enemyVector.get(enemyCunter).getxEnemy());

                if (enemyVector.get(enemyCunter).getEnemyNumber() == 1) {

                    if (enemyVector.get(enemyCunter).getxEnemy() > Level1.Xrobot) {
                        g.drawImage(enemy1r, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    } else {
                        g.drawImage(enemy1l, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    }

                } else if (enemyVector.get(enemyCunter).getEnemyNumber() == 2) {

                } else if (enemyVector.get(enemyCunter).getEnemyNumber() == 3) {

                } else if (enemyVector.get(enemyCunter).getEnemyNumber() == 4) {

                }

                g2d.rotate(-atan((enemyVector.get(enemyCunter).getyEnemy() - Level1.Yrobot) / (enemyVector.get(enemyCunter).getxEnemy() - Level1.Xrobot)), enemyVector.get(enemyCunter).getxEnemy(), enemyVector.get(enemyCunter).getyEnemy());
                //System.out.println(enemyVector.get(enemyCunter).getxEnemy()+"/"+enemyVector.get(enemyCunter).getyEnemy());

            } else {
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

            if (JRoboKill.counter == 2) {

                if (moveKey == KeyEvent.VK_F1) {

                    Health = 100;
                }

                if (moveKey == KeyEvent.VK_Q && JRoboKill.counter == 2) {
                    tanzimRob2 = new TanzimRobat();

                    JRoboKill.board.remove(Level1.RoboPanel2);
                    JRoboKill.board.add(Level2.tanzimRob2, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_W && JRoboKill.counter == 2) {
                    JRoboKill.board.remove(Level2.tanzimRob2);
                    JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_M && JRoboKill.counter == 2) {
                    map2 = new Map();

                }
           

                if (moveKey == KeyEvent.VK_N && JRoboKill.counter == 2) {

                    //kelid baraye map robat
                    JRoboKill.board.remove(Level2.map2);
                    JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();

                }

                if (moveKey == KeyEvent.VK_UP) {

                    Level1.nowMoving += 2;

                    if (Level1.Yrobot >= 0) {
                        if ((Level1.Xrobot >= xBox1 + 40 && (Level1.Yrobot > 280 || Level1.Yrobot < 180)) || (Level1.Xrobot >= xBox1 + 40 && (Level1.Yrobot <= 280 && Level1.Yrobot >= 180)) ||/*(Xrobot2<=300 && (Yrobot2<280 && Yrobot2>200))||*/ (Level1.Xrobot <= xBox1 + 40 && (Level1.Yrobot >= 280 || Level1.Yrobot <= 180))) {

                            Level1.Yrobot -= 5;

                            //age az door rad shod
                            if ((Level1.Xrobot > 200 && Level1.Xrobot < 600) && (Level1.Yrobot < 40) && JRoboKill.counter == 2 && enemyVector.size() == 0) {

                                if (enemyVector.size() == 0) {
                                    JRoboKill.counter = 3;
                                    RoboPanel3 = new Level3();
                                    JRoboKill.board.remove(Level1.RoboPanel2);
                                    JRoboKill.board.add(RoboPanel3, BorderLayout.CENTER);
                                    JRoboKill.board.revalidate();
                                    tirVector.removeAllElements();
                                }
                            }
                        }
                    }

                }

                if (moveKey == KeyEvent.VK_LEFT) {
                    Level1.nowMoving += 2;
                    if ((Level1.Xrobot >= xBox1 + 40 && (Level1.Yrobot > 280 || Level1.Yrobot < 180)) || (Level1.Xrobot >= xBox1 + 40 && (Level1.Yrobot < 280 && Level1.Yrobot > 180)) ||/*(Xrobot2<=300 && (Yrobot2<280 && Yrobot2>200))||*/ (Level1.Xrobot <= xBox1 + 40 && (Level1.Yrobot > 280 || Level1.Yrobot < 180))) {
                        //if( !(Xrobot2<xBox1 && (Yrobot2<280 || Yrobot2>200))){
                        Level1.Xrobot = Level1.Xrobot - 5;

                        //agar az roye pol oonvartar raft biyofte payin
                        if (Level1.Xrobot < 180 && JRoboKill.counter == 2) {
                            //g.drawImage(Fall, Xrobot, Yrobot, this);
                            Robo2IsAlive = false;
                            try {
                                Thread.sleep(80);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(null, "You fall in a hole ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                    }
                }
                if (moveKey == KeyEvent.VK_RIGHT) {
                    Level1.nowMoving += 2;
                    Level1.Xrobot = Level1.Xrobot + 5;
                    //agar az roye pol oonvartar raft biyofte payin
                    if (Level1.Xrobot > 550 && JRoboKill.counter == 2) {
                        //g.drawImage(Fall, Xrobot, Yrobot, this);
                        Robo2IsAlive = false;
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
                    Level1.nowMoving += 2;
                    if ((Level1.Xrobot >= xBox1 + 40 && (Level1.Yrobot > 280 || Level1.Yrobot < 180)) || (Level1.Xrobot >= xBox1 + 40 && (Level1.Yrobot <= 280 && Level1.Yrobot >= 180)) ||/*(Xrobot2<=300 && (Yrobot2<280 && Yrobot2>200))||*/ (Level1.Xrobot <= xBox1 + 40 && (Level1.Yrobot >= 280 || Level1.Yrobot <= 180))) {
                        Level1.Yrobot += 5;
                        //bara bargashtan
                        if ((Level1.Xrobot > 200 && Level1.Xrobot < 600 && JRoboKill.counter == 2) && (Level1.Yrobot > 540)) {
                            if (enemyVector.size() == 0) {

                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 100;
                                JRoboKill.board.remove(Level1.RoboPanel2);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                                tirVector.removeAllElements();
                            }
                        }
                    }

                }
            }
            //return false;
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
