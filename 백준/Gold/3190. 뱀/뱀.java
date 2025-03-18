import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static int[][] ds = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 방향 (우, 하, 좌, 상)

    private static int[] movingSnake(int cr, int cc, Queue<int[]> snakePoses, int d, int X, int[][] board) {
        int count = 0;
        board[cr][cc] = -1;
        for (int i = 0; i < X; i++) {
            int nr = cr + ds[d][0];
            int nc = cc + ds[d][1];
            count++;
            // 이동 가능 (벽 아니고, 몸통도 아니면)
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] != -1) {
                // 사과면
                if (board[nr][nc] == 1) {
                    snakePoses.offer(new int[] {nr, nc});  // 이동
                    board[nr][nc] = -1;  // 뱀 머리 위치
                } else {
                    int[] tailPos = snakePoses.poll();  // 꼬리 없애기
                    board[tailPos[0]][tailPos[1]] = 0;  // 보드 위치에서 꼬리 없애기
                    snakePoses.offer(new int[] {nr, nc});  // 이동
                    board[nr][nc] = -1;  // 뱀 머리 위치
                }
                cr = nr;
                cc = nc;
            } else {
                return new int[] {-1, count, cr, cc};
            }
        }
        return new int[] {1, count, cr, cc};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  // 보드 크기
        K = Integer.parseInt(br.readLine());  // 사과 개수
        int[][] board = new int[N][N];
        Queue<int[]> snakePoses = new LinkedList<>();  // 뱀 위치
        int cr = 0, cc = 0;
        snakePoses.add(new int[] {cr, cc});
        int angle = 0;  // 각도
        for (int i = 0; i < K; i++) {
            String[] applePos = br.readLine().split(" ");
            int ar = Integer.parseInt(applePos[0]) - 1;
            int ac = Integer.parseInt(applePos[1]) - 1;
            board[ar][ac] = 1;  // 사과 위치에 1 표시
        }
        int time = 0;  // 걸린 시간
        int L = Integer.parseInt(br.readLine());  // 뱀 방향 변환 횟수
        int past = 0;
        for (int i = 0; i < L; i++) {
            String[] movPos = br.readLine().split(" ");
            int present = Integer.parseInt(movPos[0]);
            int X = present - past;
            past = present;
            String C = movPos[1];
            int[] result = movingSnake(cr, cc, snakePoses, angle / 90, X, board);
            time += result[1];
            cr = result[2];
            cc = result[3];
            if (result[0] == -1) {
                System.out.println(time);
                return;
            }
            // 각도 바꾸기
            if (C.equals("D")) {
                angle = (angle + 90) % 360;
            } else {
                angle = (angle + 270) % 360;
            }
        }
        // 아직 남아 있다면
        int[] rest = movingSnake(cr, cc, snakePoses, angle / 90, N * N, board);
        time += rest[1];
        System.out.println(time);
    }
}
