package lev1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://school.programmers.co.kr/learn/courses/30/lessons/77484
public class Solution77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lotto = IntStream.of(lottos).sorted().boxed().collect(Collectors.toList());
        List<Integer> win = new java.util.ArrayList<>(IntStream.of(win_nums).sorted().boxed().collect(Collectors.toList()));
        win.removeAll(lotto);
        int zero = lotto.lastIndexOf(0) + 1;
        int max = win.size() - zero + 1;
        int min = win.size() + 1;
        max = (max > 5) ? 6 : max;
        min = (min > 5) ? 6 : min;
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] a = new Solution77484().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(Arrays.toString(a));
    }
}
