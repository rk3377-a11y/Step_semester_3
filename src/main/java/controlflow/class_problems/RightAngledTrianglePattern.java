public class RightAngledTrianglePattern {
    public static void printTriangle(int rows) {
        System.out.println("The right-angled triangle pattern for " + rows + " rows is");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTriangle(4);
    }
}
