package line01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int ans = 20000;

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            if (distance < 4 || distance > 178) {
                break;
            }
            cal(distance);
        }
        System.out.println(ans);
    }

    public static void cal(int distance) {
        if (distance <= 40) {
            ans -= 720;
            if (ans < 0) {
                ans += 720;
            }
        } else if (distance > 40) {
            ans -= 720;
            int subRes = distance - 40;
            int r = subRes % 8;
            int m;
            if (r == 0) {
                m = subRes / 8;
                ans -= (80 * m);
            } else {
                m = (subRes / 8) + 1;
                ans -= (80 * m);
            }

            if (ans < 0) {
                ans += (80 * m);
            }
        }
    }
}
