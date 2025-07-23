import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class ValidSudoku {
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
		};

		System.out.println(isValidUsingArray(board));


	}

	private static boolean isValid(char[][] board) {
		int dimensions = 9;
		HashSet<Character>[] rows = new HashSet[dimensions];
		HashSet<Character>[] columns = new HashSet[dimensions];
		HashSet<Character>[] boxes = new HashSet[dimensions];

		for (int i = 0; i < dimensions; i++) {
			rows[i] = new HashSet<Character>();
			columns[i] = new HashSet<Character>();
			boxes[i] = new HashSet<Character>();
		}

		for (int r = 0; r < dimensions; r++) {
			for (int c = 0; c < dimensions; c++) {
				char val = board[r][c];

				if (val == '.') {
					continue;
				}
				// check the row	
				if (rows[r].contains(val)) {
					return false;
				}

				rows[r].add(val);

				// check the column
				if (columns[c].contains(val)) {
					return false;
				}

				columns[c].add(val);

				//check the box
				int idx = (r/3) * 3 + (c/3);	
				if (boxes[idx].contains(val)) {
					return false;
				}
				boxes[idx].add(val);

			}
		}

		return true;
	}

	private static boolean isValidUsingArray(char[][] board) {
		int dim = 9;
		int[][] rows = new int[dim][dim];
		int[][] cols = new int[dim][dim];
		int[][] boxes = new int[dim][dim];
		
		for (int r = 0; r < dim; r++) {
			for (int c = 0; c < dim; c++) {
				
				if (board[r][c] == '.') {
					continue;
				}

				int pos = board[r][c] - '1';
				
				if (rows[r][pos] == 1) {
					return false;
				}
				rows[r][pos]=1;

				if (cols[c][pos] == 1) {
					return false;
				}
				cols[c][pos] =1;

				int idx = (r/3) * 3 + (c/3);
				if (boxes[idx][pos] == 1) {
					return false;
				}
				boxes[idx][pos]=1;
			}
		}
		return true;

	}
}