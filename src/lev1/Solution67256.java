package lev1;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/67256
public class Solution67256 {
    static class NP {
        int x;
        int y;

        NP(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void moveTo(NP n) {
            this.x = n.x;
            this.y = n.y;
        }

        int distance(NP np) {
            return Math.abs(this.x - np.x) + Math.abs(this.y - np.y);
        }
    }

    public String solution(int[] numbers, String hand) {
        Map<Integer, NP> npMap = new HashMap<>();
        // *, #
        npMap.put(-1, new NP(3, 0));
        npMap.put(-2, new NP(3, 2));
        // number
        int index = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 3 && (j == 0 || j == 2)) {
                    continue;
                }
                if (index == 10) index = 0;
                npMap.put(index++, new NP(i, j));
            }
        }

        NP left = new NP(3, 0);
        NP right = new NP(3, 2);
        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            NP target = npMap.get(i);
            if (target.y == 0) {
                left.moveTo(target);
                sb.append("L");
            } else if (target.y == 2) {
                right.moveTo(target);
                sb.append("R");
            } else {
                int disLeft = left.distance(target);
                int disRight = right.distance(target);
                if (disLeft > disRight) {
                    right.moveTo(target);
                    sb.append("R");
                } else if (disLeft < disRight) {
                    left.moveTo(target);
                    sb.append("L");
                } else{
                    if ("right".equals(hand)) {
                        right.moveTo(target);
                        sb.append("R");
                    } else {
                        left.moveTo(target);
                        sb.append("L");
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Solution67256().solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println(s);
    }
}
