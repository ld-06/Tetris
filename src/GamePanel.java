import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
    public static final int width = 1280;
    public static final int height = 720;

    Thread gameThread;

    public final int FPS = 60;

    public PlayManager pm;

    public GamePanel() {
        this.setPreferredSize(new DimensionUIResource(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
         
        pm = new PlayManager();
    }

    @Override
    public void run() {
       double drawInterval = 1000000000/FPS;
       double delta =0;
       long lastTime = System.nanoTime();
       long currentTime;
       while(gameThread!=null)
       {
        currentTime=System.nanoTime();
        delta+=(currentTime-lastTime)/drawInterval;
        lastTime=currentTime;
        if(delta>=1)
        {
            update();
            repaint();
            delta--;
        }

       }
    }
    public void update() {
        pm.update();
    }

    public void launchGame()
    {
        gameThread = new Thread(this); 
        gameThread.start();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        pm.paintComponent(g2);
        if(pm.currentMino!=null) pm.currentMino.draw(g2);
    }
}
