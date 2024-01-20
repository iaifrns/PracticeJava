package org.example;

import org.example.types.MenuOptions;
import org.example.types.Sex;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

class Main {

    // this is project is done with oop concepts
    private static Scanner scanner = new Scanner(System.in);
    private static MenuOptions menuOption;
    public static void main(String[] args){

        System.out.println("Hello welcome to this app \n \n");

        menuOption();

        switch (menuOption){
            case MenuOptions.IDCARD:
                generateCart();
                break;
            case MenuOptions.CARLICENCE:
                generateLicenceCart();
                break;
            default:
                break;
        }

    }

    public static void menuOption(){

        boolean isNotValid = true;

        System.out.println("1) ID Card");
        System.out.println("2) Car Licence Card");

        System.out.print("\n Choose one of the options above juste input a number that correspond to the service you want : ");
        while (isNotValid){
            try {
                int input = Integer.parseInt(scanner.nextLine());
                isNotValid = false;
                switch (input){
                    case 1:
                        menuOption = MenuOptions.IDCARD;
                        break;
                    case 2:
                        menuOption = MenuOptions.CARLICENCE;
                        break;
                    default:
                        System.out.println("The choice should be between 1 and 2 : ");
                        isNotValid = true;
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("The choice can only be in numbers : ");
            }
        }
    }

    public static void generateCart(){

        IdCard idCard = new IdCard();
        boolean isNotValid = true;

        Date date = new Date();

        idCard.setId(Base64.getEncoder().encodeToString(Long.toString(date.getTime()).getBytes()));
        idCard.setDeliveredDate(LocalDate.now());

        System.out.print("Enter your first name : ");
        idCard.setFirstName(scanner.nextLine());

        System.out.print("Enter your last name : ");
        idCard.setLastName(scanner.nextLine());

        System.out.print("Enter your date of birth with format yyyy-mm-dd : ");
        idCard.setBirthDate(scanner.nextLine());

        System.out.print("Enter your town : ");
        idCard.setTown(scanner.nextLine());

        System.out.println("choose your sex :  1-male   2-female");
        while (isNotValid){
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input > 0 && input < 3){
                    isNotValid = false;
                    idCard.setSex((input == 1) ? Sex.MALE : Sex.FEMALE);
                }else {
                    System.out.print("Please choose between 1 and 2 : ");
                }
            }catch (NumberFormatException e){
                System.out.print("Please choose between 1 and 2 : ");
            }
        }

        System.out.print("Enter your Height : ");
        idCard.setHeight(scanner.nextLine());

        System.out.println("\n\n");

        idCard.displayIdCard();

    }

    public static void generateLicenceCart(){

        CarLicenceCard carLicenceCard = new CarLicenceCard();
        boolean isNotValid = true;

        Date date = new Date();

        carLicenceCard.setId(Base64.getEncoder().encodeToString(Long.toString(date.getTime()).getBytes()));
        carLicenceCard.setDeliveredDate(LocalDate.now());

        System.out.print("Enter your first name : ");
        carLicenceCard.setFirstName(scanner.nextLine());

        System.out.print("Enter your last name : ");
        carLicenceCard.setLastName(scanner.nextLine());

        System.out.print("Enter your date of birth with format yyyy-mm-dd : ");
        carLicenceCard.setBirthDate(scanner.nextLine());

        System.out.print("Enter your town : ");
        carLicenceCard.setTown(scanner.nextLine());

        System.out.println("choose your sex :  1-male   2-female");
        while (isNotValid){
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input > 0 && input < 3){
                    isNotValid = false;
                    carLicenceCard.setSex((input == 1) ? Sex.MALE : Sex.FEMALE);
                }else {
                    System.out.print("Please choose between 1 and 2 : ");
                }
            }catch (NumberFormatException e){
                System.out.print("Please choose between 1 and 2 : ");
            }
        }

        System.out.print("Enter the licence category : ");
        carLicenceCard.setCategory(scanner.nextLine());

        System.out.print("Enter your occupation : ");
        carLicenceCard.setOccupation(scanner.nextLine());

        System.out.println("\n\n");

        carLicenceCard.displayLicenceCard();

    }

}