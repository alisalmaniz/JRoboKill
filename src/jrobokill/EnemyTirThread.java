/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ali salmani
 */
public class EnemyTirThread implements Runnable{

    boolean enemySmash;
    private double xEnemy;
    private double yEnemy;
    private double r;
    double xTir;
    double yTir;
    boolean runs;
    int xroboFirst;
    int yroboFirst;
    
    public EnemyTirThread(double xEnemy, double yEnemy, int xroboFirst, int yroboFirst) {
        
        this.xEnemy=xEnemy;
        this.yEnemy=yEnemy;
        this.xroboFirst =xroboFirst;
        this.yroboFirst =yroboFirst;
        r=0;
        xTir=xEnemy+10;
        yTir=yEnemy+10;
        enemySmash=false;
        runs=true;
        
        r=(xroboFirst-xTir)*(xroboFirst-xTir)+(yroboFirst-yTir)*(yroboFirst-yTir);
        (new Thread(this)).start();
    }

    
    
    @Override
    public synchronized void run() {
        
        while (runs) {
            //if(JRoboKill.counter!=1)
            //for(int j=0;j<Level2.enemyVector.size();j++){
            if(xTir>Level1.Xrobot && xTir<Level1.Xrobot+25 && yTir>Level1.Yrobot && yTir<Level1.Yrobot+35){
                runs=false;
                
                
                if(Level4.separTrue){
                    Level1.SeparJ-=10;
                    if(Level1.SeparJ==0)
                        Level4.separTrue=false;
                }
                else{
                    Level1.Health-=10;
                        if(Level1.Health==0){
                            JOptionPane.showMessageDialog(null, "Game Over ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                }
//                Level2.enemyVector.get(j).setTirs(Level2.enemyVector.get(j).getTirs()+1);
//                if(Level2.enemyVector.get(j).getTirs()>1){
//                    Level2.enemyVector.get(j).setEnemySmash(true);
//                    Level2.enemyVector.remove(j);
//                }
                
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
            
            
            if(xroboFirst>=xTir+20 ){
                
                xTir+=(double)(xroboFirst-xTir)*1000/r;
                yTir-=-(double)(yroboFirst-yTir)*1000/r;
            }
            
            else if(xroboFirst<=xTir+20){
                xTir+=(double)(xroboFirst-xTir)*1000/r;
                yTir-=-(double)(yroboFirst-yTir)*1000/r;
            }
           
            
          
        }
        
        
    }

    public void setEnemySmash(boolean enemySmash) {
        this.enemySmash = enemySmash;
    }

    public boolean getruns() {
        return runs;
    }

    public double getyEnemy() {
        return yEnemy;
    }

    public double getxEnemy() {
        return xEnemy;
    }

    public double getxTir() {
        return xTir;
    }

    public double getyTir() {
        return yTir;
    }

    public int getXroboFirst() {
        return xroboFirst;
    }

    public int getYroboFirst() {
        return yroboFirst;
    }
        
    
    
    
}
