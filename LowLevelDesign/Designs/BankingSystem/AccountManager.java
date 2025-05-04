package LowLevelDesign.Designs.BankingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountManager {
    private Map<String, Integer> accounts = new HashMap<>();
    private Map<String, Integer> transactions = new HashMap<>();
    private Map<String, Integer> accountCreatedAt = new HashMap<>();
    private Map<String, Integer> accountDeletedAt = new HashMap<>();

    public boolean createAccount(int timestamp, String accountId) {
        if (accounts.containsKey(accountId)) {
            return false;
        }
        accounts.put(accountId, 0);
        transactions.put(accountId, 0);
        accountCreatedAt.put(accountId, timestamp);
        accountDeletedAt.put(accountId, null);
        return true;
    }

    public Optional<Integer> deposit(String accountId, int amount) {
        if (!accounts.containsKey(accountId)) {
            return Optional.empty();
        }
        accounts.put(accountId, accounts.get(accountId) + amount);
        transactions.put(accountId, transactions.get(accountId) + amount);
        return Optional.of(accounts.get(accountId));
    }

    public Optional<Integer> pay(String accountId, int amount) {
        if (!accounts.containsKey(accountId) || accounts.get(accountId) < amount) {
            return Optional.empty();
        }
        accounts.put(accountId, accounts.get(accountId) - amount);
        transactions.put(accountId, transactions.get(accountId) + amount);
        return Optional.of(accounts.get(accountId));
    }

    public Map<String, Integer> getAccounts() {
        return accounts;
    }

    public Map<String, Integer> getTransactions() {
        return transactions;
    }

    public Optional<Integer> getBalance(String accountId, int timeAt) {
        if (!accountCreatedAt.containsKey(accountId)) {
            return Optional.empty();
        }

        int createdAt = accountCreatedAt.get(accountId);
        Integer deletedAt = accountDeletedAt.get(accountId);

        if (timeAt < createdAt || (deletedAt != null && timeAt >= deletedAt)) {
            return Optional.empty();
        }

        return Optional.ofNullable(accounts.get(accountId));
    }

    public boolean mergeAccounts(String accountId1, String accountId2) {
        if (!accounts.containsKey(accountId1) || !accounts.containsKey(accountId2)) {
            return false;
        }
        accounts.put(accountId1, accounts.get(accountId1) + accounts.get(accountId2));
        transactions.put(accountId1, transactions.get(accountId1) + transactions.get(accountId2));
        accounts.remove(accountId2);
        transactions.remove(accountId2);
        return true;
    }
}

