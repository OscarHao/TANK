import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton jbtnStart = new JButton("Start");
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnhow = new JButton("How to play");
    private JLabel jlb1 = new JLabel("Tank");
    private JPanel jpn = new JPanel();
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 500, frmH = 300, screenW, screenH;
    public MainFrame() {
        init();
    }
    public void init() {
        cp=this.getContentPane();
        JPanel jp = new JPanel();
        jp.setOpaque(false);
        cp.add(jp);
        screenW = dim.width;
        screenH = dim.height;
        this.setBounds(screenW / 2 - frmW / 2, screenH / 2 - frmH, frmW, frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.setLayout(null);
        this.setResizable(false);
        jlb1.setBounds(185, 50, 225, 60);
        jlb1.setFont(new Font("標楷體", Font.BOLD, 50));
        jlb1.setForeground(new Color(3, 23, 235));
        jbtnStart.setBounds(150, 175, 70, 35);
        jbtnExit.setBounds(220, 175, 70, 35);
        jbtnhow.setBounds(290,175,70,35);
        jpn.setOpaque(false);
        cp.add(jlb1);
        cp.add(jbtnStart);
        cp.add(jbtnExit);
        cp.add(jbtnhow);

        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        jbtnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyTankGame4 mtg= new MyTankGame4();
                mtg.setVisible(true);
            }

        });
        jbtnhow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Move：↑↓←→ Shoot：Z");
            }
        });

    }



}