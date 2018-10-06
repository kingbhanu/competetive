package practice.g4g.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DotProduct {

    private static List<Integer> createRandomArray(int n) {
        List<Integer> out = new ArrayList<>(n);
        Random random = new Random();
        for (int i=0; i<n; i++)
            out.add(random.nextInt(100));
        return out;
    }

    private static void print(List<Integer> in) {
        Iterator<Integer> iter = in.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> array1 = createRandomArray(10);
        List<Integer> array2 = createRandomArray(8);
        print(array1);
        print(array2);
        int n = Math.min(array1.size(), array2.size());
        int dot = 0;
        for (int i=0; i<n; i++) {
            dot += array1.get(i) * array2.get(i);
        }
        System.out.println("dot -> " + dot);
    }

}
