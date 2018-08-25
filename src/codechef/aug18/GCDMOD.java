package codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GCDMOD {

    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String abn[] = br.readLine().split(" ");
            long a = Long.parseLong(abn[0]);
            long b = Long.parseLong(abn[1]);
            long n = Long.parseLong(abn[2]);
            long diff = Math.abs(a-b);
            long mod = a==b ? 1000000007 : diff;
            long an = power(a, n, mod);
            long bn = power(b, n, mod);
            long sum = (an + bn) % mod;
            System.out.println(a==b ? sum : gcd(sum, diff));
        }
    }

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static long power(long x, long y, long m) {
        long ans = 1L;
        while (y>0) {
            if ((y&1)==1) {
                ans = multiply(ans, x, m);
            }
            y = y>>1;
            x = multiply(x, x, m);
        }
        return ans % m;
    }

    private static long multiply(long ans, long x, long m) {
        long ret = 0;
        while (x>0) {
            if ((x&1)==1)
                ret = (ret + ans) % m;
            ans = (ans + ans) % m;
            x>>=1;
        }
        return ret;
    }

}
