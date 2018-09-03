/**
 * @Author : zs.sun
 * @Date : 2018/8/6 17:31
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description: 初始化块的使用
 */

import LogEx;

public class Employee {
    public static int nextId;

    private int id;
    private String name;
    private double salary;

    {
        //id = nextId;
        ++nextId;
        System.out.println("This is called in the block");
    }

    static// object initilization block
    {
        //id = nextId;     // error  对于static的初始化块，必须使用static成员
        ++nextId;
        System.out.println("This is called in the static block");
    }

    static// object initilization block
    {
        //id = nextId;     // error  对于static的初始化块，必须使用static成员
        ++nextId;
        System.out.println("This is called in the static block02");
    }

    {
        //id = nextId;
        ++nextId;
        System.out.println("This is called in the block02");
    }

    public Employee(String n, double s)
    {
        name = n;
        salary = s;
        System.out.println("Employee(String, double)");
    }

    public Employee()
    {
        name = "";
        salary = 0;
        System.out.println("Employee()");
    }

    public static void main(String[] args)
    {
//        System.out.println(Employee.nextId);
//        Employee s1 = new Employee();
//        System.out.println(Employee.nextId);
//        Employee s2 = new Employee("Josan", 120.0);
//        System.out.println(Employee.nextId);

    }
}

/**
 * 1. 就算没有调用任何Employee的变量，静态初始化块都会被执行。
 */
