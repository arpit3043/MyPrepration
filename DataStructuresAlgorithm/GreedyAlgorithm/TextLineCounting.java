package GreedyAlgorithm;

import java.util.Arrays;

public class TextLineCounting {
    public static void main(String[] args) {
        String text = "Superman Batman";
        String text2 = "This is a code test";
        int width = 6;
        int result = countLines(text, width);
        System.out.println("Lines needed: " + result);
        System.out.println(Arrays.toString(findOptimalDelimiterPosition(text, text2, width)));
    }

    private static int countLines(String text, int maxWidth) {
        String[] words = text.split(" ");
        int lines = 1;
        int lineLength = 0;

        for (String word : words) {
            int wordLength = word.length();

            // Case 1: Word itself longer than width => break into chunks
            if (wordLength > maxWidth) {
                // Start a new line if we were mid-line
                if (lineLength != 0) {
                    lines++;
                }

                int fullChunks = wordLength / maxWidth;
                lines += fullChunks;
                int remaining = wordLength % maxWidth;

                // If there is a remaining part, start a new line for that
                if (remaining > 0) {
                    lineLength = remaining;
                } else {
                    lineLength = 0;
                }
            }
            // Case 2: Word fits into current line
            else if (lineLength == 0) {
                lineLength = wordLength;
            }
            // Case 3: Word fits with space
            else if (lineLength + 1 + wordLength <= maxWidth) {
                lineLength += 1 + wordLength;
            }
            // Case 4: Word doesn’t fit => move to next line
            else {
                lines++;
                lineLength = wordLength;
            }
        }

        return lines;
    }

    private static int[] findOptimalDelimiterPosition(String text1, String text2, int totalWidth) {
        int start = 1;
        int end = totalWidth - 1;
        int minHeight = Integer.MAX_VALUE;
        int bestWidth = -1;
    
        while (start <= end) {
            int leftHeight = Integer.MAX_VALUE;
            int rightHeight = Integer.MAX_VALUE;
            int mid = start + (end - start) / 2;
            int h1 = countLines(text1, mid);
            int h2 = countLines(text2, totalWidth - mid);
            int current = Math.max(h1, h2);

            if(mid > 1) {
                leftHeight = Math.max(countLines(text1, mid - 1), countLines(text2, totalWidth - mid + 1));
            }

            if(mid < totalWidth - 1) {
                rightHeight = Math.max(countLines(text1, mid + 1), countLines(text2, totalWidth - mid - 1));
            }
    
            if (current <= leftHeight && current <= rightHeight) {
                minHeight = current;
                bestWidth = mid;
                break;
            } else if (leftHeight < current) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    
        return new int[]{bestWidth, totalWidth - bestWidth, minHeight};
    }
    
}
