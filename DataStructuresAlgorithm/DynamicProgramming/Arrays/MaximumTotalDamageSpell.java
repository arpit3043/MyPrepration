package DynamicProgramming.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumTotalDamageSpell {
    public static void main(String[] args) {
        int[] power = {7, 1, 6, 6};
        System.out.println(maximumTotalDamage(power));

    }

    // Function to calculate the maximum total damage of spells
    private static long maximumTotalDamage(int[] power) {
        Map<Integer, Long> damageFrequency = new HashMap<>();
        for (int damage : power) {
            damageFrequency.put(damage, damageFrequency.getOrDefault(damage, 0L) + 1);
        }

        List<Integer> uniqueDamages = new ArrayList<>(damageFrequency.keySet());
        Collections.sort(uniqueDamages);
        int totalUniqueDamages = uniqueDamages.size();
        long[] maxDamageDP = new long[totalUniqueDamages];
        maxDamageDP[0] = uniqueDamages.get(0) * damageFrequency.get(uniqueDamages.get(0));
        
        for (int i = 1; i < totalUniqueDamages; i++) {
            int currentDamageValue = uniqueDamages.get(i);
            long currentDamageTotal = currentDamageValue * damageFrequency.get(currentDamageValue);
            
            // Initially, consider not taking the current damage
            maxDamageDP[i] = maxDamageDP[i - 1];

            // Find the previous damage value that doesn't conflict with the current one
            int previousIndex = i - 1;
            while (previousIndex >= 0 
            && (uniqueDamages.get(previousIndex) == currentDamageValue - 1
            || uniqueDamages.get(previousIndex) == currentDamageValue - 2
            || uniqueDamages.get(previousIndex) == currentDamageValue + 1
            || uniqueDamages.get(previousIndex) == currentDamageValue + 2)) {
                previousIndex--;
            }

            // Update the DP value considering the current damage
            if (previousIndex >= 0) {
                maxDamageDP[i] = Math.max(maxDamageDP[i], maxDamageDP[previousIndex] + currentDamageTotal);
            } else {
                maxDamageDP[i] = Math.max(maxDamageDP[i], currentDamageTotal);
            }
        }

        // Return the maximum damage possible
        return maxDamageDP[totalUniqueDamages - 1];
    }
}