import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

class MyPanel extends JPanel implements KeyListener,Runnable{

    Hero hero = null;
    Vector<EnemyTank> ets = new Vector<EnemyTank>();
    Vector<Bomb> bombs = new Vector<Bomb>();

    int enSize = 3;

    public MyPanel(){
        hero = new Hero(100,100);

        for(int i = 0; i <enSize; i++)
        {
            EnemyTank et = new EnemyTank((i+1)*50, 0);
            et.setColor(0);
            et.setDirect(2);
            Thread t = new Thread(et);
            t.start();
            Shot s = new Shot(et.x+10,et.y+30,2);
            et.ss.add(s);
            Thread t2 = new Thread(s);
            t2.start();
            ets.add(et);
        }

    }


    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0, 0, 400, 300);
        if(hero.isLive==true)
        {
            this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);
        }


        for(int i = 0; i <hero.shotsshot.size(); i++)
        {
            Shot myShot = hero.shotsshot.get(i);
            if(myShot!=null&&myShot.isLive==true)
            {
                g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
            }
            if(myShot.isLive==false)
            {

                hero.shotsshot.remove(myShot);
            }
        }


        for(int i = 0; i < bombs.size();i++)
        {
            Bomb b = bombs.get(i);
            if(b.life > 6)
            {

                b.lifeDown();
            }

            if(b.life == 0)
            {
                bombs.remove(b);
            }
        }


        for(int i = 0 ; i < ets.size(); i++)
        {
            EnemyTank et = ets.get(i);
            if(et.isLive)
            {
                this.drawTank(et.getX(), et.getY(), g,et.getDirect(), 0);
                for(int j = 0; j < et.ss.size();j++)
                {
                    Shot enemyShot = et.ss.get(j);
                    if(enemyShot.isLive)
                    {
                        g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
                    }else{

                        et.ss.remove(enemyShot);
                    }

                }
            }
        }
    }

    public void hitMe()
    {

        for(int i = 0; i < this.ets.size(); i++)
        {
            EnemyTank et = ets.get(i);
            if(et.isLive==true)
            {
                for(int j = 0; j < et.ss.size(); j++)
                {

                    Shot enemyShot = et.ss.get(j);
                    if(enemyShot.isLive==true)
                    {
                        this.hitTank(enemyShot, hero);
                    }
                }
            }
        }
    }

    public void hitEnemyTank()
    {
        for(int i = 0; i < hero.shotsshot.size(); i++)
        {
            Shot myShot = hero.shotsshot.get(i);

            if(myShot.isLive==true)
            {

                for(int j = 0; j < ets.size(); j++)
                {
                    EnemyTank et = ets.get(j);
                    if(et.isLive==true)
                    {
                        this.hitTank(myShot,et);
                    }
                }
            }
        }
    }

    public void hitTank(Shot s, Tank et)
    {

        switch(et.direct)
        {
            case 0:
            case 2:
                if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
                {
                    s.isLive = false;
                    et.isLive = false;
                    Bomb b = new Bomb(et.x, et.y);
                    bombs.add(b);
                }
            case 1:
            case 3:
                if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
                {
                    {

                        s.isLive = false;
                        et.isLive = false;
                        Bomb b = new Bomb(et.x, et.y);
                        bombs.add(b);
                    }
                }
        }
    }

    public void drawTank(int x , int y, Graphics g, int direct, int type)
    {
        switch(type)
        {
            case 0:
                g.setColor(Color.gray);
                break;
            case 1:
                g.setColor(Color.green);
                break;
        }
        switch(direct)
        {

            case 0:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x+15, y, 5, 30, false);
                g.fill3DRect(x+5, y+5, 10, 20, false);
                g.fillOval(x+5, y+10, 10, 30);
                g.drawLine(x+10, y+15, x+10, y);
                break;
            case 1:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y+15, 30, 5, false);
                g.fill3DRect(x+5, y+5, 20, 10, false);
                g.fillOval(x+10, y+5, 10, 30);
                g.drawLine(x+15, y+10, x+30, y+10);
                break;
            case 2:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x+15, y, 5, 30, false);
                g.fill3DRect(x+5, y+5, 10, 20, false);
                g.fillOval(x+5, y+10, 10, 30);
                g.drawLine(x+10, y+15, x+10, y+30);
                break;
            case 3:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y+15, 30, 5, false);
                g.fill3DRect(x+5, y+5, 20, 10, false);
                g.fillOval(x+10, y+5, 10, 30);
                g.drawLine(x+15, y+10, x, y+10);
                break;

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            this.hero.setDirect(0);
            this.hero.moveUP();
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            this.hero.setDirect(1);
            this.hero.moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            this.hero.setDirect(2);
            this.hero.moveDown();
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            this.hero.setDirect(3);
            this.hero.moveLeft();
        }

        if(e.getKeyCode()==KeyEvent.VK_Z)
        {

            if(this.hero.shotsshot.size()<=4&&this.hero.isLive==true)
            {
                this.hero.shotEnemy();
            }
        }


        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void run(){
        while(true)
        {
            try{
                Thread.sleep(100);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            this.hitEnemyTank();

            this.hitMe();

            this.repaint();

        }
    }
}
