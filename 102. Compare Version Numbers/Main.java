import java.util.*;
class Main {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int num1 = 0, num2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j++) - '0');
            }
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.compareVersion("1.0", "1")); // 0
        System.out.println(obj.compareVersion("1.0.1", "1")); // 1
        System.out.println(obj.compareVersion("1.0", "1.0.0")); // 0
        System.out.println(obj.compareVersion("1.2", "1.10")); // -1
    }
}