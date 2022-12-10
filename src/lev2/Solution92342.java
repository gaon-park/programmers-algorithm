package lev2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/92342
public class Solution92342 {
    static class Res {
        int res;
        int[] arr;

        Res(int res, int[] arr) {
            this.res = res;
            this.arr = arr.clone();
        }

        void change(int res, int[] arr) {
            this.res = res;
            this.arr = arr.clone();
        }
    }

    public Res search(int[] lion, int score, int index, int k, int[] info, Res cur) {
        lion[index] = Math.min(info[index] + 1, k);
        if (lion[index] > info[index])
            score += 10 - index;
        k -= lion[index];

        if (k < 1) {
            Res res = new Res(score, lion);
            if (cur.res <= 0) return res;
            if (cur.res - getApeachScore(info, cur.arr) <= res.res - getApeachScore(info, res.arr)) {
                return res;
            }
            return cur;
        }

        for (int i = 0; i < lion.length; i++) {
            if (lion[i] == 0) {
                Res tmp = search(lion, score, i, k, info, cur);
                lion[i] = 0;

                if (cur.res - getApeachScore(info, cur.arr) <= tmp.res - getApeachScore(info, tmp.arr)) {
                    cur.change(tmp.res, tmp.arr);
                }
            }
        }

        return cur;
    }

    public int getApeachScore(int[] info, int[] lion) {
        int score = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] > 0 && info[i] >= lion[i]) {
                score += 10 - i;
            }
        }
        return score;
    }

    public int[] solution(int n, int[] info) {
        Res res = search(new int[info.length], 0, 0, n, info, new Res(0, new int[info.length]));
        for (int i = 1; i < info.length; i++) {
            Res tmp = search(new int[info.length], 0, i, n, info, res);
            if (res.res - getApeachScore(info, res.arr) <= tmp.res - getApeachScore(info, tmp.arr)) {
                res.change(tmp.res, tmp.arr);
            }
        }

        if (res.res <= getApeachScore(info, res.arr)) return new int[]{-1};
        return res.arr;
    }

    public static void main(String[] args) {
        int[] n = new Solution92342().solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});
        System.out.println(Arrays.toString(n));
    }
}
