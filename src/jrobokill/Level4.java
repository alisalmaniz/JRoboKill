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
import static jrobokill.Level1.robots;
import static jrobokill.Level1.separ1;
import static jrobokill.Level1.separ2;
import static jrobokill.Level1.separ3;
import static jrobokill.Level1.separ4;
import static jrobokill.Level1.separ5;
import static jrobokill.Level1.tirCunter;
import static jrobokill.Level1.tirCunterT;
import static jrobokill.Level1.tirVector;
import static jrobokill.Level2.enemy1l;
import static jrobokill.Level2.enemy1r;
import static jrobokill.Level2.enemyCunter;
import static jrobokill.Level2.enemyDeth;
import static jrobokill.Level2.enemyVector;
import static jrobokill.Level6.KeySmall;
import static jrobokill.Level6.keyTrue;

/**
 *
 * @author Asus
 */
public class Level4 extends JPanel implements Runnable {

    private BufferedImage zamin4;
    private BufferedImage robot4;
    private BufferedImage separ;
    private BufferedImage bangBomb;
    private BufferedImage bomb;

    private Image dbImage;
    private Graphics dbg;

    public int pause4 = 0;
    private boolean Robo4IsAlive;
    public static Level5 RoboPanel5;
    public static Level6 RoboPanel6;
    public static Level10 RoboPanel10;
    public static Map map4;
    private int xBomb = 100;
    private int yBomb = 100;
    private int bangBomb1 = 0;
    private int bangBombCounter1 = 0;
    public static TanzimRobat tanzimRob4;
    private BufferedImage mane;
    private int xMane = 300;
    private int yMane = 300;
    private int xSepar = 600;
    private int ySepar = 100;
    public static boolean separTrue = false;
    private boolean separShow = true;

    int enemydethflag;

    private int moveRobots;

  
    
