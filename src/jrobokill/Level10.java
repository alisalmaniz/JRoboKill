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
import static jrobokill.Level7.enemyTirVector;

/**
 *
 * @author Asus
 */
public class Level10 extends JPanel implements Runnable {

    private BufferedImage zamin10;
  //  private BufferedImage mane;
    private BufferedImage robot10;
    private Image dbImage;
    private Graphics dbg;
    public int pause10 = 0;
    private boolean Robo10IsAlive;
    private int Xmane = 300;
    private int Ymane = 300;
    int enemydethflag;
    int kenetir;
    int nenetir;

    private int moveRobots;
    //private int Level1.nowMoving;

    public Level10() {
        enemydethflag = 0;
        Level1.Xrobot = 450;
        Level1.Yrobot = 500;

        moveRobots = 0;
        Level1.nowMoving = 0;

        nenetir = 99;
        kenetir = -1;

        setLayout(null);
        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo10IsAlive = true;

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin10.png");
        try {
            zamin10 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
       

        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot10 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }

        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());

        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 4, 100.0, 100.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 700.0, 500.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 100.0, 100.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 700.0, 100.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 200.0, 100.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 400.0, 300.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 700.0, 700.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 1, 550.0, 550.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 450.0, 350.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 100.0, 200.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 600.0, 600.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 2, 650.0, 600.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 200.0, 100.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 400.0, 350.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 500.0, 500.0));
        enemyCunter++;
        enemyVector.add(new EnemyThread(enemyCunter, 3, 450, 450.0));

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
        g.drawImage(zamin10, 0, 0, this);

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

        for (enemyCunter = 0; enemyCunter < enemyVector.size(); enemyCunter++) {
            if (enemyVector.get(enemyCunter).getEnemyNumber() == 4) {
                if (nenetir % 100 == 0) {
                    enemyTirVector.add(new EnemyTirThread((int) enemyVector.get(enemyCunter).getxEnemy(), (int) enemyVector.get(enemyCunter).getyEnemy(), Level1.Xrobot, Level1.Yrobot));
                    kenetir++;
                }
                nenetir++;
              if (kenetir >=0 &&enemyTirVector.get(kenetir).getruns()) {

                    g2d.rotate(atan((enemyTirVector.get(kenetir).getYroboFirst() - enemyTirVector.get(kenetir).getyTir()) / (enemyTirVector.get(kenetir).getXroboFirst() - enemyTirVector.get(kenetir).getxTir())), enemyTirVector.get(kenetir).getxTir(), enemyTirVector.get(kenetir).getyTir());
                    if (enemyTirVector.get(kenetir).getXroboFirst() > enemyTirVector.get(kenetir).getxTir()) {
                        g.drawImage(Level2.EnemyTir1r, (int) enemyTirVector.get(kenetir).getxTir(), (int) enemyTirVector.get(kenetir).getyTir(), this);
                    } else {
                        g.drawImage(Level2.EnemyTir1l, (int) enemyTirVector.get(kenetir).getxTir(), (int) enemyTirVector.get(kenetir).getyTir(), this);
                    }
                    g2d.rotate(-atan((enemyTirVector.get(kenetir).getYroboFirst() - enemyTirVector.get(kenetir).getyTir()) / (enemyTirVector.get(kenetir).getXroboFirst() - enemyTirVector.get(kenetir).getxTir())), enemyTirVector.get(kenetir).getxTir(), enemyTirVector.get(kenetir).getyTir());
                }
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }

    private class TirHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //sedaye shlik
            URL url = getClass().getClassLoader().getResource("seda/Tir.wav");
            AudioClip clip2 = Applet.newAudioClip(url);
            clip2.loop();
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

    class moving implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            int moveKey = e.getKeyCode();

            if (JRoboKill.counter == 10) {
                if (moveKey == KeyEvent.VK_F1) {

                    Health = 100;
                }
                if (moveKey == KeyEvent.VK_ESCAPE) {

                    System.exit(0);
                }

                //button O & P for pause and continue
                if (moveKey == KeyEvent.VK_P) {
                    pause10 = 1;
                    JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
                }
                if (moveKey == KeyEvent.VK_O) {
                    pause10 = 0;
                    JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
                }
                Level1.nowMoving += 2;

                if (moveKey == KeyEvent.VK_UP) {
                    if (Level1.Yrobot >= 0 && pause10 == 0) {
                        Level1.Yrobot = Level1.Yrobot - 5;

                    }
                }

                if (moveKey == KeyEvent.VK_LEFT) {
                    Level1.nowMoving += 2;

                    if (Level1.Xrobot >= 0 && pause10 == 0) {
                        Level1.Xrobot = Level1.Xrobot - 5;
                    }
                    //bargasht be level5
                    if ((Level1.Yrobot > 170 && Level1.Yrobot < 390 && JRoboKill.counter == 8) && (Level1.Xrobot < 50)) {
                        //bargashtan be level 5
                        JRoboKill.counter = 5;
                        JRoboKill.board.remove(Level5.RoboPanel8);
                        JRoboKill.board.add(Level4.RoboPanel5, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();
                    }
                }
                if (moveKey == KeyEvent.VK_DOWN) {
                    if (Level1.Yrobot <= 560 && pause10 == 0) {
                        Level1.Yrobot = Level1.Yrobot + 5;

                    }

                }
                if (moveKey == KeyEvent.VK_RIGHT) {
                    Level1.nowMoving += 2;
                    if (Level1.Xrobot <= 740 && pause10 == 0) {
                        Level1.Xrobot = Level1.Xrobot + 5;

                    }
                }
                if (moveKey == KeyEvent.VK_DOWN) {
                    Level1.nowMoving += 2;
                    if (Level1.Yrobot <= 560 && pause10 == 0) {
                        Level1.Yrobot = Level1.Yrobot + 5;
                    }

                }
                //bayad ye chizi ro return kone,return false;
            }
            return false;
        }

    }

}
