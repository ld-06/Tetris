import java.awt.Color;

public class Mino_L1 extends Mino{
      public Mino_L1() {
        create(Color.ORANGE);

      }
      public void setXY(int x,int y)
      {
        // o 
        // o
        // o o
        b[0].x= x;
        b[0].y= y;
        b[1].x=x;
        b[1].y=y-30;
        b[2].x=x;
        b[2].y=y+30;
        b[3].x=x+30;
        b[3].y=y+30;

      }
}
