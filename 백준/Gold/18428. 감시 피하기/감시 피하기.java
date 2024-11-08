import java.util.*;
import java.io.*;

public class Main {
    // 빈공간 조합 확인하는 함수
    public static boolean comb(int idx, int cnt, int[] selected, int N, String[][] hallway, int blankCnt, List<int[]> blankPlaces, List<int[]> teacherPlaces) {
        // 조합의 경우를 다 찾은 경우
        if (cnt == 3) {
            for (int i = 0; i < blankCnt; i++) {
                if (selected[i] == 1) {
                    int r = blankPlaces.get(i)[0];
                    int c = blankPlaces.get(i)[1];
                    hallway[r][c] = "O";
                }
            }

            // 감시 확인
            if (isAllStudentSafe(N, hallway, teacherPlaces)) {
                return true;
            }

            // 장애물 배치 복구
            for (int i = 0; i < blankCnt; i++) {
                if (selected[i] == 1) {
                    int r = blankPlaces.get(i)[0];
                    int c = blankPlaces.get(i)[1];
                    hallway[r][c] = "X";
                }
            }
            return false;  // 조합이 성공하지 않았을 경우
        }

        // 경우의 수 마지막
        if (idx == blankCnt) {
            return false;
        }

        // 현재 위치를 선택하는 경우
        selected[idx] = 1;
        if (comb(idx + 1, cnt + 1, selected, N, hallway, blankCnt, blankPlaces, teacherPlaces)) {
            return true;  // 성공한 경우 전체 탐색 종료
        }

        // 현재 위치를 선택하지 않는 경우
        selected[idx] = 0;
        if (comb(idx + 1, cnt, selected, N, hallway, blankCnt, blankPlaces, teacherPlaces)) {
            return true;  // 성공한 경우 전체 탐색 종료
        }
        return false;  // 모든 경우 확인했으나 실패
    }

    public static boolean isAllStudentSafe(int N, String[][] hallway, List<int[]> teacherPlaces) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int[] teacher : teacherPlaces) {
            int cr = teacher[0];
            int cc = teacher[1];

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                while (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    if (hallway[nr][nc].equals("O")) {
                        break;
                    }
                    if (hallway[nr][nc].equals("S")) {
                        return false;
                    }
                    nr += dr[d];
                    nc += dc[d];
                }
            }
        }
        return true;  // 모든 학생이 감시를 피한 경우
    }

    // 메인 함수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 복도 너비
        String[][] hallway = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] hallInfo = br.readLine().split(" ");
            hallway[i] = hallInfo;
        }

        List<int[]> teacherPlaces = new ArrayList<>();  // 선생님 위치
        List<int[]> blankPlaces = new ArrayList<>();  // 빈공간 위치
        int blankCnt = 0;  // 빈공간 수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (hallway[i][j].equals("X")) {
                    blankPlaces.add(new int[]{i, j});
                    blankCnt++;
                } else if (hallway[i][j].equals("T")) {
                    teacherPlaces.add(new int[]{i, j});
                }
            }
        }

        int[] selected = new int[blankCnt];

        if (comb(0, 0, selected, N, hallway, blankCnt, blankPlaces, teacherPlaces)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
