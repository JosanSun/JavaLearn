package ex07;

import java.util.BitSet;

/**
 * @Author : zs.sun
 * @Date : 2018/8/12 19:34
 * @Package : ex07
 * @ProjectName: corejava
 * @Description: This program runs the Sieve of Erathostenes benchmark.
 *               It computes all primes up to 2,000,000
 */
public class Sieve {
    public static void main(String[] args) {
        int n = 200;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++)
        {
            b.set(i);
        }
        System.out.println(b);

        i = 2;
        while(i * i <= n)
        {
            if(b.get(i))
            {
                ++count;
                int k = 2 * i;
                while(k <= n)
                {
                    b.clear(k);
                    k +=i;
                }
            }
            ++i;
        }

        while(i <= n)
        {
            if(b.get(i))
            {
                ++count;
            }
            ++i;
        }

        long end = System.currentTimeMillis();



        System.out.println(b);
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
