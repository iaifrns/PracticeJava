package org.example;

import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args){

        char[] gameBoard = new char[9];
        String[] player = {"player 1", "player 2"};
        boolean isPlayer1 = true;
        boolean isValide = false;

        displayElements(gameBoard);

        while (containEmptyElements(gameBoard)){
            if (isPlayer1) {
                System.out.print("Enter the position of 'O' player 1 : ");
                gameBoard = asynElementsInArray(isValide, isPlayer1, gameBoard);
                isPlayer1 = isValide = false;
                displayElements(gameBoard);
            }else {
                System.out.print("Enter the position of 'X' player 2 : ");
                gameBoard = asynElementsInArray(isValide, isPlayer1, gameBoard);
                isPlayer1 = true;
                isValide = false;
                displayElements(gameBoard);
            }
        }

        displayElements(gameBoard);

    }

    private static boolean containEmptyElements(char[] charArray) {

        for (char letter : charArray){
            if (letter == '\0'){
                return true;
            }
        }

        return false;
    }

    private static char[] asynElementsInArray(boolean isValide, boolean isPlayer1, char[] array){

        Scanner scanner = new Scanner(System.in);

        while (!isValide){
            try {
                int response = Integer.parseInt(scanner.nextLine());
                response--;
                if(response < 1 || response > 9){
                    System.out.printf("please the integer should be between 1 and 9 %s :", isPlayer1 ? "player 1" : "player 2");
                }else{
                    if(array[response] != '\0'){
                        System.out.printf("please %s this number has already been played can you play another :", isPlayer1 ? "player 1" : "player 2");
                    }else{
                        array[response] = isPlayer1 ? 'O' : 'X';
                        isValide = true;
                    }
                }
            }catch (NumberFormatException e){
                System.out.printf("please enter only an integer %s :", isPlayer1 ? "player 1" : "player 2");
            }
        }

        return array;

    }

    private static void displayElements(char[] gameBoard) {
        for(int i = 0; i < 9; i ++){
            System.out.printf("%d  %d  %d \n", i+1, i+2, i+3);
            System.out.printf("%c  %c  %c \n", gameBoard[i],gameBoard[++i],gameBoard[++i]);
        }
    }

}