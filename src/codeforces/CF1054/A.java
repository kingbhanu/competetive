package codeforces.CF1054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().split(" ");

        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);
        int z = Integer.parseInt(in[2]);
        int t1 = Integer.parseInt(in[3]);
        int t2 = Integer.parseInt(in[4]);
        int t3 = Integer.parseInt(in[5]);

        int stair = Math.abs(x-y)*t1;
        int wait = Math.abs(z-x)*t2 + 2*t3;
        int lift = wait + Math.abs(x-y)*t2 + t3;
        System.out.println(stair >= lift ? "YES" : "NO");
    }

}
