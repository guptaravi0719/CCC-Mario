package gamegame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;


import javax.imageio.ImageIO;

import javax.swing.*;



    public class MarioByRavi {
    public static void main(String[] args) {

Frame frame = new JFrame("Mario Project by Ravi");
        frame.setBackground(Color.CYAN);

        frame.setResizable(false);
        frame.add(new board());

        ((JFrame) frame).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 430);


        frame.setVisible(true);
    }}

class mario {
    Random random=new Random();
    int x, xvel, yvel, y,xfirstback,xsecondback,
            yenemy1=285,yenemy2=285,yenemy3=285,yenemy4=285,yenemy5=285,yenemy6=285;
           int xenemy1= random.nextInt(5000);
   int xenemy2= 5000;
   int xenemy3= 3000;
    int xenemy4=2000;
    int xenemy5 =3500;
    int xenemy6= 7000;
    Image img2=null;
    Image imgenemy1=null;
    Image  imgenemy2=null;
    Image imgenemy3=null;
    Image imgenemy4=null;
    Image imgenemy5=null;
    Image imgenemy6=null;

    public mario() {Graphics g;
        try {
            img2 = ImageIO.read(board.class.getClassLoader().getResource("image/Zxfbi.png"));
            imgenemy1 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1.png"));
            imgenemy2 = ImageIO.read(board.class.getClassLoader().getResource("image/grub1.png"));
            imgenemy3 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy (2).png"));
            imgenemy4 = ImageIO.read(board.class.getClassLoader().getResource("image/grub1.png"));
            imgenemy5 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy (3).png"));
            imgenemy6 = ImageIO.read(board.class.getClassLoader().getResource("image/grub1 - Copy - Copy (2).png "));

        } catch (IOException ev) {
            ev.printStackTrace(); }
        x = 50;
        y = 285;
        xfirstback=0;
        xsecondback=600;

    }

    public void move() {
        y+=yvel;
        xfirstback-=xvel;
        xsecondback-=xvel;
        xenemy3=xenemy3-1;
        xenemy4=xenemy4-1;
        xenemy5=xenemy5-1;
        xenemy6=xenemy6 -1;
      xenemy1=xenemy1-1;
      xenemy2=xenemy2-1;
      if(xfirstback==0) {
          xsecondback = 600; //infinite back
      }
      if(xsecondback==0){
          xfirstback=600;
      }
      if(x==xenemy1&&y==285){
          System.out.println("GAME OVER");
          java.lang.System.exit(0);
      }
        if (x == xenemy2 && y == 285) {
            System.out.println("GAME OVER");
            java.lang.System.exit(0);
        }
        if(x==xenemy3&&y==285){
            System.out.println("GAME OVER");
            java.lang.System.exit(0);
        }
        if (x == xenemy4 && y == 285) {
            System.out.println("GAME OVER");
            java.lang.System.exit(0);
        }
        if(x==xenemy5&&y==285){
            System.out.println("GAME OVER");
          java.lang.System.exit(0);
        }
        if (x == xenemy6 && y == 285) {
            System.out.println("GAME OVER");java.lang.System.exit(0);
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key==KeyEvent.VK_SPACE)
            y=220;



        if (key == KeyEvent.VK_RIGHT){

            xvel=2;
 }}
    public void keyReleased(KeyEvent e){

        int key=e.getKeyCode();
        if(key==KeyEvent.VK_LEFT)
            xvel=0;
        if(key== KeyEvent.VK_SPACE)
            y = 285;
        if(key==KeyEvent.VK_RIGHT)
            xvel=0;
    }}


    class board  extends JPanel implements ActionListener {
    mario p  ;
    Image imgback1=null,imgback2=null;
    Timer time;


    public board() {
        addKeyListener(new for_key_methods_in_mario());
        setFocusable(true);
        p = new mario();

        try {

            imgback1 = ImageIO.read(MarioByRavi.class.getClassLoader().getResource("image/WHu9Z.png"));
            imgback2= ImageIO.read(MarioByRavi.class.getClassLoader().getResource("image/WHu9Z.png"));
        } catch (IOException ev) {
            ev.printStackTrace();
        }
       time = new Timer(5, this);
      time.start();


    }
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
          }


    public void paint(Graphics g) {

        g.drawImage(imgback1, p.xfirstback, 0, null);//make same object of graphic class only
        g.drawImage(imgback2, p.xsecondback, 0, null);
        g.drawImage(p.img2, p.x, p.y, null);
        g.drawImage(p.imgenemy1, p.xenemy1, p.yenemy1, null);
        g.drawImage(p.imgenemy2, p.xenemy2, p.yenemy2, null);
        g.drawImage(p.imgenemy3, p.xenemy3, p.yenemy3, null);
        g.drawImage(p.imgenemy4, p.xenemy4, p.yenemy4, null);
        g.drawImage(p.imgenemy5, p.xenemy5, p.yenemy5, null);
        g.drawImage(p.imgenemy6, p.xenemy6, p.yenemy6, null);

    }


    class for_key_methods_in_mario extends KeyAdapter {

          public void keyReleased(KeyEvent e){

            p.keyReleased(e);
           }
           public void keyPressed(KeyEvent e){
            p.keyPressed(e);

             }
          }

}


