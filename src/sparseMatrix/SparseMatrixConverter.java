package sparseMatrix;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SparseMatrixConverter {
	static int numRow = 0;
	static int columnCount = 0;
	static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> sparsMatrix = new ArrayList<>();

	public static void getMatrix() {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the matrix (each row on a new line, elements separated by space):");

		while (input.hasNextLine()) {
			String rowInput = input.nextLine().trim();

			if (rowInput.isEmpty()) {
				break;
			}

			String[] elements = rowInput.split(" ");
			ArrayList<Integer> row = new ArrayList<>();

			for (String element : elements) {
				row.add(Integer.parseInt(element));
			}
			matrix.add(row);
		}

		System.out.println("The matrix you entered is:");

		for (ArrayList<Integer> row : matrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static int nonzerocounter() {
		int nonzeroElement = 0;
		for (ArrayList<Integer> row : matrix) {
			for (int element : row) {
				if (element != 0) {
					nonzeroElement++;
				}
			}
		}
		return nonzeroElement;
	}

	public static void toSpars() {
		int[][] tempspars=new int[matrix.size()][3];
		int[] firstRow = {matrix.size(), matrix.get(0).size(),nonzerocounter()};
		for (int i = 0; i < firstRow.length; i++) {
			sparsMatrix.get(0).add(firstRow[i]);
		}
	}

	public static void main(String[] args) {
		getMatrix();
		System.out.println("nonzero"+nonzerocounter());
		toSpars();
		System.out.println("row"+matrix.size());
		System.out.println("col"+matrix.get(0).size());
		System.out.println("col"+matrix.get(0).size());
		

	}
}
