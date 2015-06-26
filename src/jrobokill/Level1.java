/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Level1 extends JPanel {

    private int Xrobot = 400;
    private int Yrobot = 500;
    public static int x = 0;
    public static int y = 0;
    private Image dbImage;
    private Graphics dbg;
    private BufferedImage zamin;
    private BufferedImage robot;
    private BufferedImage Jet;
    private BufferedImage exit;
    private BufferedImage shop;
    private BufferedImage makanAval;
    private BufferedImage ChaleFaza;
    private BufferedImage Fall;
    private static int pause=0;
    public static Level2 RoboPanel2;

    public Level1() {
        setLayout(null);

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin.png");
        try {
            zamin = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
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
        //tamoom
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }

        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());

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
        Graphics g2 = (Graphics) g;

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

        //g.fillRect(0, 0, 290, 800);
        g.drawImage(robot, Xrobot, Yrobot, this);
        g.drawImage(Jet, 20, 90, this);
       

       
        
        //soghot robat dar chale
        if (Xrobot < 300) {
            g.drawImage(Fall, Xrobot, Yrobot, this);
            try {
                Thread.sleep(80);

            } catch (InterruptedException ex) {
                Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
            }
             JOptionPane.showMessageDialog(null, "You fall in a hole ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void update() throws InterruptedException {

        // debug amir:x++;
        //debug amir:y++;
        repaint();
        Thread.sleep(5);
    }

    class moving implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            int moveKey = e.getKeyCode();

            if (moveKey == KeyEvent.VK_ESCAPE) {

                System.exit(0);
            }
            //button O & P for pause and continue
             if (moveKey == KeyEvent.VK_P)
             {
                 pause=1;
                 JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
             }
             if (moveKey == KeyEvent.VK_O)
             {
                 pause=0;
                 JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
             }
            
                 if (moveKey == KeyEvent.VK_M)               
             {
                
                 Map map = new Map();
                 
               
             }
              
            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot >= 0 && pause==0) {
                    Yrobot = Yrobot - 5;
                    //agar az x,y door gozasht bere marhale 2
                if ((Xrobot > 200 && Xrobot < 600) && (Yrobot < 40)) {
                    JRoboKill.counter = 2;
                    RoboPanel2 = new Level2();
                    JRoboKill.board.remove(StartMenu.RoboPanel);
                    JRoboKill.board.add(RoboPanel2, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                    repaint();
                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot >= 0&& pause==0) {
                    Xrobot = Xrobot - 5;
                    repaint();
                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot <= 740&& pause==0) {
                    Xrobot = Xrobot + 5;
                    repaint();
                }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot <= 560&& pause==0) {
                    Yrobot = Yrobot + 5;
                    repaint();
                }
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }
}
