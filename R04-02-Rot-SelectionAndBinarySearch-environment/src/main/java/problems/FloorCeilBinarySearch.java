package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: - Algoritmo in-place (nao pode usar memoria extra a nao ser
 * variaveis locais) - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	public int binarySearchFloor(Integer[] v, int i, int f, int x) {
		int m = (i + f) / 2;
		if (i > f) {
			return v[f];
		} else if (v[m] < x) {
			return binarySearchFloor(v, m + 1, f, x);
		} else if(v[m] > x){
			return binarySearchFloor(v, i, m - 1, x);
		} else {
			return v[m];
		}
	}
	public int binarySearchCeil(Integer[] v, int i, int f, int x) {
		int m = (i + f) / 2;
		if (i > f) {
			return v[i];
		} else if(v[m] > x){
			return binarySearchCeil(v, i, m - 1, x);
		} else if (v[m] < x) {
			return binarySearchCeil(v, m + 1, f, x);
		} else {
			return v[m];
		}
	}

	@Override
	public Integer floor(Integer[] array, Integer x) {
		/**
		 * achou = array[i] == x return array[i] 
		 * n�o achou : return null
		 * 
		 * 
		 */

		return binarySearchFloor(array, 0, array.length - 1, x);
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
