package find_greatest;

import java.util.Arrays;

// does work?

/**
 * 
 * @author kirkah
 * 
 *         Purpose: This class runs two algorithms, each a different approach,
 *         to find the largest index of the greatest element of an array of
 *         integers.
 *
 */
public class FindGreatestIndex {
	private int[] array;
	private FindGreatestInformation info;
	private int linearSearchComparisons;

	/**
	 * Purpose: Constructs a new instance of the FindGreatestElement class. Passed
	 * in the array in which to find the largest index of the greatest element.
	 * 
	 * @param array
	 */
	public FindGreatestIndex(int[] array) {
		this.array = array;
		this.info = new FindGreatestInformation(0); // Track comparisons through recursion
	}

	/**
	 * @author kirkah
	 * 
	 *         Purpose: Finds the largest index of the greatest element through a
	 *         divide-and-conquer approach and a linear search. Prints the index of
	 *         the greatest element, and the number of comparisons each algorithm
	 *         made.
	 */
	public void runProgram() {
//		System.out.println("Array: " + Arrays.toString(this.array));
		int greatestRecursive = findGreatestIndexRecursive(this.array, 0, this.array.length - 1);
		System.out.println("---------------------------------------------");
		System.out.println("Greatest by recursion: " + greatestRecursive);
		System.out.println("Comparisons through recursion: " + this.info.comparisons);
		System.out.println("---------------------------------------------");
		int greatestLinearSearch = findGreatestIndexLinearSearch(this.array);
		System.out.println("Greatest by linear search: " + greatestLinearSearch);
		System.out.println("Comparisons through linear search: " + this.linearSearchComparisons);

	}

	/**
	 * Purpose: Recursively finds the largest index of the greatest element of the
	 * array.
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int findGreatestIndexRecursive(int[] array, int start, int end) {
		int middle = (end + start) / 2;
		int greatestIndex;
		if (start == end) {
			return start;
		}
		int lmax = findGreatestIndexRecursive(array, start, middle);
		int rmax = findGreatestIndexRecursive(array, middle + 1, end);
		this.info.comparisons++;

		if (array[lmax] > array[rmax]) {
			greatestIndex = lmax;
		} else {
			greatestIndex = rmax;
		}
		return greatestIndex;
	}

	/**
	 * Purpose: Finds the index of the greatest element of the array through a
	 * linear search.
	 * 
	 * @param array
	 * @return
	 */
	private int findGreatestIndexLinearSearch(int[] array) {
		int greatestIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] >= array[greatestIndex]) {
				greatestIndex = i;
			}
			this.linearSearchComparisons++;
		}
		return greatestIndex;
	}

	/**
	 * 
	 * @author kirkah
	 * 
	 *         Purpose: Container class to hold the number of comparisons made
	 *         through the recursive divide-and-conquer approach to the problem.
	 *
	 */
	private class FindGreatestInformation {
		public int comparisons;

		/**
		 * Purpose: Constructs a new instance of the FindGreatestInformation class.
		 * 
		 * @param comparisons
		 */
		public FindGreatestInformation(int comparisons) {
			this.comparisons = comparisons;
		}
	}
}
