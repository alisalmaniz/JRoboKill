/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Level2 extends JPanel{
     private int xTir = 0;

    private int Xrobot2 = 400;
    private int Yrobot2 = 500;
    public static int x = 0;
    public static int y = 0;
    private int xClick = 0;
    private int yClick = 0;
    private Image dbImage;
    private Graphics dbg;
    private BufferedImage zamin2;
    private BufferedImage robot2;
    private BufferedImage Tir;

    public Level2() {
        setLayout(null);

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin2.png");
        try {
            zamin2 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
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

        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());
        //mouse action listener baraye tirandazi 
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                //  **  xClick = evt.getX();
                  // ** yClick = evt.getY();

                }
            }
        });
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
        g.drawImage(zamin2, 0, 0, this);
        g.drawImage(robot2, Xrobot2, Yrobot2, this);
      //**  g.drawImage(Tir, Xrobot2, Yrobot2, this);
       //debug amir:  g.fillOval(x, y, 100, 100);
       // ** masirTirX(Xrobot2, xClick);
        *********

    }

    public void update() throws InterruptedException {

        x++;
        y++;
        repaint();
        Thread.sleep(5);
    }

    class moving implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            int moveKey = e.getKeyCode();

            if (moveKey == KeyEvent.VK_M) {
                JRoboKill.counter = 2;
            }

            if (moveKey == KeyEvent.VK_UP) {
                Yrobot2 = Yrobot2 - 5;
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                Xrobot2 = Xrobot2 - 5;

            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                Xrobot2 = Xrobot2 + 5;
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                Yrobot2 = Yrobot2 + 5;
            }

            //return false;
            return false;

        }

    }

    public void masirTirX(int xR, int xC) {
        
        if (xR > xC) {
            
            xTir = xTir + 5;

        }
        if (xR < xC) {

            xTir = xTir - 5;

        }
    }
}
