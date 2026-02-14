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
    @CsvSource({"46218815,q", "48095145,y", "35075664,c", "65004204,v", "39733877,c", "72966599,l", "73332793,f", "27586404,c", "04384163,h", "07167479,n", "07167479,n", "02331334,p", "03703023,t"})
    void calculateLetters_ShouldGenerateTheExpectedLetter(String num, char expectedC){
        Assertions.assertEquals(expectedC, calculateIdLetter(num));
    }

    @DisplayName ("calculateLetters method throws IllegalArgumentException exception when passing numbers of more than 8 letters.")
    @ParameterizedTest
    @CsvSource({"12345678901"})
    void calculateLetters_ThrowsIllegalArgumentExceptionWhenEnteringNumOfMOreThan8Digits(String num){
       Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateIdLetter(num);});
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("idNumber can't have more than 9 digits"));

    }

    @DisplayName ("calculateLetters method throws IllegalArgumentException exception when passing negative numbers.")
    @ParameterizedTest
    @CsvSource({"-12345678", "-12345", "-98475"})
    void calculateLetters_ThrowsIllegalArgumentExceptionWhenEnteringNegativeNum(String num){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateIdLetter(num);});
        assertTrue(exception.getMessage().contains("idNumber can't be negative"));

    }

}