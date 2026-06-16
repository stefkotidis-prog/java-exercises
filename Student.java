import java.util.Scanner;
public class Student {
    private String studentId;
    private String courseName;

    public Student(String studentId, String courseName){
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public  double calcGrade(){
        Scanner input = new Scanner(System.in);
        double grade = 0;
        System.out.println("Enter first grade 75%");
        int grade1 = input.nextInt();
        System.out.println("Enter second garde 25%");
        int grade2 = input.nextInt();
        grade = grade1 * 0.75 + grade2 * 0.25;
        return grade;
    }

    @Override
    public String toString(){
        return "Student Id: " + studentId + " Course Name: " + courseName;  
    }
}
