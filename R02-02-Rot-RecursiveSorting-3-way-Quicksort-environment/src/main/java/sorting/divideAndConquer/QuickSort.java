package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length == 0 || array.length == 1) return;
		quickSort(array, leftIndex, rightIndex);
	}

	public void quickSort(T[] lista, int l, int r) {
		int p = partition(lista, l, r);
		if (p > l) {
			quickSort(lista, l, p - 1);
		}
		if (p < r) {
			quickSort(lista, p + 1, r);
		}
	}
	
	public int partition(T[] lista, int l, int r) {
		int pivot = r;
		int i = l;
		int j = r;
		while (i < j) {
			if (lista[i].compareTo(lista[pivot]) <= 0) {
				i++;
			} else if (lista[j - 1].compareTo(lista[pivot]) >= 0) {
				j--;
			} else {
				Util.swap(lista, i, j - 1);
			}
		}
		Util.swap(lista, i, pivot);
		return i;

	}
}
