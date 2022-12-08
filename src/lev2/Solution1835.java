package lev2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// https://school.programmers.co.kr/learn/courses/30/lessons/1835
public class Solution1835 {
    static List<String> list = new ArrayList<>();
    static String[] st = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
    static int count;
    static String[][] data;

    public static void search(int[] visited, int index, int k, String s) {
        visited[index] = 1;
        s += st[index];
        k--;
        if (!Objects.equals(validate(s), Boolean.FALSE)) {
            for (int i = 0; i < visited.length; i++) {
                if (i != index && visited[i] == 0) {
                    search(visited, i, k, s);
                    visited[i] = 0;
                }
            }
        }
    }

    public static Boolean validate(String s) {
        // 미완성의 데이터
        if (s.length() < 8) return null;

        List<String> friends = Arrays.asList(s.split(""));
        for (String[] datum : data) {
            Boolean result = validate(friends, datum[0], datum[2], datum[3], Integer.parseInt(datum[4]) + 1);
            if (Boolean.FALSE.equals(result)) return false;
        }

        count++;
        return true;
    }

    public static boolean validate(List<String> s, String f1, String f2, String exp, int dis) {
        switch (exp) {
            case "<" -> {
                return Math.abs(s.indexOf(f1) - s.indexOf(f2)) < dis;
            }
            case ">" -> {
                return Math.abs(s.indexOf(f1) - s.indexOf(f2)) > dis;
            }
            case "=" -> {
                return Math.abs(s.indexOf(f1) - s.indexOf(f2)) == dis;
            }
            default -> {
                return false;
            }
        }
    }

    public int solution(int n, String[] data) {
        // init
        count = 0;
        Solution1835.data = new String[n][5];
        for (int i = 0; i < data.length; i++) {
            Solution1835.data[i] = data[i].split("");
        }

        for (int i = 0; i < st.length; i++) {
            search(new int[st.length], i, st.length, "");
        }
        return count;
    }

    public static void main(String[] args) {
        int n = new Solution1835().solution(2, new String[]{"N~F=0", "R~T>2"});
        System.out.println(n);
    }
}
