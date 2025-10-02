import java.util.*;
import java.io.*;

public class Main {
    public static boolean isPrime(int n) {
        int N = (int) Math.sqrt(n) + 1;
        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 2; i < N; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrom(int n) {
        ArrayList<Integer> lst = new ArrayList<>();
        while (n > 0) {
            lst.add(n % 10);
            n = n / 10;
        }
        int len = lst.size();
        for (int i = 0; i < len / 2; i++) {
            if (lst.get(i) != lst.get(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // N보다 크고 소수면서 팰린드롬인 수 중에 가장 작은 수
        while (true) {
            if (isPrime(n) && isPalindrom(n)) {
                System.out.println(n);
                break;
            } else {
                n++;
            }
        }
    }
}
