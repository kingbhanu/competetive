package codeforces.CF1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int a : arr) {
            sum += a;
            max = Math.max(max, a);
        }
        int k = 0;
        while (true) {
            if ((n * k) - 2*sum > 0 && k >= max) break;
            k++;
        }
        System.out.println(k);
    }

}
