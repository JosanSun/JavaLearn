/**
 * @Author : zs.sun
 * @Date : 2018/8/8 17:55
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public class LambdaEx02 {

    final static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
