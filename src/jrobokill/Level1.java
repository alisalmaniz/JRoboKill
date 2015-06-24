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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
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

    public Level1() {
        setLayout(null);

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin.png");
        try {
            zamin = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }
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
     public void paint(Graphics g){
     dbImage =createImage(getWidth(),getHeight());
     dbg=dbImage.getGraphics();
     paintComponent(dbg);
     g.drawImage(dbImage, 0, 0, this);
     }
     
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics) g;
        g.drawImage(zamin, 0, 0, this);
        g.drawImage(robot, Xrobot, Yrobot, this);
        //debug amir :g.fillOval(x, y, 100, 100);

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

            if (moveKey == KeyEvent.VK_M) {
                JRoboKill.counter=2;
            }

            if (moveKey == KeyEvent.VK_UP) {
                Yrobot=Yrobot-5;
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                Xrobot=Xrobot-5;

            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                Xrobot=Xrobot+5;
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                Yrobot=Yrobot+5;
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }
}
