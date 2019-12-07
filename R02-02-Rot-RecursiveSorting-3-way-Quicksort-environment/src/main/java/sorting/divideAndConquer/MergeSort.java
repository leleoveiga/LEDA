package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
    
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int m = (leftIndex + rightIndex) / 2;
            sort(array, leftIndex, m);
            sort(array, m + 1, rightIndex);
            merge(array, leftIndex, rightIndex);
        }
    }
    
    private void merge(T[] array, int leftIndex, int rightIndex) {
        T[] aux = Arrays.copyOf(array, array.length);
        int m = ((leftIndex + rightIndex) / 2) + 1;
        int l = leftIndex;
        int r = m;
        int auxIndex = leftIndex;
    
        while (l < m && r <= rightIndex && l < r) {
            if (aux[l].compareTo(aux[r]) < 0) {
                array[auxIndex] = aux[l];
                auxIndex++;
                l++;
            } else {
                array[auxIndex] = aux[r];
                auxIndex++;
                r++;
            }
        }
        
        while (l < m) {
            array[auxIndex] = aux[l];
            l++;
            auxIndex++;
        }
        
        while (r <= rightIndex) {
            array[auxIndex] = aux[r];
            r++;
            auxIndex++;
        }
        
        
    }
}
	
	