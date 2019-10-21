package problems;

public class tste {
	
	public static void main(String[] args) {
		OrderStatisticsSortedUnion<Integer> sort = new OrderStatisticsSortedUnion<>();
		
		Integer[] array1 = {1, 3, 4, 6};
		Integer[] array2 = {2, 7, 8, 10};
		int k = 5;
		
		System.out.println(sort.statisticsOrder(array1, array2, k));
	}

}
