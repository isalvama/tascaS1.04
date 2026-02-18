package first_level.exercise3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {

    @DisplayName("addInPosition method throws IndexOutOfBoundsException when entering a position greater than the array size")
    @ParameterizedTest
    @CsvSource ({"3,Carla", "9,Maria"})
    void callAddInPositionMethodWithPositionGraterThanArraySize_ThrowsIndexOutOfBoundsException(int position, String name){
        Classroom ceramics = new Classroom("Ceramics", new String[]{"Paul", "Martha"});
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {ceramics.getStudentNameInPosition(position);});
        String expectedMessage = "The position index does not exist in the current ArrayList studentNames";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("addInPosition method throws IndexOutOfBoundsException when entering a negative index position in the array")
    @ParameterizedTest
    @CsvSource ({"-3,Paul", "-1,Albert"})
    void callAddInPositionMethodWithNegativePosition_ThrowsIndexOutOfBoundsException(int position, String name){
        Classroom ceramics = new Classroom("Ceramics", new String[]{"Natalia"});
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {ceramics.getStudentNameInPosition(position);});
        String expectedMessage = "The position index can't be negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("addInPosition method doesn't throw IndexOutOfBoundsException when entering a position smaller or equal to the array's size")
    @ParameterizedTest
    @CsvSource ({"0,Carla", "1,Maria"})
    void testIfExceptionInAddInPositionMethodIsNotThrown(int position, String name){
        Classroom ceramics = new Classroom("Ceramics",  new String[]{"Pau", "Alex"});
        assertDoesNotThrow(() -> {ceramics.getStudentNameInPosition(position);});
    }

}