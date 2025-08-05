import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 화단 한 변 길이
        int[][] garden = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> centers = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                centers.add(new int[]{i, j});
            }
        }

        int minCost = Integer.MAX_VALUE;
        int[][] dirs = {{0,0},{0,1},{1,0},{-1,0},{0,-1}};  // 꽃 모양

        for (int i = 0; i < centers.size(); i++) {
            for (int j = i + 1; j < centers.size(); j++) {
                for (int k = j + 1; k < centers.size(); k++) {
                    boolean[][] visited = new boolean[N][N];
                    int cost = 0;
                    boolean valid = true;

                    int[][] combo = {centers.get(i), centers.get(j), centers.get(k)};
                    for (int[] c : combo) {   // combo = 세 개의 꽃 중심들
                        int tempCost = 0;
                        for (int[] d : dirs) {
                            int nx = c[0] + d[0];
                            int ny = c[1] + d[1];

                            // 이미 방문한 자리라면 겹친 것!
                            if (visited[nx][ny]) {
                                valid = false;
                                break;
                            }
                            visited[nx][ny] = true;   // 안 겹쳤으면 방문 표시
                            tempCost += garden[nx][ny];
                        }
                        if (!valid) break;   // 하나라도 겹쳤으면 전체 탈출
                        cost += tempCost;
                    }
                    // 겹친게 없으면 minCost 계산
                    if (valid) {
                        minCost = Math.min(minCost, cost);
                    }
                }
            }
        }
        System.out.println(minCost);

    }
}
