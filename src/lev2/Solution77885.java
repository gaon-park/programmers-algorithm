package lev2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/77885
public class Solution77885 {
    public long[] solution(long[] numbers) {
        long[] res = new long[numbers.length];
        int index = 0;
        for (long n : numbers) {
            if (n % 2 == 0) {
                res[index++] = n + 1;
            } else {
                String[] tmp = ("0" + Long.toBinaryString(n)).split("");
                int i = tmp.length - 1;
                while (!tmp[i].equals("0")) {
                    i--;
                }
                tmp[i + 1] = "0";
                tmp[i] = "1";

                StringBuilder sb = new StringBuilder();
                for (String s : tmp) {
                    sb.append(s);
                }
                res[index++] = Long.parseLong(sb.toString(), 2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        long[] n = new Solution77885().solution(new long[]{15});
        System.out.println(Arrays.toString(n));
    }
}
