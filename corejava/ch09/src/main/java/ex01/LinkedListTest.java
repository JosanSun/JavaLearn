package ex01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author : zs.sun
 * @Date : 2018/8/12 15:44
 * @Package : ex01
 * @ProjectName: corejava
 * @Description: This program demonstrates operations on linked lists.
 */
public class LinkedListTest {
    public static void main(String[] args)
    {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // merge the words from b into a

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while(bIter.hasNext())
        {
            if(aIter.hasNext())
            {
                aIter.next();
            }
            aIter.add(bIter.next());
            // System.out.println(a);
        }

        System.out.println(a);


        // System.out.println(b);

        // remove every second word from b

        bIter = b.iterator();  // 重新赋值，将bIter重新返回到表头
        while(bIter.hasNext())
        {
            // skip one element
            bIter.next();
            if(bIter.hasNext())
            {
                // skip next element
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        // bulk operation: remove all words in b from a
        a.removeAll(b);

        System.out.println(a);
    }

}
