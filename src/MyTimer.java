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

        // Adding KeyListener to Front-End.
        f.addKeyListener(this);
    }

    // Calling the printQuestion1(), and multiplying it by 60 seconds and 1000 milliseconds.
    public int useTime()
    {
        return f.printQuestion1() * 60 * 1000;
    }

    // Base code for creating the timer found at :
    // https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
    public void runTimer()
    {
        // Finding how long the timer should run for.
        time = useTime();
        Timer theTimer = new Timer();
        remainingTime = time/PERIOD;
        int timeBetween = remainingTime/2;

        theTimer.schedule(new TimerTask() {
            public void run() {

                // Printing out the time remaining.
                if (remainingTime > 0) {
                    System.out.println("Time remaining: " + remainingTime);
                    f.repaint();

                    // When the game is not being played, continue to subtract from remaining time.
                    if (!pause) {
                        remainingTime--;
                    }

                    // Else, subtract from the playtime.
                    else{
                        playTime--;
                        System.out.println(playTime);
                    }
                    if (remainingTime == timeBetween && !pause)
                    {
                        // Start the game.
                        pause = true;
                        playTime = 20;
                        f.state = 3;
                        game.startGame();
                    }

                    // Stop game.
                    if(playTime == 0){
                        pause = false;
                        f.state = 1;
                    }
                }

                // When the timer is done, print this statement.
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
        // When Enter is pressed, call the checkReady method to run timer.
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_ENTER:
                f.state = 1;
                f.repaint();
                checkReady();
        }
    }

    public static void main(String[] args)
    {
        MyTimer t = new MyTimer();
        t.f.state = 0;
        t.f.repaint();
    }
}

