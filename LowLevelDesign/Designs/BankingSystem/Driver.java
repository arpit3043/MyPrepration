package LowLevelDesign.Designs.BankingSystem;

public class Driver {
    public static void main(String[] args) {
        // Instantiate the banking system
        BankingSystemImpl bankingSystem = new BankingSystemImpl();

        // Create accounts
        System.out.println("Creating Account1: " + bankingSystem.createAccount(1, "acc1"));
        System.out.println("Creating Account2: " + bankingSystem.createAccount(1, "acc2"));
        
        // Deposit into accounts
        System.out.println("Depositing 500 into Account1: " + bankingSystem.deposit(1, "acc1", 500));
        System.out.println("Depositing 1000 into Account2: " + bankingSystem.deposit(1, "acc2", 1000));
        
        // Pay from an account
        System.out.println("Paying 200 from Account1: " + bankingSystem.pay(2, "acc1", 200));
        
        // Transfer money between accounts
        System.out.println("Transferring 300 from Account1 to Account2: " + bankingSystem.transfer(3, "acc1", "acc2", 300));
        
        // Accept a transfer
        System.out.println("Accepting Transfer (transfer1) on Account2: " + bankingSystem.acceptTransfer(4, "acc2", "transfer1"));
        
        // Check the top 2 activities (accounts with the most transactions)
        System.out.println("Top 2 Accounts by Activity: " + bankingSystem.topActivity(5, 2));
        
        // Check balance of Account1
        System.out.println("Balance of Account1 at timestamp 5: " + bankingSystem.getBalance(5, "acc1", 5));
        
        // Merge accounts
        System.out.println("Merging Account1 and Account2: " + bankingSystem.mergeAccounts(6, "acc1", "acc2"));
        
        // Check balance of Account1 after merge
        System.out.println("Balance of Account1 after merge: " + bankingSystem.getBalance(7, "acc1", 7));
        
        // Check if Account2 is deleted after merge
        System.out.println("Balance of Account2 after merge: " + bankingSystem.getBalance(7, "acc2", 7));
    }
}
