import java.util.Vector;

public class Hero extends Tank
{
    Vector<Shot> shotsshot = new Vector<Shot>();
    Shot s = null;
    public Hero(int x, int y)
    {
        super(x, y);
    }


    public void shotEnemy()
    {

        switch(this.direct)
        {
            case 0:

                s = new Shot(x+10, y, 0);

                shotsshot.add(s);
                break;
            case 1:
                s = new Shot(x+30, y+10, 1);
                shotsshot.add(s);
                break;
            case 2:
                s = new Shot(x+10, y+30, 2);
                shotsshot.add(s);
                break;
            case 3:
                s = new Shot(x, y+10, 3);
                shotsshot.add(s);
                break;
        }
        Thread t = new Thread(s);
        t.start();
    }


    public void moveUP()
    {
        y-=speed;
    }

    public void moveRight()
    {
        x+=speed;
    }
    public void moveDown()
    {
        y+=speed;
    }
    public void moveLeft()
    {
        x-=speed;
    }
}