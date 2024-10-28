import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            queue.add(i);
            visited[i] = 1;
            cnt++;
            while (!queue.isEmpty()) {
                int x = queue.poll();
                for (int j = 0; j < n; j++) {
                    // 연결되어 있고 방문하지 않았을 경우
                    if (computers[x][j] == 1 && visited[j] == 0) {
                        queue.add(j);
                        visited[j] = 1;
                    }
                }
            }
        }

        int answer = cnt;
        return answer;
    }
}