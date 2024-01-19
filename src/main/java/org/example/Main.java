package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


// this is to create a student management system of a class
// so we can create students, create subjects, view students makes on
// a particular subject, see top students and assign makes to students
class Main {

    private static final ArrayList<String> studentsList = new ArrayList<String>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> subjects = new ArrayList<String>();
    private static final HashMap<Integer, HashMap<Integer, Integer>> marks = new HashMap<Integer, HashMap<Integer, Integer>>();

    public static void main(String[] args){

        boolean isRunning = true;
        MenuOption option;

        while (isRunning){
            option = displayMenu();

            switch (option){
                case MenuOption.CREATESTUDENTS :
                    displayList(studentsList);
                    createStudent();
                    displayList(studentsList);
                    break;
                case MenuOption.CREATESUBJECT :
                    displayList(subjects);
                    createSubject();
                    displayList(subjects);
                    break;
                case MenuOption.ASSIGNMAKES :
                    assignMakes();
                    break;
                case MenuOption.VIEWMARKS:
                    displayMarkBySubject();
                    break;
                case MenuOption.TOPSTUDENTS:
                    displayTopStudents();
                    break;
                default:
                    isRunning = false;
            }
        }

    }

    private enum MenuOption{
        CREATESTUDENTS,
        CREATESUBJECT,
        VIEWMARKS,
        TOPSTUDENTS,
        ASSIGNMAKES,
        NOTHING
    }

    private static MenuOption displayMenu(){

        Scanner scanner = new Scanner(System.in);
        boolean isValide = false;

        MenuOption option = MenuOption.NOTHING;

        System.out.println("**********  Welcome to SE3 Student Management App  **********");
        System.out.println("1. Create a student");
        System.out.println("2. Create a subject");
        System.out.println("3. View students makes on particular subject");
        System.out.println("4. See top students");
        System.out.println("5. Assign makes to students on subjects");
        System.out.println("6. Exit");

        System.out.println("Choose one of the options above with the numbers so from 1-6 depending on the service you want : ");

        while (!isValide){
            try {
                int response = Integer.parseInt(scanner.nextLine());
                isValide = true;
                switch (response){
                    case 1:
                        option = MenuOption.CREATESTUDENTS;
                        break;
                    case 2:
                        option = MenuOption.CREATESUBJECT;
                        break;
                    case 3 :
                        option = MenuOption.VIEWMARKS;
                        break;
                    case 4 :
                        option = MenuOption.TOPSTUDENTS;
                        break;
                    case 5 :
                        option = MenuOption.ASSIGNMAKES;
                        break;
                    case 6 :
                        break;
                    default:
                        System.out.println("please your option should be between 1 and 6 not more not less : ");
                        isValide = false;
                }
            }catch (NumberFormatException e){
                System.out.println("please choose options from 1 to 6 depending on the service you want : ");
            }
        }

        return option;
    }

    private static void createStudent(){

        System.out.print("\n \n \n");

        System.out.print("Enter the name of the student : ");

        String studentName = scanner.nextLine();

        studentsList.add(studentName);

        System.out.println("***** Student Created *****");

    }

    private static void displayList(ArrayList<String> list){

        System.out.print("\n \n \n");

        int count = 0;

        for (int i = 0; i < list.size(); i++){
            System.out.println(i+1 + " " + list.get(i));
        }

        System.out.print("\n \n \n");
    }

    private static void createSubject(){

        System.out.println("\n \n \n");

        System.out.print("Enter the name of the subject you want to add : ");
        String subjectName = scanner.nextLine();

        subjects.add(subjectName);

        System.out.println("***** Subject Created *****");

    }

    private static void assignMakes(){

        int chosenSubjectIndex = 0;
        int chosenStudentIndex = 0;
        boolean isValid = false;
        int mark = 0;

        if(subjects.isEmpty() || studentsList.isEmpty()){

            System.out.println("Sorry can not continue the process because there are no subjects or students ");

        }else{
            chosenSubjectIndex = chooseSubjectOrStudent(subjects, true);
            System.out.println("\n \n \n");
            chosenStudentIndex = chooseSubjectOrStudent(studentsList, false);

            System.out.printf("\n Enter the make of %s in %s : ", studentsList.get(chosenStudentIndex), subjects.get(chosenSubjectIndex));

            mark = getIntegerFromUser(20, -1);

            HashMap<Integer, Integer> studentMark = new HashMap<Integer, Integer>();
            studentMark.put(chosenStudentIndex, mark);

            if(marks.containsKey(chosenSubjectIndex)){
                HashMap<Integer, Integer> previousMark = new HashMap<Integer, Integer>();
                previousMark = marks.get(chosenSubjectIndex);
                previousMark.put(chosenStudentIndex, mark);
                marks.put(chosenSubjectIndex, previousMark);
            }else{
                marks.put(chosenSubjectIndex, studentMark);
            }

            marks.forEach((key, value) -> {
                System.out.println("\n \n");
                displayAsyncMark(key, value);
            });
        }

    }

    private static int chooseSubjectOrStudent(ArrayList<String> list, boolean isSubject){
        displayList(list);
        int choosenIndex = 0;

        System.out.printf("Choose the %s that you want to fill the mark : ", isSubject ? "subject" : "student");

        choosenIndex = getIntegerFromUser(list.size(), 0);

        return choosenIndex-1;

    }

    private static void displayAsyncMark(int subjectIndex, HashMap<Integer, Integer> studentsMakes){
        System.out.println(subjects.get(subjectIndex));
        studentsMakes.forEach((studentIndex, marks) -> {
            System.out.printf("  %s : %d \n", studentsList.get(studentIndex), marks);
        });
    }

    private static void displayMarkBySubject(){

        int selectedSubject = 0;

        if(subjects.isEmpty()){
            System.out.println("There are no subjects present please you need to create some first");
        }else{
            displayList(subjects);
            System.out.println("\n \n");
            System.out.print("select the subject you want : ");

            selectedSubject = getIntegerFromUser(subjects.size(), 0);

            displayAsyncMark(selectedSubject-1, marks.get(selectedSubject-1));
        }
    }

    private static int getIntegerFromUser(int endLimit, int startLimit){

        boolean isValid = false;
        int input = 0;

        while (!isValid){
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input > startLimit && input <= endLimit){
                    isValid = true;
                }else{
                    System.out.print("please enter a number from 1 to " + subjects.size() + " : ");
                }
            }catch (NumberFormatException e){
                System.out.print("please enter a number from 1 to " + subjects.size());
            }
        }

        return input;
    }

    private static void displayTopStudents(){

        int[] studentsMarks;
        if (marks.isEmpty()){
            System.out.println("There are no subjects present please you need to create some first");
        }else{
            studentsMarks= new  int[studentsList.size()];
            marks.forEach((subjectIndex, mark) -> {
                mark.forEach((key, value) -> {
                    studentsMarks[key] += value;
                });
            });

            int[] rang = new int[studentsList.size()];
            int count = 0;

            for (int i = 0; i < studentsList.size(); i++ ){
                for (int j = 0; j < studentsList.size(); j++){
                    if(studentsMarks[i] > studentsMarks[j]){
                        count++;
                    }
                }
                if(rang[count] != '\0'){
                    rang[count+1] = i;
                }else {
                    rang[count] = i;
                }
                count = 0;
            }

            System.out.println("\n \nThe top students are");
            for (int i = 1; i <= studentsList.size(); i++){
                System.out.println(studentsList.get(rang[studentsList.size()-i]) + " with : " + (studentsMarks[rang[studentsList.size()-i]])/studentsList.size() + "/20 AV");
            }
        }

    }

}