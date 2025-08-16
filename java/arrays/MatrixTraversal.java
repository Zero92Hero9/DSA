import java.util.List;
import java.util.ArrayList;

public class MatrixTraversal {
	public static void main(String[] args) {
		int[][] matrix = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};

		int rows = matrix.length - 1;
		int cols = matrix[0].length - 1;
		List<Integer> result = new ArrayList<>();

		for (int i = rows; i >= 0; i--) {
			for (int j = cols; j >= 0 ; j--) {
				result.add(matrix[i][j]);
			}
		}

		System.out.println(result);

	}
}