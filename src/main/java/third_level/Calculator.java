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
        if (n < 0) { throw new IllegalArgumentException("The added input number must be greater than 0");
        }
        total += n;
        return total;
    }

    public double subtract(double n){
        if (n < 0) { throw new IllegalArgumentException("The added input number must be greater than 0");
        }
        total -= n;
        return total;
    }

}
