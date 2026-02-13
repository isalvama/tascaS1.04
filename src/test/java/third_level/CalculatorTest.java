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

}