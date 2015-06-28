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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static jrobokill.Level1.RoboPanel2;
import static jrobokill.Level1.T1l;
import static jrobokill.Level1.T1r;
import static jrobokill.Level1.tirCunter;
import static jrobokill.Level1.tirCunterT;
import static jrobokill.Level1.tirVector;

/**
 *
 * @author Asus
 */
public class Level2 extends JPanel implements Runnable {

    private int Xrobot2 = 400;
    private int Yrobot2 = 500;
    public static int x = 0;
    public static int y = 0;
    private Image dbImage;
    private Graphics dbg;
    private BufferedImage pol;
    private BufferedImage zamin2;
    private BufferedImage robot2;
    private BufferedImage bang;
    private BufferedImage Tir;
    private BufferedImage box;
    public static Level3 RoboPanel3;
    public static TanzimRobat tanzimRob2;
    public static Map map2;
    private int bangBox1 = 0;
    private int bangBox2 = 0;
    private int bangBoxCounter1 = 0;
    private int bangBoxCounter2 = 0;
     private int xBox1=210;
    private int yBox1=200;

    private boolean Robo2IsAlive;

    public Level2() {
        setLayout(null);

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
        for (int i = 0; i < 2; i++) {
            g.drawImage(box, xBox1, yBox1 + 38 * i, this);
        }
        //tekidan box
        if (bangBox1 == 1 && bangBoxCounter1>=4) {
            g.drawImage(bang, 200, 190, this);
        }
        if (bangBox2 == 2 && bangBoxCounter2>=4) {
            g.drawImage(bang, 200, 234, this);
        }

        if (Robo2IsAlive) {
            g.drawImage(robot2, Xrobot2, Yrobot2, this);
        } else {

        }

        for (tirCunter = 0; tirCunter < tirVector.size(); tirCunter++) {
            //System.out.println(tirVector.size());
            g2d.rotate(atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxFirstRobot(), tirVector.get(tirCunter).getyFirstRobot());
            System.out.println(tirVector.size() + "/" + tirVector.get(tirCunter).getxMouse() + "/" + tirVector.get(tirCunter).getxTir());

            if (tirVector.get(tirCunter).getxMouse() > tirVector.get(tirCunter).getxFirstRobot()) {
                g.drawImage(T1r, tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir(), this);
            } else {
                g.drawImage(T1l, tirVector.get(tirCunter).getxTir() - 35, tirVector.get(tirCunter).getyTir() - 10, this);
            }

            g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxFirstRobot(), tirVector.get(tirCunter).getyFirstRobot());
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

                JRoboKill.board.remove(Level1.RoboPanel2);
                JRoboKill.board.add(map2, BorderLayout.CENTER);
                JRoboKill.board.revalidate();
            }
            
            if (moveKey == KeyEvent.VK_N && JRoboKill.counter ==2) {

                //kelid baraye map robat
               
                JRoboKill.board.remove(Level2.map2);
                JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
                JRoboKill.board.revalidate();

            }

            if (moveKey == KeyEvent.VK_UP) {
                if((Xrobot2>=xBox1+40 && (Yrobot2>280 || Yrobot2<180))||(Xrobot2>=xBox1+40 && (Yrobot2<=280 && Yrobot2>=180))||/*(Xrobot2<=300 && (Yrobot2<280 && Yrobot2>200))||*/(Xrobot2<=xBox1+40 && (Yrobot2>=280 || Yrobot2<=180))){
                Yrobot2 = Yrobot2 - 5;
                //age az door rad shod
                if ((Xrobot2 > 200 && Xrobot2 < 600) && (Yrobot2 < 40) && JRoboKill.counter == 2) {
                    JRoboKill.counter = 3;
                    RoboPanel3 = new Level3();
                    JRoboKill.board.remove(Level1.RoboPanel2);
                    JRoboKill.board.add(RoboPanel3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                    tirVector.removeAllElements();
                }
                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                 if((Xrobot2>=xBox1+40 && (Yrobot2>280 || Yrobot2<180))||(Xrobot2>=xBox1+40 && (Yrobot2<280 && Yrobot2>180))||/*(Xrobot2<=300 && (Yrobot2<280 && Yrobot2>200))||*/(Xrobot2<=xBox1+40 && (Yrobot2>280 || Yrobot2<180))){
                   //if( !(Xrobot2<xBox1 && (Yrobot2<280 || Yrobot2>200))){
                     Xrobot2 = Xrobot2 - 5;
                //agar az roye pol oonvartar raft biyofte payin
                if (Xrobot2 < 180 && JRoboKill.counter == 2) {
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
               
                    
                    Xrobot2 = Xrobot2 + 5;
                //agar az roye pol oonvartar raft biyofte payin
                if (Xrobot2 > 550 && JRoboKill.counter == 2) {
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
                 if((Xrobot2>=xBox1+40 && (Yrobot2>280 || Yrobot2<180))||(Xrobot2>=xBox1+40 && (Yrobot2<=280 && Yrobot2>=180))||/*(Xrobot2<=300 && (Yrobot2<280 && Yrobot2>200))||*/(Xrobot2<=xBox1+40 && (Yrobot2>=280 || Yrobot2<=180))){
                Yrobot2 = Yrobot2 + 5;
                //bara bargashtan
                if ((Xrobot2 > 200 && Xrobot2 < 600 && JRoboKill.counter == 2) && (Yrobot2 > 540)) {
                    JRoboKill.counter = 1;

                    JRoboKill.board.remove(Level1.RoboPanel2);
                    JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                    tirVector.removeAllElements();
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
            tirVector.add(new TirThread(Xrobot2, Yrobot2, e.getX(), e.getY(), tirCunterT));
           
            if (e.getX() >= 200 && e.getX() <= 250 && e.getY() >= 200 && e.getY() <= 238) {
                bangBox1 = 1;
                bangBoxCounter1++;
                //JOptionPane.showMessageDialog(null, "khord ", "Game Over", JOptionPane.INFORMATION_MESSAGE);

            }
            if (e.getX() >= 200 && e.getX() <= 250 && e.getY() >= 240 && e.getY() <= 280) {
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
