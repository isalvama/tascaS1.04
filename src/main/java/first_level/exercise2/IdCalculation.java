package first_level.exercise2;

public class IdCalculation {
    private long idNumber;
    private int remainder;
    private char idLetter;

    public IdCalculation(long idNumber){
        this.idNumber = idNumber;
        this.remainder = (int)idNumber % 23;
    }

    public char calculateIdLetter(){
        idLetter = switch (remainder){
            case 0 -> 't';
            case 1 -> 'r';
            case 2 -> 'w';
            case 3 -> 'a';
            case 4 -> 'g';
            case 5 -> 'm';
            case 6 -> 'y';
            case 7 -> 'f';
            case 8 -> 'p';
            case 9 -> 'd';
            case 10 -> 'x';
            case 11 -> 'b';
            case 12 -> 'n';
            case 13 -> 'j';
            case 14 -> 'z';
            case 15 -> 's';
            case 16 -> 'q';
            case 17 -> 'v';
            case 18 -> 'h';
            case 19 -> 'l';
            case 20 -> 'c';
            case 21 -> 'k';
            case 22 -> 'e';
            default -> throw new IllegalStateException("Unexpected value: " + remainder);
        };
        return idLetter;
    }
}
