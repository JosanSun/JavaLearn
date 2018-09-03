package ex02;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @Author : zs.sun
 * @Date : 2018/8/13 9:55
 * @Package : ex01
 * @ProjectName: corejava
 * @Description: A ball that moves and bounces off the edges of a rectangle
 */
public class Ball {
    public static final int XSIZE = 15;
    public static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * Moves the ball to the next position, reversing direction if it
     * hits one of the edges
     */
    public void move(Rectangle2D bounds)
    {
        x += dx;
        y += dy;
        if(x < bounds.getMinX())
        {
            x = bounds.getMinX();
            dx = -dx;
        }
        if(x + XSIZE >= bounds.getMaxX())
        {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if(y < bounds.getMinY())
        {
            y = bounds.getMinY();
            dy = -dy;
        }
        if(y + YSIZE >= bounds.getMaxY())
        {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * Gets the shape of the ball at its current position
     */
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
