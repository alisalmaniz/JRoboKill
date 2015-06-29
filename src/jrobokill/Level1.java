/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Level1 extends JPanel implements Runnable {

    public static int Xrobot = 400;
    public static int Yrobot = 500;
    public static int x = 0;
    public static int y = 0;

    private Image dbImage;
    private Graphics dbg;
    private BufferedImage zamin;
    private BufferedImage separ;
    public static BufferedImage Robo1;
    public static BufferedImage Robo2;
    public static BufferedImage Robo3;
    public static BufferedImage Robo4;
    public static BufferedImage Robo5;
    public static BufferedImage Robo6;
    public static BufferedImage Robo7;
    public static BufferedImage Robo8;
    public static BufferedImage Robo9;
    public static BufferedImage Robo10;
    public static BufferedImage Robo11;
    public static BufferedImage Robo12;
    public static BufferedImage Robo13;
    public static BufferedImage Robo14;
    public static BufferedImage Robo15;
    public static BufferedImage[] robots;

    private BufferedImage Jet;
    private BufferedImage exit;
    
    public static BufferedImage healthBar1;
    public static BufferedImage healthBar2;
    public static BufferedImage healthBar3;
    public static BufferedImage healthBar4;
    public static BufferedImage healthBar5;
    
    
    public static String HealthAdress = "";
    private BufferedImage shop;
    private BufferedImage makanAval;
    private BufferedImage ChaleFaza;
    private BufferedImage Fall;
    private static int pause = 0;
    public static Level2 RoboPanel2;

    public static TanzimRobat tanzimRob1;
    public static Map map1;

    public static int RoboPool = 0;
    private JButton health;
    private boolean Robo1IsAlive;
    private int moveRobots;
    private int nowMoving;
    public static int Health = 60;
    public static int Separ = 100;

    //thread
    public static int tirCunter = 0;
    public static int tirCunterT = 0;
    public static Vector<TirThread> tirVector;
    public static BufferedImage T1r;
    public static BufferedImage T1l;

    public Level1() {
        setLayout(null);

        health = new JButton("Start");
        //health.setFont(new Font("Arial", Font.BOLD, 20));
        health.setSize(100, 100);
        health.setLocation(0, 0);
        health.setBackground(Color.WHITE);
        //health.setForeground(Color.WHITE);
        add(health);

        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo1IsAlive = true;
        moveRobots = 0;
        nowMoving = 0;
        robots = new BufferedImage[15];

        //robot
        URL resourceRobo1 = getClass().getResource("/pic/Robo1.png");
        URL resourceRobo2 = getClass().getResource("/pic/Robo2.png");
        URL resourceRobo3 = getClass().getResource("/pic/Robo3.png");
        URL resourceRobo4 = getClass().getResource("/pic/Robo4.png");
        URL resourceRobo5 = getClass().getResource("/pic/Robo5.png");
        URL resourceRobo6 = getClass().getResource("/pic/Robo6.png");
        URL resourceRobo7 = getClass().getResource("/pic/Robo7.png");
        URL resourceRobo8 = getClass().getResource("/pic/Robo8.png");
        URL resourceRobo9 = getClass().getResource("/pic/Robo9.png");
        URL resourceRobo10 = getClass().getResource("/pic/Robo10.png");
        URL resourceRobo11 = getClass().getResource("/pic/Robo11.png");
        URL resourceRobo12 = getClass().getResource("/pic/Robo12.png");
        URL resourceRobo13 = getClass().getResource("/pic/Robo13.png");
        URL resourceRobo14 = getClass().getResource("/pic/Robo14.png");
        URL resourceRobo15 = getClass().getResource("/pic/Robo15.png");

        try {

            robots[0] = ImageIO.read(resourceRobo1);
            robots[1] = ImageIO.read(resourceRobo2);
            robots[2] = ImageIO.read(resourceRobo3);
            robots[3] = ImageIO.read(resourceRobo4);
            robots[4] = ImageIO.read(resourceRobo5);
            robots[5] = ImageIO.read(resourceRobo6);
            robots[6] = ImageIO.read(resourceRobo7);
            robots[7] = ImageIO.read(resourceRobo8);
            robots[8] = ImageIO.read(resourceRobo9);
            robots[9] = ImageIO.read(resourceRobo10);
            robots[10] = ImageIO.read(resourceRobo11);
            robots[11] = ImageIO.read(resourceRobo12);
            robots[12] = ImageIO.read(resourceRobo13);
            robots[13] = ImageIO.read(resourceRobo14);
            robots[14] = ImageIO.read(resourceRobo15);

        } catch (IOException e) {
            System.out.println("invalid adress Robots");
        }

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin.png");
        try {
            zamin = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }
        //separ
        URL resourceSepar = getClass().getResource("/pic/separ11.png");
        try {
            separ = ImageIO.read(resourceSepar);
        } catch (IOException e) {
            System.out.println("invalid adress separ");
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
        //health bar
        //health
        //navar salamati 1
        
        URL resourceHealth1 = getClass().getResource("/pic/healthBar1.png");
        try {
            healthBar1 = ImageIO.read(resourceHealth1);
        } catch (IOException e) {
            System.out.println("invalid adress health");
        }
        //navar salamati 2
        
        URL resourceHealth2 = getClass().getResource("/pic/healthBar2.png");
        try {
            healthBar2 = ImageIO.read(resourceHealth2);
        } catch (IOException e) {
            System.out.println("invalid adress health");
        }
        //navar salamati 3
        
        URL resourceHealth3 = getClass().getResource("/pic/healthBar3.png");
        try {
            healthBar3 = ImageIO.read(resourceHealth3);
        } catch (IOException e) {
            System.out.println("invalid adress health");
        }
        //navar salamati 4
        
        URL resourceHealth4 = getClass().getResource("/pic/healthBar4.png");
        try {
            healthBar4 = ImageIO.read(resourceHealth4);
        } catch (IOException e) {
            System.out.println("invalid adress health");
        }
        //navar salamati 5
        
        URL resourceHealth5 = getClass().getResource("/pic/healthBar5.png");
        try {
            healthBar5 = ImageIO.read(resourceHealth5);
        } catch (IOException e) {
            System.out.println("invalid adress health");
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
        
        

        if (moveRobots == 15) {
            moveRobots = 0;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
        }

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

            g.drawImage(robots[moveRobots], Xrobot, Yrobot, this);

            if (nowMoving > 0) {

                moveRobots++;
                nowMoving--;
            }

        } else {
            g.drawImage(Fall, Xrobot, Yrobot, this);
        }
        
        
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
       
      

        g.drawImage(separ, 650, 555, this);

        System.out.println("**************" + tirVector.size());
        for (tirCunter = 0; tirCunter < tirVector.size(); tirCunter++) {

            //System.out.println(tirVector.size());
            g2d.rotate(atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
            //System.out.println(Xrobot+"/"+tirVector.get(tirCunter).getxTir());

            if (tirVector.get(tirCunter).getxMouse() > tirVector.get(tirCunter).getxFirstRobot()) {
                g.drawImage(T1r, (int) tirVector.get(tirCunter).getxTir(), (int) tirVector.get(tirCunter).getyTir(), this);
            } else {
                g.drawImage(T1l, (int) tirVector.get(tirCunter).getxTir() - 35, (int) tirVector.get(tirCunter).getyTir() - 10, this);
            }

            g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());

        }

    }

    @Override
    public void run() {

        while (true) {
            repaint();
            health.repaint();
        }
    }

    class moving implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            int moveKey = e.getKeyCode();

            if (JRoboKill.counter == 1) {

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

                if (moveKey == KeyEvent.VK_M && JRoboKill.counter == 1) {

                    //kelid baraye map robat
                    map1 = new Map();
                    JRoboKill.board.remove(StartMenu.RoboPanel);
                    JRoboKill.board.add(map1, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();

                }
                if (moveKey == KeyEvent.VK_N && JRoboKill.counter == 1) {

                    //kelid baraye map robat
                    // map1 = new Map();
                    JRoboKill.board.remove(Level1.map1);
                    JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();

                }
                if (moveKey == KeyEvent.VK_Q && JRoboKill.counter == 1) {

                    //kelid baraye tanzimat robat
                    tanzimRob1 = new TanzimRobat();

                    JRoboKill.board.remove(StartMenu.RoboPanel);
                    JRoboKill.board.add(tanzimRob1, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_W && JRoboKill.counter == 1) {
                    JRoboKill.board.remove(Level1.tanzimRob1);
                    JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }


                if (moveKey == KeyEvent.VK_UP) {
                    if (Yrobot >= 0 && pause == 0) {
                        nowMoving += 2;
                        Yrobot = Yrobot - 5;
                        //agar az x,y door gozasht bere marhale 2
                        if ((Xrobot > 200 && Xrobot < 600 && JRoboKill.counter == 1) && (Yrobot < 40)) {

                            Xrobot = 400;
                            Yrobot = 500;

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
                    nowMoving += 2;
                    if (Xrobot >= 0 && pause == 0) {
                        Xrobot = Xrobot - 5;
                    }
                    //soghot robat dar chale

                    if (Xrobot < 300) {
                        Robo1IsAlive = false;

                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        JOptionPane.showMessageDialog(null, "You fall in a hole ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        JRoboKill.counter = 1;

                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        Robo1IsAlive = true;
                        Xrobot = 400;
                        Yrobot = 500;
                    }
                }

                if (moveKey == KeyEvent.VK_RIGHT) {
                    nowMoving += 2;
                    if (Xrobot <= 740 && pause == 0) {
                        Xrobot = Xrobot + 5;
                    }
                }
                if (moveKey == KeyEvent.VK_DOWN) {
                    nowMoving += 2;
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
            //sedaye shlik
            if (Option.OnSound) {
                URL url = getClass().getClassLoader().getResource("seda/Tir.wav");
                AudioClip clip2 = Applet.newAudioClip(url);
                clip2.loop();
            }

            tirVector.add(new TirThread(Xrobot, Yrobot, e.getX(), e.getY(), tirCunterT));
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
