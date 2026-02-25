
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class PlayManager {
    public final static int width = 360;
    public final static int height = 600;
    public final int left_x;
    public final int right_x;
    public final int top_y;
    public final int bottom_y;
    public Mino currentMino;
    public final int startMino_x;
    public final int startMino_y;
    public PlayManager() {
        left_x = GamePanel.width / 2 - width / 2;
        right_x=left_x + width;
        top_y =50;
        bottom_y = top_y +height;
        currentMino = new Mino_L1();
        startMino_x = left_x+width/2-30;
        startMino_y= top_y+30;
        currentMino.setXY(startMino_x, startMino_y);
        
    }
    public void update()
    {
        if(currentMino!=null) 
        {
            currentMino.update();
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
       
    }
}
