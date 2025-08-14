import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(drinks);
        double maxVal = drinks[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            double rest = drinks[i] / 2;
            if (drinks[i] % 2 != 0) {
                rest += 0.5;
            }
            maxVal += rest;
        }
        long intMaxVal = (long) maxVal;
        if (intMaxVal == maxVal) {
            System.out.println(intMaxVal);
        } else {
            System.out.println(maxVal);
        }

    }
}
