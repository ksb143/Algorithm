import java.io.*;
import java.util.*;

public class Main {
    static class Village {
        long x;
        long a;
        Village(long x, long a) {
            this.x = x;
            this.a = a;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // N개의 줄
        List<Village> villages = new ArrayList<>();
        long totalPeople = 0;  // 사람 수 총합
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Village v = new Village(Long.parseLong(input[0]), Long.parseLong(input[1]));
            villages.add(v);
            totalPeople += v.a;
        }

        long half = (totalPeople + 1) / 2;

        villages.sort(Comparator.comparingLong(v -> v.x));
        long preSum = 0;
        for (int i = 0; i < N; i++) {
            Village vil = villages.get(i);
            preSum += vil.a;
            if (preSum >= half) {
                System.out.println(vil.x);
                break;
            }
        }

    }
}
