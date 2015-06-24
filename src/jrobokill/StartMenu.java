/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class StartMenu extends JPanel {
        private JButton Start;
    private JButton option;
    private JButton exit;
    public boolean GoToGame =false;

    public StartMenu() {
        setLayout(null);

        //kelid start
        Start = new JButton("Start");
        Start.setFont(new Font("Arial", Font.BOLD, 20));
        Start.setSize(100, 100);
        Start.setLocation(860, 800);
        Start.setBackground(Color.BLACK);
        Start.setForeground(Color.WHITE);
         add(Start);
         //tamom
         
        //action listener for start 
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              GoToGame =true;
               
            }
        });
        //tamoom
       
    }
}
