package ex05;

/**
 * @Author : zs.sun
 * @Date : 2018/8/8 14:14
 * @Package : ex01
 * @ProjectName: corejava
 * @Description:
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name)
    {
        this.name = name;
        this.salary = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString()
    {
        return name;
    }

    /**
     * Compares employees by salary
     * @param other another Employee object
     *              @return a negative value
     */
    @Override
    public int compareTo(Employee other)
    {
        return Double.compare(salary, other.salary);
    }
}
