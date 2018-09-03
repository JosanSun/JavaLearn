/**
 * @Author : zs.sun
 * @Date : 2018/8/7 19:23
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
import

public class ArgsVar {

    public static void main(String[] args)
    {
        double[] dNums = new double[10];
        for(int i = 0; i < dNums.length; ++i)
        {
            dNums[i] = 125.5 + i;
        }

        System.out.println(max(dNums[0], dNums[1], dNums[2]));
        System.out.println(max(dNums[0]));
    }


    public static double max(double... values)
    {
        double largest = Double.NEGATIVE_INFINITY;
        for(double v: values)
        {
            if(v > largest)
            {
                largest = v;
            }
        }
        return largest;
    }
}

