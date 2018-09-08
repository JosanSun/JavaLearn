package ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : josancpp
 * @Date : 18-09-07 007  22:44
 * @Package : ex01
 * @ProjectName: corejava
 * @Description:
 */
public class CountLongWords {
    public static void main(String[] args) throws IOException{
        // E:\code\github\JavaLearn\corejava\alice30.txt
        //  readAllBytes()不适合大数据量的读取
        String contents = new String(Files.readAllBytes(Paths.get("alice30.txt")),
                StandardCharsets.UTF_8);
        // 去除除字母以外的所有字符
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        for(String str : words){
            System.out.println(str);
        }

        long count = 0;
        for(String w : words)
        {
            if(w.length() > 12)
            {
                ++count;
            }
        }
        System.out.println(count);

        // 过滤出满足条件的元素
        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w->w.length() > 12).count();
        System.out.println(count);
    }
}
