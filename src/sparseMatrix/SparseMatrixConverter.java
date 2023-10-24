package sparseMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SparseMatrixConverter {
	static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> sparseMatrix = new ArrayList<>();

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

	public static int countNonZeroElements() {
		int nonZeroElements = 0;
		for (ArrayList<Integer> row : matrix) {
			for (int element : row) {
				if (element != 0) {
					nonZeroElements++;
				}
			}
		}
		return nonZeroElements;
	}

	public static void convertToSparse() {
		int nonZeroElements = countNonZeroElements();
		sparseMatrix.add(new ArrayList<>(List.of(matrix.size(), matrix.get(0).size(), nonZeroElements)));

		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(i).size(); j++) {
				int element = matrix.get(i).get(j);
				if (element != 0) {
					sparseMatrix.add(new ArrayList<>(List.of(i, j, element)));
				}
			}
		}

		System.out.println("The sparse matrix representation is:");

		for (ArrayList<Integer> row : sparseMatrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		getMatrix();
		convertToSparse();
	}
}
