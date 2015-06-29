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
import javax.swing.JFrame;
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
public class Level5 extends JPanel implements Runnable {

    private BufferedImage zamin5;
    private BufferedImage robot5;
    private Image dbImage;
    private Graphics dbg;

    public int pause5 = 0;
    private int Xrobot5 = 20;
    private int Yrobot5 = 300;

    private boolean Robo5IsAlive;
    public static Level7 RoboPanel7;
    public static Level8 RoboPanel8;
    public static Level9 RoboPanel9;
    public static Map map5;
    public static TanzimRobat tanzimRob5;

    public Level5() {

        setLayout(null);

        TirHandler tirHandler = new TirHandler();
        addMouseListener(tirHandler);

        Robo5IsAlive = true;
        //zamin
        URL resourceZamin = getClass().getResource("/pic/zamin5.png");
        try {
            zamin5 = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zamin");
        }

        //tamoom
        //robot
        URL resourceRobot = getClass().getResource("/pic/robot.png");
        try {
            robot5 = ImageIO.read(resourceRobot);
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
        g.drawImage(zamin5, 0, 0, this);

        g.drawImage(robot5, Xrobot5, Yrobot5, this);

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
            
            if(JRoboKill.counter==5){

            if (moveKey == KeyEvent.VK_ESCAPE) {

                System.exit(0);
            }
            //button O & P for pause and continue
            if (moveKey == KeyEvent.VK_P) {
                pause5 = 1;
                JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if (moveKey == KeyEvent.VK_O) {
                pause5 = 0;
                JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if (moveKey == KeyEvent.VK_M && JRoboKill.counter == 5) {
                map5 = new Map();

                JRoboKill.board.remove(Level4.RoboPanel5);
                JRoboKill.board.add(map5, BorderLayout.CENTER);
                JRoboKill.board.revalidate();
            }

            if (moveKey == KeyEvent.VK_N && JRoboKill.counter == 5) {

                //kelid baraye map robat
                JRoboKill.board.remove(Level5.map5);
                JRoboKill.board.add(Level4.RoboPanel5, BorderLayout.CENTER);
                JRoboKill.board.revalidate();

            }
            if (moveKey == KeyEvent.VK_Q && JRoboKill.counter == 5) {
                tanzimRob5 = new TanzimRobat();

                JRoboKill.board.remove(Level4.RoboPanel5);
                JRoboKill.board.add(Level5.tanzimRob5, BorderLayout.CENTER);
                JRoboKill.board.revalidate();
            }
            if (moveKey == KeyEvent.VK_W && JRoboKill.counter == 5) {
                JRoboKill.board.remove(Level5.tanzimRob5);
                JRoboKill.board.add(Level4.RoboPanel5, BorderLayout.CENTER);
                JRoboKill.board.revalidate();
            }
            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot5 >= 0 && pause5 == 0) {
                    Yrobot5 = Yrobot5 - 5;
                    //raftan be level 9
                    if (Xrobot5 > 270 && Xrobot5 < 480 && Yrobot5 < 50 && JRoboKill.counter == 5) {

                        JRoboKill.counter = 9;
                        RoboPanel9 = new Level9();
                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(RoboPanel9, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    //chale ha
                    if (Xrobot5 < 250 && Yrobot5 < 150 && JRoboKill.counter == 5) {
                        System.out.println("oftad 1 ");
                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;
                        //Level1 s = new Level1();
                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    if (Xrobot5 > 500 && Yrobot5 < 150 && JRoboKill.counter == 5) {
                        System.out.println("oftad 2 ");
                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;

                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }

                }
            }

            if (moveKey == KeyEvent.VK_LEFT) {
                if (Xrobot5 >= 0 && pause5 == 0) {
                    Xrobot5 = Xrobot5 - 5;

                    //bargasht be level4
                    if ((Yrobot5 > 180 && Yrobot5 < 380 && JRoboKill.counter == 5) && (Xrobot5 < 50)) {
                        //bargashtan be level 4
                        JRoboKill.counter = 4;

                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(Level3.RoboPanel4, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                        tirVector.removeAllElements();
                    }
                    if (Xrobot5 < 250 && Yrobot5 < 150 && JRoboKill.counter == 5) {
                        System.out.println("oftad 1 ");
                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;

                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    if (Xrobot5 < 250 && Yrobot5 > 410 && JRoboKill.counter == 5) {
                        System.out.println("oftad 3 ");
                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;

                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }

                }
            }

            if (moveKey == KeyEvent.VK_RIGHT) {
                if (Xrobot5 <= 740 && pause5 == 0) {
                    Xrobot5 = Xrobot5 + 5;
                    //raftan be level 8
                    if (Yrobot5 > 170 && Yrobot5 < 390 && Xrobot5 > 720 && JRoboKill.counter == 5) {

                        JRoboKill.counter = 8;
                        RoboPanel8 = new Level8();
                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(RoboPanel8, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    if (Xrobot5 > 500 && Yrobot5 < 150 && JRoboKill.counter == 5) {
                        System.out.println("oftad 2 ");
                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;

                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    if (Xrobot5 > 500 && Yrobot5 > 410 && JRoboKill.counter == 5) {
                        System.out.println("oftad 4 ");
                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;
                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }

                }
            }
            if (moveKey == KeyEvent.VK_DOWN) {
                if (Yrobot5 <= 560 && pause5 == 0) {
                    Yrobot5 = Yrobot5 + 5;
                    //raftan be level 7
                    if (Xrobot5 > 280 && Xrobot5 < 450 && Yrobot5 > 550 && JRoboKill.counter == 5) {

                        JRoboKill.counter = 7;
                        RoboPanel7 = new Level7();
                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(RoboPanel7, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    if (Xrobot5 < 250 && Yrobot5 > 410 && JRoboKill.counter == 5) {
                        System.out.println("oftad 3 ");
                        JRoboKill.counter = 1;

                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;

                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }
                    if (Xrobot5 > 500 && Yrobot5 > 410 && JRoboKill.counter == 5) {
                        System.out.println("oftad 4 ");
                        //raftan be level 1 pas az oftadan dar chale
                        JRoboKill.counter = 1;
                        JRoboKill.board.remove(Level4.RoboPanel5);
                        JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
                        JRoboKill.board.revalidate();
                    }

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
            tirVector.add(new TirThread(Xrobot5, Yrobot5, e.getX(), e.getY(), tirCunterT));
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
