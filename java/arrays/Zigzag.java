import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Zigzag {
	public static void main(String[] args) {
		int[][] matrix = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};

		int rows = matrix.length;
		int cols = matrix[0].length;
		List<Integer> result = new ArrayList<>();

		int i = rows-1;
		int j = cols-1;
		int index = 0;
		String direction = "up";

		while (index < rows * cols) {
			result.add(matrix[i][j]);
			if (direction.equals("up")) {
				 if (i - 1 < 0) {					
					direction = "down";
					j -= 1;
				 } else {
					i -=1;
				}
			} else {
				if (i + 1 == rows) {
					direction = "up";
					j -= 1;
				} else {
					i += 1;
				}
			}

			index++;
		}

		System.out.println(result);
	}
}