package Designs.CustomHashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CustomHashMap<K, V> {
    private static long TTL_MILLIS = 60000; // Default TTL is 60 seconds
    private final Map<K, ValueWithExpiry<V>> map;

    // Static method to set global TTL (in seconds)
    public static void setGlobalTTLSeconds(long ttlSeconds) {
        TTL_MILLIS = ttlSeconds * 1000;
    }

    // Constructor
    public CustomHashMap() {
        this.map = new ConcurrentHashMap<>();
        startCleanupTask();
    }

    // Internal class to store value with timestamp
    private static class ValueWithExpiry<V> {
        V value;
        long expiryTime;

        ValueWithExpiry(V value) {
            this.value = value;
            this.expiryTime = System.currentTimeMillis() + TTL_MILLIS;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    public void put(K key, V value) {
        map.put(key, new ValueWithExpiry<>(value));
    }

    public V get(K key) {
        ValueWithExpiry<V> wrapper = map.get(key);
        if (wrapper == null || wrapper.isExpired()) {
            map.remove(key);
            return null;
        }
        return wrapper.value;
    }

    public boolean containsKey(K key) {
        ValueWithExpiry<V> wrapper = map.get(key);
        return wrapper != null && !wrapper.isExpired();
    }

    public void remove(K key) {
        map.remove(key);
    }

    public int size() {
        cleanUp(); // Remove expired entries before reporting size
        return map.size();
    }

    private void cleanUp() {
        for (K key : map.keySet()) {
            if (map.get(key).isExpired()) {
                map.remove(key);
            }
        }
    }

    private void startCleanupTask() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            cleanUp();
        }, TTL_MILLIS, TTL_MILLIS, TimeUnit.MILLISECONDS);
    }
}
