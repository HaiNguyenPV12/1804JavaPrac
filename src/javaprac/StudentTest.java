/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprac;

import java.util.Scanner;

/**
 *
 * @author Hai
 */
public class StudentTest {

    /**
     * @param args the command line arguments
     */

    Student[] Students;
    Student objStudent;
    int maxstudents;
    int index = 0;
    int id, yob;
    String sex;
    Scanner input;
    boolean check = true;

    public StudentTest() {
        input = new Scanner(System.in);
        System.out.print("Enter Number of students: ");
        while (true) {
            try {
                maxstudents = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Please enter a number: ");
            }
        }
        Students = new Student[maxstudents];
    }

    public void add() {
        objStudent = new Student();
        if (index == maxstudents) {
            System.out.println("\nArray is full.\n");
            return;
        }
        input = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        check = true;
        while (check == true) {
            try {
                id = Integer.parseInt(input.nextLine());
                check = false;
                if (id < 0) {
                    System.out.println("Must be positive number");
                    System.out.print("ID: ");
                    check = true;
                }
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        break;
                    } else if (id == Students[i].id) {
                        System.out.println("ID already exists.");
                        System.out.print("ID: ");
                        check = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Must be a number.");
                System.out.print("ID: ");
            } catch (Exception e) {
                e.getMessage();
            }
        }

        System.out.print("Enter student sex(male/female): ");
        do {
            try {
                sex = input.nextLine();
                check = false;
                if (!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female")) {
                    System.out.print("\"male\" or \"female\" only: ");
                    check = true;
                }
                if (sex.equals("male")) {
                    sex = "Male";
                }
                if (sex.equals("female")) {
                    sex = "Female";
                }
            } catch (Exception e) {
                System.out.println("ERROR! Must be \"male\" or \"female\".");
                System.out.print("Sex: ");
            }
        } while (check == true);

        System.out.print("Enter year of birth: ");
        check = true;
        do {
            input = new Scanner(System.in);
            try {
                yob = Integer.parseInt(input.nextLine());
                check = false;
                if (yob >= 1992 || yob <= 1970) {
                    System.out.println("Year of birth must be greater than 1970 and less than 1992.");
                    System.out.print("Year: ");
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Error. Must be a number.");
                System.out.print("Year: ");
            }
        } while (check == true);

        objStudent = new Student(id, yob, sex);
        Students[index++] = objStudent;
        System.out.println("\nStudent added successfully.\n");
    }

    public void printMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Display catalog.");
        System.out.println("3. Exit\n");
        System.out.print("Option: ");
    }

    public int doChoice(Scanner input) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
        return choice;
    }

    public void display() {
        for (int i = 0; i < Students.length; i++) {
            if (index == 0) {
                System.out.println("\nArray is empty\n");
                return;
            }
            if (i == index) { // since 'i < index' in for loop isn't working.
                return;
            }
            System.out.println("\nID:            " + Students[i].id);
            System.out.println("Sex:           " + Students[i].sex);
            System.out.println("Year of birth: " + Students[i].yob + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner input;
        int choice;
        StudentTest objStudentTest = new StudentTest();
        while (true) {
            input = new Scanner(System.in);
            objStudentTest.printMenu();
            choice = objStudentTest.doChoice(input);
            switch (choice) {
            case 1:
                objStudentTest.add();
                break;
            case 2:
                objStudentTest.display();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid option. (1-3)");
                break;
            }
        }
    }

}
