public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;

        for (int qty : sectionA) totalA += qty;
        for (int qty : sectionB) totalB += qty;

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highest = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                " | Status: " + status + " | Highest Quantity: " + highest +
                " (" + highestSection + ", Item " + highestIndex + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}