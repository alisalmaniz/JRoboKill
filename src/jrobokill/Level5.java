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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

    public Level5() {

        setLayout(null);

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
        Graphics g2 = (Graphics) g;
        g.drawImage(zamin5, 0, 0, this);

        g.drawImage(robot5, Xrobot5, Yrobot5, this);

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
                pause5 = 1;
                JOptionPane.showMessageDialog(null, "Pasue", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if (moveKey == KeyEvent.VK_O) {
                pause5 = 0;
                JOptionPane.showMessageDialog(null, "continue ", "", JOptionPane.INFORMATION_MESSAGE);
            }

            if (moveKey == KeyEvent.VK_UP) {
                if (Yrobot5 >= 0 && pause5 == 0) {
                    Yrobot5 = Yrobot5 - 5;
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
                /* if ((Xrobot5 > 200 && Xrobot5 < 600 && JRoboKill.counter == 4) && (Yrobot5 > 540)) {
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
