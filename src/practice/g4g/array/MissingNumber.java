package practice.g4g.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MissingNumber {

    private static List<Integer> createArray(int n) {
        List<Integer> arr = new ArrayList<>(n);
        for (int i=1; i<=n; i++) arr.add(i);
        Random random = new Random();
        int i = random.nextInt(n);
        arr.remove(i);
        arr.add(i, arr.get(i-1));
        return arr;
    }

    private static void print(List<Integer> arr) {
        Iterator<Integer> iter = arr.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    private static int missingNumber(List<Integer> arr) {
        for (int i=0; i<arr.size(); i++) {
            int index = arr.get(i);
            int val = arr.get(Math.abs(index));
            if (val < 0) return Math.abs(val);
            arr.remove(Math.abs(index));
            arr.add(Math.abs(index), -1*val);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = createArray(10);
        print(arr);
        System.out.println(missingNumber(arr));
    }

}
