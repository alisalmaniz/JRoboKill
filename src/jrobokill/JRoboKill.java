/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static JFrame board;
    public static StartMenu startmenu;
    public static void main(String[] args) throws InterruptedException {
        
        // TODO code application logic here
         board = new JFrame();

        // new karadn naghshe ha va start menu
        
        startmenu = new StartMenu();

        //tanzim jframe
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
        board.setExtendedState(JFrame.MAXIMIZED_BOTH);
        board.setResizable(false);
        Dimension size = new Dimension(805, 635);
        board.setSize(size);
        //amir:add kardan start menu be Jfram
        board.add(startmenu, BorderLayout.CENTER);
       
        
        //agar start ro az toye "start menu" zad bazi shoroa she.
       /*oon teke code k avaz shod ,hala goftam haminjori bashe inja shayahd be kar biad
        mokhlesim!!!!!!!!! amir.
        : while(true){
            
        if (startmenu.GoToGame == true) {
            System.out.println("debug amir: raft toye if.");
            //amir: age karbar start ro zad 
            //panel start ro hazfesh kon va panel level 1 ro bezar
            //hazfe panel start:
            board.remove(startmenu);
            board.add(RoboPanel, BorderLayout.CENTER);
            board.revalidate();
                //tamom

            //tanzim jframe -->tamam
            while (true) {
                // if counter===1 yani toye marhale 1 hast.
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
    }*/
    }
}
