import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] rectangle = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                rectangle[i][j] = line.charAt(j) - '0';
            }
        }
        int ans = 1;
        int maxLen = Math.min(N, M);
        boolean flag = false;
        while (maxLen > 1) {
            for (int i = 0; i <= N - maxLen; i++) {
                if (flag) {
                    break;
                }
                for (int j = 0; j <= M - maxLen; j++) {
                    if (rectangle[i][j] == rectangle[i + maxLen - 1][j] &&
                        rectangle[i][j] == rectangle[i][j + maxLen - 1] &&
                        rectangle[i][j] == rectangle[i + maxLen - 1][j + maxLen - 1]) {
                        ans = maxLen * maxLen;
                        flag = true;
                        break;
                    }
                }
            }
            maxLen--;
        }

        System.out.println(ans);


    }
}
