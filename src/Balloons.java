import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Balloons
{
    private MyTimer back;
    public ArrayList<Balloon> balloons = new ArrayList<Balloon>();

    public Balloons(MyTimer bb)
    {
        back = bb;
    }

    public void startGame()
    {
        for (int i = 0; i < 40; i++)
        {
            Balloon b = new Balloon(back, this);
            b.setBalloonX((int) (Math.random() * 800));
            b.setBalloonY((int)(Math.random() * 550));
            balloons.add(b);
        }
    }
}
