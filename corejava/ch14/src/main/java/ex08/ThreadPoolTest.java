package ex08;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @Author : zs.sun
 * @Date : 2018/8/21 14:02
 * @Package : ex08
 * @ProjectName: corejava
 * @Description:
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        try(Scanner in = new Scanner(System.in))
        {
//            System.out.print("Enter base directory(e.g. /usr/local/jdk5.0/src): ");
//            String directory = in.nextLine();
//            System.out.print("Enter keyword(e.g. volatile): ");
//            String keyword = in.nextLine();

            String directory = "C:\\Program Files";
            String keyword = "java";

            ExecutorService pool = Executors.newCachedThreadPool();

            MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);

            try
            {
                System.out.println(result.get() + " matching files");
            }
            catch(ExecutionException e)
            {
                e.printStackTrace();
            }
            pool.shutdown();

            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size = " + largestPoolSize);
        }
    }
}

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 */
class MatchCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    /**
     * Constructs a MatchCounter.
     * @param directory the directory in which to start the search
     * @param keyword   the keyword to look for
     * @param pool      the thread pool for submitting subtasks
     */
    public MatchCounter(File directory, String keyword, ExecutorService pool)
    {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call()
    {
        count = 0;
        try
        {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for(File file : files)
            {
                if(file.isDirectory())
                {
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }
                else
                {
                    if(search(file))
                    {
                        ++count;
                    }
                }
            }

            for(Future<Integer> result : results)
            {
                try
                {
                    count += result.get();
                }
                catch (ExecutionException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (InterruptedException e)
        {

        }
        return count;
    }

    /**
     * Searches a file for a given keyword.
     * @param file the file to search
     * @return true if the keyword is contained in the file
     */
    public boolean search(File file)
    {
        try
        {
            try(Scanner in = new Scanner(file, "UTF-8"))
            {
                boolean found = false;
                while(!found && in.hasNextLine())
                {
                    String line = in.nextLine();
                    if(line.contains(keyword))
                    {
                        found = true;
                    }
                }
                return found;
            }
        }
        catch (IOException e)
        {
            return false;
        }
    }
}

/**
 * Enter base directory(e.g. /usr/local/jdk5.0/src): C:\Program Files\Java\jdk1.8.0_121\
 Enter keyword(e.g. volatile): java
 98 matching files
 largest pool size = 61
 */

/**
 * Enter base directory(e.g. /usr/local/jdk5.0/src): C:\Program Files
 Enter keyword(e.g. volatile): java
 * 878 matching files
 * largest pool size = 800   1370   1176
 */
