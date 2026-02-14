package second_level;

import first_level.exercise1.Book;
import first_level.exercise3.Classroom;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;


class JTest implements WithAssertions{

    @DisplayName("An assertion that proves that the value of two whole objects is equal")
    @ParameterizedTest
    @CsvSource({"2,2", "34,34", "-3,-3"})
    void valueOfTwoObj_IsEqual(int num1, int num2){
        assertThat(num1).isEqualTo(num2);
    }

    @DisplayName("An assertion that proves that the value of two whole objects is not equal")
    @ParameterizedTest
    @CsvSource({"2,3", "-3,3", "8,20"})
    void valueOfTwoObj_IsNotEqual(int num1, int num2){
        assertThat(num1).isNotEqualTo(num2);
    }

    @Test
    @DisplayName("An assertion that demonstrates that the reference to one object is the same as another")
    void referenceOfTwoObj_isTheSame() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = array1;
        assertThat(array1).isSameAs(array2);
    }

    @Test
    @DisplayName("An assertion that demonstrates that the reference to another object is different")
    void referenceOfTwoObj_isNotTheSame() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertThat(array1).isNotSameAs(array2);
    }

    @Test
    @DisplayName("An assertion indicating that two arrays of integers are identical")
    void twoArraysOfInt_AreEqual() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(3, 4, 5, 5));
        assertThat(array1).isEqualTo(array2);
        assertThat(array1).isNotEqualTo(array3);
        assertThat(array2).isNotEqualTo(array3);
    }

    @Test
    @DisplayName("An assertion to verify the order of the objects in an ArrayList is the way they were inserted")
    void orderOfObjInArray_AreEqual() {
        var container = new ArrayList<>();
        Classroom maths = new Classroom("Maths");
        Book book1 = new Book("Nada", "Carmen Laforet");
        ArrayList<Character> array1 = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
        container.add(maths);
        container.add(book1);
        container.add(array1);
        assertThat(container).containsExactly(maths, book1, array1);
    }

    @Test
    @DisplayName("An assertion to verify that an ArrayList contains the objects in any order.")
    void arrayListContainsObjAdded() { var container = new ArrayList<>();
        Classroom maths = new Classroom("Maths");
        Book book1 = new Book("Nada", "Carmen Laforet");
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(4, 5, 0));
        container.add(maths);
        container.add(book1);
        container.add(array1);
        assertThat(container).contains(book1, array1, maths);
        }


    @Test
    @DisplayName("An assertion to verify that in an ArrayList one of the objects has been added only once")
    void arrayListContainsObjAddedOnlyOnce() { var container = new ArrayList<>();
        Classroom maths = new Classroom("Maths");
        Book book1 = new Book("Nada", "Carmen Laforet");
        ArrayList<String> array1 = new ArrayList<>(Arrays.asList("Hello", "world", "!"));
        container.add(array1);
        container.add(maths);
        container.add(book1);
        container.add(array1);
        assertThat(container).containsOnlyOnce(book1, maths);
    }

    @Test
    @DisplayName("An assertion to verify that an ArrayList does not contain a removed object")
    void arrayListDoesNotContainARemovedObj() {
        var container = new ArrayList<>();
        Classroom maths = new Classroom("Maths");
        Book book1 = new Book("Nada", "Carmen Laforet");
        ArrayList<Character> array1 = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
        container.add(maths);
        container.add(book1);
        container.add(array1);
        container.remove(2);
        assertThat(container).doesNotContain( array1);
    }

    @Test
    @DisplayName("A map contains one of the keys added to it")
    void hashMapContainsKey() {
        HashMap<Integer, ArrayList<Integer>> testMap = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(7, 3, 5, 1));
        testMap.put(1, array1);
        testMap.put(2, array2);
        assertThat(testMap).containsKey(2);
        assertThat(testMap).doesNotContainKey(3);
    }

    @Test
    @DisplayName("An assertion that validates that the exception ArrayIndexOutOfBoundsException is thrown when appropriate")
    void arrayIndexOutOfBoundsExceptionIsThrownWhenAppropriate() {
        Classroom ceramics = new Classroom("Ceramics");
        assertThatThrownBy(() -> {ceramics.addInPosition(1, "Laura");}).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> {ceramics.addInPosition(8, "Emma");}).isInstanceOf(IndexOutOfBoundsException.class);

    }

    @Test
    @DisplayName("An assertion to verify that an empty Optional object is indeed empty")
    void emptyOptionalObjIsEmpty() {
        Optional<String> optionalObject = Optional.empty();
        assertThat(optionalObject).isEmpty();
    }
}