package first_level.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private final String className;
    private ArrayList<String> studentNames;

    public Classroom(String className){
        this.className = className;
        this.studentNames = new ArrayList<>();
    }

    public List<String> getStudentNames() {
        return List.copyOf(studentNames);
    }

    public Classroom(String className, ArrayList<String> studentNamesToAdd){
        this.className = className;
        this.studentNames = new ArrayList<>(studentNamesToAdd);
    }

    public void addStudents(String studentName){
        studentNames.add(studentName);
    }

    public void addInPosition(int position, String studentName){
        if (position > studentNames.size())
        {throw new IndexOutOfBoundsException("The position does not exist in the current ArrayList studentNames");}
        studentNames.add(position, studentName);
    }
}
