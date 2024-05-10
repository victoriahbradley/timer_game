import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyStore;
import java.util.TimerTask;
import java.util.Timer;


public class MyTimer implements KeyListener
{
    public int time;
    private final int PERIOD = 1000;
    private final int DELAY = 0;
    public TimerViewer f;
    private int remainingTime;

    private boolean pause = false;
    private int playTime = 0;

    private Balloons game;
    public MyTimer()
    {
        game = new Balloons(this);
        f = new TimerViewer(this, game);
        f.addKeyListener(this);
    }
    public int useTime()
    {
        return f.printQuestion1() * 60 * 1000;
    }

    public void runTimer()
    {
        time = useTime();
        Timer theTimer = new Timer();
        remainingTime = time/PERIOD;
        int timeBetween = remainingTime/2;

        theTimer.schedule(new TimerTask() {
            public void run() {
                if (remainingTime > 0) {
                    System.out.println("Time remaining: " + remainingTime);
                    f.repaint();
                    if (!pause) {
                        remainingTime--;
                    }
                    else{
                        playTime--;
                        System.out.println(playTime);
                    }
                    if (remainingTime == timeBetween && !pause)
                    {
                        //start the game
                        pause = true;
                        playTime = 20;
                        f.state = 3;
                        game.startGame();
                    }
                    if(playTime == 0){ //stop game
                        pause = false;
                        f.state = 1;
                    }
                }
                else
                {
                     System.out.println("Your work period is done!");
                     f.state = 2;
                     f.repaint();
                    theTimer.cancel();
                }
            }
        }, DELAY, PERIOD);
    }
    public int getRemainingTime() {
        return remainingTime;
    }

    public void checkReady()
    {
        if (f.state == 1)
        {
            runTimer();
        }
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
                f.state = 1;
                f.repaint();
                checkReady();
        }
    }
    public String getTime()
    {
        return Integer.toString(time);
    }

    public static void main(String[] args)
    {
        MyTimer t = new MyTimer();
        t.f.state = 0;
        t.f.repaint();
    }
}

