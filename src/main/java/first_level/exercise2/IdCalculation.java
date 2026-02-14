package first_level.exercise2;

public class IdCalculation {

    private static int convertToInt(String idNumber){
        String idNumStringWithoutZeros = idNumber.replaceAll("^0+", "");
        if (idNumber.startsWith("-")) {
            throw new IllegalArgumentException("idNumber can't be negative");
        }
        if (idNumStringWithoutZeros.length() > 8) {
            throw new IllegalArgumentException("idNumber can't have more than 9 digits");
        }
        try{
            return Integer.parseInt(idNumStringWithoutZeros);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The input number should only contain digits");
        }
    }

    public static char calculateIdLetter(String idNumber){
        int validatedIdNumber = convertToInt(idNumber);
        int remainder = validatedIdNumber % 23;
        return switch (remainder){
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
    }
}
