package ex08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author : josancpp
 * @Date : 18-09-07 007  00:06
 * @Package : ex08
 * @ProjectName: corejava
 * @Description:
 */
public class Test {

    public static void main(String [] a)  {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println("Print all numbers:");
        evaluate(list, (n)->true);

        System.out.println("Print no numbers:");
        evaluate(list, (n)->false);

        System.out.println("Print even numbers:");
        evaluate(list, (n)-> n%2 == 0 );

        System.out.println("Print odd numbers:");
        evaluate(list, (n)-> n%2 == 1 );

        System.out.println("Print numbers greater than 5:");
        evaluate(list, (n)-> n > 5 );


        //Old way:
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        for(Integer n : list1) {
            int x = n * n;
            System.out.println(x);
        }

//New way:
        List<Integer> list01 = Arrays.asList(1,2,3,4,5,6,7);
        Function<Integer, Integer> fuct = (Integer x)-> {return x*x;};
        list01.stream().map(fuct).forEach(System.out::println);
        //list01.stream().map((x) -> x*x).forEach(System.out::println);
        // list01没有改变
        for(Integer n : list01) {
            System.out.println(n);
        }


    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list)  {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}

