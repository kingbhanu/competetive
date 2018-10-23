package codeforces.CF1054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> l = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> r = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int out[] = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            out[i] = l.get(i) + r.get(i);
            max = Math.max(max, out[i]);
        }
        max++;
        for (int i=0; i<n; i++) {
            out[i] = max - out[i];
        }

        //verify
        boolean verify = true;
        // current element
        for (int i=0; i<n; i++) {
            int count = 0;
            // element on left
            for (int j=0; j<i; j++) {
                count += (out[i]<out[j] ? 1 : 0);
            }
            if (count != l.get(i)) {
                verify = false;
                break;
            }
        }
        if (verify) {
            // current element
            for (int i=n-1; i>=0; i--) {
                int count = 0;
                // element on right
                for (int j=i; j<n; j++) {
                    count += (out[i]<out[j] ? 1 : 0);
                }
                if (count != r.get(i)) {
                    verify = false;
                    break;
                }
            }
        }
        if (verify) {
            System.out.println("YES");
            Arrays.stream(out).forEach(x -> System.out.print(x + " "));
        } else {
            System.out.println("NO");
        }
    }

}
