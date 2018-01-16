public class Tank
{

    int x = 0;

    int y = 0;


    int direct = 0;

    int speed = 1;

    int Color;
    boolean isLive = true;

    public int getColor() {
        return Color;
    }
    public void setColor(int color) {
        Color = color;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getDirect() {
        return direct;
    }
    public void setDirect(int direct) {
        this.direct = direct;
    }
    public Tank(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}