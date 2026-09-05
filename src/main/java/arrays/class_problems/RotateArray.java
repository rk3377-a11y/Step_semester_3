public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] result = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if (i < result.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
