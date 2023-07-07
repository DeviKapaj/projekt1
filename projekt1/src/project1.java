
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class project1 {

    Scanner scanner = new Scanner(System.in);
    project1() throws SQLException {

        DataBase dataBase = new DataBase();

        System.out.println("Choose what do you want to do");
        System.out.println("1: Add students");
        System.out.println("2: Go to commands");

        int choice = scanner.nextInt();

        if(choice == 1){
            System.out.println("How many students do you want to add?");
            int nrstudent = scanner.nextInt();

            System.out.println("Give student information: id, name, age, sex, branch, grade, year");
            for (int i = 0; i < nrstudent; i++) {
                System.out.print("Student "+ i +" :");
                dataBase.addStudent(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next().charAt(0), scanner.next(), scanner.nextDouble(), scanner.nextInt());
                System.out.println();
            }
        } else if (choice == 2) {
            System.out.println("");
        }

        System.out.println("Give a command:");
        System.out.println("1: Show list of students");
        System.out.println("2: Search student with ID");
        System.out.println("3: Change the year and age of a student");
        System.out.println("4: Change the grade of a student");
        System.out.println("5: Show students in descending order by grade");
        System.out.println("6: Add grades to a student's subjects");
        System.out.println("7: Remove a student");


        int nr = scanner.nextInt();
            switch(nr){

                case 1:
                    dataBase.sortTable();
                    ResultSet rset = dataBase.getAll();
                    while(rset.next()){
                        System.out.println("ID: " + rset.getInt("ID") + ", Name: " + rset.getString(2) + ", Age: " + rset.getInt(3) + ", Gender " + rset.getString(4) + ", Branch: " + rset.getString(5) + ", Grade: " + rset.getDouble(6) + ", Year: " + rset.getInt(7));
                    }
                    break;

                case 2:
                    System.out.println("Search with ID");
                    rset = dataBase.getId(scanner.nextInt());
                    while(rset.next()){
                        System.out.println(rset.getInt("id") + " " + rset.getString(2) + " " + rset.getInt(3) + " " + rset.getString(4) + " " + rset.getString(5) + " " + rset.getInt(6) + " " + rset.getInt(7));
                    }
                    break;

                case 3:
                    System.out.println("Search with ID");
                    int id = scanner.nextInt();
                    System.out.println("Year");
                    int year = scanner.nextInt();
                    System.out.println("Age");
                    int age = scanner.nextInt();
                    dataBase.change(id, year, age);
                    break;

                case 4:
                    System.out.println("Search with ID");
                    id = scanner.nextInt();
                    System.out.println("Change grade into: ");
                    double grade = scanner.nextDouble();
                    dataBase.changeGrade(grade, id);
                    break;

                case 5:
                    rset = dataBase.byGrade();
                    while(rset.next()){
                        System.out.println("ID: " + rset.getInt("ID") + ", Name: " + rset.getString(2) + ", Age: " + rset.getInt(3) + ", Gender " + rset.getString(4) + ", Branch: " + rset.getString(5) + ", Grade: " + rset.getDouble(6) + ", Year: " + rset.getInt(7));
                    }
                    break;

                case 6:
                    System.out.println("Search the student you want to add grades with ID");
                    id = scanner.nextInt();
                    System.out.println("Add Algoritmike grade: ");
                    int grade1 = scanner.nextInt();
                    System.out.println("Add Matematike grade: ");
                    int grade2 = scanner.nextInt();
                    System.out.println("Add Anglisht grade: ");
                    int grade3 = scanner.nextInt();
                    System.out.println("Add Cpp grade: ");
                    int grade4 = scanner.nextInt();
                    System.out.println("Add SistemeMultimediale grade: ");
                    int grade5 = scanner.nextInt();
                    System.out.println("Add ArkitektureKomp grade: ");
                    int grade6 = scanner.nextInt();
                    System.out.println("Add LendeMeZgjedhje grade: ");
                    int grade7 = scanner.nextInt();
                    System.out.println("Add Java grade: ");
                    int grade8 = scanner.nextInt();
                    dataBase.addGrade(grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8, id);
                    break;

                case 7:
                    System.out.println("Search the student you want to remove with ID");
                    id = scanner.nextInt();
                    dataBase.delete(id);


                default:
                    System.exit(0);
            }

        }
    }

