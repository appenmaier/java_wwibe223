package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import model.Student;

/**
 * Assoziativspeicher (Maps)
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D08_Maps {

  public static void main(String[] args) {

    Student student1 = new Student("7162533", "Hans");
    Student student2 = new Student("9981602", "Peter");
    Student student3 = new Student("7291534", "Lisa");

    Map<Student, Double> studentsWithGrade = new HashMap<>();

    /* Werte setzen */
    studentsWithGrade.put(student1, 2.2);
    studentsWithGrade.put(student2, 4.0);
    studentsWithGrade.put(student3, 1.7);
    studentsWithGrade.put(new Student("8172543", "Peter"), 1.8);

    /* Werte überschreiben */
    System.out.println(studentsWithGrade.put(student2, 3.9));

    /* Werte lesen */
    System.out.println(studentsWithGrade.get(new Student("9981602", "Peter")));

    /* Inhalte pruefen */
    System.out.println(studentsWithGrade.containsKey(student3));
    System.out.println(studentsWithGrade.containsValue(1.0));

    System.out.println(studentsWithGrade);
    System.out.println();

    /* Datensammlung: Der Menge aller Schluessel */
    System.out.println("Anwesenheitsliste");
    for (Student student : studentsWithGrade.keySet()) {
      System.out.println(student.name());
    }
    System.out.println();

    /* Datensammlung: Alle Werte */
    double total = 0;
    for (double grade : studentsWithGrade.values()) {
      total += grade;
    }
    System.out.println("Durchschnittsnote: " + total / studentsWithGrade.values().size());
    System.out.println();

    /* Datensammlung: Die Menge aller Eintraege (Schluessel-Werte-Paare) */
    System.out.println("Notenliste");
    for (Entry<Student, Double> entry : studentsWithGrade.entrySet()) {
      Student student = entry.getKey();
      Double grade = entry.getValue();
      System.out.println(student.id() + ": " + grade);
    }

  }

}
