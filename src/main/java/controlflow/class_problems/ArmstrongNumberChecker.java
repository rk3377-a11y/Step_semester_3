public class ArmstrongNumberChecker {
    public static void checkArmstrong(int number) {
        int origNumber = number;
        int digitCount = String.valueOf(number).length();
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digitCount);
            number = number / 10;
        }

        boolean isArmstrong = sum == origNumber;
        System.out.println("Is the number " + origNumber + " an Armstrong number? " + (isArmstrong ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        checkArmstrong(153);
        checkArmstrong(154);
    }
}
