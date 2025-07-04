import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper = new int[10][10];
    static int[] paperCount = {0, 5, 5, 5, 5, 5};  // 색종이 크기 별 개수
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0 ,0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    static void dfs(int x, int y, int cnt) {
        if (x >= 10) {
            min = Math.min(min, cnt);
            return;
        }

        if (cnt >= min) {
            return;
        }

        if (y >= 10) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (paper[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (paperCount[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0);  // 덮기
                    paperCount[size]--;
                    dfs (x, y + 1, cnt + 1);
                    attach(x, y, size, 1);
                    paperCount[size]++;
                }
            }
        } else {
            dfs(x, y + 1, cnt);  // 넘어가기
        }
    }

    static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) {  // 사이즈 넘어가면
            return false;
        }
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void attach(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = value;
            }
        }
    }
}
