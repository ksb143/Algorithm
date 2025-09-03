import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.length() == 1) {
            input = "0" + input;
        }
        int[] initNum = new int[2];
        int[] num = new int[2];
        initNum[0] = input.charAt(0) - '0';
        initNum[1] = input.charAt(1) - '0';
        num[0] = input.charAt(0) - '0';
        num[1] = input.charAt(1) - '0';
        int cycle = 0;
        while (true) {
            int plusNum = (num[0] + num[1]) % 10;
            num[0] = num[1];
            num[1] = plusNum;
            cycle++;
            if (initNum[0] == num[0] && initNum[1] == num[1]) {
                break;
            }
        }
        System.out.println(cycle);
    }
}
