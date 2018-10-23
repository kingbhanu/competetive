package codeforces.CF1054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().split(" ");
        int max = 0;
        int i = 0;
        boolean e = false;
        for (; i<n; i++) {
            int curr = Integer.parseInt(in[i]);
            if (curr > max) {
                e = true;
                break;
            } else {
                max = Math.max(max,curr+1);
            }
        }
        if (e) System.out.println(i+1);
        else System.out.println(-1);
    }

}