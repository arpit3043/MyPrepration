package Designs.OnlineVotingSystem;

public class BasicEncryptor implements EncryptionStrategy {
    @Override
    public String encrypt(int value) {
        // Implement encryption logic here
        return "encrypted_" + value;
    }
}