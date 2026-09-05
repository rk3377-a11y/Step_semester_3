public class PalindromeNumberChecker {
    public static void checkPalindrome(int number) {
        int origNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        boolean isPalindrome = reversedNumber == origNumber;
        System.out.println("Is the number " + origNumber + " a Palindrome? " + (isPalindrome ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        checkPalindrome(12321);
        checkPalindrome(12345);
    }
}
