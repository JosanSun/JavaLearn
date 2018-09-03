package ex13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @Author : zs.sun
 * @Date : 2018/8/7 20:24
 * @Package : ex13
 * @ProjectName: corejava
 * @Description:
 */
public class ReflectionTest {
    public static void main(String[] args)
    {
        // read class name from command line args or user input
        String name;
        if(args.length > 0)
        {
            name = args[0];
        }
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name(eg: java.util.Date): ");
            name = in.next();
        }

        try
        {
            // print class name and superclass name (if != Object)
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if(modifiers.length() > 0)
            {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if(superc1 != null && superc1 != Object.class)
            {
                System.out.print(" extends " + superc1.getName());
            }
            System.out.print("\n{\n");
            printConstructor(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.print("}");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Prints all constructors of a class
     */
    public static void printConstructor(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for(Constructor c : constructors)
        {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(0 < modifiers.length())
            {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for(int j = 0; j < paramTypes.length; ++j)
            {
                if(0 < j)
                {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all methods of a class
     * @param  cl a class
     */
    public static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();
        // Method[] methods = cl.getMethods();       // 只是获得作用域为public的方法

        for(Method m : methods)
        {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if(0 < modifiers.length())
            {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");

            // print parameter types
            Class[] paraTypes = m.getParameterTypes();
            for(int j = 0; j < paraTypes.length; ++j)
            {
                if(0 < j)
                {
                    System.out.print(", ");
                }
                System.out.print(paraTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Print all fields of a class
     * @param cl a class
     */
    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();
        // Field[] fields = cl.getFields();         // 只是找出作用域为public的字段

        for(Field f : fields)
        {
            Class  type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(0 < modifiers.length())
            {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}


