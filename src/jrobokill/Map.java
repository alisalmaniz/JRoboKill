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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Map extends JPanel {

    private BufferedImage zaminMap;
    private JButton ok;

    public Map() {
        setLayout(null);

        //zamin
        URL resourceMap = getClass().getResource("/pic/mapLevel.png");
        try {
            zaminMap = ImageIO.read(resourceMap);
        } catch (IOException e) {
            System.out.println("invalid adress zamin Map");
        }

        //tamoom
       /* ok = new JButton("Ok");
         ok.setFont(new Font("Arial", Font.BOLD, 20));
         ok.setSize(100, 100);
         ok.setLocation(300, 300);
         ok.setBackground(Color.WHITE);
         ok.setForeground(Color.BLACK);

         add(ok);
         ok.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         if (JRoboKill.counter == 1) {
         JRoboKill.board.remove(Level1.map1);
         JRoboKill.board.add(StartMenu.RoboPanel, BorderLayout.CENTER);
         JRoboKill.board.revalidate();
         }
         if (JRoboKill.counter == 2) {
         JRoboKill.board.remove(Level2.map2);
         JRoboKill.board.add(Level1.RoboPanel2, BorderLayout.CENTER);
         JRoboKill.board.revalidate();
         }

         }

         });*/
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(zaminMap, 0, 0, this);
        if (JRoboKill.counter == 1) {
            g.setColor(Color.RED);
            g.fillOval(400, 470, 20, 20);
        }
        if (JRoboKill.counter == 2) {
            g.setColor(Color.RED);
            g.fillOval(400, 400, 20, 20);
        }
         if (JRoboKill.counter == 3) {
            g.setColor(Color.RED);
            g.fillOval(400, 300, 20, 20);
        }
         if (JRoboKill.counter == 4) {
            g.setColor(Color.RED);
            g.fillOval(400, 200, 20, 20);
        }
         if (JRoboKill.counter == 10) {
            g.setColor(Color.RED);
            g.fillOval(400, 100, 20, 20);
        }
         if (JRoboKill.counter ==5) {
            g.setColor(Color.RED);
            g.fillOval(600, 250, 20, 20);
        }
         if (JRoboKill.counter ==6) {
            g.setColor(Color.RED);
            g.fillOval(200, 200, 20, 20);
        }
         if (JRoboKill.counter ==7) {
            g.setColor(Color.RED);
            g.fillOval(600, 270, 20, 20);
        }
         if (JRoboKill.counter ==8) {
            g.setColor(Color.RED);
            g.fillOval(700, 230, 20, 20);
        }
    }
}
