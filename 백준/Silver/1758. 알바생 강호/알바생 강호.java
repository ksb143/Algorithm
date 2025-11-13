import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 사람 수
        int[] tips = new int[N];  // 팁
        for (int i = 0; i < N; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips);

        long maxTip = 0;

        int order = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (tips[i] - (order - 1) <= 0) {
                break;
            }
            maxTip += tips[i] - (order - 1);
            order++;
        }

        System.out.println(maxTip);
    }
}
