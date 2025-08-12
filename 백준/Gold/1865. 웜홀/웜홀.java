import java.util.*;
import java.io.*;

public class Main {
    static int INF = Integer.MAX_VALUE;

    static int[] dist;

    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }


    private static boolean bellmanFord(ArrayList<ArrayList<Edge>> adjList, int N) {
        // 슈퍼소스 간선 붙이기
        for (int i = 1; i <= N; i++) {
            adjList.get(0).add(new Edge(i, 0));
        }
        // 무한대로 초기화
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int u = 0; u <= N; u++) {
                if (dist[u] == INF) {
                    continue;
                }
                for (Edge edge : adjList.get(u)) {
                    int v = edge.to;
                    int w = edge.weight;
                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                        if (i == N) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());  // 테스트케이스
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 지점 수
            int M = Integer.parseInt(st.nextToken());  // 도로 수
            int W = Integer.parseInt(st.nextToken());  // 웜홀 수
            // 인접리스트 만들기 (인접 행렬 사용하려고 했으나 T가 0인 예외 표현 힘듦 이슈로 변경)
            ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
            for (int k = 0; k <= N; k++) {
                ArrayList<Edge> list = new ArrayList<>();
                adjList.add(list);
            }
            // 도로 표시
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());  // 시작
                int E = Integer.parseInt(st.nextToken());  // 끝
                int T = Integer.parseInt(st.nextToken());  // 소요시간
                Edge e1 = new Edge(E, T);
                Edge e2 = new Edge(S, T);
                adjList.get(S).add(e1);
                adjList.get(E).add(e2);
            }
            // 웜홀
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());  // 시작
                int E = Integer.parseInt(st.nextToken());  // 끝
                int T = Integer.parseInt(st.nextToken());  // 소요시간
                Edge e = new Edge(E, -T);
                adjList.get(S).add(e);
            }

            String ans = bellmanFord(adjList, N) ? "YES" : "NO";
            System.out.println(ans);

        }

    }
}
