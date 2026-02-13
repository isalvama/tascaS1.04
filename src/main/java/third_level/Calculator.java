package third_level;

public class Calculator {
    private int total;

    public Calculator (){
        this.total = 0;
    }

    public double getTotal(){
        return total;
    }

    public double add(double n){
        return total + n;
    }

}
