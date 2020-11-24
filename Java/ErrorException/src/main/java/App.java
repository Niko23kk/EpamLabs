import exseption.*;
import model.Faculty;
import model.Student;
import model.Group;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Faculty firstFaculty = new Faculty("IT", 1);
        Faculty secondFaculty = new Faculty("PIM", 1);

        Group firstGroup = new Group(firstFaculty, 1);
        Group secondGroup = new Group(firstFaculty, 2);
        Group thirdGroup = new Group(secondFaculty, 3);
        Group fourthGroup = new Group(secondFaculty, 4);

        Student firstStudent = new Student("Alexey", firstGroup, 1);
        Student secondStudent = new Student("Andrey", firstGroup, 2);
        Student thirdStudent = new Student("Maksim", secondGroup, 3);
        Student fourthStudent = new Student("Alexsandra", secondGroup, 4);
        Student fifthStudent = new Student("Anna", thirdGroup, 5);
        Student sixthStudent = new Student("Veronika", thirdGroup, 6);
        Student seventhStudent = new Student("Stas", fourthGroup, 7);
        Student eighthStudent = new Student("Bodya", fourthGroup, 8);

        Faculty[] faculties = new Faculty[]{firstFaculty, secondFaculty};

        Group[] groups = new Group[]{firstGroup, secondGroup, thirdGroup, fourthGroup};

        Student[] students = new Student[]{firstStudent, secondStudent, thirdStudent, fourthStudent,
                fifthStudent, sixthStudent, seventhStudent, eighthStudent};

        Random random = new Random();

        for (int i = 0; i < students.length; i++) {
            students[i].putNote("Math", (Math.abs(random.nextInt())) % 10 + 1);
        }

        //1 task
        double averageGrade = 0;
        int countOfGrades = 0;
        int studentId = 1;

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        });

        Student student = students[Arrays.binarySearch(Arrays.stream(students).mapToInt(x -> x.getId()).toArray(), studentId)];

        for (HashMap.Entry<String, Integer> entry : student.getGrades().entrySet()) {
            averageGrade += entry.getValue();
            countOfGrades++;
        }

        averageGrade = averageGrade / countOfGrades;

        System.out.println("Средняя оценка студента с id" + student.getId() + " : " + averageGrade);

        if(faculties.length == 0)
            try {
                throw new NoFacultiesException("В униферситете нет ни одного факультета");
            } catch (NoFacultiesException e) {
                System.out.println(e.getMessage());
                return;
            }

        for(int i = 0; i < students.length; i++){
            if(students[i].getGrades().entrySet().size() == 0)
                try {
                    throw new NoDisciplinesException("У студента нет названия дисциплины");
                } catch (NoDisciplinesException e) {
                    System.out.println(e.getMessage());
                    return;
                }
        }

        //2 task
        averageGrade = 0;
        countOfGrades = 0;
        Group group = firstGroup;
        Faculty faculty = firstFaculty;
        try {
            for (int i = 0; i < groups.length; i++) {
                if (groups[i].getFaculty() == faculty)
                    break;
                if (i == groups.length - 1)
                    throw new NoGroupsException("На факультете нет студентов");
            }
            for (int i = 0; i < students.length; i++) {
                if (students[i].getGroup() == group)
                    break;
                if (i == students.length - 1)
                    throw new NoStudentsException("В группе нет студентов");
            }
            for (int i = 0; i < students.length; i++) {
                if (students[i].getGroup().getId() == group.getId() && group.getFaculty() == faculty) {
                    if (students[i].getGrades().get("Math") < 0 || students[i].getGrades().get("Math") > 10)
                        throw new IncorrectGradeException("Некорректная оценка ", students[i].getGrades().get("Math"));
                    averageGrade += students[i].getGrades().get("Math");
                    countOfGrades++;
                }
            }
        } catch (IncorrectGradeException e) {
            System.out.println(e.getMessage());
        }
        catch (NoStudentsException e){
            System.out.println(e.getMessage());
        } catch (NoGroupsException e) {
            System.out.println(e.getMessage());
        }

        averageGrade = averageGrade / countOfGrades;

        System.out.println("Средняя оценка по математике в первой группе на факультете IT " + group.getId() + " : " + averageGrade);

        //3 task
        averageGrade = 0;
        countOfGrades = 0;

        try {
            for (int i = 0; i < students.length; i++) {
                if (students[i].getGrades().get("Math") != null) {
                    if (students[i].getGrades().get("Math") < 0 || students[i].getGrades().get("Math") > 10)
                        throw new IncorrectGradeException("Некорректная оценка ", students[i].getGrades().get("Math"));
                    averageGrade += students[i].getGrades().get("Math");
                    countOfGrades++;
                }
            }
            averageGrade = averageGrade / countOfGrades;
        } catch (IncorrectGradeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Средняя оценка по математике в университете " + averageGrade);

    }
}
