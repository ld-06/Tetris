import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener{
    public static boolean upPressed, downPressed, leftPressed, rightPressed, pausePressed;
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W)
        {
            upPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_S)
        {
            downPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_A)
        {
            leftPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_D)
        {
            rightPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            if(pausePressed)
            {
                pausePressed=false;
            }
            else pausePressed=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

}
