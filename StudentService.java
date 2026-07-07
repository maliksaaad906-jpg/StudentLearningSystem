import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
       
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        Student existing = searchStudentById(student.getId());
        if (existing != null) {
            throw new IllegalArgumentException("Student ID already exist.");
        }
        students.add(student);
    }

    public void viewAllStudent(){
        if (students.isEmpty()) {
            System.out.println("No student data available");
            return;
        }
        for(Student student : students){
            
            System.out.println(student);
        }        
    }
    public Student searchStudentById(int id){
       for(Student student : students) {
        if (student.getId() == id) {
            return student;
        }
       }
       return null;
    }
    public void updateMarks(int id, double newMarks){
        Student student = searchStudentById(id);

        if (student != null) {
            student.setMarks(newMarks);
        }
        else
            throw new IllegalArgumentException("Student not found.");
    }
    public void deleteStudent(int id){
        Student student = searchStudentById(id);
        if(student != null){
            students.remove(student);
        }
        else
            throw new IllegalArgumentException("Student not found.");
    }

    // public static void main(String[] args) {
    //     Student s1 = new Student(1, "Saad", 22, 72);
    //     Student s2 = new Student(2, "Farhaz", 36, 73);
    //     Student s3 = new Student(3, "Aamir", 35, 78);

    //     StudentService service = new StudentService();

    //     service.addStudent(s1);
    //     service.addStudent(s2);
    //     service.addStudent(s3);

    //     // s1.setMarks(68);
        
    //     // System.out.println(service.searchStudentById(1));
    //     service.updateMarks(3, 100);    
    //     service.viewAllStudent();
    //     // service.deleteStudent(2);


    // }
}
