package codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


// @problem : https://www.codechef.com/AUG18B/problems/PROBLEMS

public class PROBLEMS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ps[] = br.readLine().split(" ");
        int p = Integer.parseInt(ps[0]);
        int s = Integer.parseInt(ps[1]);
        Pair difficulty[] = new Pair[p];
        for (int i=0; i<p; i++) {
            String score[] = br.readLine().split(" ");
            String numOfCons[] = br.readLine().split(" ");
            Pair task[] = new Pair[s];
            for (int j=0; j<s; j++) {
                task[j] = new Pair(Integer.parseInt(score[j]), Integer.parseInt(numOfCons[j]));
            }
            Arrays.sort(task, Comparator.comparing(Pair::getScore));
            int c = 0;
            for (int j=0; j<s-1; j++) {
                if (task[j].n > task[j+1].n) {
                    c++;
                }
            }
            difficulty[i] = new Pair(c,i+1);
        }
        Arrays.sort(difficulty, (a,b) -> {
            if (a.s == b.s) return a.n - b.n;
            return a.s-b.s;
        });
        for (int i=0; i<p; i++) System.out.println(difficulty[i].n);
    }
}

class Pair {
    int s, n;
    Pair(int s, int n) {
        this.s = s;
        this.n = n;
    }
    public int getScore() {
        return this.s;
    }
}
