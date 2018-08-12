package codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// @problem : https://www.codechef.com/AUG18B/problems/SPELLBOB

public class SPELLBOB {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0) {
            String top = br.readLine();
            String bottom = br.readLine();
            int bc = 0, oc = 0, obc = 0;
            for(int i=0; i<top.length(); i++) {
                char t = top.charAt(i);
                char b = bottom.charAt(i);
                if ((t == 'b' && b == 'o') || (t == 'o' && b == 'b')) {
                    obc++;
                    continue;
                }
                if (t == 'b' || b == 'b') bc++;
                if (t == 'o' || b == 'o') oc++;
            }
            if (bc + obc + oc > 2 && oc < 2 && bc < 3) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
