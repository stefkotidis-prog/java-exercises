public class ExamsTest2 {
    public static void main(String [] args){
        Student[] myStudents = new Student[4];
        myStudents[0]  = new GradStudent("N1", "JAVA", "FT");
        myStudents[1] = new GradStudent("N2", "C++", "PT");
        myStudents[2] = new UnderStudent("N3", "Algorithms", 1);
        myStudents[3] = new UnderStudent("N4", "Data Bases", 5);

        for(int i = 0; i < myStudents.length; i++ ){
            System.out.println(myStudents[i].toString());
            if(myStudents[i] instanceof GradStudent){
                GradStudent grad = (GradStudent) myStudents[i];
                if(grad.getDegree() == true){
                    System.out.println("Congrats you got the degree");
                }
            }
        }

        

    }
}
