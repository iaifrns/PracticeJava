package org.example;

import java.util.Arrays;
import java.util.Scanner;

class Main {

    // this exercise is on a function maskNumbers that it main role is to mask a number except the last 4 digits
    public static void main(String[] args){

      String[] listNumbers = {"9035847354", "894583486", "12", "23456", "3457657855"};

      for (int i=0; i<listNumbers.length; i++){
          System.out.println(maskNumber(listNumbers[i]));
      }
    }

    private static String maskNumber(String number){

        int endPoint = number.length() - 4;

        char[] num = number.toCharArray();

        if(number.length() > 4){
            Arrays.fill(num, 0, endPoint, '#');
        }

        return new String(num);
    }

}