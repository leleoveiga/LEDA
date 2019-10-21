package problems;

/**
 * Dado dois arrays ordenados em ordem crescente, encontrar a k-esima
 * estatistica de ordem da uniao ordenada deles.
 * 
 * Restricoes: - os arrays nao possuem elementos em comum e nem repetidos - k eh
 * um numero compreendido entre 1 e array1.length + array2.length - caso o
 * k-esima estatistica de ordem nao exista, o metodo deve retornar null - voce
 * nao pode usar memoria extra - seu algoritmo deve ter complexidade
 * O(array1.length + array2.length). - voce nao pode usar nenhum metodo pronto
 * de manipulacao de arrays, exceto length.
 * 
 * @author adalbertocajueiro
 *
 */
public class OrderStatisticsSortedUnion<T extends Comparable<T>> {
	public T statisticsOrder(T[] array1, T[] array2, int k) {
		int i = 0;
		int j = 0;
		int pos = 0;

		while (i + j < array1.length + array2.length) {
			if (i == array1.length) {
				j++;
				pos = 1;
			} 
			else if (j == array2.length) {
				i++;
				pos = 0;
			}

			else if (array1[i].compareTo(array2[j]) < 0) {
				i++;
				pos = 0;
			}
			else if (array2[j].compareTo(array1[i]) < 0) {
				j++;
				pos = 1;
			}

			if (i + j == k) {
				if (pos == 0) {
					return array1[i - 1];
				} else {
					return array2[j - 1];
				}
			}
		}

		return null;
	}
}
