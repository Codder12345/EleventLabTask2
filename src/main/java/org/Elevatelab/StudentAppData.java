package org.Elevatelab;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentAppData {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       
       try {
    	   do {
               System.out.println("--- Student Record Management System ---");
               System.out.println("1. Add Student");
               System.out.println("2. View All Students");
               System.out.println("3. Update Student");
               System.out.println("4. Delete Student");
               System.out.println("0. Exit");
               System.out.print("Enter your choice: ");
               int choice;
               choice = sc.nextInt();

               switch (choice) {
                   case 1:
                       addStudent();
                       break;
                   case 2:
                       viewStudents();
                       break;
                   case 3:
                       updateStudent();
                       break;
                   case 4:
                       deleteStudent();
                       break;
                   case 0:
                       System.out.println("Exit...");
                       break;
                   default:
                       System.out.println("Invalid choice");
               }

           } while (true);
        
       }catch(Exception ex) {
    	    System.out.println("Error"+ex.getMessage());
    	   
       }
    }

    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
        	  System.out.println("ID     Name        Marks");
            for (Student s : students) {
                s.display();
            }
        }
    }

    public static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);
                found = true;
                System.out.println("Student updated.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                found = true;
                System.out.println("Student deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

}
