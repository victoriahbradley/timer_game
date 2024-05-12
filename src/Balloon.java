import javax.swing.*;
import java.awt.*;

public class Balloon {
    private Image Balloon;
    public static final int  BALLOONW = 75;
    public static final int BALLOONH = 75;
    private int BalloonX;
    private int BalloonY;
    private boolean isPopped;
    private Balloons b;
    private MyTimer back;

    Balloon(MyTimer backEnd, Balloons balls)
    {
        back = backEnd;
        b = balls;
        Balloon = new ImageIcon("images/balloon.png").getImage();
        Balloon = Balloon.getScaledInstance(120, 120,Image.SCALE_DEFAULT);
    }

    public int getBalloonX() {
        return BalloonX;
    }

    public void setBalloonX(int balloonX) {
        BalloonX = balloonX;
    }

    public int getBalloonY() {
        return BalloonY;
    }

    public Image getImage(){
        return Balloon;
    }

    public void setBalloonY(int num)
    {
        BalloonY = num;
    }

    public void setPop(boolean b)
    {
        isPopped = b;
        back.f.repaint();
    }

    public boolean isPopped() {
        return isPopped;
    }
}
