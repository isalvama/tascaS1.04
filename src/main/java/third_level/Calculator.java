package third_level;

public class Calculator {
    private double total;

    public Calculator (){
        this.total = 0;
    }

    public double getTotal(){
        return total;
    }

    public double add(double n){
        total += n;
        return total;
    }

    public double subtract(double n){
        total -= n;
        return total;
    }

    public double multiply(double n){
        total *= n;
        return total;
    }

    public double divide(double n){
        if (n == 0){throw new ArithmeticException("The input number cannot be 0");}
        total /= n;
        return total;
    }

    public double reset(){
        total = 0;
        return total;
    }

}
