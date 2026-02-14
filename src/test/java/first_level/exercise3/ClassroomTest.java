package first_level.exercise3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {

    @DisplayName("addInPosition method throws IndexOutOfBoundsException when entering a position greater than the ArrayList size")
    @ParameterizedTest
    @CsvSource ({"3,Carla", "9,Maria"})
    void addInPositionMethod_ThrowsIndexOutOfBoundsException(int position, String name){
        Classroom ceramics = new Classroom("Ceramics", new ArrayList<>(Arrays.asList("Paul", "Martha")));
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {ceramics.addInPosition(position, name);});
        String expectedMessage = "The position does not exist in the current ArrayList studentNames";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("addInPosition method doesn't throw IndexOutOfBoundsException when entering a position smaller or equal to the ArrayList's size")
    @ParameterizedTest
    @CsvSource ({"0,Carla", "1,Maria"})
    void testIfExceptionInAddInPositionMethodIsNotThrown(int position, String name){
        Classroom ceramics = new Classroom("Ceramics");
        ceramics.addStudents("Pau");
        assertDoesNotThrow(() -> {ceramics.addInPosition(position, name);});
    }

}