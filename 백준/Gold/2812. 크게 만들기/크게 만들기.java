import java.io.*;
import java.util.*;

public class Main {
    public static long assembleNum(int[] arr) {
        long num = 0;
        long tenSquare = 1;
        for (int n : arr) {
            if (n == -1) {
                continue;
            }
            num += n * tenSquare;
            tenSquare *= 10;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String s = br.readLine();  // n자리 숫자 중 k개 지웠을 때 가장 큰 수

        int remove = K;
        ArrayDeque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!st.isEmpty() && remove > 0 && st.peekLast() < c) {
                st.pollLast();
                remove--;
            }
            st.addLast(c);
        }

        while (remove > 0) {
            st.pollLast();
            remove--;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : st) {
            ans.append(c);
        }

        System.out.println(ans);
    }
}
