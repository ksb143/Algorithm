import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] ds = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static void bfs(int[][] rgbInfo, int sr, int sc, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();;
            int cr = curr[0];
            int cc = curr[1];
            for (int[] d : ds) {
                int nr = cr + d[0];
                int nc = cc + d[1];
                // 범위 안이며 255고 방문하지 않았을 때 진행
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && rgbInfo[nr][nc] == 255 && !visited[nr][nc]) {
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);  // 세로
        M = Integer.parseInt(input[1]);  // 가로
        int[][] rgbInfo = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int cnt = 0;
            int rgb = 0;
            for (int j = 0; j < M * 3; j++) {
                rgb += Integer.parseInt(line[j]);
                cnt++;
                if (cnt == 3) {
                    rgbInfo[i][j / 3] = rgb / 3;  // 평균 집어넣기
                    // 초기화
                    rgb = 0;
                    cnt = 0;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());  // 경계값
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 경계값 기준
                if (rgbInfo[i][j] >= T) {
                    rgbInfo[i][j] = 255;
                } else {
                    rgbInfo[i][j] = 0;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (rgbInfo[i][j] == 255 && !visited[i][j]) {
                    bfs(rgbInfo, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
