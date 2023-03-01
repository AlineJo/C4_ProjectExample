import java.util.ArrayList;
import java.util.Scanner;

public class CollageApp {


    String username;
    String role;

    ArrayList<Student> studentArrayList;

    public CollageApp() {
        studentArrayList = new ArrayList<>();
    }

    public static void main(String[] args) {


        CollageApp collageAppObj = new CollageApp();
        collageAppObj.login();

    }

    private void login() {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        while (true) {
            System.out.println("Enter Username");
            String inputUser = scan.next();
            System.out.println("Enter Password");
            String inputPassword = scan.next();

            if (isUserExist(inputUser, inputPassword)) {
                displayOptions();
                break;
            } else {
                System.out.println("Wrong Credentials!");
                count++;
                if (count > 3) {
                    break;
                }
            }
        }
    }

    private void displayOptions() {
        if (role.equals(Admin.ROLE)) {
            Admin.displayOptions();
            selectAdminOption();
        } else {
            Student.displayOptions();
        }
    }

    private void selectAdminOption() {
        Scanner scan = new Scanner(System.in);
        int inputOption = scan.nextInt();

        switch (inputOption) {
            case 1: {
                addStudent();
                break;
            }
            case 2: {
                addSubjectToStudent();
                break;
            }
            case 3: {
                displayAllStudents();
                break;
            }
            case 4: {
                displayStudentById();
                break;
            }
            case 5: {
                exit();
                break;
            }

            default: {
                System.out.println("Please Select one of the Options!");
                displayOptions();
            }
        }

    }


    // ############### ADMIN Functions ###############
    private void addStudent() {

        Scanner scan = new Scanner(System.in);
        Student student = new Student();
        System.out.println("insert student id");
        student.setId(scan.next());
        System.out.println("insert student name");
        student.setName(scan.next());
        System.out.println("insert student password");
        student.setPassword(scan.next());
        studentArrayList.add(student);

        displayOptions();

    }

    private void addSubjectToStudent() {
        Scanner scan = new Scanner(System.in);

        System.out.println("insert student id");
        String inputId = scan.next();


        if (getStudentIndexById(inputId) == -1) {
            System.out.println("Student Not Found!");
        } else {
            System.out.println("insert Subject name");
            String subjectName = scan.next();

            System.out.println("insert Subject mark");
            double subjectMark = scan.nextDouble();

            ArrayList<Subject> newSubjects =
                    studentArrayList.get(getStudentIndexById(inputId)).getSubjects();
            newSubjects.add(new Subject(subjectName, subjectMark));
            studentArrayList.get(getStudentIndexById(inputId)).setSubjects(newSubjects);
        }
        displayOptions();


    }


    private void displayAllStudents() {
        for (Student s : studentArrayList) {
            s.displayInfo();
        }
        displayOptions();
    }

    private void displayStudentById() {
        Scanner scan = new Scanner(System.in);
        System.out.println("insert student id");
        String inputId = scan.next();

        if (getStudentIndexById(inputId) == -1) {
            System.out.println("Student Not Found!");
        } else {
            studentArrayList.get(getStudentIndexById(inputId)).displayInfo();
        }

        displayOptions();
    }
    // ############### ADMIN Functions ###############


    private void exit() {
        login();
    }

    private int getStudentIndexById(String inputId) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getId().equals(inputId)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isUserExist(String inputUser, String inputPassword) {

        if (inputUser.equals(Admin.USERNAME) && inputPassword.equals(Admin.PASSWORD)) {
            username = Admin.USERNAME;
            role = Admin.ROLE;
            return true;
        } else if (isStudent(inputUser, inputPassword)) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isStudent(String inputUser, String inputPassword) {
        for (Student s : studentArrayList) {
            if (inputUser.equals(s.getName()) && inputPassword.equals(s.getPassword())) {
                username = s.getId();
                role = Student.ROLE;
                return true;
            }
        }
        return false;
    }
}
