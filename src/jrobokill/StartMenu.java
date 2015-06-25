/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static jrobokill.JRoboKill.counter;
import static jrobokill.JRoboKill.startmenu;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Asus
 */
public class StartMenu extends JPanel {

    private JButton Start;
    private JButton option;
    private JButton exit;
    public static Level1 RoboPanel;
    private BufferedImage PicStart;

    public static boolean GoToGame = false;

    public StartMenu() {
        setLayout(null);

        //zamin
        URL resourcePicStart = getClass().getResource("/pic/start.jpg");
        try {
            PicStart = ImageIO.read(resourcePicStart);
        } catch (IOException e) {
            System.out.println("invalid adress pic start");
        }
        //tamom

        //kelid start
        Start = new JButton("Start");
        Start.setFont(new Font("Arial", Font.BOLD, 20));
        Start.setSize(100, 100);
        Start.setLocation(300, 300);
        Start.setBackground(Color.BLACK);
        Start.setForeground(Color.WHITE);
        add(Start);
        //tamom
        //kelid option
        option = new JButton("Option");
        option.setFont(new Font("Arial", Font.BOLD, 20));
        option.setSize(100, 100);
        option.setLocation(400, 300);
        option.setBackground(Color.BLACK);
        option.setForeground(Color.WHITE);
        add(option);
        //tamom
        //kelid exit
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setSize(100, 100);
        exit.setLocation(500, 300);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        add(exit);
        //tamom
        //action listener for option
        option.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*    URL url = getClass().getClassLoader().getResource("/seda/seda11.wav");
                
                 AudioClip clip2 = Applet.newAudioClip(url);
                 clip2.loop();
                 System.out.println("debug amir: option shod");*/
                AudioPlayer myBackgroundPlayer = AudioPlayer.player;

                ContinuousAudioDataStream myLoop = null;
                //use a try block in case the file doesn't exist.
                try {
                    AudioStream myBackgroundMusic
                            = new AudioStream(new FileInputStream(new File(getClass().getResource("j.wav").toURI())));
                    AudioData myData = myBackgroundMusic.getData();
                    myLoop = new ContinuousAudioDataStream(myData);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Invalid file!");
                }

                // play background music.
                myBackgroundPlayer.start(myLoop);
            }
        });
        //tamom
        //action listener for exit
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                System.out.println("debug amir: exit shod");
            }
        });
        //tamom
        //action listener for start 
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //GoToGame = true;
                // System.out.println("debug amir: start zade shod" + GoToGame);

                //new kardan level ha
                RoboPanel = new Level1();

                //tamam
                JRoboKill.board.remove(startmenu);
                JRoboKill.board.add(RoboPanel, BorderLayout.CENTER);
                JRoboKill.board.revalidate();
                //
                System.out.println("debug amir: 123");

            }
        });
        //tamoom

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics) g;
        g.drawImage(PicStart, 0, 0, this);

        //debug amir :g.fillOval(x, y, 100, 100);
    }
}
