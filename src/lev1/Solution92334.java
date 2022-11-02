package lev1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class Solution92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> idList = new ArrayList<>(Arrays.asList(id_list));
        int[][] count = new int[id_list.length][id_list.length];
        for (String re : report) {
            int i = idList.indexOf(re.split(" ")[0]);
            int j = idList.indexOf(re.split(" ")[1]);
            count[i][j] = 1;
        }

        int[] reported = new int[id_list.length];

        // 신고 당했나?
        for (int i = 0; i < id_list.length; i++) {
            int forI = 0;
            boolean flg = false;
            for (int j = 0; j < id_list.length; j++) {
                if (i == j) continue;
                forI += count[j][i];
                if (forI >= k) {
                    flg = true;
                    break;
                }
            }
            if (flg) {
                // i가 정지당했다고 메일보내줘
                for (int j = 0; j < id_list.length; j++) {
                    if (count[j][i] > 0) {
                        reported[j]++;
                    }
                }
            }
        }

        return reported;
    }

    public static void main(String[] args) {
//        int[] arr = new Solution().solution(
//                new String[]{"muzi", "frodo", "apeach", "neo"},
//                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
//                2);

        int[] arr = new Solution92334().solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                2);

        System.out.println(Arrays.toString(arr));
    }
}
