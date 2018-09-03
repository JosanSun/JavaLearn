package ex01;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @Author : zs.sun
 * @Date : 2018/8/7 11:14
 * @Package : ex01
 * @ProjectName: corejava
 * @Description:
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;           // java8

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public Employee()
    {
        name = "Josan";
        salary = 1500;
        hireDay = LocalDate.of(2000, 1, 1);
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        // a quick test to see if the objects are identical
        if(this == otherObject)
        {
            return true;
        }

        // must return false if the explicit parameter is null
        if(null == otherObject)
        {
            return false;
        }

        // if the classes don't match, they can't be equal
        if(getClass() != otherObject.getClass())
        {
            return false;
        }

        // now we know otherObject is a non-null Employee
        Employee other = (Employee) otherObject;

//        // test whether the fields have identical values
        // 这不是null安全的
//        return name.equals(other.name)
//                && salary == other.salary
//                && hireDay.equals(other.hireDay);

        // null安全的方法
        return Objects.equals(name, other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }
}
