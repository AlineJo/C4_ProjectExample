public class Admin {

    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "Pass@123";
    public static final String ROLE = "ADMIN";
    public static final int OPTIONS_COUNT = 5;


    public static void displayOptions() {
        System.out.println("\n1. Add Student");
        System.out.println("2. Add Subjects to student");
        System.out.println("3. Display All Students");
        System.out.println("4. Display Student By Id");
        System.out.println("5. Exit");
        System.out.println("# Select Option From the above.");
    }

}
