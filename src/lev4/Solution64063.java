package lev4;

import java.util.Arrays;
import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/64063
public class Solution64063 {
    HashMap<Long, Long> map = new HashMap<>();

    Long find(long x) {
        if (map.get(x) == null) {
            map.put(x, x + 1);
            return x;
        } else {
            map.put(x, find(map.get(x)));
            return map.get(x);
        }
    }

    public long[] solution(long k, long[] room_number) {
        long[] result = new long[room_number.length];
        int index = 0;
        for (long n : room_number) {
            result[index++] = find(n);
        }

        return result;
    }

    public static void main(String[] args) {
        long[] n = new Solution64063().solution(10, new long[]{1, 3, 4, 1, 3, 1});
        System.out.println(Arrays.toString(n));
    }
}
