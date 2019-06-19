package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class Cnote {

    public static void main(String[] args) throws Exception {
        try {
            Scanner s = new Scanner(System.in);
            ArrayList<String> result = new ArrayList<>();
            int tc = s.nextInt();
            boolean flag = false;
            for (int i = 0; i < tc; i++) {
                int x = s.nextInt();
                int y = s.nextInt();
                int k = s.nextInt();
                int n = s.nextInt();
                for (int j = 0; j < n; j++) {
                    int pages = s.nextInt();
                    int price = s.nextInt();
                    if (pages >= (x - y) && price <= k) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    result.add("LuckyChef");
                } else
                    result.add("UnluckyChef");
                flag = false;
            }
            for (int i = 0; i < tc; i++)
                System.out.println(result.get(i));
        } catch (Exception e) {

        }
    }
}

