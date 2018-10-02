package practice.acm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * @problem : https://helloacm.com/how-to-search-in-2d-sorted-matrix/
 * @author  : swayam raina
 * @type    : arrays
 *
 */
public class SearchIn2DMatrix {

    private boolean search(List<List<Integer>> matrix, int value) {
        if (null == matrix || 0 == matrix.size()) return false;
        int rowIndex = binarySearchRow(matrix, value, 0, matrix.size()-1);
        return binarySearchColumn(matrix, value, 0, matrix.get(0).size()-1, rowIndex);
    }

    private int binarySearchRow(List<List<Integer>> matrix, int value, int s, int e) {
        int mid = 0;
        while (s<=e) {
            mid = (s+e)/2;
            if (value == matrix.get(mid).get(0)) return mid;
            if (value > matrix.get(mid).get(0)) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        int size = matrix.get(0).size()-1;
        if (e < 0) return -1;
        return value > matrix.get(e).get(size) ? s : e;
    }

    private boolean binarySearchColumn(List<List<Integer>> matrix, int value, int s, int e, int rowIndex) {
        if (matrix.size() <= rowIndex || 0 > rowIndex) return false;
        int mid = 0;
        while (s<=e) {
            mid = (s+e)/2;
            if (value == matrix.get(rowIndex).get(mid)) return true;
            if (s == e) return false;
            if (value > matrix.get(rowIndex).get(mid)) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> r1 = Arrays.asList(1,3,5,7);
        List<Integer> r2 = Arrays.asList(8,10,11,15);
        List<Integer> r3 = Arrays.asList(17,18,19,21);
        List<Integer> r4 = Arrays.asList(23,25,30,31);
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(r1);
        matrix.add(r2);
        matrix.add(r3);
        matrix.add(r4);

        SearchIn2DMatrix searchIn2DMatrix = new SearchIn2DMatrix();
        System.out.println(false == searchIn2DMatrix.search(matrix, 0));
        System.out.println(false == searchIn2DMatrix.search(matrix, 33));
        System.out.println(true == searchIn2DMatrix.search(matrix, 31));
        System.out.println(false == searchIn2DMatrix.search(matrix, 16));
        System.out.println(true == searchIn2DMatrix.search(matrix, 19));
        System.out.println(false == searchIn2DMatrix.search(matrix, 4));
        System.out.println(false == searchIn2DMatrix.search(matrix, 28));
        System.out.println(true == searchIn2DMatrix.search(matrix, 5));
    }

}
