package adt.heap;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        HeapImpl<Integer> heap = new HeapImpl<>((o1, o2) -> o1.compareTo(o2));
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        System.out.println(Arrays.toString(heap.toArray()));
        heap.heapsort(new Integer[]{34, 92, 5, 12, 49, 20, 43, 6});
        System.out.println(Arrays.toString(heap.toArray()));
        System.out.println(heap.isEmpty());
        heap.insert(3);
        System.out.println(Arrays.toString(heap.toArray()));
        System.out.println(heap.isEmpty());
    }
}
