package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static ArrayList<Integer> positionPlayer1 = new ArrayList<Integer>();
    static ArrayList<Integer> positionPlayer2 = new ArrayList<Integer>();

    static char[] gameBoard = new char[9];
    static boolean isPlayer1 = true;
    static boolean isValide = false;
    static boolean thereIsAWinner = false;

    public static void main(String[] args){

        displayElements(gameBoard);

        while (containEmptyElements(gameBoard) && !thereIsAWinner){
            playGround();
        }

        displayElements(gameBoard);

        if(thereIsAWinner){
            System.out.printf("***** WINNER %s has won ***** \n", !isPlayer1 ? "Player 1" : "Player 2");
        }else {
            System.out.println("***** The Game Ended Equal *****");
        }

    }

    private static void playGround(){
        System.out.printf("Enter the position of '%s' %s : ", isPlayer1 ? "O" : "X", isPlayer1 ? "player 1" : "player 2");
        gameBoard = asynElementsInArray(isValide, isPlayer1, gameBoard);
        thereIsAWinner = hasWon( isPlayer1 ? positionPlayer1.toString() : positionPlayer2.toString());
        isPlayer1 = !isPlayer1;
        isValide = false;
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
                if(response < 1 || response > 9){
                    System.out.printf("please the integer should be between 1 and 9 %s :", isPlayer1 ? "player 1" : "player 2");
                }else{
                    response--;
                    if(array[response] != '\0'){
                        System.out.printf("please %s this number has already been played can you play another :", isPlayer1 ? "player 1" : "player 2");
                    }else{
                        if(isPlayer1){
                            positionPlayer1.add(response+1);
                        }else{
                            positionPlayer2.add(response+1);
                        }
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

    private static boolean hasWon(String plays){

        int[] winingPositions = {1,2,3,4,5,6,7,8,9,1,5,9,3,5,7,1,4,7,2,5,8,3,6,9};
        int count = 0;
        boolean result = false;

        for (int i = 0; i < winingPositions.length; i++){
            if(plays.contains(String.valueOf(winingPositions[i]))){
                count++;
            }
            if (count == 3){
                result = true;
            }
            if ((i+1)%3 == 0){
                count = 0;
            }
            if(result) {
                break;
            }
        }

        return result;
    }

}