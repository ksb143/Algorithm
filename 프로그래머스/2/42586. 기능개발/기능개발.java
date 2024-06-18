import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 빈 큐 만들기
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();

        // 큐에 num 삽입
        // add는 큐가 꽉 찬 경우 IllegalStateException 반환
        // offer는 큐가 꽉 찬 경우 false 반환
        int len = progresses.length;
        for (int i = 0; i < len; i++) {
            p.offer(progresses[i]);
            s.offer(speeds[i]);

        }
        ArrayList<Integer> answer = new ArrayList<>();

        // 큐에 무엇이 남아 있다면 반복문 계속
        while (!p.isEmpty()) {
            int cnt = p.size();
            // 진행도 올리기
            for (int i = 0; i < cnt; i++) {
                // poll은 큐의 첫 번째 값 제거 및 반환
                int progress = p.poll();
                int speed = s.poll();
                progress += speed;
                p.offer(progress);
                s.offer(speed);
            }
            // 큐 첫 기능이 100% 이상일 때
            if (p.peek() >= 100) {
                int comp = 0;
                // 큐가 있고 100%가 넘으면 반복문 계속
                while (!p.isEmpty() && p.peek() >= 100) {
                    p.poll();
                    s.poll();
                    comp += 1;
                }
                // 100%가 안 넘으면 끝내기
                answer.add(comp);
            }
        }
        // 배열로 변환
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}