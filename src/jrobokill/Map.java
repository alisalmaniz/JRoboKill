/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import static jrobokill.MainFrame.startmenu;
import static jrobokill.StartMenu.RoboPanel;

/**
 *
 * @author Asus
 */
public class Map extends JFrame implements ActionListener, FocusListener {

    private BufferedImage Map;
    private Image dbImage;
    private Graphics dbg;
    private JButton ok;
    private JPanel PanelMap;
    public static boolean MapORLevel = false;

    public Map() {
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Map");
        setLayout(null);
        //getContentPane().setLayout(null);
        //panel map
        PanelMap = new JPanel();
        PanelMap.setSize(500, 500);
        
        
        
        
        
        //kelid ok
       // ok.setLayout(null);
        ok = new JButton("Ok");
        ok.setFont(new Font("Arial", Font.BOLD, 20));
        ok.setSize(100, 100);
        ok.setLocation(300, 300);
        ok.setBackground(Color.WHITE);
        ok.setForeground(Color.BLACK);
        
        this.PanelMap.add(ok,BorderLayout.SOUTH);
        
        this.add(PanelMap, BorderLayout.CENTER);

        /* //action lister baraye ok
         ok.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         MapORLevel=true;
         }
         });*/
        //map
      /*  URL resourceMap = getClass().getResource("/pic/map.png");
         try {
         Map = ImageIO.read(resourceMap);
         } catch (IOException e) {
         System.out.println("invalid adress map");
         }*/
        //tnazim
        setVisible(true);

        Dimension size = new Dimension(805, 630);
        setSize(size);

    }

    public void paint(Graphics g) {
        URL sbg = getClass().getResource("/pic/map.png");
        try {
            Map = ImageIO.read(sbg);
        } catch (IOException e) {
            System.out.println("invalid adress map");
        }
     //   super.paint(g);
        g.drawImage(Map, 0, 30, null);
//            repaint();
  //      ok.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            this.dispose();
            
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
