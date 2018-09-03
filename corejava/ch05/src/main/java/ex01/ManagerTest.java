package ex01;

/**
 * @Author : zs.sun
 * @Date : 2018/8/7 11:13
 * @Package : ex01
 * @ProjectName: corejava
 * @Description:
 */
public class ManagerTest {
    public static void main(String[] args)
    {
        Manager m1 = new Manager();

        System.out.println(m1.hashcode);
        m1.setBonus(125.9);
        System.out.println(m1.hashcode);

        System.out.println(m1.toString());
//        // construct a Manager object
//        Manager boss = new Manager("Carl Cracher", 80000, 1987, 12, 15);
//        boss.setBonus(5000);
//
//        Employee[] staff =  new Employee[3];
//
//        // fill the staff array with Manager and Employee objects
//        staff[0] = boss;
//        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
//
//        // print out information about all Employee objects
//        for(Employee e : staff)
//        {
//            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
//        }
//
//        boss.setBonus(500);             // ok
//        // staff[0].setBonus(500);         // error
//        // Manager m = staff[2];           // error

        testOth();
    }

    private static final void testOth()
    {
        Manager[] managers = new Manager[10];
        Employee[] staff = managers; // OK
        if(staff == null)
        {
            System.out.println("staff is null");
        }
        else
        {
            System.out.println("staff is not null");
        }



        staff[0] = new Manager("Harry Hacker", 50000, 1989, 10, 1);   // ok
        //// 编译可以通过，但是运行会出错。  java.lang.ArrayStoreException
        //staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        //managers[0].setBonus(500);
//        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
//
//        for(Manager e : managers)
//        {
//            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary() +
//                    ", bonus = " + e.getBonus());
//            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
//        }
        System.out.println();
    }
}
