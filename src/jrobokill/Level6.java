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
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ali salmani
 */
public class Level6 extends JPanel implements Runnable{
    private BufferedImage zamin6;
    private BufferedImage mane;
    private BufferedImage robot6;
    private Image dbImage;
    private Graphics dbg;

    public int pause6 = 0;
    private int Xrobot6 = 20;
    private int Yrobot6 = 300;
    private int Xmane = 300;
    private int Ymane = 300;

    private boolean Robo6IsAlive;
    public Level6(){
        setLayout(null);

        Robo6IsAlive = true;
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin6.png");
        try {
            zamin6 = ImageIO.read(resourceZamin);
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
            robot6 = ImageIO.read(resourceRobot);
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
        Graphics g2 = (Graphics) g;
        g.drawImage(zamin6, 0, 0, this);

        g.drawImage(robot6, Xrobot6, Yrobot6, this);
        g.drawImage(mane, Xmane,Ymane, this);
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
                pause6 = 1;
                JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if (moveKey == KeyEvent.VK_O) {
                pause6 = 0;
                JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
            }

            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot6 >= 0 && pause6 == 0) {
                    Yrobot6 = Yrobot6 - 5;
                    
                    

                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot6 >= 0 && pause6 == 0) {
                    Xrobot6 = Xrobot6 - 5;
                    

                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot6 <= 740 && pause6 == 0) {
                    Xrobot6 = Xrobot6 + 5;
                   
            }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot6 <= 560 && pause6 == 0) {
                    Yrobot6 = Yrobot6 + 5;
                    
                }
                /* if ((Xrobot6 > 200 && Xrobot6 < 600 && JRoboKill.counter == 4) && (Yrobot6 > 540)) {
                 JRoboKill.counter = 3;

                 JRoboKill.board.remove(Level3.RoboPanel4);
                 JRoboKill.board.add(Level2.RoboPanel3, BorderLayout.CENTER);
                 JRoboKill.board.revalidate();
                 }*/
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }
}
