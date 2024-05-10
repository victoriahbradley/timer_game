import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TimerViewer extends JFrame implements MouseListener {

        private int time;

        private MyTimer back;

        private Image timer;

        private Image end_screen;

        private Image welcome_page;

        private Image popBalloons;

        private Color yellow;

        public int state;
        private Balloons g1;
        private int balloonsLeft;


    public TimerViewer(MyTimer backend, Balloons game) {
        state = 0;

        back = backend;

        timer = new ImageIcon("images/timer.png").getImage();

        end_screen = new ImageIcon("images/end_screen.png").getImage();

        welcome_page = new ImageIcon("images/welcome_page.png").getImage();

        popBalloons = new ImageIcon("images/popBalloons.png").getImage();

        g1 = game;

        yellow = new Color(255, 222, 84);

        this.addMouseListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setTitle("Timer");

        this.setSize(800, 600);

        this.setVisible(true);
    }

        public int printQuestion1 () {
        String answer = JOptionPane.showInputDialog(null, "How long do you want to work for (minutes)?");
        return Integer.parseInt(answer);
        }

        @Override
        public void mouseClicked (MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        for (Balloon bal : g1.balloons) {
            if (mouseX < bal.getBalloonX() + bal.BALLOONW &&
                    mouseX > bal.getBalloonX() - bal.BALLOONW) {
                if (mouseY < bal.getBalloonY() + bal.BALLOONH &&
                        mouseY > bal.getBalloonY() - bal.BALLOONH) {
                    bal.setPop(true);
                    repaint();
                }
            }
        }
    }

        @Override
        public void mousePressed (MouseEvent e){

    }

        @Override
        public void mouseReleased (MouseEvent e){

    }

        @Override
        public void mouseEntered (MouseEvent e){

    }

        @Override
        public void mouseExited (MouseEvent e){

    }


        public void paint (Graphics g){
        // Painting the Background.
        clear(g);
        this.getContentPane().setBackground(Color.YELLOW);
        g.setColor(yellow);
        this.setFont(new Font("Serif", Font.PLAIN, 200));

        int timeR;

        if (state == 0) {
            System.out.println("state0");
            g.drawImage(welcome_page, 0, 0, this);
            g.drawImage(welcome_page, 0, 0, this);
        } else if (state == 1) {
            System.out.println("state1");
            g.drawImage(timer, 0, 0, this);
            timeR = back.getRemainingTime();
            //calc min and seconds here
            int sec = back.getRemainingTime() % 60;
            int min = back.getRemainingTime() / 60;
            g.drawString(String.valueOf(min), 200, 350);
            if (sec == 0) {
                g.drawString("00", 400, 350);
            } else {
                g.drawString(String.valueOf(sec), 400, 350);
            }
        } else if (state == 2) {
            System.out.println("state2");
            g.drawImage(end_screen, 0, 0, this);
        } else if (state == 3) {
            System.out.println("state3");
            g.drawImage(popBalloons, 0, 0, this);
            //draw balloons
            for (Balloon bal : g1.balloons) {
                if (!bal.isPopped())
                {
                    g.drawImage(bal.getImage(), bal.getBalloonX(), bal.getBalloonY(), this);
                }
            }
        }
    }

        public void clear (Graphics g)
        {
            g.setColor(new Color(225, 225, 225));
            g.fillRect(0, 0, 800, 600);
        }

}
