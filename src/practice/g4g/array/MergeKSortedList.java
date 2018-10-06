package practice.g4g.array;


// @problem :       https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
//
// @application :   External sort
//                  Database sort the results using external sort and since
//                  the size is greater than RAM available, we bring in K pages
//                  and sort them and then merge them.
//
// @see :           https://www.youtube.com/watch?v=YjFI9CJy6x0 - 1:00:00


import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Iterator;

public class MergeKSortedList {

    private List<Node> sortedLists;

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        mergeKSortedList.sortedLists = new ArrayList<>();
        mergeKSortedList.sortedLists.add(createList(new int[]{5,7,8,10}));
        mergeKSortedList.sortedLists.add(createList(new int[]{1,2,3,6}));
        mergeKSortedList.sortedLists.add(createList(new int[]{3,7,11,12}));
        mergeKSortedList.sortedLists.add(createList(new int[]{4,7,8,10}));
        mergeKSortedList.sortedLists.add(createList(new int[]{1,3,4,6}));
        mergeKSortedList.print(mergeKSortedList.merge());
    }

    private List<Node> merge() {
        List<Node> list = new LinkedList<>();
        PriorityQueue<Node> minHeap = createMinHeap();
        while (Integer.MAX_VALUE != minHeap.peek().value) {
            Node curr = minHeap.poll();
            list.add(curr);
            minHeap.add((curr.next == null) ? new Node(Integer.MAX_VALUE) : curr.next);
        }
        return list;
    }

    private PriorityQueue<Node> createMinHeap() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int n = this.sortedLists.size();
        while (n-- > 0) {
            priorityQueue.add(this.sortedLists.get(n));
        }
        return priorityQueue;
    }

    private void print(List<Node> list) {
        Iterator<Node> iterator = list.iterator();
        while (iterator.hasNext()) {
            Node curr = iterator.next();
            System.out.print(curr.value + " ");
        }
    }

    private static Node createList(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i=1; i<arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    private static class Node implements Comparable<Node> {
        int value;
        Node next;

        public Node(int v) {
            this.value = v;
        }

        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }

    /*
     * this is called with heapify(0)
     *
     * heapify(int index) {
     *     int smallest = index;            // top most element; but now needs re-balancing
     *     int left = getLeft(smallest);    // left index -  2*i+1
     *     int right = getRight(smallest);  // right index -  2*i+2
     *     if (arr[smallest] < arr[left]
     *         smallest = left;
     *     if (arr[smallest] < arr[right]
     *         smallest = right;
     *     if (smallest != index) {
     *         int temp = arr[index];
     *         arr[index] = arr[smallest];
     *         arr[smallest] = temp;
     *         heapify(smallest);
     *     }
     * }
     *
     */

}
