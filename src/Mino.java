import java.awt.Color;
import java.awt.Graphics2D;

public class Mino {
    public Block b[] = new Block[4];
    public Block tempBlock[] = new Block[4];
    public int autoDropCounter=0;
    public void create(Color c) {
        for (int i = 0; i < 4; i++) {
            b[i] = new Block(c);
            tempBlock[i] = b[i];
        }
    }

    public void setXY(int x, int y) {
    }

    public void updateXY(int direction) {
    }

    public void update() {
        autoDropCounter++;
        if(autoDropCounter==60)
        {
        for(int i=0;i<4;i++)
        {
            b[i].y+=30;
        }
        autoDropCounter=0;
    }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x+2, b[0].y+2, 26, 26);
        g2.fillRect(b[1].x+2, b[1].y+2, 26, 26);
        g2.fillRect(b[2].x+2, b[2].y+2, 26, 26);
        g2.fillRect(b[3].x+2, b[3].y+2, 26, 26);
    }

}
