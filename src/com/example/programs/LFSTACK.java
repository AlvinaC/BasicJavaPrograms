package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class LFSTACK {
	public static void main(String[] args) {

		try {
			LFSTACK stck = new LFSTACK();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < tc; i++) {
				Integer noT = Integer.parseInt(reader.readLine().trim());
				CopyOnWriteArrayList<Stack<Integer>> visited = new CopyOnWriteArrayList<Stack<Integer>>();
				int totalNo = 0;
				for (int j = 0; j < noT; j++) {
					String[] strAry = reader.readLine().trim().split(" ");
					Integer len = Integer.parseInt(strAry[0]);
					totalNo = totalNo + len;
					Stack<Integer> mystack = new Stack<Integer>();
					for (int h = 0, k = 1; h < len; h++, k++) {
						mystack.push(Integer.parseInt(strAry[k]));
					}
					visited.add(mystack);
				}
				int[] result = new int[totalNo];

				String[] strAry = reader.readLine().trim().split(" ");
				for (int j = 0; j < strAry.length; j++)
					result[j] = Integer.parseInt(strAry[j]);
				Stack<Integer> mystack = new Stack<Integer>();
				mystack.push(result[0]);
				if (noT == 1) {

					Stack<Integer> stack = new Stack<Integer>();
					for (int k = 0; k < result.length; k++) {
						stack.push(visited.get(0).elementAt(k));
					}
					boolean flag = true;
					for (int k = 0; k < result.length; k++) {
						if (stack.peek() == result[k]) {
							stack.pop();
							continue;
						} else {
							flag = false;
							break;
						}
					}
					if (flag)

						list.add("Yes");
					else
						list.add("No");
				} else {
					String resS = stck.checkIfValidStack(noT, visited, result, mystack, 0);
					list.add(resS);
				}
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String checkIfValidStack(Integer noT, CopyOnWriteArrayList<Stack<Integer>> visited, int[] result,
			Stack<Integer> mystack, int pos) {
		if (visited.size() == 0 && pos == result.length)
			return "Yes";
		for (int i = 0; i < visited.size(); i++) {
			int one = visited.get(i).peek();
			int two = mystack.peek();
			if (one == two) {
				visited.get(i).pop();
				if (visited.get(i).size() == 0)
					visited.remove(i);
				pos++;
				if (pos < result.length)
					mystack.push(result[pos]);
				String resS = checkIfValidStack(noT, visited, result, mystack, pos);
				return resS;
			}
		}
		return "No";
	}
}
