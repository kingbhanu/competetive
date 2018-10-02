package practice.acm.arrays;

import java.util.Arrays;

/**
 *
 *
 * @problem : https://helloacm.com/the-wiggle-sort-algorithm-on-array-of-integers/
 * @author  : swayam raina
 * @type    : arrays
 *
 */
public class WiggleSortedNumbers {

    public static void main(String[] args) {
        int arr[] = {3,5,2,6,1,4,7};
        int[] copy = Arrays.copyOf(arr, arr.length);
        print(wibbleSort1(copy));
        copy = arr;
        print(wibbleSort2(copy));
    }

    // O(nlogn)
    private static int[] wibbleSort1(int arr[]) {
        if (arr.length < 3) throw new IllegalStateException("Array size should be greater than 2");
        Arrays.sort(arr);
        for (int i=2; i<arr.length; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
        return arr;
    }

    // O(n)
    private static int[] wibbleSort2(int arr[]) {
        if (arr.length < 3) throw new IllegalStateException("Array size should be greater than 2");
        // odd index is actually even index
        // as count starts from 0
        for (int i=1; i<arr.length; i++) {
            // if current index is even
            // the element should be greater than the prev
            // similarly, for odd, element should be smaller than prev
            if ((i%2==1) == arr[i]<arr[i-1]) {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }
        return arr;
    }

    private static void print(int arr[]) {
        for (int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }

}
