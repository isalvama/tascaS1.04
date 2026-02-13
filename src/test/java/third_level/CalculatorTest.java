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
    }

}