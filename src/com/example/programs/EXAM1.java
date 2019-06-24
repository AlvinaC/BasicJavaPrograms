package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class EXAM1 {

    public static void main(String[] args) throws Exception {
        try {
            Scanner s = new Scanner(System.in);
            ArrayList<Integer> list = new ArrayList<>();
            EXAM1 c = new EXAM1();
            int tc = s.nextInt();
            for (int i = 0; i < tc; i++) {
                int n = s.nextInt();
                String an = s.next();
                String can = s.next();
                int sum = c.checkNow(an, can);
                list.add(sum);
            }
            for (int i = 0; i < tc; i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int checkNow(String an, String can) {
        int score = 0;
        boolean discard = false;
        for (int i = 0; i < an.length(); i++) {
            if (an.charAt(i) == can.charAt(i)) {
                if (!discard)
                    score++;
                discard = false;
            } else if (an.charAt(i) != can.charAt(i) && can.charAt(i) != 'N') {
                if (discard)
                    discard = false;
                else
                    discard = true;
            } else if (an.charAt(i) != can.charAt(i) && can.charAt(i) == 'N') {
                if (discard)
                    discard = false;
            }
        }
        return score;
    }

}
