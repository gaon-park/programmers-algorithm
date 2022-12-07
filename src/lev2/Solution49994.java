package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/49994
public class Solution49994 {
    static class PointC {
        int x;
        int y;

        PointC() {
            x = 0;
            y = 0;
        }

        PointC(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof PointC) {
                PointC p = (PointC) o;
                return x == p.x && y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int solution(String dirs) {
        Map<PointC, List<PointC>> map = new HashMap<>();
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                map.put(new PointC(i, j), new ArrayList<>());
                map.put(new PointC(i * -1, j), new ArrayList<>());
                map.put(new PointC(i, j * -1), new ArrayList<>());
                map.put(new PointC(i * -1, j * -1), new ArrayList<>());
            }
        }

        PointC p = new PointC();
        int x = 0, y = 0;
        int count = 0;
        for (String s : dirs.split("")) {
            PointC key = new PointC(x, y);
            if (s.equals("U") && y < 5) {
                y++;
            } else if (s.equals("D") && y > -5) {
                y--;
            } else if (s.equals("R") && x < 5) {
                x++;
            } else if (s.equals("L") && x > -5) {
                x--;
            } else {
                continue;
            }

            PointC value = new PointC(x, y);
            if (!map.get(key).contains(value) && !map.get(value).contains(key)) {
                List<PointC> tmp = map.get(key);
                tmp.add(value);
                map.put(key, tmp);

                tmp = map.get(value);
                tmp.add(key);
                map.put(value, tmp);

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = new Solution49994().solution("LULLLLLLU");
        System.out.println(n);
    }
}
