import ex01.Employee;

import java.util.ArrayList;

/**
 * @Author : zs.sun
 * @Date : 2018/8/7 17:54
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public class ArrayListEx {
    public static void main(String[] args)
    {
        ArrayList<Employee> list01 = new ArrayList<>(100);
        Employee e = new Employee();
        list01.add(e);

        Employee e01 = list01.get(0);

        // list01.set(1, e);
    }

}
