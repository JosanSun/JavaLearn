package ex02;

import ex01.Manager;

/**
 * @Author : zs.sun
 * @Date : 2018/8/7 16:18
 * @Package : ex02
 * @ProjectName: corejava
 * @Description:
 */
public class Execute extends Manager{
    double addInt;

    public Execute(String name, double salary, int year, int month, int day)
    {
        super(name, salary, year, month, day);
        setBonus(12.3);
        //addInt = getBonus();       // error
    }


}
