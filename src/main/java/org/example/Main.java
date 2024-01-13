package org.example;

import java.util.Scanner;

class Main {

    public static void main(String[] args){

       Scanner scanner = new Scanner(System.in);

       String operation = "+/-*";

       boolean isValide = false;

       System.out.print("enter the first number : ");

        int num1 = 0;

       while (!isValide){

           String number1 = scanner.nextLine();

           try {

               num1 = Integer.parseInt(number1);
               isValide = true;

           }catch (NumberFormatException e){

               System.out.print("please enter a number : ");

           }

       }

       isValide = false;

       System.out.print("Enter the second number : ");

        int num2 = 0;

       while (!isValide){

           String number2 = scanner.nextLine();

           try {

               num2 = Integer.parseInt(number2);
               isValide = true;

           }catch (NumberFormatException e){

               System.out.print("please enter the second number : ");

           }

       }

       System.out.print("Enter the operation you want: ");

       isValide = false;

       String operator = "";

       while (!isValide){

           operator = scanner.nextLine();

           if(operation.contains(operator)){
               isValide = true;
           }else{
               System.out.print("The operation should be either +, -, / or * : ");
           }

       }

       switch (operator){
           case "/" :
               System.out.print("The answer is : " + ((double)num1/num2));
               break;
           case "*":
               System.out.print("The answer is : " + ((double)num1*num2));
               break;
           case "-":
               System.out.print("The answer is : " + (num1-num2));
               break;
           case "+":
               System.out.print("The answer is : " + (num1+num2));
               break;
       }

       scanner.close();

    }

}