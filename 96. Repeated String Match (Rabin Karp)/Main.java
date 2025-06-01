import java.util.*;
public class Main {
    private int BASE = 1000000;

    public int repeatedStringMatch(String A, String B) {
        if (A.equals(B)) return 1;
        int count = 1;
        StringBuilder sourceBuilder = new StringBuilder(A);
        while (sourceBuilder.length() < B.length()) {
            count++;
            sourceBuilder.append(A);
        }
        String source = sourceBuilder.toString();

        if (source.equals(B)) return count;
        if (rabinKarp(source, B) != -1) return count;
        if (rabinKarp(source + A, B) != -1) return count + 1;
        return -1;
    }

    private int rabinKarp(String source, String target) {
        if (source == null || target == null || source.isEmpty() || target.isEmpty()) return -1;

        int m = target.length();
        long power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }

        long targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        long hashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;

            if (i < m - 1) {
                continue;
            }

            if (i >= m) {
                hashCode = (hashCode - (source.charAt(i - m) * power)) % BASE;
            }

            if (hashCode < 0) {
                hashCode += BASE;
            }

            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        String A = "abcd";
        String B = "cdabcdab";
        int result = obj.repeatedStringMatch(A, B);
        System.out.println(result); // Output: 3
    }    
}
