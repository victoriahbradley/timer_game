import java.util.TimerTask;
import java.util.Timer;

public class MyTimer
{
    public int time;
    private final int PERIOD = 1000;
    private final int DELAY = 0;
    private TimerViewer f;
    private int timeRemain;

    public MyTimer()
    {
        f = new TimerViewer(time, this);
    }
    public int useTime()
    {
        return f.printQuestion() * 60 * 1000;
    }

    public void runTimer()
    {
        Timer theTimer = new Timer();
        time = useTime();
        System.out.println(time);
        theTimer.schedule(new TimerTask() {
            int remainingTime = time/PERIOD;
            public void run()
            {
                if (remainingTime > 0)
                {
                    System.out.println("Time remaining: " + remainingTime);
                    f.repaint();
                    remainingTime--;
                }
                else
                {
                     System.out.println("Your work period is done!");
                    theTimer.cancel();
                }
            }
        }, DELAY, PERIOD);
    }
    public int getRemainingTime() {
        return remainingTime;
    }

    public String getTime()
    {
        return Integer.toString(time);
    }
    public static void main(String[] args)
    {
        MyTimer t = new MyTimer();
        t.runTimer();
    }
}

