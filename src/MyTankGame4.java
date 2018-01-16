import javax.swing.*;
public class MyTankGame4 extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyTankGame4 mytankgame1 = new MyTankGame4();
    }

    public MyTankGame4(){
        mp = new MyPanel();
        Thread t = new Thread(mp);
        t.start();
        this.add(mp);
//   注册监听
        this.addKeyListener(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}