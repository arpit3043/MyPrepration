package LowLevelDesign.Designs.BankingSystem;

import java.util.List;
import java.util.Optional;

public interface BankingSystem {
    boolean createAccount(int timestamp, String accountId);
    Optional<Integer> deposit(int timestamp, String accountId, int amount);
    Optional<Integer> pay(int timestamp, String accountId, int amount);
    List<String> topActivity(int timestamp, int n);
    Optional<String> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount);
    boolean acceptTransfer(int timestamp, String accountId, String transferId);
    boolean mergeAccounts(int timestamp, String accountId1, String accountId2);
    Optional<Integer> getBalance(int timestamp, String accountId, int timeAt);
}
