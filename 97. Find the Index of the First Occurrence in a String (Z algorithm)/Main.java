import java.util.*;
class Main {
    public int strStr(String haystack, String needle) {
        StringBuilder newStr = new StringBuilder(needle).append("#");
        newStr.append(haystack);

        // Calculate Z array for the combined string
        int[] Z = calculateZ(newStr);

        // Scan Z array to find index where pattern length matches
        for (int i = 0; i < Z.length; i++) {
            if (Z[i] == needle.length()) {
                // i - needle.length() - 1 skips over the needle + '#' prefix
                return i - needle.length() - 1;
            }
        }
        return -1;
    }
    private int[] calculateZ(StringBuilder zString) {
        int n = zString.length();
        int[] Z = new int[n];
        int left = 0, right = 0;

        for (int k = 1; k < n; k++) {
            if (k > right) {
                // Outside the current Z-box; start fresh
                left = right = k;

                // Extend the Z-box while characters match
                while (right < n && zString.charAt(right) == zString.charAt(right - left)) {
                    right++;
                }

                Z[k] = right - left;
                right--;
            } else {
                // Inside the current Z-box
                int k1 = k - left;

                // If value doesn't stretch past right boundary, copy it
                if (k + Z[k1] <= right) {
                    Z[k] = Z[k1];
                } else {
                    // Otherwise, start matching from current right
                    left = k;
                    while (right < n && zString.charAt(right) == zString.charAt(right - left)) {
                        right++;
                    }

                    Z[k] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }
    public static void main(String[] args) {
        Main solution = new Main();
        String haystack = "hello";
        String needle = "ll";
        int result = solution.strStr(haystack, needle);
        System.out.println(result); // Output: 2
    }
} 