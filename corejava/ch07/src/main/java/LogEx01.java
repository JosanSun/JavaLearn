import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Author : zs.sun
 * @Date : 2018/8/9 15:07
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public class LogEx01 {
    public static void main(String[] args)
    {
        int x = 10;
        System.out.println("x = " + x);

        Logger.getGlobal().info("x = " + x);

        StringWriter out = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(out));
        String desc = out.toString();
    }
}


class LogEx02 {

}