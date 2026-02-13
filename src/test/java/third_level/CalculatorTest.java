package third_level;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;


class CalculatorTest implements WithAssertions {

    @Test
    void calculatorStartsWithTotalZero() {
        Calculator calculator = new Calculator();
        assertThat(calculator.getTotal()).isEqualTo(0);
    }

    @Test
    void calculatorAddsTwoAndTotalResultIsTwo() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(2)).isEqualTo(2);
        assertThat(calculator.add(2)).isNotEqualTo(3);

    }

    @Test
    void throwIllegalArgumentExceptionWhenAddingNegativeNumber() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> {calculator.add(-2);}).isInstanceOf(IllegalArgumentException.class).withFailMessage("The input number must be greater than 0");

    }

    @Test
    void getTotalAftercalculatorAddsNumbers() {
        Calculator calculator = new Calculator();
        calculator.add(2);
        calculator.add(2);
        assertThat(calculator.getTotal()).isEqualTo(4);
    }

    @Test
    void calculatorSubtractTwoAndTotalResultIs0() {
        Calculator calculator = new Calculator();
        calculator.add(2);
        assertThat(calculator.subtract(2)).isEqualTo(0);
        assertThat(calculator.subtract(2)).isNotEqualTo(2);

    }

    @Test
    void throwIllegalArgumentExceptionWhenSubtractNegativeNumber() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> {calculator.subtract(-2);}).isInstanceOf(IllegalArgumentException.class).withFailMessage("The input number must be greater than 0");

    }

    @Test
    void calculatorMultiplyFourAndTotalResultIs0() {
        Calculator calculator = new Calculator();
        calculator.add(0);
        assertThat(calculator.multiply(6)).isEqualTo(0);
        assertThat(calculator.multiply(6)).isNotEqualTo(6);

    }

    @Test
    void calculatorMultiplySixToTwoAndTotalResultIsTwelve() {
        Calculator calculator = new Calculator();
        calculator.add(2);
        assertThat(calculator.multiply(6)).isEqualTo(12);
        assertThat(calculator.multiply(6)).isNotEqualTo(0);
    }

    @Test
    void throwIllegalArgumentExceptionWhenMultiplyingNegativeNumber() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> {calculator.multiply(-2);}).isInstanceOf(IllegalArgumentException.class).withFailMessage("The input number must be greater than 0");

    }

    @Test
    void calculatorDivide2AndTotalResultIs2() {
        Calculator calculator = new Calculator();
        calculator.add(4);
        assertThat(calculator.divide(2)).isEqualTo(2);
        assertThat(calculator.divide(2)).isNotEqualTo(0);

    }
}