
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

public class PlayManager {
    public final static int width = 360;
    public final static int height = 600;
    public static  int left_x;
    public static  int right_x;
    public static  int top_y;
    public static  int bottom_y;
    public Mino currentMino;
    public final int startMino_x;
    public final int startMino_y;
    
    public PlayManager() {
        left_x = GamePanel.width / 2 - width / 2;
        right_x=left_x + width;
        top_y =50;
        bottom_y = top_y +height;
        currentMino = pickMino();
        startMino_x = left_x+width/2-30;
        startMino_y= top_y+30;
        currentMino.setXY(startMino_x, startMino_y);
        
    }

    private Mino pickMino()
    {
        Mino mino =null;
        int i = new Random().nextInt(7);
        if(i==0) mino = new Mino_L1();
        else if(i==1) mino = new Mino_L2();
        else if(i==2) mino = new Mino_square();
        else if(i==3) mino = new Mino_Bar();
        else if(i==4) mino = new Mino_T();
        else if(i==5) mino = new Mino_Z1();
        else mino = new Mino_Z2();
        return mino;

    }
    public void update()
    {
        if(KeyHandler.pausePressed==false)
        {
        if(currentMino!=null) 
        {
            currentMino.update();
        }
    }
    }
    public void paintComponent(Graphics2D g2)
    {
       g2.setColor(Color.white);
       g2.setStroke(new BasicStroke(4f));
       g2.drawRect(left_x-4,top_y-4, width+8, height+8);
       int x= right_x +100;
       int y = bottom_y-200;
       g2.drawRect(x,y,200,200);
       g2.setFont(new Font("Arial",Font.PLAIN,30));
       g2.drawString("NEXT", x+60, y+60);
       g2.setColor(Color.yellow);
       g2.setFont(g2.getFont().deriveFont(50f));
       if(KeyHandler.pausePressed)
       {
        x=left_x+70;
        y=top_y+320;
        g2.drawString("Paused", x, y);
       }
       
    }
}
