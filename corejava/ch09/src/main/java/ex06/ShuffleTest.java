package ex06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : zs.sun
 * @Date : 2018/8/12 19:22
 * @Package : ex06
 * @ProjectName: corejava
 * @Description: This program demonstrates the random shuffle and sort algorithms.
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);

        Collections.shuffle(numbers);

        System.out.println(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
