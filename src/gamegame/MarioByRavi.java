package gamegame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.applet.*;
import javax.sound.sampled.*;


import javax.imageio.ImageIO;
import javax.swing.*;


public class MarioByRavi {



    public static void main(String[] args) {

        JFrame frame = new JFrame("Mario Project by Ravi");
        frame.setBackground(Color.CYAN);
        frame.setResizable(false);
        frame.add(new board());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 430);
        frame.setVisible(true);
    }}
    class mario { 
    public static boolean condition=false, bol=true ,bol2=true;
        static boolean jump = false;
    Graphics g;
    Random random=new Random();
    int x, xvel, yvel, y, xfirstback,xsecondback, yenemy1=285, yenemy2=285,yenemy3=285,yenemy4=285,yenemy5=285,yenemy6=285,yenemy7=285,yenemy8=285;
    int score=0;
    int xenemy1= 4500+random.nextInt(5000);
    int xenemy2=8000+random.nextInt(5000);
    int xenemy3= 3100+random.nextInt(5000);
    int xenemy4=1200;
    int xenemy5 =3500;
    int xenemy6= 7000;
    int xflag=600;
    int yflag= 285;
        int xenemy7=5000;
    int xenemy8=6000;
    int xplane1=2000;
        int xplane2=15000;
        int xplane3=16000;
        int xplane4=17500;
        int xplane5=19000;
        int xplane6=16500;
        int  xplane7=19500;
        int yplane1=285;
        int yplane2=285;
        int yplane3=285;
        int yplane4=285;
        int yplane5=285;
        int yplane6=285;
        int yplane7=285;
         Image plane1=null;
         Image plane2=null;
         Image plane3=null;
         Image plane4=null;
         Image plane5=null;
         Image plane6=null;
         Image plane7=null;
         Image fire=null;


         Image img2=null;
         Image imgenemy1=null;
         Image  imgenemy2=null;
         Image imgenemy3=null;
         Image imgenemy4=null;
         Image imgenemy5=null;
         Image imgenemy6=null;
         Image imgenemy7=null;
Image  imgenemy8=null;
Image flag=null;
Image energy=null;

        public mario() {


        try {
            flag = ImageIO.read(board.class.getClassLoader().getResource("image/rez_flag.png"));
            energy= ImageIO.read(board.class.getClassLoader().getResource("image/energyf.png"));

            plane1 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy - Copy.png"));
            plane2 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy.png"));
            plane3 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy.png"));
            plane4 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy.png"));
            plane5 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy.png"));
            plane6 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy - Copy.png"));
            plane7 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy.png"));
            fire = ImageIO.read(board.class.getClassLoader().getResource("image/fire.png"));
            img2 = ImageIO.read(board.class.getClassLoader().getResource("image/Zxfbi.png"));
            imgenemy1 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemygun.png"));
            imgenemy2 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemygun.png"));
            imgenemy3 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemy.png"));
            imgenemy4 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemygun.png"));
            imgenemy5 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemygun.png"));
            imgenemy6 = ImageIO.read(board.class.getClassLoader().getResource("image/fly1 - Copy - Copy.png"));
            imgenemy6 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemygun.png "));
            imgenemy7 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemygun.png"));
            imgenemy8 = ImageIO.read(board.class.getClassLoader().getResource("image/rsz_enemygun.png"));
        } catch (IOException ev) {
            ev.printStackTrace();
        }
        x = 50;
            y = 285;
        xfirstback = 0;
        xsecondback = 600;

    }

    public void move() {


        xplane3=xplane3-1;
        xplane4=xplane4-1;
        xplane5=xplane5-1;
        xplane5=xplane5-1;
        xplane6=xplane6-1;
        xplane7=xplane7-2;
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
        URL url = this.getClass().getClassLoader().getResource("sounds/smb_gameover.wav");
        AudioInputStream audioIn = null;
        try {
            audioIn = AudioSystem.getAudioInputStream(url);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            clip.open(audioIn);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(y==220){
            yvel=+1;
        }
        if(y>=285){
            y=285;
        }




        if(x==xenemy1-5&&y==285){
            condition=true;
            bol2=false;
           clip.start();
        }

        if (x == xenemy2-5&&y==285) {
            bol2=false;
            clip.start();
            condition=true;


        }
        if(x==xenemy3-5&&y==285){
            clip.start();
            condition=true;
            bol2=false;

        }
        if (x ==xenemy4-5&&y==285) {
            clip.start();
            condition=true;
            bol2=false;
        }
        if(x==xenemy5-5&&y==285){
            clip.start();
            condition=true;
            bol2=false;
        }
        if(x==xplane1-5&&y==210){
            clip.start();
            condition=true;
            bol2=false;
        }
        if(x==xplane2&&y==200){
            clip.start();
            condition=true;
            bol2=false;
        }
        if(score>500&&score<550){

            clip.start();
        }
        if(x==xplane3&&y==285){ clip.start();
            condition=true;
            bol2=false;
        }
        if(x==xplane5&&y==285){ clip.start();
            condition=true;

        }
        if(x==xplane6&&y==285){ clip.start();
            condition=true;
            bol2=false;
        }
        if(x==xplane7&&y==285){ clip.start();
            condition=true;
            bol2=false;

        }




        if (x == xenemy6 && y == 285) { clip.start();
            condition=true;
          bol=false;
            bol2=false;

        }
        }
        public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(!jump) {

            if (key == KeyEvent.VK_SPACE) {
                URL url2 = this.getClass().getClassLoader().getResource("sounds/smb_jumpsmall.wav");
                AudioInputStream audioIn = null;
                jump = true;
                try {
                    audioIn = AudioSystem.getAudioInputStream(url2);
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Clip clip2 = null;
                try {
                    clip2 = AudioSystem.getClip();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }
                try {
                    clip2.open(audioIn);
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                clip2.start();
                yvel=-1;




                System.out.println("pressed");
            }
        }

        if (key == KeyEvent.VK_RIGHT){

             xvel=2;

 }}
    public void keyReleased(KeyEvent e){

        int key=e.getKeyCode();
        if(key==KeyEvent.VK_LEFT)
            xvel=0;
           if(key== KeyEvent.VK_SPACE){

               jump = false;
           }

            System.out.println("release");

        if(key==KeyEvent.VK_RIGHT)
            xvel=0;

    }}


    class board  extends JPanel implements ActionListener { float score=0;
    mario p  ;
    Image imgback1=null,imgback2=null;
    Timer time;

     Image over;
    public board() {
        addKeyListener(new for_key_methods_in_mario());
        setFocusable(true);
        p = new mario();

        try {
            over=ImageIO.read(MarioByRavi.class.getClassLoader().getResource("image/rsz_game-over-png-5.png"));
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
        if(p.bol2==true){
            score = (float) (score+.05);
        }
        g.setColor(Color.RED);

        g.setFont(new Font("Courier new",Font.BOLD,30));
        g.drawImage(imgback1, p.xfirstback, 0, null);//make same object of graphic class only
        g.drawImage(imgback2, p.xsecondback, 0, null);
        g.drawImage(p.img2, p.x, p.y, null);
        g.drawImage(p.imgenemy1, p.xenemy1, p.yenemy1, null);
        g.drawImage(p.imgenemy2, p.xenemy2, p.yenemy2, null);
        g.drawImage(p.imgenemy3, p.xenemy3, p.yenemy3, null);
        g.drawImage(p.imgenemy4, p.xenemy4, p.yenemy4, null);
        g.drawImage(p.imgenemy5, p.xenemy5, p.yenemy5, null);
        g.drawImage(p.imgenemy6, p.xenemy6, p.yenemy6, null);
        g.drawImage(p.imgenemy7, p.xenemy5, p.yenemy5, null);
        g.drawImage(p.plane1, p.xplane1, p.yplane1, null);
        g.drawImage(p.plane2, p.xplane2, p.yplane2, null);
        g.drawImage(p.plane3, p.xplane3, p.yplane3, null);
        g.drawImage(p.plane4, p.xplane4, p.yplane4, null);
        g.drawImage(p.plane5, p.xplane5, p.yplane5, null);
        g.drawImage(p.plane6, p.xplane6, p.yplane6, null);
        g.drawImage(p.plane7, p.xplane7, p.yplane7, null);
        g.drawImage(p.energy, 3000,285, null);
        g.drawImage(p.energy, 4500,285, null);
        g.drawImage(p.energy, 12000,285, null);
        g.drawImage(p.energy, 9000,285, null);
        g.drawImage(p.energy, 15000,285, null);
        g.drawImage(p.imgenemy7, p.xenemy5, p.yenemy5, null);
        g.drawImage(p.flag, p.xflag, p.yflag, null);
        g.drawString("score"+" "+score,5,20);
        g.setColor(Color.BLUE);

        g.setFont(new Font("Courier new",Font.BOLD,20));
        g.drawString("JUMP--SPACEBAR",150,30);

        g.drawString("MOVE--RIGHT ",380,30);
        g.setColor(Color.BLACK);

        g.setFont(new Font("Times New Roman",Font.BOLD,15));
        if(score>500&&score<600)
        {
            g.drawString("Congratulations 500+ score" ,200,100);

        }
        if(score>1000&&score<1100)
        {
            g.drawString("Congratulations 1000+ score",200,100);
        }

        if(p.condition==true) {
             g.setColor(Color.green);

             g.setFont(new Font("Courier new", Font.BOLD, 50));
             g.drawImage(imgback1, p.xfirstback, 0, null);
             g.drawImage(over, 0, 0, null);

             g.drawString("max score is" + " " + Math.round (score*100)/100, 50, 50);
  
              p.bol=false;
                          }
    }


    class for_key_methods_in_mario extends KeyAdapter {

          public void keyReleased(KeyEvent e){  // if(p.x>p.xenemy1||p.x>p.xenemy2||p.x>p.xenemy3||p.x>p.xenemy4||p.x>p.xenemy5||p.x>p.xenemy6)

            p.keyReleased(e);
           }

           public void keyPressed(KeyEvent e){

          /*   if(p.bol==true){
               score++;
             }*/
               if (p.bol2 == true) {

                   p.keyPressed(e);
               }

          }}}


