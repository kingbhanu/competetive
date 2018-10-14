package hackerearth.company.TCS;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MatrixMinimisation {

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm[] = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long mat1[][] = new long[n][m];
        long row[] = new long[n];
        long col[] = new long[m];
        long rm = Long.MAX_VALUE;
        long cm = Long.MAX_VALUE;
        boolean rmn=false,cmn=false;
        long tot=0;
        for (int i=0; i<n; i++) {
            String in[] = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                mat1[i][j] = Long.parseLong(in[j]);
                row[i] += mat1[i][j];
                if (mat1[i][j]<0) rmn = true;
                tot += mat1[i][j];
            }
            if (rm > row[i]) rm = row[i];
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                col[i] += mat1[j][i];
                if (mat1[j][i]<0) cmn = true;
            }
        }
        for (int i=0; i<m; i++)
            if (cm > col[i]) cm = col[i];

        if (rm<cm && rmn) {
            System.out.println(tot-rm);
        } else if (cm<rm && cmn) {
            System.out.println(tot-cm);
        } else {
            System.out.println(tot);
        }
    }

}
