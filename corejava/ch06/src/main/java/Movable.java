import ex01.Employee;
import org.omg.CORBA.Object;

/**
 * @Author : zs.sun
 * @Date : 2018/8/8 14:24
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public abstract interface Movable{
    void move(double x, double y);
    int getMax(int x, int y);
    final double x = 1.23;
    int x01 = 1;
}
