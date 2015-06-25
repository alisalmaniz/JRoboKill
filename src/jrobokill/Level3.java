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
public class Level3 extends JPanel {

    private BufferedImage zamin3;
    private BufferedImage robot3;
    private Image dbImage;
    private Graphics dbg;

    private BufferedImage ChaleFaza;
    private BufferedImage Fall;

    public int pause3 = 0;
    private int Xrobot3 = 400;
    private int Yrobot3 = 500;

    public Level3() {
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin.png");
        try {
            zamin3 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot3 = ImageIO.read(resourceRobot);
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
        g.drawImage(zamin3, 0, 0, this);

        g.drawImage(robot3, Xrobot3, Yrobot3, this);

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
                pause3 = 1;
                JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if (moveKey == KeyEvent.VK_O) {
                pause3 = 0;
                JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
            }

            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot3 >= 0 && pause3 == 0) {
                    Yrobot3 = Yrobot3 - 5;
                    repaint();
                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot3 >= 0 && pause3 == 0) {
                    Xrobot3 = Xrobot3 - 5;
                    repaint();
                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot3 <= 740 && pause3 == 0) {
                    Xrobot3 = Xrobot3 + 5;
                    repaint();
                }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot3 <= 560 && pause3 == 0) {
                    Yrobot3 = Yrobot3 + 5;
                    repaint();
                }
            }

            //bayad ye chizi ro return kone,return false;
            return false;

        }

    }
}
