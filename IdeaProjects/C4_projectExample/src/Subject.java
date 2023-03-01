public class Subject {
   private String name;
   private double mark;

    public Subject(String subjectName, double subjectMark) {
        setName(subjectName);
        setMark(subjectMark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String displayInfo() {
        return getName() +" : "+ getMark();
    }
}
