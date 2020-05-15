package com.example.programs;

import java.io.*;
public class Hashcode {

   public static void main(String args[]) {
      String Str = new String("abc");
      System.out.println("Hashcode for Str :" + Str.hashCode() );
      String Str1 = new String("cab");
      System.out.println("Hashcode for Str :" + Str1.hashCode() );
   }
}