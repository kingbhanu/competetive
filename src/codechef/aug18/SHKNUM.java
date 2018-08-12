package codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// @problem : https://www.codechef.com/AUG18B/problems/SHKNUM

public class SHKNUM {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            if (n==1) {
                System.out.println("2");
                continue;
            }
            if (n==3) {
                System.out.println("0");
                continue;
            }
            if (n==7) {
                System.out.println("1");
                continue;
            }
            int sb = setBits(n);
            // 2^n - 1
            if ((1<<sb)-n == 1) {
                System.out.println("2");
            } else if (sb==1) {
                System.out.println("1");
            } else {
                int x = base(n);
                int dx = n-x;
                int dxbase = base(dx);
                if (dx-dxbase > (dxbase<<1)-dx) {
                    if (1 == setBits(n + (dxbase<<1)-dx)) {
                        System.out.println(1+(dxbase<<1)-dx);
                    } else {
                        System.out.println((dxbase<<1)-dx);
                    }
                } else {
                    System.out.println(dx-dxbase);
                }
            }
        }
    }
    private static int setBits(int n) {
        int c = 0;
        while (n>0) {
            n = n & (n-1);
            c++;
        }
        return c;
    }
    private static int base(int n) {
        int x = 1;
        while (n>0) {
            n = n>>1;
            x = x<<1;
        }
        return x>>1;
    }
}
