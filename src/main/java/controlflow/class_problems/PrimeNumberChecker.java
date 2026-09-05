public class PrimeNumberChecker {
    public static void checkPrime(int number) {
        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println("Is the number " + number + " a Prime number? " + (isPrime ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        checkPrime(17);
        checkPrime(18);
    }
}
