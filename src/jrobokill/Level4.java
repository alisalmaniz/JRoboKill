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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Level4 extends JPanel{
    
    private BufferedImage zamin4;
    private BufferedImage robot4;
    
    private Image dbImage;
    private Graphics dbg;
    
    public int pause4 = 0;
    private int Xrobot4 = 400;
    private int Yrobot4 = 500;
    
    public Level4(){
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin4.png");
        try {
            zamin4 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot4 = ImageIO.read(resourceRobot);
        } catch (IOException e) {
            System.out.println("invalid adress Rabat");
        }

        //move
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new moving());
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
        g.drawImage(zamin4, 0, 0, this);

        g.drawImage(robot4, Xrobot4, Yrobot4, this);
        

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

            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot4 >= 0 && pause4 == 0) {
                    Yrobot4 = Yrobot4 - 5;
                    repaint();
                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot4 >= 0 && pause4 == 0) {
                    Xrobot4 = Xrobot4 - 5;
                    repaint();
                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot4 <= 740 && pause4 == 0) {
                    Xrobot4 = Xrobot4 + 5;
                    repaint();
                }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot4 <= 560 && pause4 == 0) {
                    Yrobot4 = Yrobot4 + 5;
                    repaint();
                }
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }
}
