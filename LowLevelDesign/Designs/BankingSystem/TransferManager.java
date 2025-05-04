package LowLevelDesign.Designs.BankingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TransferManager {
    private Map<String, Map<String, Object>> transfers = new HashMap<>();
    private int transferCounter = 1;

    public Optional<String> createTransfer(int timestamp, String sourceAccountId, String targetAccountId, int amount, AccountManager accountManager) {
        if (sourceAccountId.equals(targetAccountId) || !accountManager.getAccounts().containsKey(sourceAccountId) || !accountManager.getAccounts().containsKey(targetAccountId)) {
            return Optional.empty();
        }

        String transferId = "transfer" + transferCounter++;
        Map<String, Object> transfer = new HashMap<>();
        transfer.put("source", sourceAccountId);
        transfer.put("target", targetAccountId);
        transfer.put("amount", amount);
        transfer.put("timestamp", timestamp);
        transfer.put("accepted", false);
        transfers.put(transferId, transfer);
        return Optional.of(transferId);
    }

    public boolean acceptTransfer(int timestamp, String transferId, AccountManager accountManager) {
        if (!transfers.containsKey(transferId)) {
            return false;
        }

        Map<String, Object> transfer = transfers.get(transferId);
        boolean accepted = (boolean) transfer.get("accepted");
        if (accepted) return false;

        final int MILLISECONDS_IN_1_DAY = 86400000;
        if (timestamp > (int) transfer.get("timestamp") + MILLISECONDS_IN_1_DAY) {
            accountManager.deposit((String) transfer.get("source"), (int) transfer.get("amount"));
            transfers.remove(transferId);
            return false;
        }

        accountManager.deposit((String) transfer.get("target"), (int) transfer.get("amount"));
        accountManager.deposit((String) transfer.get("source"), -(int) transfer.get("amount"));
        transfer.put("accepted", true);
        return true;
    }

    public Map<String, Map<String, Object>> getTransfers() {
        return transfers;
    }
}
