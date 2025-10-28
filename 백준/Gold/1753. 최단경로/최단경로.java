import java.util.*;
import java.io.*;

public class Main {
    public static int[] dijkstra(List<int[]>[] adj, int start, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        pq.offer(new int[]{start, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);  // dist 초기화
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cv = curr[0];
            int cw = curr[1];



            for (int[] next : adj[cv]) {
                int nv = next[0];  // 다음 노드
                int nw = next[1];  // 다음 노드로 가기 위한 가중치
                // 다음 노드로 가는 길이 없었거나 혹은 현재 가는 경로가 더 짧다면 길이 교체 및 큐 삽입
                if (dist[nv] > cw + nw) {
                    dist[nv] = cw + nw;
                    pq.offer(new int[] {nv, dist[nv]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());  // 정점 개수
        int E = Integer.parseInt(st.nextToken());  // 간선 개수
        int K = Integer.parseInt(br.readLine());  // 시작 정점
        List<int[]>[] adj = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {  // 빈 리스트 채우기
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < E; i++) {  // 가중치 삽입
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[] {v, w});
        }

        int[] dist = dijkstra(adj, K, V);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }
}
