import javax.swing.*;
import java.awt.*;

public class TimerViewer extends JFrame {

    private int time;

    private MyTimer back;

    private Image timer;

    private Image end_screen;

    private Image welcome_page;

    private Image popBalloons;

    private Image balloon;

    public int state;
    private PopBalloons g1;

    private int balloonX;

    private int balloonY;

    private int balloonsLeft;


    public TimerViewer(int time, MyTimer backend) {
        state = 0;

        back = backend;

        timer = new ImageIcon("images/timer.png").getImage();

        end_screen = new ImageIcon("images/end_screen").getImage();

        welcome_page = new ImageIcon("images/welcome_screen").getImage();

        popBalloons = new ImageIcon("images/popBalloons").getImage();

        balloon = new ImageIcon("images/balloon").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setTitle("Timer");

        this.setSize(800, 600);

        this.setVisible(true);
    }

    public int printQuestion1() {
        String answer = JOptionPane.showInputDialog(null, "How long do you want to work for (minutes)?");
        return Integer.parseInt(answer);
    }

    //public int printQuestion2()
    //{
    //    String answer = JOptionPane.showInputDialog(null, "How many breaks do you want (max 3)");
    //    if (Integer.parseInt(answer) > 3)
    //    {
    //        answer = "3";
    //    }
    //    return Integer.parseInt(answer);
    //}

    public void runGame1()
    {
        balloonX = 0;
        balloonY = 0;
        while (balloonsLeft != 0)
        {
            repaint();
        }

    }

    public void paint(Graphics g) {
        // Painting the Background.
        clear(g);
        this.getContentPane().setBackground(Color.WHITE);
        this.setFont(new Font("Serif", Font.PLAIN,  10));
        g.setColor(new Color(0, 0, 0));

        int timeR = back.getRemainingTime();

        if (state == 0)
        {
            g.drawImage(welcome_page, 0, 0, this);
        }
        else if (state == 1)
        {
            g.drawImage(timer, 0, 0, this);
            timeR = back.getRemainingTime();
            g.drawString(String.valueOf(timeR), 300, 400);
        }
        else if (state == 2)
        {
            g.drawImage(end_screen, 0, 0, this);
        }
        else if (state == 3)
        {
            g.drawImage(popBalloons, 0, 0, this);
        }
    }

    public void clear(Graphics g)
    {
        g.setColor(new Color(225, 225, 225));
        g.fillRect(0, 0, 800, 600);
    }

}
