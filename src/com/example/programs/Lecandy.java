package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class Lecandy {

    public static void main(String[] args) {
        int tc;
        ArrayList<String> list = new ArrayList<>();
        Lecandy l = new Lecandy();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of testcase:");
        tc = s.nextInt();
        for (int i = 0; i < tc; i++) {
            System.out.println("Enter the no of elephants:");
            int n = s.nextInt();
            System.out.println("Enter the no of candies:");
            int c = s.nextInt();
            int[] k = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                k[j] = s.nextInt();
                sum = sum + k[j];
            }
            String result = l.checkNow(sum, c);
            list.add(result);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private String checkNow(int sum, int c) {
        if (sum > c)
            return "No";
        else return "Yes";
    }
}

