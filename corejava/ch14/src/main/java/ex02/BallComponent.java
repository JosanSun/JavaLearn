package ex02;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @Author : zs.sun
 * @Date : 2018/8/13 9:56
 * @Package : ex01
 * @ProjectName: corejava
 * @Description: The component that draws the balls.
 */
public class BallComponent extends JPanel{
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    /**
     * Add a ball to the component
     * @param b the ball to add
     */
    public void add(Ball b)
    {
        balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // erase background
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls)
        {
            g2.fill(b.getShape());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
