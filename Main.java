import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("========== Student Management System ==========");

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    try{
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter student Marks: ");
                    double marks = sc.nextDouble();
                    Student student = new Student(id, name, age, marks);
                    service.addStudent(student);
                    System.out.println("Student added successfully");
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InputMismatchException e){
                        System.out.println(e.getMessage());
                        sc.nextLine();
                    }

                    break;
                case 2:
                    service.viewAllStudent();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    Student student = service.searchStudentById(id);
                    if (student != null ){
                        System.out.println(student);
                    } 
                    else
                        System.out.println("Student not found");

                    break;
                case 4:
                    try{
                    System.out.print("Enter student ID to change marks: ");
                    id = sc.nextInt();

                    System.out.print("Marks you want to assign: ");
                    double newMarks = sc.nextDouble();
                    
                    
                    service.updateMarks(id, newMarks);
                    System.out.println("Marks updated successfully");}
                    
                    
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InputMismatchException e){
                        System.out.println(e.getMessage());
                        sc.nextLine();
                    }
                    break;
                case 5:
                    try{
                        System.out.print("Enter student ID to delete: ");
                        id = sc.nextInt();
                       
                        service.deleteStudent(id); 
                        
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    catch(InputMismatchException e){
                        System.out.println(e.getMessage());
                        sc.nextLine();
                    }
                    
                    break;
                case 6:
                    System.out.println("Thank you for using Student Management System.");
                    return;
                default :
                System.out.println("Invalid choice. Please try again.");
                    break;
            }



            
        }
    }
}
