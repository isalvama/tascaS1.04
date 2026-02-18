package third_level;
import first_level.exercise1.BooksCollection;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalculatorTest implements WithAssertions {
    Calculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void teardown() {
        calculator.reset();
    }

    @Test
    void calculatorStartsWithTotalZero() {
        assertThat(calculator.getTotal()).isEqualTo(0);
    }

    @Test
    void calculatorAddsTwoAndTotalResultIsTwo() {
        assertThat(calculator.add(2)).isEqualTo(2);
        assertThat(calculator.add(2)).isNotEqualTo(3);

    }

    @Test
    void getTotalAftercalculatorAddsNumbers() {
        calculator.add(2);
        calculator.add(2);
        assertThat(calculator.getTotal()).isEqualTo(4);
    }

    @Test
    void calculatorSubtractTwoAndTotalResultIs0() {
        calculator.add(2);
        assertThat(calculator.subtract(2)).isEqualTo(0);
        assertThat(calculator.subtract(2)).isNotEqualTo(2);

    }

    @Test
    void calculatorMultiplyFourAndTotalResultIs0() {
        calculator.add(0);
        assertThat(calculator.multiply(6)).isEqualTo(0);
        assertThat(calculator.multiply(6)).isNotEqualTo(6);

    }

    @Test
    void calculatorMultiplySixToTwoAndTotalResultIsTwelve() {
        calculator.add(2);
        assertThat(calculator.multiply(6)).isEqualTo(12);
        assertThat(calculator.multiply(6)).isNotEqualTo(0);
    }

    @Test
    void calculatorDivide2AndTotalResultIs2() {
        calculator.add(4);
        assertThat(calculator.divide(2)).isEqualTo(2);
        assertThat(calculator.divide(2)).isNotEqualTo(0);
    }

    @Test
    void throwArithmeticExceptionWhenDividingByZero() {
        assertThatThrownBy(() -> {calculator.divide(0);}).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void calculatorResetCallResultIsZero() {
        calculator.add(2);
        assertThat(calculator.reset()).isEqualTo(0);
    }

    @Test
    void calculatorGetTotal() {
        calculator.add(2);
        calculator.subtract(1);
        assertThat(calculator.getTotal()).isEqualTo(1);
        calculator.multiply(8);
        assertThat(calculator.getTotal()).isEqualTo(8);
        calculator.divide(4);
        assertThat(calculator.getTotal()).isEqualTo(2);
    }
}