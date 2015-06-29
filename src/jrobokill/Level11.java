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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static jrobokill.Level1.T1l;
import static jrobokill.Level1.T1r;
import static jrobokill.Level1.Xrobot;
import static jrobokill.Level1.Yrobot;
import static jrobokill.Level1.robots;
import static jrobokill.Level1.tirCunter;
import static jrobokill.Level1.tirCunterT;
import static jrobokill.Level1.tirVector;

/**
 *
 * @author Asus
 */
public class Level11 extends JPanel implements Runnable {

    private BufferedImage zamin11;
    private BufferedImage mane;
    private BufferedImage robot11;
    private Image dbImage;
    private Graphics dbg;
    public int pause11 = 0;
    private boolean Robo11IsAlive;
    private int Xmane = 300;
    private int Ymane = 300;
    public static Level6 RoboPanel6;
    
    private int moveRobots;
    private int nowMoving;

    public Level11() {
        Level1.Xrobot = 450;
        Level1.Yrobot = 30;

        moveRobots=0;
        nowMoving=0;
        
        setLayout(null);
        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo11IsAlive = true;

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin11.png");
        try {
            zamin11 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //mane
        URL resourceMane = getClass().getResource("/pic/mane.png");
        try {
            mane = ImageIO.read(resourceMane);
        } catch (IOException e) {
            System.out.println("invalid adress mane");
        }

        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot11 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
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
        
        if(moveRobots==15)
            moveRobots=0;
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        g.drawImage(zamin11, 0, 0, this);

        g.drawImage(robots[moveRobots], Xrobot, Yrobot, this);
            
            if(nowMoving>0){
                
                moveRobots++;
                nowMoving--;
            }
            
            
            
        g.drawImage(mane, Xmane, Ymane, this);

        
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

            if (JRoboKill.counter ==11 ){
                if (moveKey == KeyEvent.VK_ESCAPE) {

                    System.exit(0);
                }
                //button O & P for pause and continue
                if (moveKey == KeyEvent.VK_P) {
                    pause11 = 1;
                    JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
                }
                if (moveKey == KeyEvent.VK_O) {
                    pause11 = 0;
                    JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
                }

                if (moveKey == KeyEvent.VK_UP) {
                    nowMoving+=2;
                    if (Level1.Yrobot >= 0 && pause11 == 0) {
                        Level1.Yrobot = Level1.Yrobot - 5;

                    }
                }

                if (moveKey == KeyEvent.VK_LEFT) {
                    nowMoving+=2;
                    if (Level1.Xrobot >= 0 && pause11 == 0) {
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

                if (moveKey == KeyEvent.VK_RIGHT) {
                    nowMoving+=2;
                    if (Level1.Xrobot <= 740 && pause11 == 0) {
                        Level1.Xrobot = Level1.Xrobot + 5;
                    }
                    if (Level1.Yrobot > 200 && Level1.Yrobot < 400 && Level1.Xrobot > 600) {
                        JOptionPane.showMessageDialog(null, "khkhkh ", "", JOptionPane.INFORMATION_MESSAGE);                        //raftan be level 6
                        JRoboKill.counter = 6;
                        RoboPanel6 = new Level6();
                        JRoboKill.board.remove(Level6.RoboPanel11);
                        JRoboKill.board.add(RoboPanel6, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();

                    }
                }
                if (moveKey == KeyEvent.VK_DOWN) {
                    nowMoving+=2;
                    if (Level1.Yrobot <= 560 && pause11 == 0) {
                        Level1.Yrobot = Level1.Yrobot + 5;

                    }

                }

            }
            //bayad ye chizi ro return kone,return false;
            return false;
        }

    }
}
