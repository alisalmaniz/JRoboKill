/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ComponentEvent;
import java.net.URL;
import javax.swing.JFrame;
import static jrobokill.JRoboKill.board;

/**
 *
 * @author Asus
 */
public class MainFrame extends JFrame {

    public static StartMenu startmenu;

    public MainFrame() {
        super("JRoboKill");

        startmenu = new StartMenu(this);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        Dimension size = new Dimension(805, 635);
        setSize(size);
        //amir:add kardan start menu be Jfram
        add(startmenu, BorderLayout.CENTER);
        

            

    }

    @Override
    protected void processComponentEvent(ComponentEvent e) {
        System.out.println("p");
        if (e.getID() == 01) {
            System.out.println("wov");
            Level1 level1 = new Level1();
            this.remove(startmenu);
            this.add(level1, BorderLayout.CENTER);
            repaint();

        }

        super.processComponentEvent(e); //To change body of generated methods, choose Tools | Templates.
    }

}
