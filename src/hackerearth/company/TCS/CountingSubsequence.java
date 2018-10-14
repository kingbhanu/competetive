package hackerearth.company.TCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();
        int Q = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[Q];
        for(int i_arr=0; i_arr<Q; i_arr++)
        {
            arr[i_arr] = br.readLine();
        }

        int[] out_ = helpPrivateRyan(S, arr);
        System.out.print(out_[0]);
        for(int i_out_=1; i_out_<out_.length; i_out_++)
        {
            System.out.print(" " + out_[i_out_]);
        }

        wr.close();
        br.close();
    }
    static int[] helpPrivateRyan(String S, String[] arr){
        // Write your code here
        int ans[] = new int[arr.length];
        Map<String, List<Integer>> points = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            List<Integer> arr2 = new ArrayList<>();
            arr2.add(i);
            points.put(S.substring(i,i+1), arr2);
            if (points.containsKey(S.substring(i,i+1))) {
                points.get(S.substring(i,i+1)).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                points.put(S.substring(i,i+1), indexes);
            }
        }

        //process
        for (int i=0; i<arr.length; i++) {
            String curr = arr[i];
            List<Integer> indexes = points.get(curr);
            if ((null == indexes) || (0 == indexes.size())) {
                ans[i] = 0;
            } else {
                for (int index : indexes)
                    ans[i] = (ans[i] + mult(index)%1000000007) % 1000000007;
            }
        }

        return ans;
    }

    private static int mult(int index) {
        int ans = 0;
        int two = 2;
        for (int i=1; i<index; i++) {
            ans = (ans + (two*2)%1000000007) % 1000000007;
        }
        return ans==0 ? 2 : ans%1000000007;
    }

}
