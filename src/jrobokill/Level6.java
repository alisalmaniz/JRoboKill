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
 * @author Ali salmani
 */
public class Level6 extends JPanel implements Runnable {

    private BufferedImage zamin6;
    // private BufferedImage mane;
    private BufferedImage robot6;
    private Image dbImage;
    private Graphics dbg;

    public int pause6 = 0;
    //private int Level1Xrobot = 20;
    //private int Level1Yrobot = 300;
    private int Xmane = 300;
    private int Ymane = 300;
    public static Level11 RoboPanel11;
    public static Map map6;

    private boolean Robo6IsAlive;
    public static TanzimRobat tanzimRob6;

    public Level6() {
        Level1.Xrobot = 740;
        Level1.Yrobot = 300;

        setLayout(null);
        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo6IsAlive = true;

        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin6.png");
        try {
            zamin6 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
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
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(zamin6, 0, 0, this);

        g.drawImage(robot6, Level1.Xrobot, Level1.Yrobot, this);

        // g.drawImage(mane, Xmane, Ymane, this);
        for (tirCunter = 0; tirCunter < tirVector.size(); tirCunter++) {
            //System.out.println(tirVector.size());

            g2d.rotate(atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
            System.out.println(tirVector.size() + "/" + tirVector.get(tirCunter).getxMouse() + "/" + tirVector.get(tirCunter).getxTir());

            if (tirVector.get(tirCunter).getxMouse() > tirVector.get(tirCunter).getxFirstRobot()) {
                g.drawImage(T1r, (int) tirVector.get(tirCunter).getxTir(), (int) tirVector.get(tirCunter).getyTir(), this);
            } else {
                g.drawImage(T1l, (int) tirVector.get(tirCunter).getxTir(), (int) tirVector.get(tirCunter).getyTir(), this);
            }

            g2d.rotate(-atan((tirVector.get(tirCunter).getyMouse() - tirVector.get(tirCunter).getyFirstRobot()) / (tirVector.get(tirCunter).getxMouse() - tirVector.get(tirCunter).getxFirstRobot())), tirVector.get(tirCunter).getxTir(), tirVector.get(tirCunter).getyTir());
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

            if (JRoboKill.counter == 6) {
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

                if (moveKey == KeyEvent.VK_M && JRoboKill.counter == 6) {
                    map6 = new Map();

                    JRoboKill.board.remove(Level4.RoboPanel6);
                    JRoboKill.board.add(map6, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }

                if (moveKey == KeyEvent.VK_N && JRoboKill.counter == 6) {

                    //kelid baraye map robat
                    JRoboKill.board.remove(Level6.map6);
                    JRoboKill.board.add(Level4.RoboPanel6, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();

                }
                if (moveKey == KeyEvent.VK_Q && JRoboKill.counter == 6) {
                    tanzimRob6 = new TanzimRobat();

                    JRoboKill.board.remove(Level4.RoboPanel6);
                    JRoboKill.board.add(Level6.tanzimRob6, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_W && JRoboKill.counter == 6) {
                    JRoboKill.board.remove(Level6.tanzimRob6);
                    JRoboKill.board.add(Level4.RoboPanel6, BorderLayout.CENTER);
                    JRoboKill.board.revalidate();
                }
                if (moveKey == KeyEvent.VK_UP) {
                    if (Level1.Yrobot >= 0 && pause6 == 0) {
                        Level1.Yrobot = Level1.Yrobot - 5;

                    }
                }

                if (moveKey == KeyEvent.VK_LEFT) {
                    if (Level1.Xrobot >= 0 && pause6 == 0) {
                        Level1.Xrobot = Level1.Xrobot - 5;
                    }
                    if (Level1.Yrobot > 160 && Level1.Yrobot < 390 && Level1.Xrobot < 50 && JRoboKill.counter == 6) {

                        //raftan be level 11
                        JRoboKill.counter = 11;
                        RoboPanel11 = new Level11();
                        JRoboKill.board.remove(Level4.RoboPanel6);
                        JRoboKill.board.add(RoboPanel11, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();

                    }
                }

                if (moveKey == KeyEvent.VK_RIGHT) {
                    if (Level1.Xrobot <= 740 && pause6 == 0) {
                        Level1.Xrobot = Level1.Xrobot + 5;
                        if ((Level1.Yrobot > 180 && Level1.Yrobot < 380 && JRoboKill.counter == 6) && (Level1.Xrobot > 740)) {
                            //bargashtan be level 4
                            JRoboKill.counter = 4;
                            Level1.Xrobot=50;
                            Level1.Yrobot=300;
                            JRoboKill.board.remove(Level4.RoboPanel6);
                            JRoboKill.board.add(Level3.RoboPanel4, BorderLayout.CENTER);
                            JRoboKill.board.revalidate();
                            tirVector.removeAllElements();
                        }

                    }
                }
                if (moveKey == KeyEvent.VK_DOWN) {
                    if (Level1.Yrobot <= 560 && pause6 == 0) {
                        Level1.Yrobot = Level1.Yrobot + 5;

                    }

                }

            }
            //bayad ye chizi ro return kone,return false;
            return false;
        }

    }

    private class TirHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //sedaye shlik
            if (Option.OnSound) {
                URL url = getClass().getClassLoader().getResource("seda/Tir.wav");
                AudioClip clip2 = Applet.newAudioClip(url);
                clip2.loop();
            }
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
}
