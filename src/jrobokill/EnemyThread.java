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
 * @author Ali salmani
 */
public class EnemyThread implements Runnable{

    int j;
    //int firstXEnemy;
    //int firstYEnemy;
    //int xFirstRobot;
    //int yFirstRobot;
    double xEnemy;
    double yEnemy;
    int threadNumber;
    int enemyNumber;
    
    
    public EnemyThread(int threadNumber, int enemyNumber,double xEnemy , double yEnemy) {
    
        this.xEnemy = xEnemy+10;
        this.yEnemy = yEnemy+20;
        this.threadNumber=threadNumber;
        this.enemyNumber=enemyNumber;
        
        //firstXEnemy=xEnemy+20;
        
        //firstYEnemy=xEnemy+20;
        
        j=1000;
        
        
        (new Thread(this)).start();
        
       
    }

    
    
    @Override
    public synchronized void run() {
        
        while (xEnemy!=Level1.Xrobot || yEnemy!=Level1.Yrobot) {
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TirThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(xEnemy>Level1.Xrobot){
                xEnemy--;
               
            }
            else{
                xEnemy++;
                
            }
        }
        
        
        
    }

    public int getEnemyNumber() {
        return enemyNumber;
    }

    public double getxEnemy() {
        return xEnemy;
    }

    public double getyEnemy() {
        return yEnemy;
    }
    
    
}
