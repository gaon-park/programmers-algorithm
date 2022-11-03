package lev2;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/133501
public class Solution133501 {
    static class GuardStatus {
        int[] scope;
        int workTime;
        int breakTime;
        // 0: 휴식중, 1: 근무중
        int status;
        int realTimeWork;
        int realTimeBreak;

        GuardStatus(int[] scope, int workTime, int breakTime) {
            int[] newScope = new int[2];
            newScope[0] = Math.min(scope[0], scope[1]);
            newScope[1] = Math.max(scope[0], scope[1]);
            this.scope = newScope;
            this.workTime = workTime;
            this.breakTime = breakTime;
            this.status = 1;
            this.realTimeWork = workTime;
            this.realTimeBreak = breakTime;
        }

        public void flow() {
            if (status > 0) {
                realTimeWork--;
            } else {
                realTimeBreak--;
            }
            statusUpdate();
        }

        public void statusUpdate() {
            if (realTimeWork == 0) {
                status = 0;
                realTimeWork = workTime;
            } else if (realTimeBreak == 0) {
                status = 1;
                realTimeBreak = breakTime;
            }
        }
    }

    public int solution(int distance, int[][] scope, int[][] times) {
        List<GuardStatus> gs = new ArrayList<>();
        for (int i = 0; i < scope.length; i++) {
            gs.add(new GuardStatus(scope[i], times[i][0], times[i][1]));
        }
        for (int i = 1; i <= distance; i++) {
            for (GuardStatus g : gs) {
                if (g.scope[0] <= i && g.scope[1] >= i && g.status == 1) {
                    return i;
                } else {
                    g.flow();
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int n = new Solution133501().solution(12,
                new int[][]{{7, 8}, {4, 6}, {11, 10}},
                new int[][]{{2, 2}, {2, 4}, {3, 3}});
        System.out.println(n);
    }
}
