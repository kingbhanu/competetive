package codeforces.CF1064;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            long n = Long.parseLong(br.readLine());
            if (n == 0) {
                System.out.println(1);
                continue;
            }
            int c = 1;
            int x = 0;
            for (int i=0; i<=31; i++) {
                if ((n&(c<<i)) == (c<<i)) {
                    x++;
                }
            }
            System.out.println((1<<x));
        }
    }
}
