public class UnderStudent extends Student {
    private int dept;
    
    public UnderStudent(String studentId, String courseName, int dept){
        super(studentId, courseName);
        this.dept = dept;
    }

    @Override
    public String toString(){
        return super.toString() + " Department num: " + dept;
    }
}
