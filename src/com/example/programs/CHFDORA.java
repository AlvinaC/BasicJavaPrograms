package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CHFDORA {
	public static void main(String[] args) {
		try {
			CHFDORA t = new CHFDORA();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] str = reader.readLine().trim().split(" ");
				Integer n = Integer.parseInt(str[0]);
				Integer m = Integer.parseInt(str[1]);
				int[][] a = new int[n][m];
				for (int j = 0; j < n; j++) {
					str = reader.readLine().trim().split(" ");
					for (int h = 0; h < m; h++) {
						a[j][h] = Integer.parseInt(str[h]);
					}
				}
				calculate(a, n, m);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void calculate(int[][] a, int n, int m) {
		for (int f = 1; f < n - 1; f++) {
			for (int i = 0, j = 2; i < n - 1 && j < m; i++, j += 3) {
				boolean isPal = false;

				for (int h = i, k = j; h <= j / 2 && k >= j / 2; h++, k--) {
					if (a[i][h] == a[i][k]) {
						isPal = true;
						continue;
					} else {
						isPal = false;
						break;
					}
				}
				if (isPal) {
					int row = i - ((j + 1) / 2) - 1;
					int col = ((j + 1) / 2) - 1;
					for (int h = row, k = row + j; h <= j / 2 && k >= i / 2; h++, k--) {
						if (a[h][col] == a[k][col]) {
							isPal = true;
							continue;
						} else {
							isPal = false;
							break;
						}
					}
				}
			}
		}
	}
}
