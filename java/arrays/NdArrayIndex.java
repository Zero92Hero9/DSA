import java.util.Arrays;

public class NdArrayIndex {
	public static void main(String[] args) {
		int[][] apartments = {{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12}};

		parseArray(apartments);
		replaceLockerCode(apartments, 45);
		parseArray(apartments);

	}

	private static void replaceLockerCode(int[][] apartments, int lockerCode) {
		apartments[0][1] = lockerCode;
	}

	private static void parseArray(int[][] apartments) {
		for (int i = 0; i < apartments.length; i++) {
			for (int j = 0; j < apartments[i].length; j++) {
				System.out.print(apartments[i][j] +",");
			}
			System.out.println();
		}
	}
}