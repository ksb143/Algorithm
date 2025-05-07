import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] minimumDate = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int num = 100 - progresses[i];
            if (num % speeds[i] == 0) {
                minimumDate[i] = num / speeds[i];
            } else {
                minimumDate[i] = num / speeds[i] + 1;
            }
        }
        List<Integer> lst = new ArrayList<>();
        int idx = 1;
        while (idx <= progresses.length) {
            int preDate = minimumDate[idx - 1];
            int cnt = 1;
            for (; idx < progresses.length; idx++) {
                if (preDate >= minimumDate[idx]) {
                    cnt++;
                } else {
                    break;
                }
            }
            lst.add(cnt);
            idx++;
        }
        int[] answer = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        return answer;
    }
}