package LowLevelDesign.Designs.BankingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BankingSystemImpl implements BankingSystem {
    private AccountManager accountManager;
    private TransferManager transferManager;

    public BankingSystemImpl() {
        accountManager = new AccountManager();
        transferManager = new TransferManager();
    }

    @Override
    public boolean createAccount(int timestamp, String accountId) {
        return accountManager.createAccount(timestamp, accountId);
    }

    @Override
    public Optional<Integer> deposit(int timestamp, String accountId, int amount) {
        return accountManager.deposit(accountId, amount);
    }

    @Override
    public Optional<Integer> pay(int timestamp, String accountId, int amount) {
        return accountManager.pay(accountId, amount);
    }

    @Override
    public List<String> topActivity(int timestamp, int n) {
        List<Map.Entry<String, Integer>> sortedAccounts = new ArrayList<>(accountManager.getTransactions().entrySet());
        sortedAccounts.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort by transaction total

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n && i < sortedAccounts.size(); i++) {
            Map.Entry<String, Integer> entry = sortedAccounts.get(i);
            result.add(entry.getKey() + "(" + entry.getValue() + ")");
        }
        return result;
    }

    @Override
    public Optional<String> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount) {
        return transferManager.createTransfer(timestamp, sourceAccountId, targetAccountId, amount, accountManager);
    }

    @Override
    public boolean acceptTransfer(int timestamp, String accountId, String transferId) {
        return transferManager.acceptTransfer(timestamp, transferId, accountManager);
    }

    @Override
    public boolean mergeAccounts(int timestamp, String accountId1, String accountId2) {
        return accountManager.mergeAccounts(accountId1, accountId2);
    }

    @Override
    public Optional<Integer> getBalance(int timestamp, String accountId, int timeAt) {
        return accountManager.getBalance(accountId, timeAt);
    }
}
