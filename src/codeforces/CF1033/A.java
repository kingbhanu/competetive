package codeforces.CF1033;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class A {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];

        String q[] = br.readLine().split(" ");
        String k[] = br.readLine().split(" ");
        int qx = Integer.parseInt(q[0])-1;
        int qy = Integer.parseInt(q[1])-1;
        int kx = Integer.parseInt(k[0])-1;
        int ky = Integer.parseInt(k[1])-1;

        String f[] = br.readLine().split(" ");
        int x = Integer.parseInt(f[0])-1;
        int y = Integer.parseInt(f[1])-1;

        boolean exec = true;
        if (!(x>qx && kx>qx && y>qy && ky>qy ||
                x>qx && kx>qx && y<qy && ky<qy ||
                    x<qx && kx<qx && y<qy && ky<qy ||
                        x<qx && kx<qx && y>qy && ky>qy)) {
            System.out.println("NO");
            exec = false;
        }

        if (exec) {
            for (int i=0; i<n; i++) {
                board[i][qy] = 1;
                board[qx][i] = 1;
                if (qx-i >= 0 && qy-i < n && qx-i < n && qy-i >= 0) board[qx-i][qy-i] = 1;
                if (qx+i >= 0 && qy+i < n && qx+i < n && qy+i >= 0) board[qx+i][qy+i] = 1;
                if (qx-i >= 0 && qy+i < n && qx-i < n && qy+i >= 0) board[qx-i][qy+i] = 1;
                if (qx+i >= 0 && qy-i < n && qx+i < n && qy-i >= 0) board[qx+i][qy-i] = 1;
            }

            boolean check = true;
            Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(kx,ky));
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> p = queue.poll();
                //System.out.println("processing : " + p.getKey() + " " + p.getValue());
                visited[p.getKey()][p.getValue()] = true;
                if (p.getKey() == x && p.getValue() == y) {
                    check = false;
                    break;
                }
                addToQ(queue, p.getKey(), p.getValue(), n, visited, board);
            }
            System.out.println(!check ? "YES" : "NO");
        }

    }

    private static void addToQ(Queue<Pair<Integer,Integer>> queue, int x, int y, int n, boolean visited[][], int board[][]) {
        for (int i=-1;i<2;i++) {
            for (int j=-1;j<2;j++) {
                if (x+i >= 0 && x+i <n && y+j < n && y+j >= 0 && !visited[x+i][y+j] && board[x+i][y+j] == 0) {
                    queue.add(new Pair<>(x+i, y+j));
                    visited[x+i][y+j] = true;
                    //System.out.println("adding " + x+i + " " + y+j);
                }
            }
        }
    }

}
