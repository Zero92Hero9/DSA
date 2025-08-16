import java.util.Arrays;

public class TransposeMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
			{1,2,3},
			{4,5,6}
		};

		System.out.println(Arrays.deepToString(transposeMatrix(matrix)));
	}

	private static int[][] transposeMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = rows > 0 ? matrix[0].length : 0;
		int[][] transposedArr = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				transposedArr[j][i] = matrix[i][j];
			}
		}

		return transposedArr;
	}
}