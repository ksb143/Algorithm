import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static int[] findFarNode(List<int[]>[] adj, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        int farNode = start;
        int farDist = 0;

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        dist[start] = 0;
        while (!dq.isEmpty()) {
            int cn = dq.poll();
            for (int[] next : adj[cn]) {
                int nn = next[0];  // 다음 노드
                int w = next[1];  // 가중치

                if (dist[nn] == -1) {
                    dist[nn] = dist[cn] + w;  // 거리 업데이트
                    dq.offer(nn);  // 큐에 넣어서 계속 탐색

                    // 가장 먼 노드와 거리 갱신
                    if (dist[nn] > farDist) {
                        farDist = dist[nn];
                        farNode = nn;
                    }

                }
            }
        }

        return new int[]{farNode, farDist};

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());  // 노드수
        List<int[]>[] adj = new ArrayList[n + 1]; 

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[p].add(new int[] {c, w});
            adj[c].add(new int[] {p, w});
        }

        int[] farNode = findFarNode(adj, 1);  // 루트에서 가장 먼 노드
        int[] maxDist = findFarNode(adj, farNode[0]);  // 가장 먼 노드에서 가장 먼 노드
        System.out.println(maxDist[1]);
    }
}
