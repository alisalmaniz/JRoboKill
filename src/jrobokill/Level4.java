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
    private int Xrobot4 = 400;
    private int Yrobot4 = 500;

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
    private int yMane =300;

    public Level4() {

        setLayout(null);

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
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot4 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }
        //separ
        URL resourceSepar = getClass().getResource("/pic/separ.png");
        try {
            separ = ImageIO.read(resourceSepar);
        } catch (IOException e) {
            System.out.println("invalid adress separ");
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
        g.drawImage(zamin4, 0, 0, this);
        g.drawImage(separ, 300, 300, this);
        g.drawImage(bomb, xBomb, yBomb, this);
        if (bangBomb1 == 1 && bangBombCounter1 >= 2) {
            g.drawImage(bangBomb, xBomb - 10, yBomb - 10, this);
        }

        g.drawImage(robot4, Xrobot4, Yrobot4, this);
        g.drawImage(mane, xMane, yMane, this);
        
        

        for (tirCunter = 0; tirCunter < tirVector.size(); tirCunter++) {
            //System.out.println(tirVector.size());

            g2d.rotate(atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
                System.out.println(tirVector.size()+"/"+tirVector.get(tirCunter).getxMouse()+"/"+tirVector.get(tirCunter).getxTir());
             
            if(tirVector.get(tirCunter).getxMouse()>tirVector.get(tirCunter).getxFirstRobot())
                g.drawImage(T1r,(int)tirVector.get(tirCunter).getxTir(),(int)tirVector.get(tirCunter).getyTir(),this);
            else
                g.drawImage(T1l,(int)tirVector.get(tirCunter).getxTir(),(int)tirVector.get(tirCunter).getyTir(),this);
                    
            g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse()-tirVector.get(tirCunter).getyFirstRobot())/(tirVector.get(tirCunter).getxMouse()-tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());

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
                if (Yrobot4 >= 0 && pause4 == 0) 
                {
                    
                   if((Xrobot4>=xMane+60 && (Yrobot4>=360 || Yrobot4<=300))||(Xrobot4>=xMane+40 && (Yrobot4<=360 && Yrobot4>=300))||(Xrobot4<=xMane+40 && (Yrobot4>=360 || Yrobot4<=300)))
                    Yrobot4 = Yrobot4 - 5;
                    
                }
                if (Xrobot4 > 250 && Xrobot4 < 400 && Yrobot4 < 50 && JRoboKill.counter == 4) {

                    //raftan be level 10 ***final
                    JRoboKill.counter = 10;
                    RoboPanel10 = new Level10();
                    JRoboKill.board.remove(Level3.RoboPanel4);
                    JRoboKill.board.add(RoboPanel10, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                    tirVector.removeAllElements();

                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot4 >= 0 && pause4 == 0) {
                    Xrobot4 = Xrobot4 - 5;
                    //vared shodan be marhale 6
                    if (Xrobot4 < 30 && Yrobot4 > 200 && Yrobot4 < 400 && JRoboKill.counter == 4) {

                        //raftan be level 6
                        JRoboKill.counter = 6;
                        RoboPanel6 = new Level6();
                        JRoboKill.board.remove(Level3.RoboPanel4);
                        JRoboKill.board.add(RoboPanel6, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();

                    }

                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot4 <= 740 && pause4 == 0) {
                    Xrobot4 = Xrobot4 + 5;
                    if (Xrobot4 > 700 && Yrobot4 > 200 && Yrobot4 < 400 && JRoboKill.counter == 4) {

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
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot4 <= 560 && pause4 == 0) {
                    Yrobot4 = Yrobot4 + 5;

                }
                if ((Xrobot4 > 200 && Xrobot4 < 600 && JRoboKill.counter == 4) && (Yrobot4 > 540)) {
                    JRoboKill.counter = 3;

                    JRoboKill.board.remove(Level3.RoboPanel4);
                    JRoboKill.board.add(Level2.RoboPanel3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                    tirVector.removeAllElements();
                }
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }

    private class TirHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tirVector.add(new TirThread(Xrobot4, Yrobot4, e.getX(), e.getY(), tirCunterT));
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
