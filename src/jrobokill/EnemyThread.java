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


    //int firstXEnemy;
    //int firstYEnemy;
    //int xFirstRobot;
    //int yFirstRobot;
    double xEnemy;
    double yEnemy;
    int threadNumber;
    int enemyNumber;
    double r;
    Boolean enemySmash;
    
    
    public EnemyThread(int threadNumber, int enemyNumber,double xEnemy , double yEnemy) {
    
        this.xEnemy = xEnemy+10;
        this.yEnemy = yEnemy+20;
        this.threadNumber=threadNumber;
        this.enemyNumber=enemyNumber;
        enemySmash=false;
        
        //firstXEnemy=xEnemy+20;
        
        //firstYEnemy=xEnemy+20;
        
        
        
        (new Thread(this)).start();
        
       
    }

    
    
    @Override
    public synchronized void run() {
        
        
        
        while (!enemySmash && !(xEnemy>=Level1.Xrobot-10 && yEnemy>=Level1.Yrobot-10 && xEnemy<=Level1.Xrobot+40 && yEnemy<=Level1.Yrobot+40)) {
            
            
            
            
            r=(yEnemy-Level1.Yrobot)*(yEnemy-Level1.Yrobot)+(xEnemy-Level1.Xrobot)*(xEnemy-Level1.Xrobot);
            try {
                
               if(r>200000)
               Thread.sleep(50);
               else if(r>10000)
                   Thread.sleep(30);
               else if(r>3000)
                   Thread.sleep(20);
               else if(r>1000)
                   Thread.sleep(12);
               else
                   Thread.sleep(5);
               /*
                else if(r>160000)
                Thread.sleep(800000/(int)r);
                else if(r>30000)
                Thread.sleep(500000/(int)r);
                else if(r>10000)
                Thread.sleep(400000/(int)r);
                else
                Thread.sleep(200000/(int)r);
                 */
            } catch (InterruptedException ex) {
                Logger.getLogger(TirThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
                xEnemy-=(double)(xEnemy-Level1.Xrobot)/100;
                yEnemy-=(double)(yEnemy-Level1.Yrobot)/100;
           
            
                
            
           
            
    
        }
        
        enemySmash = true;
        
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

    public Boolean getEnemySmash() {
        return enemySmash;
    }

    public void setEnemySmash(Boolean enemySmash) {
        this.enemySmash = enemySmash;
    }
    
    
}
