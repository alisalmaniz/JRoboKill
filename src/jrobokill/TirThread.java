/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class TirThread implements Runnable{

   
    int xRobot;
    int yRobot;
    double xMouse;
    double yMouse;
    int xFirstRobot;
    int yFirstRobot;
    double xTir;
    double yTir;
    int threadNumber;
    double degree;
    double r;
    boolean runs;
    
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
        runs=true;
        
        degree=-atan((yMouse-yFirstRobot)/(xMouse-xFirstRobot));
        
        r=(yMouse-yFirstRobot)*(yMouse-yFirstRobot)+(xMouse-xFirstRobot)*(xMouse-xFirstRobot);
        
        System.out.println(1.23/2);
        
        
        (new Thread(this)).start();
        
        
    }

    
    
    @Override
    public synchronized void run() {
        
        
        
        
        while (runs) {
            if(JRoboKill.counter!=1)
            for(int j=0;j<Level2.enemyVector.size();j++){
            if(xTir>Level2.enemyVector.get(j).getxEnemy() && xTir<Level2.enemyVector.get(j).getxEnemy()+25 && yTir>Level2.enemyVector.get(j).getyEnemy() && yTir<Level2.enemyVector.get(j).getyEnemy()+35){
                runs=false;
                Level2.enemyVector.get(j).setTirs(Level2.enemyVector.get(j).getTirs()+1);
                if(Level2.enemyVector.get(j).getTirs()>1){
                    Level2.enemyVector.get(j).setEnemySmash(true);
                    Level2.enemyVector.remove(j);
                }
                
            }
        }
            
            try {

                
                if(r>360000)
                    Thread.sleep(1000000/(int)r);
                else if(r>160000)
                    Thread.sleep(800000/(int)r);
                else if(r>30000)
                    Thread.sleep(500000/(int)r);
                else if(r>10000)
                    Thread.sleep(400000/(int)r);
                else if(r>1000)
                    Thread.sleep(200000/(int)r);
                else if(r>100)
                    Thread.sleep(1000/(int)r);
                else
                    Thread.sleep(0);
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(TirThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            if(r<1000)
                r=1000*r;
            
            if(r<100)
                r=100;
            
            System.out.println(xMouse-xFirstRobot);
            if(xMouse>=xRobot+20 ){
                
                xTir+=(double)(xMouse-xFirstRobot)*1000/r;
                yTir-=-(double)(yMouse-yFirstRobot)*1000/r;
            }
            
            else if(xMouse<=xRobot+20){
                xTir+=(double)(xMouse-xFirstRobot)*1000/r;
                yTir-=-(double)(yMouse-yFirstRobot)*1000/r;
            }
           
            
          
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

    public double getxTir() {
        return xTir;
    }

    public double getyTir() {
        return yTir;
    }
    
     public boolean getruns() {
        return runs;
    }
    
}
