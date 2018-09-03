package ex02;

import java.io.Console;
import java.util.*;

/**
 * This program demonstrates console input.
 * @version 1.10 2004-02-10
 * @author Cay Horstmann
 */
public class InputTest
{
    public static void main(String[] args)
    {

        secretInput();

        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.print("How old are you? ");
        int age = in.nextInt();

        // display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));



    }

    // 注意，只能通过命令行执行。IDE中会报空指针异常。原因的话请参考JDK。
    private static void secretInput()
    {
        // 必须利用命令行来运行，否则无法正常运行
        Console cons = System.console();
        String name01 = cons.readLine("please input your name:");           // 正常读写
        char[] chars = cons.readPassword("please input password:");         // 这里密码输入的时候，无法看见输入的状态
        String password = String.valueOf(chars);
        System.out.println("your name: " + name01 + " your password:" + password);
    }
}

