package find_greatest;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] array = new int[10000000];
		for (int i = array.length - 1; i > -1; i--) {
			Random random = new Random();
			array[i] = random.nextInt() % array.length;
//			array[i] = 7;
		}
		FindGreatestIndex program = new FindGreatestIndex(array);
		program.runProgram();
	}
}
