package classes_and_objects.class_problems;

public class M2_MessWalletDemo {
    static class MessWallet {
        private double balance;

        MessWallet(double balance) {
            if (balance < 0) {
                System.out.println("Warning: negative opening balance given, starting at 0");
                this.balance = 0;
            } else {
                this.balance = balance;
            }
        }

        void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up amount must be positive");
            } else {
                balance += amount;
                System.out.println("Balance after top-up: " + balance);
            }
        }

        void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                balance -= amount;
                System.out.println("Balance after deduction: " + balance);
            }
        }

        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
