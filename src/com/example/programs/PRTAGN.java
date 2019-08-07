package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class PRTAGN {

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			PRTAGN p = new PRTAGN();
			ArrayList<obj> list = new ArrayList<obj>();
			for (int i = 0; i < tc; i++) {
				int q = Integer.parseInt(reader.readLine().trim());
				LinkedHashSet<Integer> set = new LinkedHashSet<>();
				Integer countE = 0;
				Integer countO = 0;
				for (int j = 0; j < q; j++) {
					Integer x = Integer.parseInt(reader.readLine().trim());
					if (!set.contains(x)) {
						// boolean status = set.add(x);
						// if (status) {
						set.add(x);
						Integer count = countSetBits(x);
						if (count % 2 == 0)
							countE++;
						else
							countO++;

						LinkedHashSet<Integer> temp = new LinkedHashSet<>();
						Iterator<Integer> localit = set.iterator();
						while (localit.hasNext()) {
							Integer tempVal = localit.next();
							if (tempVal != x) {
								Integer xor = x ^ tempVal;
								temp.add(xor);
							}
						}
						if (temp.size() > 0) {
							Iterator<Integer> itr = temp.iterator();
							while (itr.hasNext()) {
								Integer curVal = itr.next();
								// boolean go = set.add(curVal);
								if (!set.contains(curVal)) {
									set.add(curVal);
									// if (go) {
									Integer counter = countSetBits(curVal);
									if (counter % 2 == 0)
										countE++;
									else
										countO++;
									// }
								}
							}
							list.add(p.new obj(countE, countO));
						} else
							list.add(p.new obj(countE, countO));
					} else
						list.add(p.new obj(countE, countO));
				}
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).even + " " + list.get(i).odd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static Integer countSetBits(Integer ele) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((ele & 1) == 1) {
				count++;
			}
			ele = ele >>> 1;
		}
		return count;

	}

	class obj {
		Integer even;
		Integer odd;

		public obj(Integer even, Integer odd) {
			super();
			this.even = even;
			this.odd = odd;
		}
	}
}
