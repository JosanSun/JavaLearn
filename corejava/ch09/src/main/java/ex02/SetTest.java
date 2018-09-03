package ex02;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author : zs.sun
 * @Date : 2018/8/12 17:02
 * @Package : ex02
 * @ProjectName: corejava
 * @Description: This program uses a set to print all unique words in System.in
 */
public class SetTest {
    public static void main(String[] args) {
        // HashSet implements Set
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        // URL url = SetTest.class.getResource("SetTest.class");
        // URL url = SetTest.class.getResource("");     // 仍然无法准确找到文件的位置
        System.out.println(url);
        if(url != null)
        {
            String pathname = url.toString();
            System.out.println(pathname);
            File file = new File(pathname);
            if(file.isFile())
            {
                System.out.println("This is a file");
            }
            else
            {
                System.out.println("This is not a file");
            }
        }


        try(Scanner in = new Scanner(System.in))
        {
            while(in.hasNext())
            {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 0; i <= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
