import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author : zs.sun
 * @Date : 2018/8/22 11:47
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public class Test {
    public static void main01(String[] args) {
        // List<Integer> list = new ArrayList<>();       // ok
        List<Integer> list = null;          // error
        for(Integer a : list)
        {
            System.out.println(a);
        }
    }

    /**
     * 探讨中间处理函数
     */
    public static void main02(String[] args) {
        Integer int01 = 12;
        int01 = 5;
        System.out.println(int01);


        List<Integer> list = new ArrayList<>();

        list.add(12222222);
        list.add(1322222222);
        list.add(123);

        for(Integer aa : list)
        {
            aa = 777777;
            // System.out.println(aa);
        }
        for(Integer aa : list)
        {
            System.out.println(aa);
        }


        int[] list02 = {12, 13, 14};

        for(int aa : list02)
        {
            aa = 777777;
            // System.out.println(aa);
        }
        for(int aa : list02)
        {
            System.out.println(aa);
        }


        List<TestInner> list01 = new ArrayList<>();

        list01.add(new TestInner(1, 2));
        list01.add(new TestInner(2, 2));
        list01.add(new TestInner(3, 3));

        for(TestInner aa : list01)
        {
            aa.setA(5);
            aa.setB(6);
        }

        for(TestInner aa : list01)
        {
            System.out.println(aa.getA());
            System.out.println(aa.getB());
        }

        List<TestInner> testInnerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        TestInner testInner = new TestInner();
            testInner.setA(i);
            testInner.setB(i+1);
            testInnerList.add(testInner);
        }
        for (TestInner inner : testInnerList) {
            System.out.println(inner.getA()+"---" + inner.getB());
        }
        System.out.println("Another test: ----");
        TestInner inner01 = testInnerList.get(0);
        inner01.setA(1000);
        inner01.setB(2000);
        for (TestInner inner : testInnerList) {
            System.out.println(inner.getA()+"---" + inner.getB());
        }
    }



    /**
     * 对于数字的话，%s也可以有效地解析出来，并打印
     */
    public static void main03(String[] args) {
        String str = null;

        Date date = new Date();

        str = String.format("%s_%s", date, 2.15);

        System.out.println(str);
    }

    /**
     *
     */
    public static void main04(String[] args)
    {
        int a = 10;
        System.out.println(a);
        setNum(a);
        System.out.println(a);


        String str = "hello";
        System.out.println(str);
        setString(str);
        System.out.println(str);
    }

    public static void setNum(int a)
    {
        a = 12;
    }

    public static void setString(String str){
        str = "weknow";
    }


    /**
     * 输出BigDecimal
     */
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(1.23);
        System.out.println(bigDecimal);
        System.out.println(String.format("This is a test: %s", bigDecimal));
    }
}

class TestInner
{
    private int a;
    private int b;

    public TestInner() {
    }

    public TestInner(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}