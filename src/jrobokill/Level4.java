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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class Level4 extends JPanel implements Runnable{
    
    private BufferedImage zamin4;
    private BufferedImage robot4;
    
    private Image dbImage;
    private Graphics dbg;
    
    public int pause4 = 0;
    private int Xrobot4 = 400;
    private int Yrobot4 = 500;
    
    private boolean Robo4IsAlive;
    
    public Level4(){
        
        setLayout(null);
        
        Robo4IsAlive=true;
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
        g.drawImage(zamin4, 0, 0, this);

        g.drawImage(robot4, Xrobot4, Yrobot4, this);
        

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
                if ((Xrobot4 > 200 && Xrobot4 < 600 && JRoboKill.counter == 4) && (Yrobot4 > 540)) {
                    JRoboKill.counter = 3;
                   
                    
                    JRoboKill.board.remove(Level3.RoboPanel4);
                    JRoboKill.board.add(Level2.RoboPanel3, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }
        
    private class TirHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}