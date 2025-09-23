import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int a = nums[0], b = nums[1], c = nums[2], d = nums[3], e = nums[4], f = nums[5];
        int y;
        int x;
        if (b * d - e * a != 0) {
            y = (c * d - f * a) / (b * d - e * a);
            if (a != 0) {
                x = (c - b * y) / a;
            } else {
                x = (f - e * y) / d;
            }
        } else {
            x = (c * e - f * b) / (a * e - d * b);
            if (b != 0) {
                y = (c - a * x) / b;
            } else {
                y = (f - d * x) / e;
            }
        }


        System.out.println(x + " " + y);

    }
}
