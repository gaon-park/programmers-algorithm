package lev2;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class Solution70129 {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;
        while (s.length() > 1) {
            String tmp = s.replaceAll("0", "");
            zero += (s.length() - tmp.length());
            s = Integer.toBinaryString(tmp.length());
            count++;
            if (s.equals("1")) break;
        }

        return new int[]{count, zero};
    }
}
