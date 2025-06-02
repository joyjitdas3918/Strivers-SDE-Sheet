import java.util.*;
class Main {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (n < m)
            return -1;

        // Preprocess the needle to get LPS array
        int[] LPS = preprocess(needle);

        return KMP(haystack, needle, LPS);
    }

    // KMP search: uses the LPS array to avoid rechecking characters
    private int KMP(String str, String pattern, int[] LPS) {
        int sptr = 0; // Pointer in haystack
        int pptr = 0; // Pointer in pattern
        int n = str.length(), m = pattern.length();

        while (sptr < n) {
            if (str.charAt(sptr) == pattern.charAt(pptr)) {
                // Characters match; move both pointers
                sptr++;
                pptr++;

                // Full pattern matched
                if (pptr == m)
                    return sptr - m;
            } else {
                // Mismatch
                if (pptr == 0) {
                    // Start from next char in haystack
                    sptr++;
                } else {
                    // Jump to the last known good prefix
                    pptr = LPS[pptr - 1];
                }
            }
        }

        return -1;

    }
     private int[] preprocess(String pattern) {
        int len = pattern.length();
        int[] LPS = new int[len];
        int prev = 0; // Length of previous longest prefix suffix
        int i = 1;

        LPS[0] = 0; // First char has no proper prefix/suffix

        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(prev)) {
                // If match, extend the prefix
                prev++;
                LPS[i] = prev;
                i++;
            } else {
                if (prev == 0) {
                    // No match and no prefix to fallback to
                    LPS[i] = 0;
                    i++;
                } else {
                    // Fallback to previous LPS
                    prev = LPS[prev - 1];
                }
            }
        }

        return LPS;
    }
    public static void main(String[] args) {
        Main solution = new Main();
        String haystack = "hello";
        String needle = "ll";
        int result = solution.strStr(haystack, needle);
        System.out.println(result); // Output: 2
    }
} 