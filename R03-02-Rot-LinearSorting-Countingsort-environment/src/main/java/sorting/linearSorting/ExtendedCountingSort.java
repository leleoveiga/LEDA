package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int l, int r) {
		if (verifica(array, l, r)) {
			
			int maior = maxValue(array, l, r);
			int menor = minValue(array, l, r);

			int size = maior - menor + 1;

			Integer[] lista = new Integer[size];

			for (int i = 0; i < lista.length; i++) {
				lista[i] = 0;
			}

			for (int i = l; i <= r; i++) {
				lista[array[i] - menor]++;
			}

			int count = l;
			for (int i = 0; i < lista.length; i++) {
				while (lista[i] > 0) {
					array[count++] = i + menor;
					lista[i]--;
				}
			}
		}

	}

	private int maxValue(Integer[] array, int l, int r) {
		int maior = array[l];

		for (int i = l + 1; i <= r; i++) {
			if (maior < array[i]) {
				maior = array[i];
			}
		}

		return maior;
	}

	private int minValue(Integer[] array, int l, int r) {
		int menor = array[l];

		for (int i = l + 1; i <= r; i++) {
			if (menor > array[i]) {
				menor = array[i];
			}
		}

		return menor;
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