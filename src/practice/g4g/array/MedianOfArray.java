package practice.g4g.array;

import java.util.*;

public class MedianOfArray {

    private static final Comparator<Integer> comparator = (a,b) -> {
        return b-a;
    };

    private static List<Integer> createRandomArray(int n) {
        List<Integer> out = new ArrayList<>(n);
        Random random = new Random();
        for (int i=0; i<n; i++)
            out.add(random.nextInt(100));
        return out;
    }

    private static void print(String pre, List<Integer> in) {
        if (null != pre) System.out.print(pre + " -> ");
        Iterator<Integer> iter = in.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    private static int printLargestElement(int k, List<Integer> in) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
        Iterator<Integer> iter = in.iterator();
        while (iter.hasNext()) {
            maxHeap.add(iter.next());
        }
        // for even size we need middle two values
        // or kth and k-1 th largest elements
        if (in.size() % 2 == 0) k = k-1;
        while (k > 0) {
            maxHeap.poll();
            k--;
        }
        // for even elements median is average of middlemost elements
        return (in.size() % 2 == 0) ? (maxHeap.poll()+maxHeap.poll())/2 : maxHeap.peek();
    }

    public static void main(String[] args) {
        List<Integer> array1 = createRandomArray(10);
        List<Integer> array2 = createRandomArray(8);
        print("array1", array1);
        print("array2", array2);
        List<Integer> arr = new ArrayList<>();
        arr.addAll(array1);
        arr.addAll(array2);
        int s = (array1.size()+array2.size())/2;
        System.out.println(printLargestElement(s, arr));
        Collections.sort(arr);
        print("sorted array", arr);
        System.out.println(arr.get(s));
    }

}
