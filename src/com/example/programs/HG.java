package com.example.programs;

import java.util.ArrayList;

public class HG {
	public static int[][] C  = { { 0,0,0,0}, { 0,0,1,0 }, { 0,0,0,0}, { 0,0,1,0} };
	public static int[][] C_orig = new int[4][4];
	public static int[][] M = new int[4][4];
	public static int[][] path = new int[61][2];
	public static int[] RowCover = new int[4];
	public static int[] ColCover = new int[4];
	public static int nrow = 4;
	public static int ncol = 4;
	public static int path_count = 0;
	public static int path_row_0;
	public static int path_col_0;
	public static int asgn = 0;
	public static int step;

	public HG(int[][] c) {
		C = copyOf(c);
		C_orig = copyOf(c);
	}

	public int[][] copyOf(int[][] c) {
		int[][] copy = new int[4][4];
		for (int i = 0; i < c.length; i++) {
			// Need to do it this way, otherwise it copies only memory location
			System.arraycopy(c[i], 0, copy[i], 0, c[i].length);
		}

		return copy;
	}

	private static void resetMaskandCovers() {
		for (int r = 0; r < nrow; r++) {
			RowCover[r] = 0;
			for (int c = 0; c < ncol; c++) {
				M[r][c] = 0;
			}
		}
		for (int c = 0; c < ncol; c++)
			ColCover[c] = 0;
	}

	// For each row of the cost matrix, find the smallest element and subtract
	// it from every element in its row. When finished, Go to Step 2.
	private static void step_one() {
		int min_in_row;

		for (int r = 0; r < nrow; r++) {
			min_in_row = C[r][0];
			for (int c = 0; c < ncol; c++)
				if (C[r][c] < min_in_row)
					min_in_row = C[r][c];
			for (int c = 0; c < ncol; c++)
				C[r][c] -= min_in_row;
		}
		step = 2;
	}

	// Find a zero (Z) in the resulting matrix. If there is no starred
	// zero in its row or column, star Z. Repeat for each element in the
	// matrix. Go to Step 3.
	private static void step_two() {
		for (int r = 0; r < nrow; r++)
			for (int c = 0; c < ncol; c++) {
				if (C[r][c] == 0 && RowCover[r] == 0 && ColCover[c] == 0) {
					M[r][c] = 1;
					RowCover[r] = 1;
					ColCover[c] = 1;
				}
			}
		for (int r = 0; r < nrow; r++)
			RowCover[r] = 0;
		for (int c = 0; c < ncol; c++)
			ColCover[c] = 0;
		step = 3;
	}

	// Cover each column containing a starred zero. If K columns are covered,
	// the starred zeros describe a complete set of unique assignments. In this
	// case, Go to DONE, otherwise, Go to Step 4.
	private static void step_three() {
		int colcount;
		for (int r = 0; r < nrow; r++)
			for (int c = 0; c < ncol; c++)
				if (M[r][c] == 1)
					ColCover[c] = 1;

		colcount = 0;
		for (int c = 0; c < ncol; c++)
			if (ColCover[c] == 1)
				colcount += 1;
		if (colcount >= ncol || colcount >= nrow)
			step = 7;
		else
			step = 4;
	}

	// methods to support step 4
	private static int[] find_a_zero() {
		int[] row_col = new int[2];
		int r = 0;
		int c;
		boolean done;
		int row = -1;
		int col = -1;
		done = false;
		while (!done) {
			c = 0;
			while (true) {
				if (C[r][c] == 0 && RowCover[r] == 0 && ColCover[c] == 0) {
					row = r;
					col = c;
					done = true;
				}
				c += 1;
				if (c >= ncol || done)
					break;
			}
			r += 1;
			if (r >= nrow)
				done = true;
		}
		row_col[0] = row;
		row_col[1] = col;
		return row_col;
	}

	private static boolean star_in_row(int row) {
		boolean tmp = false;
		for (int c = 0; c < ncol; c++)
			if (M[row][c] == 1)
				tmp = true;
		return tmp;
	}

	private static int find_star_in_row(int row, int col) {
		col = -1;
		for (int c = 0; c < ncol; c++)
			if (M[row][c] == 1)
				col = c;

		return col;
	}

	// Find a noncovered zero and prime it. If there is no starred zero
	// in the row containing this primed zero, Go to Step 5. Otherwise,
	// cover this row and uncover the column containing the starred zero.
	// Continue in this manner until there are no uncovered zeros left.
	// Save the smallest uncovered value and Go to Step 6.
	private static void step_four() {
		int row = -1;
		int col = -1;
		boolean done;

		done = false;
		while (!done) {

			int[] row_col = find_a_zero();
			row = row_col[0];
			col = row_col[1];
			if (row == -1)

			{
				done = true;
				step = 6;
			} else {
				M[row][col] = 2;
				if (star_in_row(row)) {
					col = find_star_in_row(row, col);
					RowCover[row] = 1;
					ColCover[col] = 0;
				} else {
					done = true;
					step = 5;
					path_row_0 = row;
					path_col_0 = col;
				}
			}
		}
	}

	// methods to support step 5
	private static int find_star_in_col(int c, int r) {
		r = -1;
		for (int i = 0; i < nrow; i++)
			if (M[i][c] == 1)
				r = i;

		return r;
	}

