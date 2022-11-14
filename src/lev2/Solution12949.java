package lev2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12949
public class Solution12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] answer = new Solution12949().solution(
                new int[][]{{1, 4}, {3, 2}, {4, 1}},
                new int[][]{{3, 3,}, {3, 3}}
        );

        System.out.println(Arrays.toString(answer[0]) + "" + Arrays.toString(answer[1]));
    }
}
