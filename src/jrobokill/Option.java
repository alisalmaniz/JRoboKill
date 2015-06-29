/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrobokill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static jrobokill.MainFrame.startmenu;

/**
 *
 * @author Asus
 */
public class Option extends JFrame implements ActionListener {

    private JButton On, Off, Help;
    private JLabel seda;
    private BufferedImage optionPic;
    public static boolean OnSound = false;
    public static int SedaChange = 0;

    public Option() throws IOException {
        super("Option");

        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        Dimension size = new Dimension(800, 600);
        setSize(size);
        /**
         * *
         * add JLabel sounds
         */
        seda = new JLabel("Sounds :");
        seda.setLocation(300, 50);
        seda.setSize(500, 100);
        seda.setFont(new Font("Courier New", Font.BOLD, 20));
        //add(seda);
        /**
         * *
         * add JButton On for mute sounds
         */
        On = new JButton("Sound : click");
        On.setFont(new Font("Arial", Font.BOLD, 20));
        On.setSize(300, 100);
        On.setLocation(300, 100);
        On.setBackground(Color.BLACK);
        On.setForeground(Color.WHITE);
        add(On);
        On.addActionListener(this);

        /**
         * add JButton off for mute sounds
         */
        

     
        /**
         * *
         * add JButton HELP
         */
        Help = new JButton("Help");
        Help.setFont(new Font("Arial", Font.BOLD, 20));
        Help.setSize(100, 100);
        Help.setLocation(400, 300);
        Help.setBackground(Color.BLACK);
        Help.setForeground(Color.WHITE);
        add(Help);

        Help.addActionListener(this);

        Off.addActionListener(this);
        //  setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/pic/zamin2.png")))));
        // JLabel background = new JLabel(new ImageIcon("pic/zamin2.png"));
        // add(background);
        // setContentPane(new JLabel(new ImageIcon("pic\\zamin2.png")));

        //Off.addFocusListener(this);
    }

    /* public void paint(Graphics g) {
     URL sbg = getClass().getResource("/pic/option.png");
     try {
     optionPic = ImageIO.read(sbg);
     } catch (IOException e) {
     System.out.println("invalid adress option pic");
     }
     super.paint(g);
     g.drawImage(optionPic, 0, 0, null);
     //repaint();
     //On.repaint();
        

     }*/
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == On) {

            if (SedaChange == 0) {
                On.setText("Sound : On");
                OnSound = true;
                SedaChange++;
            } else {
                On.setText("Sound : Off");
                OnSound = false;
                SedaChange--;
            }

            System.out.println("dfdfdf");
        }
       
        if (e.getSource() == Help) {
            JOptionPane.showMessageDialog(null, "MOVE :Arrow Keys\nPause :P\nContinue :O"
                    + "\n" + "Map :M & N" + "\n" + "Setting :Q & W", "Help", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
