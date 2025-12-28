import java.io.*;
import java.util.*;

class Student {
    private String name;
    private String surname;
    private double score;
    
    public Student(String name, String surname, double score) {
        this.name = name;
        this.surname = surname;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public double getScore() {
        return score;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', surname='" + surname + "', score=" + score + "}";
    }
}


public class StudentCheck {
    
    public static ArrayList<Student> loadStudents(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 3) {
                    String name = parts[0];
                    String surname = parts[1];
                    double score = Double.parseDouble(parts[2]);
                    students.add(new Student(name, surname, score));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing score: " + e.getMessage());
        }
        
        return students;
    }
    
    public static void main(String[] args) {

        ArrayList<Student> students = loadStudents("studentsGroup2.txt");
        
        System.out.println("ALL STUDENTS");
        students.forEach(System.out::println);
        System.out.println();
        

        System.out.println("STUDENTS WITH SCORE 5");
        students.stream()
                .filter(student -> student.getScore() == 5.0)
                .forEach(System.out::println);
        System.out.println();
        

        System.out.println("AVERAGE SCORE");
        double average = students.stream()
                                 .mapToDouble(Student::getScore)
                                 .average()
                                 .orElse(0.0);
        System.out.println("" + average);
        System.out.println();
        

        System.out.println("NUMBER OF STUDENTS WITH SCORE 5");
        long count = students.stream()
                             .filter(student -> student.getScore() == 5.0)
                             .count();
        System.out.println("" + count);
    }
}