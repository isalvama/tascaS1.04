package first_level.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static first_level.exercise2.IdCalculation.calculateIdLetter;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class IdCalculationTest {

    @DisplayName ("calculateLetters method returns the correct char")
    @ParameterizedTest
    @CsvSource({"46218815,Q", "48095145,Y", "35075664,C", "65004204,V", "39733877,C", "72966599,L", "73332793,F", "27586404,C", "04384163,H", "07167479,N", "07167479,N", "02331334,P", "03703023,T"})
    void calculateLetters_ShouldGenerateTheExpectedLetter(String num, char expectedC){
        Assertions.assertEquals(expectedC, calculateIdLetter(num));
    }

    @DisplayName ("calculateLetters method throws IllegalArgumentException exception when passing negative numbers.")
    @ParameterizedTest
    @CsvSource({"-12345678", "-12345", "-98475"})
    void calculateLetters_ThrowsIllegalArgumentExceptionWhenEnteringNegativeNum(String num){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateIdLetter(num);});
        assertTrue(exception.getMessage().contains("idNumber can't be negative"));

    }

    @DisplayName ("calculateLetters method throws IllegalArgumentException exception when passing numbers of more than 8 letters.")
    @ParameterizedTest
    @CsvSource({"12345678901"})
    void calculateLetters_ThrowsIllegalArgumentExceptionWhenEnteringNumOfMoreThan8Digits(String num){
       Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateIdLetter(num);});
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("idNumber can't have more than 8 digits"));

    }

    @DisplayName ("calculateLetters method throws NumberFormatException exception when passing digits containing other than numbers")
    @ParameterizedTest
    @CsvSource({"1234567w", "123o5678", "!1235678"})
    void calculateLetters_ThrowsNumberFormatExceptionWhenEnteringDigitsOtherThanNumbers(String num){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            calculateIdLetter(num);});
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("idNumber should only contain numbers"));

    }

}