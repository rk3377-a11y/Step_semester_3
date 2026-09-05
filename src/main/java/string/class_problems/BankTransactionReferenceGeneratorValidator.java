public class BankTransactionReferenceGeneratorValidator {

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return firstThree + rest;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: length must be 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 11 characters must be digits";
            }
        }

        String date = reference.substring(3, 9);
        String seq = reference.substring(9, 14);

        String day = date.substring(0, 2);
        String month = date.substring(2, 4);
        String year = date.substring(4, 6);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] DATE: ")
              .append(day).append("/").append(month).append("/").append(year)
              .append(" | SEQ: ").append(seq);

        return result.toString();
    }

    public static void main(String[] args) {
        String normalized1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(normalized1));

        String normalized2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(normalized2));
    }
}