import java.util.Scanner;

public class Student
{
    int id, age;
    String name;

    Student(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    void display(){
        System.out.println("Student id is: " + id);
        System.out.println("Student name is: " + name);
        System.out.println("Student age is: " + age);
    }
    //main class.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int age = sc.nextInt();
        String name = sc.next();
        Student student = new Student(id, age, name);
        student.display();
    }
}
