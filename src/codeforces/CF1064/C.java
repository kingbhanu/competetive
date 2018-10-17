package codeforces.CF1064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in = br.readLine();
        char arr[] = in.toCharArray();
        Arrays.sort(arr);
        System.out.println(arr);
    }

}
