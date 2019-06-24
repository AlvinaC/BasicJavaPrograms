package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.codechef.com/problems/RAINBOWA

//test case
//1
//14
//1 2 3  4 5 6 7 7 6 5 4 3 2 1
//yes

//1
//15
//1 2 3 4 5 6 7 7 7 6 5 4 3 2 1
//yes

public class RainbowArray {

    public static void main(String[] args) throws Exception {
        try {
            Scanner s = new Scanner(System.in);
            RainbowArray r = new RainbowArray();
            ArrayList<String> list = new ArrayList<>();
            int tc = s.nextInt();
            for (int i = 0; i < tc; i++) {
                int n = s.nextInt();
                int[] a = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = s.nextInt();
                }
                String res = r.checkNow(a);
                list.add(res);
            }
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
        } catch (Exception e) {

        }
    }

    private String checkNow(int[] a) {
        int count = 0;
        if (a[0] != 1)
            return "no";
        for (int i = 0, j = a.length - 1; i <= j; j--, i++) {
            if (a[i] > 7 || a[i] < 1)
                return "no";
            if (a[i] == a[j] && ((Math.abs(a[i + 1] - a[i]) == 1.0) || (a[i + 1] - a[i] == 0))) {
                if ((Math.abs(a[i + 1] - a[i]) == 1.0))
                    count++;
                continue;
            } else
                return "no";
        }
        if (a.length % 2 == 0) {
            count++;
        } else {
            if (a[a.length / 2] - a[(a.length / 2) - 1] == 0) {
                count++;
            }
        }
        if (count == 7)
            return "yes";
        return "no";
    }
}
