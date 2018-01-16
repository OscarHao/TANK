import java.util.Vector;

public class EnemyTank extends Tank implements Runnable
{
    int times = 0;

    Vector<Shot> ss = new Vector<Shot>();


    public EnemyTank(int x, int y)
    {
        super(x, y);
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true)
        {
            switch(this.direct)
            {
                case 0:

                    for(int i = 0; i < 30; i++)
                    {

                        if(y>0)
                        {
                            y-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for(int i = 0; i < 30; i++)
                    {
                        if(x<400)
                        {
                            x+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for(int i = 0; i < 30; i++)
                    {
                        if(y<300)
                        {
                            y+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for(int i = 0; i < 30; i++)
                    {
                        if(x > 0)
                        {
                            x-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            this.times++;
            if(times%2==0)
            {
                if(isLive)
                {
                    if(ss.size()<5)
                    {
                        Shot s =null;
                        switch(direct)
                        { case 0:
                            s = new Shot(x+10, y, 0);
                            ss.add(s);
                            break;
                            case 1:
                                s = new Shot(x+30, y+10, 1);
                                ss.add(s);
                                break;
                            case 2:
                                s = new Shot(x+10, y+30, 2);
                                ss.add(s);
                                break;
                            case 3:
                                s = new Shot(x, y+10, 3);
                                ss.add(s);
                                break;
                        }
                        Thread t = new Thread(s);
                        t.start();

                    }
                }
            }
            this.direct = (int)(Math.random()*4);
            if(this.isLive == false)
            {
                break;
            }
        }
    }

}
