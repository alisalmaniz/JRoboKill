/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import static jrobokill.JRoboKill.board;

/**
 *
 * @author Asus
 */
public class MainFrame extends JFrame{

    public static StartMenu startmenu;
    
    public MainFrame() {
        super("JRoboKill");
        
            startmenu = new StartMenu();
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
    
    
}
