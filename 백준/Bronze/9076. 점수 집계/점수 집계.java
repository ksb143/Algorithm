import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] scores = new int[5];  // 점수 집합
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                scores[j]= Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores);
            if (scores[3] - scores[1] >= 4) {
                System.out.println("KIN");
            } else {
                System.out.println(
                    scores[1] + scores[2] + scores[3]
                );
            }

        }
    }
}
