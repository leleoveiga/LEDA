package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	public int binarySearchFloor(Integer[] v, int i, int f, int x) {
		int m = (i+f)/2;
		if(i==f) {
			if(v[m] >= x) {
				return v[m-1];
			} else {
				return v[m];
			}
		}
		else if(v[m] == x) {
			return v[m-1];
		}
		else if(v[m] < x) {
			return binarySearchFloor(v, m+1, f, x);
		} else {
			return binarySearchFloor(v, i, m-1, x);
		}
	}
	
	@Override
	public Integer floor(Integer[] array, Integer x) {
		/**
		 * achou = array[i] == x return array[i]
		 * não achou : return null
		 *  
		 * 
		 */
		
		return binarySearchFloor(array, 0, array.length-1, x);
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
