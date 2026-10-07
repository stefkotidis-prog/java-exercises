public abstract class Athlete {
    protected String name;
    protected int age;
    protected double heightCm;

    public Athlete(String name, int age, double heightCm) {
        this.name = name;
        this.age = age;
        this.heightCm = heightCm;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getHeightCm() { return heightCm; }
}