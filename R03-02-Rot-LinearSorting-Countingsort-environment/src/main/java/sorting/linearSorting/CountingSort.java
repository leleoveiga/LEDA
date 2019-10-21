package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int l, int r) {
		if (verifica(array, l, r)) {
			
			int maior = maiorValor(array, l, r);

			Integer[] lista = new Integer[maior + 1];

			for (int i = 0; i < lista.length; i++) {
				lista[i] = 0;
			}

			for (int i = l; i <= r; i++) {
				lista[array[i]]++;
			}

			int count = l;
			
			for (int i = 0; i < lista.length; i++) {
				while (lista[i] > 0) {
					array[count++] = i;
					lista[i]--;
				}
			}
		}

	}

	private int maiorValor(Integer[] array, int l, int r) {
		int maiorValor = array[l];

		for (int i = l + 1; i <= r; i++) {

			if (maiorValor < array[i]) {
				maiorValor = array[i];

			}
		}

		return maiorValor;
	}

	private boolean verifica(Integer[] array, int l, int r) {
		boolean ans = true;

		if (array.length <= 0 || array == null) {
			ans = false;

		} else if (l >= r || l < 0) {
			ans = false;

		} else if (r > array.length || r <= 0 || l >= array.length) {
			ans = false;
		}

		return ans;
	}
}