/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.applet.Applet;
import java.applet.AudioClip;
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
public class Level10 extends JPanel implements Runnable {

    private BufferedImage zamin10;
    private BufferedImage mane;
    private BufferedImage robot10;
    private Image dbImage;
    private Graphics dbg;
    public int pause10 = 0;
    private boolean Robo10IsAlive;
    private int Xmane = 300;
    private int Ymane = 300;

    public Level10() {
        Level1.Xrobot = 450;
        Level1.Yrobot = 30;

        setLayout(null);
        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo10IsAlive = true;

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin10.png");
        try {
            zamin10 = ImageIO.read(resourceZamin);
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
            robot10 = ImageIO.read(resourceRobot);
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
        g.drawImage(zamin10, 0, 0, this);

        g.drawImage(robot10, Level1.Xrobot, Level1.Yrobot, this);
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
            //sedaye shlik
            URL url = getClass().getClassLoader().getResource("seda/Tir.wav");
            AudioClip clip2 = Applet.newAudioClip(url);
            clip2.loop();
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

            if (JRoboKill.counter == 8) {
                if (moveKey == KeyEvent.VK_ESCAPE) {

                    System.exit(0);
                }
                //button O & P for pause and continue
                if (moveKey == KeyEvent.VK_P) {
                    pause10 = 1;
                    JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
                }
                if (moveKey == KeyEvent.VK_O) {
                    pause10 = 0;
                    JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
                }

                if (moveKey == KeyEvent.VK_UP) {
                    if (Level1.Yrobot >= 0 && pause10 == 0) {
                        Level1.Yrobot = Level1.Yrobot - 5;

                    }
                }

                if (moveKey == KeyEvent.VK_LEFT) {
                    if (Level1.Xrobot >= 0 && pause10 == 0) {
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
                    if (Level1.Xrobot <= 740 && pause10 == 0) {
                        Level1.Xrobot = Level1.Xrobot + 5;

                    }
                }
                if (moveKey == KeyEvent.VK_DOWN) {
                    if (Level1.Yrobot <= 560 && pause10 == 0) {
                        Level1.Yrobot = Level1.Yrobot + 5;

                    }

                }

            }
            //bayad ye chizi ro return kone,return false;
            return false;
        }

    }
}
