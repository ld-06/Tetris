import java.awt.Color;

public class Mino_square extends Mino{
public Mino_square() {
        create(Color.yellow);
    }

    public void setXY(int x, int y) {
        // o o
        // o o
        //
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x-30;
        b[1].y = b[0].y - 30;
        b[2].x = b[0].x ;
        b[2].y = b[0].y-30;
        b[3].x = b[0].x -30;
        b[3].y = b[0].y;
    }

    public void getDirection1() { }
    public void getDirection2() { }
    public void getDirection3() { }
    public void getDirection4() { }
}
