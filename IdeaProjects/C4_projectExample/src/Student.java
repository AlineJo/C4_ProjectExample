import java.util.ArrayList;

public class Student {
    public static final String ROLE = "STUDENT";
    public static final int OPTIONS_COUNT = 3;

    private String id;
    private String name;
    private String Password;
    private double GPA;
    public ArrayList<Subject> subjects = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return getPassword();
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getGPA() {
        double sum = 0;
        int count = subjects.size();

        for(Subject s : subjects){
            sum += s.getMark();
        }
        GPA = sum/count;
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


    public void displayInfo() {
        String msg = "\n\tname: " + name;
        msg += "\n\tGPA: " + getGPA();
        msg += "\n\tsubjects: ";
        for (Subject s : getSubjects()) {
            msg += s.displayInfo() + " | ";
        }
        System.out.println(msg);
    }

    public static void displayOptions() {
        System.out.println("\n1. Display My Information");
        System.out.println("\n2. Change Password");
        System.out.println("\n3. Exit");
        System.out.println("\n# Select Option From the above.");
    }


}
