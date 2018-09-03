package ex01;

/**
 * @Author : zs.sun
 * @Date : 2018/8/5 17:29
 * @Package : ex01
 * @ProjectName: corejava
 * @Description:
 */
public class Welcome {
    public static void main(String[] args)
    {
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for(int i = 0; i < greeting.length(); ++i)
        {
            System.out.print("=");
        }
        System.out.println();
    }
}
