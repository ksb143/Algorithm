import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.offer(new int[] {N, 0});
        visited[N] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int num = curr[0];
            int second = curr[1];
            if (num == K) {
                System.out.println(second);
                break;
            }
            int next1 = num - 1;
            int next2 = num + 1;
            int next3 = num * 2;
            if (next1 >= 0 && next1 <= 100000 && !visited[next1]) {
                queue.offer(new int[] {next1, second + 1});
                visited[next1] = true;
            }
            if (next2 >= 0 && next2 <= 100000 && !visited[next2]) {
                queue.offer(new int[] {next2, second + 1});
                visited[next2] = true;
            }
            if (next3 >= 0 && next3 <= 100000 && !visited[next3]) {
                queue.offer(new int[] {next3, second + 1});
                visited[next3] = true;
            }
        }

    }
}
