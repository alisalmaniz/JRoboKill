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
import java.net.URL;
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
    public static MainFrame board;
   // private URL url;

    public static void main(String[] args) throws InterruptedException {

        // TODO code application logic here
        board = new MainFrame();

        
        // new karadn naghshe ha va start menu

        //tanzim jframe
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
