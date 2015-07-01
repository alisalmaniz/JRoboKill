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
import javax.swing.JFrame;
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
public class Level5 extends JPanel implements Runnable {

    private BufferedImage zamin5;
    private BufferedImage robot5;
    private Image dbImage;
    private Graphics dbg;

    public int pause5 = 0;
    private boolean Robo5IsAlive;
    public static Level7 RoboPanel7;
    public static Level8 RoboPanel8;
    public static Level9 RoboPanel9;
    public static Map map5;
    public static TanzimRobat tanzimRob5;

    int enemydethflag;

    private int moveRobots;



    public Level5() {

        setLayout(null);

        enemydethflag = 0;
        Level1.Xrobot = 10;
        Level1.Yrobot = 200;

        moveRobots = 0;
        Level1.nowMoving = 0;


        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo5IsAlive = true;
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin5.png");
        try {
            zamin5 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot5 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }

        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());

        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 100.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 600.0, 250.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 400.0, 300.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 150.0, 300.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 600.0, 300.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 150.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 550.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 450.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 100.0, 250.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 550.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 400.0, 250.0));

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
        g.drawImage(zamin5, 0, 0, this);
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

            if (JRoboKill.counter == 5) {

                if (JRoboKill.counter == 5) {

                    if (moveKey == KeyEvent.VK_F1) {

                        Health = 100;
                    }

                    if (moveKey == KeyEvent.VK_ESCAPE) {

                        System.exit(0);

                    }
                    //button O & P for pause and continue
                    if (moveKey == KeyEvent.VK_P) {
                        pause5 = 1;
                        JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (moveKey == KeyEvent.VK_O) {
                        pause5 = 0;
                        JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (moveKey == KeyEvent.VK_M && JRoboKill.counter == 5) {
                        map5 = new Map();


                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(map5, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }

                    if (moveKey == KeyEvent.VK_N && JRoboKill.counter == 5) {

                        //kelid baraye map robat
                        JRoboKill.board.remove(Level5.map5);
                        JRoboKill.board.add(Level4.RoboPanel5, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();


                    }
                    if (moveKey == KeyEvent.VK_Q && JRoboKill.counter == 5) {
                        tanzimRob5 = new TanzimRobat();

                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(Level5.tanzimRob5, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    if (moveKey == KeyEvent.VK_W && JRoboKill.counter == 5) {
                        JRoboKill.board.remove(Level5.tanzimRob5);
                        JRoboKill.board.add(Level4.RoboPanel5, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }

                    if (moveKey == KeyEvent.VK_UP) {
                        Level1.nowMoving += 2;
                        if (Level1.Yrobot >= 0 && pause5 == 0) {
                            Level1.Yrobot = Level1.Yrobot - 5;
                            //raftan be level 9
                            if (Level1.Xrobot > 270 && Level1.Xrobot < 480 && Level1.Yrobot < 50 && JRoboKill.counter == 5) {
                                if (enemyVector.size() == 0) {
                                    JRoboKill.counter = 9;
                                    RoboPanel9 = new Level9();
                                    JRoboKill.board.remove(Level4.RoboPanel5);
                                    JRoboKill.board.add(RoboPanel9, BorderLayout.CENTER);
                                    JRoboKill.board.revalidate();
                                }
                            }
                            //chale ha
                            if (Level1.Xrobot < 250 && Level1.Yrobot < 150 && JRoboKill.counter == 5) {
                                System.out.println("oftad 1 ");
                                //raftan be level 1 pas az oftadan dar chale
                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;

                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }
                            if (Level1.Xrobot > 500 && Level1.Yrobot < 150 && JRoboKill.counter == 5) {
                                System.out.println("oftad 2 ");
                                //raftan be level 1 pas az oftadan dar chale
                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;

                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }

                        }

                    }

                    if (moveKey == KeyEvent.VK_LEFT) {
                        Level1.nowMoving += 2;
                        if (Level1.Xrobot >= 0 && pause5 == 0) {
                            Level1.Xrobot = Level1.Xrobot - 5;

                            //bargasht be level4
                            if ((Level1.Yrobot > 180 && Level1.Yrobot < 380 && JRoboKill.counter == 5) && (Level1.Xrobot < 50)) {
                                //bargashtan be level 4
                                if (enemyVector.size() == 0) {
                                    JRoboKill.counter = 4;

                                    Level1.Xrobot = 720;
                                    Level1.Yrobot = 300;

                                    JRoboKill.board.remove(Level4.RoboPanel5);
                                    JRoboKill.board.add(Level3.RoboPanel4, BorderLayout.CENTER);
                                    JRoboKill.board.revalidate();
                                    tirVector.removeAllElements();
                                }
                            }
                            if (Level1.Xrobot < 250 && Level1.Yrobot < 150 && JRoboKill.counter == 5) {
                                System.out.println("oftad 1 ");
                                //raftan be level 1 pas az oftadan dar chale
                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;

                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }
                            if (Level1.Xrobot < 250 && Level1.Yrobot > 410 && JRoboKill.counter == 5) {
                                System.out.println("oftad 3 ");
                                //raftan be level 1 pas az oftadan dar chale
                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;
                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }

                        }
                    }

                    if (moveKey == KeyEvent.VK_RIGHT) {
                        Level1.nowMoving += 2;
                        if (Level1.Xrobot <= 740 && pause5 == 0) {
                            Level1.Xrobot = Level1.Xrobot + 5;
                            //raftan be level 8
                            if (Level1.Yrobot > 170 && Level1.Yrobot < 390 && Level1.Xrobot > 720 && JRoboKill.counter == 5) {
                                if (enemyVector.size() == 0) {
                                    JRoboKill.counter = 8;
                                    RoboPanel8 = new Level8();
                                    JRoboKill.board.remove(Level4.RoboPanel5);
                                    JRoboKill.board.add(RoboPanel8, BorderLayout.CENTER);
                                    JRoboKill.board.revalidate();
                                }
                            }
                            if (Level1.Xrobot > 500 && Level1.Yrobot < 150 && JRoboKill.counter == 5) {
                                System.out.println("oftad 2 ");
                                //raftan be level 1 pas az oftadan dar chale
                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;

                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }
                            if (Level1.Xrobot > 500 && Level1.Yrobot > 410 && JRoboKill.counter == 5) {
                                System.out.println("oftad 4 ");
                                //raftan be level 1 pas az oftadan dar chale
                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;
                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }

                        }
                    }
                    if (moveKey == KeyEvent.VK_DOWN) {
                        Level1.nowMoving += 2;
                        if (Level1.Yrobot <= 560 && pause5 == 0) {
                            Level1.Yrobot = Level1.Yrobot + 5;
                            //raftan be level 7
                            if (Level1.Xrobot > 280 && Level1.Xrobot < 450 && Level1.Yrobot > 550 && JRoboKill.counter == 5) {
                                if (enemyVector.size() == 0) {
                                    JRoboKill.counter = 7;
                                    RoboPanel7 = new Level7();
                                    JRoboKill.board.remove(Level4.RoboPanel5);
                                    JRoboKill.board.add(RoboPanel7, BorderLayout.CENTER);
                                    JRoboKill.board.revalidate();
                                }
                            }
                            if (Level1.Xrobot < 250 && Level1.Yrobot > 410 && JRoboKill.counter == 5) {
                                System.out.println("oftad 3 ");
                                JRoboKill.counter = 1;

                                //raftan be level 1 pas az oftadan dar chale
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;

                                JRoboKill.counter = 1;

                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }
                            if (Level1.Xrobot > 500 && Level1.Yrobot > 410 && JRoboKill.counter == 5) {
                                System.out.println("oftad 4 ");
                                //raftan be level 1 pas az oftadan dar chale
                                JRoboKill.counter = 1;
                                Level1.Xrobot = 400;
                                Level1.Yrobot = 500;
                                JRoboKill.board.remove(Level4.RoboPanel5);
                                JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                                JRoboKill.board.revalidate();
                            }

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
