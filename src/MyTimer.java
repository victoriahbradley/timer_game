import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Timer;


public class MyTimer
{
    public int time;
    private final int PERIOD = 1000;
    private final int DELAY = 0;
    private TimerViewer f;
    private KeyListener k;
    private int remainingTime;
    public MyTimer()
    {
        f = new TimerViewer(time, this);
    }
    public int useTime()
    {
        return f.printQuestion1() * 60 * 1000;
    }

    public void runTimer()
    {
        time = useTime();
        //int breaks = f.printQuestion2();
        //int timeBetween = time/breaks;
        Timer theTimer = new Timer();
        System.out.println(time);
        remainingTime = time/PERIOD;
        theTimer.schedule(new TimerTask() {
            public void run() {
                if (remainingTime > 0) {
                    //if (remainingTime%timeBetween == 0)
                    //{

                    //}
                    f.state++;
                    System.out.println("Time remaining: " + remainingTime);
                    f.repaint();
                    remainingTime--;
                }
                else
                {
                     System.out.println("Your work period is done!");
                     f.repaint();
                    theTimer.cancel();
                }
            }
        }, DELAY, PERIOD);
    }
    public int getRemainingTime() {
        return remainingTime;
    }

    public boolean checkReady()
    {
        while (f.state == 0)
        {
            if (f.state > 0)
            {
                return true;
            }
        }
        return false;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // The keyCode lets you know which key was pressed
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_ENTER:
                f.state++;
                return;
        }
        f.repaint();
    }
    public String getTime()
    {
        return Integer.toString(time);
    }
    public static void main(String[] args)
    {
        MyTimer t = new MyTimer();
        if (t.checkReady()) {
            t.runTimer();
        }
    }
}

