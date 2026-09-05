public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPriceSoFar) {
                minPriceSoFar = price;
            } else if (price - minPriceSoFar > maxProfit) {
                maxProfit = price - minPriceSoFar;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
