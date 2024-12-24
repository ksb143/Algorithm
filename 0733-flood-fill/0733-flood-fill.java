import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int num = image[sr][sc];  // 시작 색
        int rowLength = image.length;  // row 길이
        int colLength = image[0].length;  // col 길이
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});
        image[sr][sc] = color;
        int[][] visited = new int[rowLength][colLength];

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        visited[sr][sc] = 1;

        // 큐가 비지 않을 때까지 반복
        while (!queue.isEmpty()) {
            // 큐 안에 넣은거 빼내서 color로 변경
            int[] curr = queue.poll();
            int cr = curr[0], cc = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i], nc = cc + dc[i];
                // 범위 안이고 시작 숫자와 같고 방문하지 않으면 큐 안에 넣기
                if (nr >= 0 && nr < rowLength && nc >= 0 && nc < colLength && image[nr][nc] == num && visited[nr][nc] == 0) {
                    queue.add(new int[] {nr, nc});
                    image[nr][nc] = color;
                    visited[nr][nc] = 1;
                }
            }
        }

        return image;
    }
}