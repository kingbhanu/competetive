package practice.g4g;


// @problem : https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/

public class RotateMatrix {

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int matrix[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateMatrix.print(rotateMatrix.rotate(matrix, 90));
    }

    private void print(int matrix[][]) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] rotate(int matrix[][], int degree) {
        int r = matrix.length;
        int c = matrix[0].length;
        int out[][] = new int[r][c];
        // transpose
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                out[i][j] = matrix[j][i];
            }
        }
        // reverse
        for (int i=0; i<r/2; i++) {
            for (int j=0; j<c; j++) {
                int temp = out[i][j];
                out[i][j] = out[r-1-i][j];
                out[r-1-i][j] = temp;
            }
        }
        return out;
    }

}
