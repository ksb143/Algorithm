import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] reach = new boolean[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            reach[e1][e2] = true;
        }
        for (int mid = 1; mid <= n; mid++) {
            for (int from = 1; from <= n; from++) {
                // i에서 k로 갈 수 없으면 건너뛰기
                if (!reach[from][mid]) {
                    continue;
                }
                for (int to = 1; to <= n; to++) {
                    if (reach[mid][to]) {
                        reach[from][to] = true;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for (int q = 0; q< s; q++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (reach[u][v]) {
                System.out.println(-1);
            } else if (reach[v][u]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
