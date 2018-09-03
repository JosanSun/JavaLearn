import java.io.IOException;

/**
 * @Author : zs.sun
 * @Date : 2018/8/8 17:57
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public class LambdaEx03 {
    public static void main(String args[]) {
        int num = 1;
        Converter<Integer, String> s = param -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
        num = 3;       //   Error:(11, 91) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量

        IOException e ;

    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }


}


