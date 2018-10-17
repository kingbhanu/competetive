package codeforces.CF1064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D {

    private static boolean debug = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        String nm[] = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String rc[] = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        String xy[] = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        char in[][] = new char[n+1][m+1];
        for (int i=1;i<=n;i++) {
            String line = br.readLine();
            int j = 1;
            for (char curr : line.toCharArray()) {
                in[i][j++] = curr;
            }
        }

        // solution
        Queue<State> queue = new LinkedList<>();
        int visited[][]= new int[n+1][m+1];
        for (int i=0; i<=n; i++) Arrays.fill(visited[i], Integer.MIN_VALUE);
        int count[][] = new int[n+1][m+1];
        int ans = 0;
        queue.add(new State(r,c,x,y));
        visited[r][c] = queue.peek().x + queue.peek().y;
        count[r][c] = 1;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (debug) System.out.println(state);
            if (count[state.r][state.c] == 1)
                ans++;

            if (State.isValidState(in, state.r, state.c-1, n, m,state.x-1, state.y) &&
                    State.checkAgain(visited[state.r][state.c-1], state.x-1, state.y)) {

                queue.add(new State(state.r, state.c-1, state.x-1, state.y));
                visited[state.r][state.c-1] = state.x-1 + state.y;
                count[state.r][state.c-1] += 1;
            }
            if (State.isValidState(in, state.r, state.c+1, n, m,state.x, state.y-1) &&
                    State.checkAgain(visited[state.r][state.c+1], state.x, state.y-1)) {

                queue.add(new State(state.r, state.c+1, state.x, state.y-1));
                visited[state.r][state.c+1] = state.x + state.y-1;
                count[state.r][state.c+1] += 1;
            }
            if (State.isValidState(in, state.r-1, state.c, n, m,state.x, state.y) &&
                    State.checkAgain(visited[state.r-1][state.c], state.x, state.y)) {

                queue.add(new State(state.r-1, state.c, state.x, state.y));
                visited[state.r-1][state.c] = state.x + state.y;
                count[state.r-1][state.c] += 1;
            }
            if (State.isValidState(in, state.r+1, state.c, n, m, state.x, state.y) &&
                    State.checkAgain(visited[state.r+1][state.c], state.x, state.y)) {

                queue.add(new State(state.r+1, state.c, state.x, state.y));
                visited[state.r+1][state.c] = state.x + state.y;
                count[state.r+1][state.c] += 1;
            }
        }
        System.out.println(ans);
    }


    static class State {

        int r,c,x,y;

        public State(int r, int c, int x, int y) {
            this.x = x;
            this.c = c;
            this.y = y;
            this.r = r;
        }

        public static boolean isValidState(char[][] in, int r, int c, int n, int m, int x, int y) {
            return (r>0 && r<=n && c>0 && c<=m && x>=0 && y>=0 && in[r][c] != '*');
        }

        public static boolean checkAgain(int old, int fx, int fy) {
            return (old < fx+fy);
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            return sb.append(this.r)
                    .append("::").append(this.c)
                    .append("::").append(this.x)
                    .append("::").append(this.y).toString();
        }

    }

}
