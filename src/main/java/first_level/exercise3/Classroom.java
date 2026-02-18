package first_level.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private final String className;
    private String[] studentNames;

    public Classroom(String className){
        this.className = className;
        this.studentNames = new String[]{};
    }

    public Classroom(String className, String[] studentNamesToAdd){
        this.className = className;
        this.studentNames = studentNamesToAdd;
    }

    public String getStudentNameInPosition(int position){
        if (position > studentNames.length) {
            throw new ArrayIndexOutOfBoundsException("The position index does not exist in the current ArrayList studentNames");
        }
        if (position < 0) {
            throw new ArrayIndexOutOfBoundsException("The position index can't be negative");
        }
        return studentNames[position];
    }
}
