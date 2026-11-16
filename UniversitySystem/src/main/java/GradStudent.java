import java.util.Scanner;
public class GradStudent extends Student{
    private String msc;
    Scanner input = new Scanner(System.in);
    
    public GradStudent(String studentId, String courseName, String msc ){
        super(studentId, courseName);
        this.msc = msc;
    }

    public boolean getDegree(){
        double finalGrade = calcGrade();
        return finalGrade>=5;
    }

    @Override
    public double calcGrade(){
        System.out.println("Enter diplomatiki grade: ");
        int grade3 = input.nextInt();
        return super.calcGrade() * 0.7  +  grade3 * 0.3;
    }

    @Override
    public String toString(){
        return super.toString() + " MSC in: " + msc;

    }
    
}
