/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class TirThread implements Runnable{

    int j;
    int xRobot;
    int yRobot;
    double xMouse;
    double yMouse;
    int xFirstRobot;
    int yFirstRobot;
    int xTir;
    int yTir;
    int threadNumber;
    
    public TirThread(int xRobot, int yRobot, double xMouse,  double yMouse,int threadNumber) {
    
        this.xRobot = xRobot;
        this.yRobot = yRobot;
        this.xMouse = xMouse;
        this.yMouse = yMouse;
        this.threadNumber=threadNumber;
        
        xFirstRobot=xRobot+20;
        xTir=xRobot+20;
        yFirstRobot=yRobot+20;
        yTir=yRobot+20;
        j=1000;
        
        
        (new Thread(this)).start();
        
       
    }

    
    
    @Override
    public synchronized void run() {
        
        while (j>0) {
            
            
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(TirThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(xMouse>xRobot+20){
                
                xTir++;
            }
            else{
                xTir--;
            }
            
            
            j--;
        }
        
        //Level1.tirVector.remove(threadNumber);
        //Level1.tirCunterT--;
    }

    public double getxMouse() {
        return xMouse;
    }

    public double getyMouse() {
        return yMouse;
    }

    public int getxFirstRobot() {
        return xFirstRobot;
    }

    public int getyFirstRobot() {
        return yFirstRobot;
    }

    public int getxTir() {
        return xTir;
    }

    public int getyTir() {
        return yTir;
    }
    
    
    
}