	private static int find_prime_in_row(int r, int c) {
		for (int j = 0; j < ncol; j++)
			if (M[r][j] == 2)
				c = j;
		return c;
	}

	private static void augment_path() {
		for (int p = 0; p < path_count; p++)
			if (M[path[p][0]][path[p][1]] == 1)
				M[path[p][0]][path[p][1]] = 0;
			else
				M[path[p][0]][path[p][1]] = 1;
	}

	private static void clear_covers() {
		for (int r = 0; r < nrow; r++)
			RowCover[r] = 0;
		for (int c = 0; c < ncol; c++)
			ColCover[c] = 0;
	}

	private static void erase_primes() {
		for (int r = 0; r < nrow; r++)
			for (int c = 0; c < ncol; c++)
				if (M[r][c] == 2)
					M[r][c] = 0;
	}

	// Construct a series of alternating primed and starred zeros as follows.
	// Let Z0 represent the uncovered primed zero found in Step 4. Let Z1 denote
	// the starred zero in the column of Z0 (if any). Let Z2 denote the primed zero
	// in the row of Z1 (there will always be one). Continue until the series
	// terminates at a primed zero that has no starred zero in its column.
	// Unstar each starred zero of the series, star each primed zero of the series,
	// erase all primes and uncover every line in the matrix. Return to Step 3.
	private static void step_five() {
		boolean done;
		int r = -1;
		int c = -1;

		path_count = 1;
		path[path_count - 1][0] = path_row_0;
		path[path_count - 1][1] = path_col_0;
		done = false;
		while (!done) {
			r = find_star_in_col(path[path_count - 1][1], r);
			if (r > -1) {
				path_count += 1;
				path[path_count - 1][0] = r;
				path[path_count - 1][1] = path[path_count - 2][1];
			} else
				done = true;
			if (!done) {
				c = find_prime_in_row(path[path_count - 1][0], c);
				path_count += 1;
				path[path_count - 1][0] = path[path_count - 2][0];
				path[path_count - 1][1] = c;
			}
		}
		augment_path();
		clear_covers();
		erase_primes();
		step = 3;
	}

	// methods to support step 6
	private static int find_smallest(int minval) {
		for (int r = 0; r < nrow; r++)
			for (int c = 0; c < ncol; c++)
				if (RowCover[r] == 0 && ColCover[c] == 0)
					if (minval > C[r][c])
						minval = C[r][c];
		return minval;
	}

	// Add the value found in Step 4 to every element of each covered row, and
	// subtract
	// it from every element of each uncovered column. Return to Step 4 without
	// altering any stars, primes, or covered lines.
	private static void step_six() {
		int minval = Integer.MAX_VALUE;

		minval = find_smallest(minval);
		for (

				int r = 0; r < nrow; r++)
			for (int c = 0; c < ncol; c++) {
				if (RowCover[r] == 1)
					C[r][c] += minval;
				if (ColCover[c] == 0)
					C[r][c] -= minval;
			}
		step = 4;
	}

	private static void step_seven(int step) {

		System.out.println("\n\n---------Run Complete----------");
	}

	public static int findLargest()

	{
		int largest = 0;
		for (int i = 0; i < nrow; i++) {
			for (int j = 0; j < ncol; j++) {
				if (C[i][j] > largest) {
					largest = C[i][j];
				}
			}
		}

		return largest;
	}

	private static void genTestMatrix() {

		int maxWeight = findLargest();
		for (int i = 0; i < nrow; i++) {
			for (int j = 0; j < ncol; j++) {
				C[i][j] = (maxWeight - C[i][j]);
			}
		}
		resetMaskandCovers();
	}

	private static void InitMunkres() {

		genTestMatrix();

		step = 1;
	}

	private static int[] RunMunkres() {
		boolean done = false;

		while (!done) {
			ShowCostMatrix();
			ShowMaskMatrix();
			switch (step) {
			case 1:

				step_one();
				break;
			case 2:

				step_two();
				break;
			case 3:

				step_three();
				break;
			case 4:

				step_four();
				break;
			case 5:

				step_five();
				break;
			case 6:

				step_six();
				break;
			case 7:

				step_seven(step);
				done = true;
				break;

			}
		}
		int[] res = new int[4];
		int k = 0;

		
		return res;
	}

	private static void ShowCostMatrix() {

		System.out.println("\n");
		System.out.println("------------Step-------------" + step);
		for (int r = 0; r < nrow; r++) {

			System.out.println();
			System.out.println("     ");

			for (int c = 0; c < ncol; c++) {
				System.out.println(C[r][c] + " ");
			}
		}
	}

	private static void ShowMaskMatrix() {

		System.out.println();
		System.out.println("\n    ");

		for (int c = 0; c < ncol; c++)
			System.out.println(" " + ColCover[c]);

		for (int r = 0; r < nrow; r++) {
			System.out.println("\n  " + RowCover[r] + "  ");
			for (int c = 0; c < ncol; c++) {
				System.out.println(M[r][c] + " ");

			}
		}
	}

	public static void main(String[] args) {
		InitMunkres();
		RunMunkres();
		// Console.ReadKey();
	}

	public int[] runHG() {
		InitMunkres();
		return RunMunkres();
	}
}
