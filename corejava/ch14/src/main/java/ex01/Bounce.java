package ex01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author : zs.sun
 * @Date : 2018/8/13 9:52
 * @Package : ex01
 * @ProjectName: corejava
 * @Description: Shows an animated bouncing ball
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * The frame with ball component and buttons
 */
class BounceFrame extends JFrame
{
    private BallComponent comp;
    public static final int STEPS = 2000;
    public static final int DELAY = 2;

    /**
     * Constructs the frame with the component for showing the bouncing ball
     * and Start and Close buttons
     */
    public BounceFrame()
    {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container
     * @param c the container
     * @param title the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the panel and makes it bounce 1,000 times
     */
    public void addBall()
    {
        try
        {
            Ball ball = new Ball();
            comp.add(ball);

            for (int i = 1; i <= STEPS; i++) {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        }
        catch(InterruptedException e)
        {

        }
    }
}
