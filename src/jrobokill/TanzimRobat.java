/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class TanzimRobat extends JPanel {

    private BufferedImage zaminTanzim;
    private JButton ok;

    public TanzimRobat() {
        setLayout(null);

        //zamin
        URL resourceZamin = getClass().getResource("/pic/back2.png");
        try {
            zaminTanzim = ImageIO.read(resourceZamin);
        } catch (IOException e) {
            System.out.println("invalid adress zaminTanzim");
        }
       // KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new BackToPanel());
        //tamoom
      /*  ok = new JButton("Ok");
         ok.setFont(new Font("Arial", Font.BOLD, 20));
         ok.setSize(100, 100);
         ok.setLocation(300, 300);
         ok.setBackground(Color.WHITE);
         ok.setForeground(Color.BLACK);

         add(ok, BorderLayout.SOUTH);
         ok.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         if (JRoboKill.counter == 1) {
         JRoboKill.board.remove(Level1.tanzimRob1);
         JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
         JRoboKill.board.revalidate();
         }
         if (JRoboKill.counter == 2) {
         JRoboKill.board.remove(Level2.tanzimRob2);
         JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
         JRoboKill.board.revalidate();
         }

         }

         });*/
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(zaminTanzim, 0, 0, this);
    }

    /*class BackToPanel implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            int press = e.getKeyCode();
            if (press == KeyEvent.VK_W && JRoboKill.counter == 2) {
                JRoboKill.board.remove(Level2.tanzimRob2);
                JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
                JRoboKill.board.revalidate();
            }

            return false;
        }
    }*/
}
