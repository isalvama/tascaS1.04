package first_level.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private final String className;
    private String teacherName;
    private ArrayList<String> studentNames;

    public Classroom(String className, String teacherName){
        this.className = className;
        this.teacherName = teacherName;
        this.studentNames = new ArrayList<>();
    }

    public List<String> getStudentNames() {
        return List.copyOf(studentNames);
    }

    public Classroom(String className, String teacherName, ArrayList<String> studentNamesToAdd){
        this.className = className;
        this.teacherName = teacherName;
        this.studentNames = new ArrayList<>(studentNamesToAdd);
    }

    public void addStudents(String studentName){
        studentNames.add(studentName);
    }

    public void addInPosition(int position, String studentName){
        if (position > studentName.length())
        {throw new IndexOutOfBoundsException("The position does not exist in the current ArrayList studentNames");}
        studentNames.add(position, studentName);
    }
}