    public Level4() {
        Level1.Xrobot = 400;
        Level1.Yrobot = 500;

        moveRobots = 0;
        Level1.nowMoving = 0;

        setLayout(null);

        Level1.Xrobot = 300;
        Level1.Yrobot = 610;

        enemydethflag = 0;

        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo4IsAlive = true;
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin4.png");
        try {
            zamin4 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //mane
        URL resourceMane = getClass().getResource("/pic/mane.png");
        try {
            mane = ImageIO.read(resourceMane);
        } catch (IOException e) {
            System.out.println("invalid adress pic mane");
        }
        //SEPAR!!!!!!
        URL resources = getClass().getResource("/pic/Mysepar.png");
        try {
            separ = ImageIO.read(resources);
        } catch (IOException e) {
            System.out.println("invalid adress pic mane");
        }
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot4 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }

        //bang bomb
        URL resourceBangBomb = getClass().getResource("/pic/bang.png");
        try {
            bangBomb = ImageIO.read(resourceBangBomb);
        } catch (IOException e) {
            System.out.println("invalid adress banggg bomb");
        }
        //bomb
        URL resourceBomb = getClass().getResource("/pic/bomb.png");
        try {
            bomb = ImageIO.read(resourceBomb);
        } catch (IOException e) {
            System.out.println("invalid adress bomb");
        }
        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());

        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 100.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 600.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 400.0, 300.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 100.0, 500.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 600.0, 500.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 150.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 550.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 400.0, 100.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 100.0, 400.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 600.0, 400.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 400.0, 10.0));

        (new Thread(this)).start();
    }

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
        g.drawImage(zamin4, 0, 0, this);

        g.drawImage(bomb, xBomb, yBomb, this);
         if (separShow) {
                g.drawImage(separ, xSepar, ySepar, this);
            }
        if (bangBomb1 == 1 && bangBombCounter1 >= 2) {
            g.drawImage(bangBomb, xBomb - 10, yBomb - 10, this);
        }
         if (keyTrue) {
            g.drawImage(KeySmall, 730, 30, this);
        }
        for (enemyCunter = 0; enemyCunter < enemyVector.size(); enemyCunter++) {

            if (enemyVector.get(enemyCunter).getEnemySmash()) {
                g.drawImage(enemyDeth, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
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

        g.drawImage(mane, xMane, yMane, this);

        //separ
        if (separTrue) {
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

        for (tirCunter = 0; tirCunter < tirVector.size(); tirCunter++) {
            //System.out.println(tirVector.size());

            if (Level1.tirVector.get(tirCunter).getruns()) {
                g2d.rotate(atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
                System.out.println(tirVector.size() + "/" + tirVector.get(tirCunter).getxMouse() + "/" + tirVector.get(tirCunter).getxTir());

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
                    if (enemyVector.get(enemyCunter).getxEnemy() > Level1.Xrobot) {
                        g.drawImage(Level2.enemy2r, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    } else {
                        g.drawImage(Level2.enemy2l, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    }
                } else if (enemyVector.get(enemyCunter).getEnemyNumber() == 3) {
                    if (enemyVector.get(enemyCunter).getxEnemy() > Level1.Xrobot) {
                        g.drawImage(Level2.enemy3r, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    } else {
                        g.drawImage(Level2.enemy3l, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    }
                } else if (enemyVector.get(enemyCunter).getEnemyNumber() == 4) {
                    if (enemyVector.get(enemyCunter).getxEnemy() > Level1.Xrobot) {
                        g.drawImage(Level2.enemy4r, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    } else {
                        g.drawImage(Level2.enemy4l, (int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), this);
                    }
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
            
            if (moveKey == KeyEvent.VK_F1) {

                    Health = 100;
                }

            if (JRoboKill.counter == 4) {

                if (moveKey == KeyEvent.VK_ESCAPE) {

                    System.exit(0);
                }
                //button O & P for pause and continue
                if (moveKey == KeyEvent.VK_P) {
                    pause4 = 1;
                    JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
                }
                if (moveKey == KeyEvent.VK_O) {
                    pause4 = 0;
                    JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
                }

                if (moveKey == KeyEvent.VK_M && JRoboKill.counter == 4) {
                    map4 = new Map();

                    JRoboKill.board.remove(Level3.RoboPanel4);
                    JRoboKill.board.add(map4, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }

                if (moveKey == KeyEvent.VK_N && JRoboKill.counter == 4) {

                    //kelid baraye map robat
                    JRoboKill.board.remove(Level4.map4);
                    JRoboKill.board.add(Level3.RoboPanel4, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();

                }
                if (moveKey == KeyEvent.VK_Q && JRoboKill.counter == 4) {
                    tanzimRob4 = new TanzimRobat();

                    JRoboKill.board.remove(Level3.RoboPanel4);
                    JRoboKill.board.add(Level4.tanzimRob4, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_W && JRoboKill.counter == 4) {
                    JRoboKill.board.remove(Level4.tanzimRob4);
                    JRoboKill.board.add(Level3.RoboPanel4, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }

                if (moveKey == KeyEvent.VK_UP) {

                    Level1.nowMoving += 2;
                    if (Level1.Yrobot >= 0 && pause4 == 0) {

                       /* if ((Level1.Xrobot >= xMane + 60 && (Level1.Yrobot >= 360 || Level1.Yrobot <= 300)) || (Level1.Xrobot >= xMane + 40 && (Level1.Yrobot <= 360 && Level1.Yrobot >= 300)) || (Level1.Xrobot <= xMane + 40 && (Level1.Yrobot >= 360 || Level1.Yrobot <= 300))) {
                            Level1.Yrobot -=5;
                        }*/
                        if(!((Level1.Xrobot > xMane-42) && (Level1.Xrobot < xMane+97 )&& (Level1.Yrobot > yMane-42) && (Level1.Yrobot < yMane+91) ))
                        {
                             Level1.Yrobot -=5;
                        }
                        else
                        {
                           
                        }
                    }
                    //gereftan separ
                    if (Level1.Xrobot >= xSepar - 10 && Level1.Xrobot <= xSepar + 10 && Level1.Yrobot >= ySepar - 10 && Level1.Yrobot <= ySepar + 10) {
                        separTrue = true;
                        separShow = false;
                    }
                    if (Level1.Xrobot > 250 && Level1.Xrobot < 400 && Level1.Yrobot < 50 && JRoboKill.counter == 4 && keyTrue==true ) {

                        //raftan be level 10 ***final
                        if (enemyVector.size() == 0){
                        JRoboKill.counter = 10;
                        RoboPanel10 = new Level10();
                        JRoboKill.board.remove(Level3.RoboPanel4);
                        JRoboKill.board.add(RoboPanel10, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();}

                    }
                }

                if (moveKey == KeyEvent.VK_LEFT) {
                    Level1.nowMoving += 2;
                    if (Level1.Xrobot >= 0 && pause4 == 0) {
                       /* if ((Level1.Xrobot >= xMane - 40 && Level1.Xrobot <= xMane + 100 && (Level1.Yrobot >= yMane + 70 || Level1.Yrobot <= yMane - 40)) || (Level1.Xrobot >= xMane + 100 && (Level1.Yrobot >= yMane + 70 || Level1.Yrobot <= yMane - 40)) || (Level1.Xrobot <= xMane - 40 && (Level1.Yrobot >= yMane + 70 || Level1.Yrobot <= yMane - 40)) || (Level1.Yrobot <= yMane + 70 && Level1.Yrobot >= yMane - 40 && Level1.Xrobot <= xMane - 40) || (Level1.Yrobot <= yMane + 70 && Level1.Yrobot >= yMane - 40 && Level1.Xrobot >= xMane + 100)) {
                            Level1.Xrobot -=5;
                        }*/
                         if((Level1.Xrobot > xMane-42) && (Level1.Xrobot < xMane+97 )&& (Level1.Yrobot > yMane-42) && (Level1.Yrobot < yMane+91) )
                        {
                            
                        }
                        else
                        {
                            Level1.Xrobot -=5;
                        }

                        if (Level1.Xrobot >= xSepar - 10 && Level1.Xrobot <= xSepar + 10 && Level1.Yrobot >= ySepar - 10 && Level1.Yrobot <= ySepar + 10) {
                            separTrue = true;
                            separShow = false;
                        }
                        //vared shodan be marhale 6
                        if (Level1.Xrobot < 30 && Level1.Yrobot > 200 && Level1.Yrobot < 400 && JRoboKill.counter == 4) {

                            //raftan be level 6
                            if (enemyVector.size() == 0){
                            JRoboKill.counter = 6;
                            RoboPanel6 = new Level6();
                            JRoboKill.board.remove(Level3.RoboPanel4);
                            JRoboKill.board.add(RoboPanel6, BorderLayout.CENTER);
                            JRoboKill.board.revalidate();
                            tirVector.removeAllElements();}

                        }

                    }
                }

                if (moveKey == KeyEvent.VK_RIGHT) {
                    Level1.nowMoving += 2;
                    if (Level1.Xrobot <= 740 && pause4 == 0) {
                        // if ((Level1.Xrobot >= xMane - 40 && Level1.Xrobot <= xMane + 100 && (Level1.Yrobot >= yMane + 70 || Level1.Yrobot <= yMane - 40)) || (Level1.Xrobot >= xMane + 100 && (Level1.Yrobot >= yMane + 70 || Level1.Yrobot <= yMane - 40)) || (Level1.Xrobot <= xMane - 40 && (Level1.Yrobot >= yMane + 70 || Level1.Yrobot <= yMane - 40)) || (Level1.Yrobot <= yMane + 70 && Level1.Yrobot >= yMane - 40 && Level1.Xrobot <= xMane - 40) || (Level1.Yrobot <= yMane + 70 && Level1.Yrobot >= yMane - 40 && Level1.Xrobot >= xMane + 100)) {
                         //x va y for mane
                         if((Level1.Xrobot > xMane-42) && (Level1.Xrobot < xMane+97 )&& (Level1.Yrobot > yMane-42) && (Level1.Yrobot < yMane+91) )
                        {
                            
                        }
                        else
                        {
                            Level1.Xrobot +=5;
                        }
                        // }
                        if (Level1.Xrobot >= xSepar - 10 && Level1.Xrobot <= xSepar + 10 && Level1.Yrobot >= ySepar - 10 && Level1.Yrobot <= ySepar + 10) {
                            separTrue = true;
                            separShow = false;
                        }
                        if (Level1.Xrobot > 700 && Level1.Yrobot > 200 && Level1.Yrobot < 400 && JRoboKill.counter == 4) {

                            if (enemyVector.size() == 0) {
                                //raftan be level 5
                                JRoboKill.counter = 5;
                                RoboPanel5 = new Level5();
                                JRoboKill.board.remove(Level3.RoboPanel4);
                                JRoboKill.board.add(RoboPanel5, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                                tirVector.removeAllElements();
                            }

                        }

                    }
                }
                if (moveKey == KeyEvent.VK_DOWN) {
                    Level1.nowMoving += 2;

                    if (Level1.Yrobot <= 560 && pause4 == 0) {
                        Level1.Yrobot +=5; 
                    }
                    if (Level1.Xrobot >= xSepar - 10 && Level1.Xrobot <= xSepar + 10 && Level1.Yrobot >= ySepar - 10 && Level1.Yrobot <= ySepar + 10) {
                        separTrue = true;
                        separShow = false;
                    }
                    if ((Level1.Xrobot > 200 && Level1.Xrobot < 600 && JRoboKill.counter == 4) && (Level1.Yrobot > 540)) {
                        if (enemyVector.size() == 0) {
                            JRoboKill.counter = 3;
                            Level1.Xrobot=400;
                            Level1.Yrobot=50;
                            JRoboKill.board.remove(Level3.RoboPanel4);
                            JRoboKill.board.add(Level2.RoboPanel3, BorderLayout.CENTER);
                            JRoboKill.board.revalidate();
                            tirVector.removeAllElements();
                        }
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
            if (e.getX() >= xBomb - 30 && e.getX() <= xBomb + 30 && e.getY() >= yBomb - 30 && e.getY() <= yBomb + 30) {
                bangBomb1 = 1;
                bangBombCounter1++;
                //JOptionPane.showMessageDialog(null, "khord ", "Game Over", JOptionPane.INFORMATION_MESSAGE);

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
