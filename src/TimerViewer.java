import javax.swing.*;
import java.awt.*;

public class TimerViewer extends JFrame {
    private int time;
    private MyTimer back;
    public TimerViewer(int time, MyTimer backend) {
        back = backend;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Timer");
        this.setSize(800, 600);
        this.setVisible(true);
    }

    public int printQuestion() {
        String answer = JOptionPane.showInputDialog(null, "How long do you want to work for (minutes)?");
        return Integer.parseInt(answer);
    }

    public void paint(Graphics g) {
        // Painting the Background.
        this.getContentPane().setBackground(Color.WHITE);
        this.setFont(new Font("Serif", Font.PLAIN,  100));
        g.setColor(new Color(0, 0, 0));

        while (time != 0)
        {
            int currentTime = time;
            if (currentTime == time) {
                g.drawString(String.valueOf(time), 300, 400);
            }
            else if (back.getRemainingTime() != 0)
            {
                g.drawString(String.valueOf(back.getRemainingTime()), 300, 400);
            }
        }
        g.drawString("You're work period is complete", 300, 400);
    }
}
