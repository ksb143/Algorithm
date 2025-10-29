import java.util.*;
import java.io.*;

public class Main {
    public static long[] bellmanFord(int n, int[][] edges) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] == Long.MAX_VALUE) {  // 출발 시점이 무한대면 넘기기
                    continue;
                }
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());  // 출발
            int B = Integer.parseInt(st.nextToken());  // 도착
            int C = Integer.parseInt(st.nextToken());  // 시간
            edges[i] = new int[] {A, B, C};
        }

        long[] dist = bellmanFord(N, edges);

        boolean hasNegativeCycle = false;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dist[u] == Long.MAX_VALUE) {
                continue;
            }
            if (dist[v] > dist[u] + w) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Long.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }

    }
}
