import java.awt.Color;

public class Mino_Z1 extends Mino{
public Mino_Z1() {
    create(Color.RED);

  }

  public void setXY(int x, int y) {
    //   o
    // o o
    // o
    b[0].x = x;
    b[0].y = y;
    b[1].x = x;
    b[1].y = y - 30;
    b[2].x = x-30;
    b[2].y = y + 30;
    b[3].x = x - 30;
    b[3].y = y ;

  }

  public void getDirection1() {
    //   o
    // o o
    // o
    tempBlock[0].x = b[0].x;
    tempBlock[0].y = b[0].y;
    tempBlock[1].x = tempBlock[0].x;
    tempBlock[1].y = tempBlock[0].y - 30;
    tempBlock[2].x = tempBlock[0].x-30;
    tempBlock[2].y = tempBlock[0].y + 30;
    tempBlock[3].x = tempBlock[0].x -30;
    tempBlock[3].y = tempBlock[0].y ;
    updateXY(1);
  }

  public void getDirection2() {
    // o o
    //   o o
    // 
    tempBlock[0].x = b[0].x;
    tempBlock[0].y = b[0].y;
    tempBlock[1].x = tempBlock[0].x + 30;
    tempBlock[1].y = tempBlock[0].y;
    tempBlock[2].x = tempBlock[0].x - 30;
    tempBlock[2].y = tempBlock[0].y-30;
    tempBlock[3].x = tempBlock[0].x ;
    tempBlock[3].y = tempBlock[0].y - 30;
    updateXY(2);
  }

  public void getDirection3() {
   getDirection1();
  }

  public void getDirection4() {
   getDirection2();
  }
}
