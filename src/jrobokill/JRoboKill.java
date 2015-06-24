/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Ali salmani
 */
public class JRoboKill {

    /**
     * @param args the command line arguments
     */
    public static int counter = 1;
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
                // TODO code application logic here
        JFrame board = new JFrame();
        
        // new karadn naghshe ha va start menu
        
        Level1 RoboPanel = new Level1();
        Level2 RoboPanel2 = new Level2();
        StartMenu startmenu =new StartMenu();
        
        //tanzim jframe
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
        board.setExtendedState(JFrame.MAXIMIZED_BOTH);
        board.setResizable(false);
        Dimension size = new Dimension(805, 635);
        board.setSize(size);
        
        board.add(RoboPanel, BorderLayout.CENTER);
        
        //agar start ro az toye "start menu" zad bazi shoroa she.
        
       // if(startmenu.GoToGame==true)
            //khali
            
        //tanzim jframe -->tamam
        while (true) {
            // if counter===1 tani toye marhale 1 hast.
            if (counter == 1) {
                
                RoboPanel.update();
            } else {
                break;
            }
        }
        //if counter ==2 bood panel avali ro hazf kon va dovomi ro ezafe kon
        if (counter == 2) {
                board.remove(RoboPanel);
                
                board.add(RoboPanel2, BorderLayout.CENTER);
                board.revalidate();
                
                //tamoom
            }
        while (true) {
            if (counter == 2) {
               
                RoboPanel2.update();

            } else {
                break;
            }
        }

    }
    }
    

