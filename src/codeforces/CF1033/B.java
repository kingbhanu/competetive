package codeforces.CF1033;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String k[] = br.readLine().split(" ");
            long x = Long.parseLong(k[0]);
            long y = Long.parseLong(k[1]);
            long p1 = x+y;
            long p2 = Math.abs(x-y);
            System.out.println(p2==1 && isPrime(p1) ? "YES" : "NO");
        }
    }

    private static boolean isPrime(long a) {
        if (a%2==0) return false;
        for (int i=3;i*i<=a;i+=2) {
            if (a%i == 0) return false;
        }
        return true;
    }

}
