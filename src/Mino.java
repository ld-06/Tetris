import java.awt.Color;
import java.awt.Graphics2D;

public class Mino {
    public Block b[] = new Block[4];
    public Block tempBlock[] = new Block[4];
    public int autoDropCounter = 0;
    public int direction = 1;
    public boolean leftCollision, rightCollision, bottomCollision;
    public boolean active = true;
    public boolean deactivating;
    int deactivateCounter=0;

    public void create(Color c) {
        for (int i = 0; i < 4; i++) {
            b[i] = new Block(c);
            tempBlock[i] = new Block(c);
        }
    }

    public void setXY(int x, int y) {
    }

    public void updateXY(int direction) {
        checkRotationCollision();
        if (leftCollision == false && rightCollision == false && bottomCollision == false) {
            this.direction = direction;
            for (int i = 0; i < 4; i++) {
                b[i].x = tempBlock[i].x;
                b[i].y = tempBlock[i].y;
            }
        }
    }

    public void update() {
        if(deactivating)
        {
            deactivating();
        }
        if (KeyHandler.upPressed) {
            if (direction == 1) {
                getDirection2();

            } else if (direction == 2) {
                getDirection3();

            } else if (direction == 3) {
                getDirection4();
            } else {
                getDirection1();
            }
            KeyHandler.upPressed = false;
        }
        checkMovementCollision();
        if (KeyHandler.downPressed) {
            if (bottomCollision == false) {
                for (int i = 0; i < 4; i++) {
                    b[i].y += 30;
                }
                autoDropCounter = 0;
            }
            KeyHandler.downPressed = false;
        }
        if (KeyHandler.leftPressed) {
            if (leftCollision == false) {
                for (int i = 0; i < 4; i++) {
                    b[i].x -= 30;
                }
            }
            KeyHandler.leftPressed = false;
        }
        if (KeyHandler.rightPressed) {

            if (rightCollision == false) {
                for (int i = 0; i < 4; i++) {
                    b[i].x += 30;
                }
            }
            KeyHandler.rightPressed = false;
        }
        if (bottomCollision) {
            deactivating=true;
        } else {
            autoDropCounter++;
            if (autoDropCounter == 60) {
                for (int i = 0; i < 4; i++) {
                    b[i].y += 30;
                }
                autoDropCounter = 0;
            }
        }

    }

    private void deactivating() {
       deactivateCounter++;
       if(deactivateCounter==45)
       {
        deactivateCounter=0;
        checkMovementCollision();
        if(bottomCollision)
        {
            active=false;
        }
       }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x + 2, b[0].y + 2, 26, 26);
        g2.fillRect(b[1].x + 2, b[1].y + 2, 26, 26);
        g2.fillRect(b[2].x + 2, b[2].y + 2, 26, 26);
        g2.fillRect(b[3].x + 2, b[3].y + 2, 26, 26);
    }

    public void getDirection1() {

    }

    public void getDirection2() {

    }

    public void getDirection3() {

    }

    public void getDirection4() {

    }

    public void checkMovementCollision() {
        leftCollision = rightCollision = bottomCollision = false;
        checkStaticBlockCollision();
        for (int i = 0; i < 4; i++) {
            if (b[i].x == PlayManager.left_x)
                leftCollision = true;
        }
        for (int i = 0; i < 4; i++) {
            if (b[i].x + 30 == PlayManager.right_x)
                rightCollision = true;
        }
        for (int i = 0; i < 4; i++) {
            if (b[i].y + 30 == PlayManager.bottom_y)
                bottomCollision = true;
        }
    }

    public void checkRotationCollision() {
        leftCollision = rightCollision = bottomCollision = false;
        checkStaticBlockCollision();
        for (int i = 0; i < 4; i++) {
            if (tempBlock[i].x < PlayManager.left_x)
                leftCollision = true;
        }
        for (int i = 0; i < 4; i++) {
            if (tempBlock[i].x + 30 > PlayManager.right_x)
                rightCollision = true;
        }
        for (int i = 0; i < 4; i++) {
            if (tempBlock[i].y + 30 > PlayManager.bottom_y)
                bottomCollision = true;
        }
    }
private  void checkStaticBlockCollision()
    {
        for(int i=0;i<PlayManager.staticBlocks.size();i++)
        {
            int targetX=PlayManager.staticBlocks.get(i).x;
            int targetY=PlayManager.staticBlocks.get(i).y;
            for(int ii=0;ii<b.length;ii++)
            {
                if(b[ii].y+30==targetY&&b[ii].x==targetX)
                {
                    bottomCollision=true;
                }
            }
            for(int ii=0;ii<b.length;ii++)
            {
                if(b[ii].x-30==targetX&&b[ii].y==targetY)
                {
                    leftCollision=true;
                }
            }
            for(int ii=0;ii<b.length;ii++)
            {
                if(b[ii].x+30==targetX&&b[ii].y==targetY)
                {
                    rightCollision=true;
                }
            }
            
        }
    }
}
