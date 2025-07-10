import java.util.*;

class Solution {
    static int[][] board = new int[102][102];  // 2배 확대 좌표 -> 선을 표현
    static boolean[][] visited = new boolean[102][102];
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 우 하 좌 상
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 모든 사각형 외곽 1로 채우기 (2배 확대)
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    board[j][i] = 1;
                }
            }
        }

        // 2. 내부 0으로 초기화
        for (int[] r : rectangle) {
            int x1 = r[0] * 2 + 1, y1 = r[1] * 2 + 1;
            int x2 = r[2] * 2 - 1, y2 = r[3] * 2 - 1;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    board[j][i] = 0;
                }
            }
        }

        // 3. BFS 시작
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterY * 2, characterX * 2, 0});
        visited[characterY * 2][characterX * 2] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0], x = curr[1], dist = curr[2];

            if (x == itemX * 2 && y == itemY * 2) {
                return dist / 2;
            }

            for (int[] d : dirs) {
                int ny = y + d[0];
                int nx = x + d[1];
                if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102) {  // 범위 안 아니면 넘어가기
                    continue;
                }
                if (visited[ny][nx]) {  // 방문했으면 넘어가기
                    continue;
                }
                if (board[ny][nx] != 1) {  // 테두리가 아니면 넘어가기
                    continue;
                }

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx, dist + 1});
            }
        }

        return -1;
    }
}
