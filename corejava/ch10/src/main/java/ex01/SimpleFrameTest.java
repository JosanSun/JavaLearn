package ex01;

import sun.security.provider.PolicySpiFile;

import javax.swing.*;
import java.awt.*;

/**
 * @Author : zs.sun
 * @Date : 2018/8/12 20:02
 * @Package : ex01
 * @ProjectName: corejava
 * @Description:
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


class SimpleFrame extends JFrame
{
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}