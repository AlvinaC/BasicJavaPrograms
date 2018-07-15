package com.example.programs;

import java.util.Scanner;

public class DateDifference {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] d1 = new int[3];
		int[] d2 = new int[3];
		int[] d3 = new int[] { 01, 01, 2014 };
		int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.println("enter first date:");
		System.out.println("enter date");
		d1[0] = s.nextInt();
		System.out.println("enter month");
		d1[1] = s.nextInt();
		System.out.println("enter year");
		d1[2] = s.nextInt();
		System.out.println("enter second date:");
		System.out.println("enter date");
		d2[0] = s.nextInt();
		System.out.println("enter month");
		d2[1] = s.nextInt();
		System.out.println("enter year");
		d2[2] = s.nextInt();
		int d1diff = d1[2] * 365 + d1[0];
		if (d1[1] > 2) {
			d1diff = d1diff + ((d1[2] / 4) + (d1[2] / 400) - (d1[2] / 100));
		} else {
			d1diff = d1diff + (((d1[2] - 1) / 4) + ((d1[2] - 1) / 400) - ((d1[2] - 1) / 100));
		}
		for (int i = 0; i < d1[1]; i++) {
			d1diff = d1diff + months[i];
		}
		int d2diff = d2[2] * 365 + d2[0];
		if (d2[1] > 2) {
			d2diff = d2diff + ((d2[2] / 4) + (d2[2] / 400) - (d2[2] / 100));
		} else {
			d2diff = d2diff + (((d2[2] - 1) / 4) + ((d2[2] - 1) / 400) - ((d2[2] - 1) / 100));
		}
		for (int i = 0; i < d2[1]; i++) {
			d2diff = d2diff + months[i];
		}
		int diff = Math.abs(d2diff - d1diff);
		System.out.println("day diff:" + diff);
		int noofweeks = diff / 7;
	}

}
