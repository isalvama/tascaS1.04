package first_level.exercise2;

public class IdCalculation {

    private static int convertToInt(String idNumber){
        String idNumStringWithoutZeros = idNumber.replaceAll("^0+", "");
        if (idNumber.startsWith("-")) {
            throw new IllegalArgumentException("idNumber can't be negative");
        }
        if (idNumStringWithoutZeros.length() > 8) {
            throw new IllegalArgumentException("idNumber can't have more than 8 digits");
        }
        try{
            return Integer.parseInt(idNumStringWithoutZeros);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("idNumber should only contain numbers");
        }
    }

    public static char calculateIdLetter(String idNumber){
        int validatedIdNumber = convertToInt(idNumber);
        int remainder = validatedIdNumber % 23;
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.charAt(remainder);
    }
}
