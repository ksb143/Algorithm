import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());  // 세로
        int W = Integer.parseInt(st.nextToken());  // 가로

        int[] blocks = new int[W];  // 블록
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] world = new boolean[H][W];
        for (int c = 0; c < W; c++) {
            for (int r = 0; r < blocks[c]; r++) {
                world[r][c] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < H; i++) {
            int check = -1;
            for (int j = 0; j < W; j++) {
                if (world[i][j])  {
                    cnt += Math.max(check, 0);
                    check = 0;
                } else {
                    if (check >= 0) {
                        check++;
                    }
                }
            }
        }

        System.out.println(cnt);


    }
}
