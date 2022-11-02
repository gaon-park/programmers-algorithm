package lev1;

import java.util.Arrays;
import java.util.stream.IntStream;

// https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class Solution86051 {
    public int solution(int[] numbers) {
        return IntStream.range(1, 10).sum() - Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {
        int s = new Solution86051().solution(new int[]{5,8,4,0,6,7,9});
        System.out.println(s);
    }
}
