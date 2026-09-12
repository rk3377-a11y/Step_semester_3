package classes_and_objects.class_problems;

public class M5_StudentCollegeInfoDemo {
    static class Student {
        String name;
        int attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("A", 90);
        Student s2 = new Student("B", 85);

        Student.printCollegeInfo();
    }
}
