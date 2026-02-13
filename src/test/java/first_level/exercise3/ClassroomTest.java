package first_level.exercise3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {

    @ParameterizedTest
    @CsvSource ({"2,Carla", "1,Maria"})
    void testExceptionInAddInPositionMethod(int position, String name){
        Classroom ceramics = new Classroom("Ceramics", "John Doe");
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {ceramics.addInPosition(position, name);});
        String expectedMessage = "Index: " + position + ", Size: " + ceramics.getStudentNames().size();
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @CsvSource ({"0,Carla", "1,Maria"})
    void testIfExceptionInAddInPositionMethodIsNotThrown(int position, String name){
        Classroom ceramics = new Classroom("Ceramics", "John Doe");
        ceramics.addStudents("Pau");

        assertDoesNotThrow(() -> {ceramics.addInPosition(position, name);});
    }

}