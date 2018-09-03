import java.io.File;

/**
 * @Author : zs.sun
 * @Date : 2018/8/8 20:51
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */
public class FileTree {

    public static void main(String[] args)
    {
        File f = new File("D:/book/百度网盘书籍分享/JAVA");
        printFile(f, 0);
    }

    private class A
    {

    }

    static void printFile(File file, int level)
    {

        for(int i = 0; i < level; ++i)
        {
            System.out.print("---");
        }
        System.out.println(file.getName());

        if(file.isDirectory())
        {
            // System.out.println("|");
            File[] files = file.listFiles();
            for(File tmp : files)
            {
                printFile(tmp, level + 1);
            }
        }
    }
}
