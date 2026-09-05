public class GCDCalculator {
    public static void findGCD(int number1, int number2) {
        int a = number1, b = number2;

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        System.out.println("The GCD of " + number1 + " and " + number2 + " is " + a);
    }

    public static void main(String[] args) {
        findGCD(36, 24);
    }
}
