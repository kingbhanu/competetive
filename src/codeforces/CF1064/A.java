package codeforces.CF1064;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @link
 * @tag
 */
public class A {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String abc[] = br.readLine().split(" ");
        int a = Integer.parseInt(abc[0]);
        int b = Integer.parseInt(abc[1]);
        int c = Integer.parseInt(abc[2]);
        boolean ab = a+b>c;
        boolean ac = a+c>b;
        boolean bc = c+b>a;
        if (ab && ac && bc) {
            System.out.println(0);
        } else {
            int diff = 0;
            if (!ab) {
                diff = c-a-b;
            } else if (!ac) {
                diff = b-a-c;
            } else {
                diff = a-c-b;
            }
            System.out.println(diff+1);
        }
    }

}
