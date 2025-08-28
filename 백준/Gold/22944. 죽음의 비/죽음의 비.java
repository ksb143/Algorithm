import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int H;
    static int D;
    static int[][] ds = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int bfs(int[] start, char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int[] info = {start[0], start[1], H, 0, 0};  // 현재 위치, 체력, 우산내구도, 이동 횟수
        q.offer(info);
        int[][] best = new int[N][N];  // 보조 배열
        for (int i = 0; i < N; i++) {
            Arrays.fill(best[i], -1);
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];  // 현재 로우 위치
            int cc = curr[1];  // 현재 컬럼 위치
            int ch = curr[2];  // 현재 체력
            int cd = curr[3];  // 현재 우산 내구도
            int cnt = curr[4];  // 현재 이동 횟수
            for (int[] d : ds) {
                int nr = cr + d[0];
                int nc = cc + d[1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }
                if (board[nr][nc] == 'E') return cnt + 1;  // 안전지대 도착

                int nh = ch, nd = cd;
                if (board[nr][nc] == 'U') nd = D;  // 우산 교체

                if (nd > 0) nd--; else nh--;  // 데미지 적용
                if (nh <= 0) continue;  // 사망 체크

                int rem = nh + nd;
                if (rem <= best[nr][nc]) continue;  // 가자치기
                best[nr][nc] = rem;

                q.offer(new int[] {nr, nc, nh, nd, cnt + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 한 변 길이
        H = Integer.parseInt(st.nextToken());  // 현재 체력
        D = Integer.parseInt(st.nextToken());  // 우산 내구도
        char[][] board = new char[N][N];  // S 현재위치, E 안전지대, U 우산위치
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int ans = bfs(start, board);
        System.out.println(ans);

    }
}
