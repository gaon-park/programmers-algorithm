package lev2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/134239
public class Solution134239 {
    public List<Integer> getArr(int k) {
        List<Integer> res = new ArrayList<>();
        res.add(k);
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            res.add(k);
        }
        return res;
    }

    public double[] getArea(List<Integer> arr) {
        double[] res = new double[arr.size() - 1];
        for (int i = 1; i < arr.size(); i++) {
            res[i - 1] = (arr.get(i - 1) + arr.get(i)) / 2.0;
        }
        return res;
    }

    public double[] solution(int k, int[][] ranges) {
        double[] res = new double[ranges.length];
        double[] area = getArea(getArr(k));
        int arrSize = area.length;
        for (int i = 0; i < ranges.length; i++) {
            // 범위 확인
            int l = ranges[i][0], r = arrSize + ranges[i][1];
            if (l - r == 0) {
                res[i] = 0;
            } else if (l > r) {
                res[i] = -1;
            } else {
                for (int j = l; j < r; j++) {
                    res[i] += area[j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        double[] d = new Solution134239().solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}});
        System.out.println(Arrays.toString(d));
    }
}
