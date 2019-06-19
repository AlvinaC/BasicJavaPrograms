package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class Equalize {

    public static void main(String[] args) throws Exception {
        try {
            Scanner s = new Scanner(System.in);
            int tc = s.nextInt();
            int count = 0;
            int prev = -1;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < tc; i++) {
                int n = s.nextInt();
                int sum = 0;
                int smallest = -1;
                for (int j = 0; j < n; j++) {
                    int val = s.nextInt();
                    sum = sum + val;
                    if (prev != -1) {
                        if (val == prev)
                            count++;
                    }
                    prev = val;
                    if (smallest == -1)
                        smallest = val;
                    else {
                        if (val < smallest)
                            smallest = val;
                    }
                }
                if (count == n - 1)
                    list.add(0);
                else {
                    int minOps = sum - n * smallest;
                    list.add(minOps);
                }
                count = 0;
                sum = 0;
            }
            for (int i = 0; i < tc; i++)
                System.out.println(list.get(i));
        } catch (Exception e) {

        }
    }
}
