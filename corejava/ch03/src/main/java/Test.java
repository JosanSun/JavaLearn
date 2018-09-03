/**
 * @Author : zs.sun
 * @Date : 2018/8/5 19:34
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public class Test {
    public static void main(String[] args)
    {
        String greeting = "Hello";
        int n = greeting.length();          // 5

        // cpCount为码点数量
        int cpCount = greeting.codePointCount(0, greeting.length());       // 5

        char first = greeting.charAt(0);         // 'H'
        char last = greeting.charAt(greeting.length() - 1); // '0'

        int index = greeting.offsetByCodePoints(0, 2);  // 2
        int cp = greeting.codePointAt(index);  // 108

        System.out.println();
    }
}
